import { Injectable } from '@angular/core';
import {HttpClient, HttpErrorResponse, HttpHeaders} from "@angular/common/http";
import {catchError, Observable, pipe, retry, throwError} from "rxjs";
import {User} from "../model/user";
import {Technician} from "../model/technician";
import {Business} from "../model/business";

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  basePath: string = 'http://localhost:8080/api/v1';
  httpOptions = {
    headers: new HttpHeaders({
      'Content-type': 'application-json',
    })
  }
  information: User | undefined;
  constructor(private http: HttpClient) { }
  //api error handling
  public handleError(error: HttpErrorResponse) {
    if (error.status === 0) {
      // A client-side or network error occurred. Handle it accordingly.
      console.error('An error occurred:', error.error);
    } else {
      // The backend returned an unsuccessful response code.
      // The response body may contain clues as to what went wrong.
      console.error(
        `Backend returned code ${error.status}, body was: `, error.error);
    }
    // Return an observable with a user-facing error message.
    return throwError(() => new Error('Something bad happened; please try again later.'));
  }
  //sign up
  public signUp(user: Technician): Observable<any>{
    return this.http.post<Technician>(`${this.basePath}/technicians`, user)
      .pipe(retry(3), catchError(this.handleError));
  }
  public signUpB(user: Business): Observable<any>{
    return this.http.post<Business>(`${this.basePath}/businesses`, user)
      .pipe(retry(3), catchError(this.handleError));
  }
  //sign in
  public signIn(user: User): Observable<any>{
    return this.http.post<User>(`${this.basePath}/logIn/technician`, user)
      .pipe(retry(3), catchError(this.handleError));
  }
  public signInB(user: User): Observable<any>{
    return this.http.post<User>(`${this.basePath}/logIn/businesses`, user)
      .pipe(retry(3), catchError(this.handleError));
  }
  // get, set Token
  public setToken(accessToken: string): void{
    localStorage.setItem('accessToken', accessToken);
  }
  public getToken(){
    return localStorage.getItem('accessToken');
  }
  // get, set currentUser
  public setCurrentUser(user: string): void{
    localStorage.setItem('currentUser', user);
  }
  public getCurrentUser(){
    return localStorage.getItem('currentUser');
  }
  //is signed
  public isSignedIn(): boolean{
    return this.getInformation()?.password !== undefined;
  }
  // sign-out
  public signOut(){
    localStorage.removeItem('accessToken');
    localStorage.removeItem('currentUser');
    this.setInformation(undefined);
  }
  public getValidatedData(_value: string){
    let currentUserString = this.getCurrentUser();
    if (currentUserString) {
      let currentUser = JSON.parse(currentUserString);
      return currentUser[_value];
    } else {
      return null;
    }
  }
  setInformation(data: User | undefined): void{
    this.information = data;
  }
  getInformation(){
    return this.information;
  }




}
