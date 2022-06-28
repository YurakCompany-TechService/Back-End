import { Component, OnInit } from '@angular/core';
import {AuthService} from "../../security/services/auth.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  constructor(private router: Router,
              private authService: AuthService) { }

  ngOnInit(): void {
  }
  public getFirstName(){
    // this.authService.getValidatedData('firstName');
    console.log(this.authService.getInformation()?.firstName);
    return this.authService.getInformation()?.firstName;
  }
  public getLastName(){
    // this.authService.getValidatedData('lastName');
    return this.authService.getInformation()?.lastName;
  }
  public getEmail(){
    // this.authService.getValidatedData('email');
    return this.authService.getInformation()?.email;
  }
  public getBrand(){
    // this.authService.getValidatedData('brand');
    return this.authService.getInformation()?.brand;
  }
  public getArea(){
    // this.authService.getValidatedData('area');
    return this.authService.getInformation()?.area;
  }
  public getGender(){
    // this.authService.getValidatedData('gender');
    return this.authService.getInformation()?.gender;
  }
  public getPhone(){
    // this.authService.getValidatedData('phone');
    console.log(this.authService.getInformation()?.phone)
    return this.authService.getInformation()?.phone;
  }
  public showCompleteName(){
    return `${this.getFirstName()}  ${this.getLastName()}`;
  }
}
