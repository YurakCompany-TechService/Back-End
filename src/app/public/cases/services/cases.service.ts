import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpHeaders } from "@angular/common/http";
import { catchError, Observable, retry, throwError } from "rxjs";
import { Case } from "../model/case";
import {TechniciansService} from "../../../technicians/services/technicians.service";

@Injectable({
  providedIn: 'root'
})
export class CasesService {
  // Cases Endpoint
  basePath = 'http://localhost:3000/cases';
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    })
  }

  constructor(private http: HttpClient, private techniciansService: TechniciansService ) { }

  handleError(error: HttpErrorResponse) {
    if (error.error instanceof ErrorEvent) {
      // Default Error Handling
      console.log(`An error occurred ${error.status}, body was: ${error.error}`);
    } else {
      // Unsuccessful Response Error Code returned from Backend
      console.log(`Backend returned code ${error.status}, body was: ${error.error}`);
    }
    // Return Observable with Error Message to Client
    return throwError(() => new Error('Something happened with request, please try again later.'));
  }

  // Get all cases
  getAll(): Observable<Case> {
    return this.http.get<Case>(this.basePath, this.httpOptions)
      .pipe(
        retry(2),
        catchError(this.handleError)
      );
  }

  getTechnician(technicianId: any) {
    return this.techniciansService.getById(technicianId);
  }
}
