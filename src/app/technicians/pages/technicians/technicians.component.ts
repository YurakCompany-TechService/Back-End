import { Component, OnInit } from '@angular/core';
import { AuthService } from "../../../security/services/auth.service";

@Component({
  selector: 'app-technicians',
  templateUrl: './technicians.component.html',
  styleUrls: ['./technicians.component.css']
})
export class TechniciansComponent implements OnInit {

  constructor(public authService: AuthService) { }

  ngOnInit(): void {
  }
  public getFirstName(){
    // return this.authService.getValidatedData('firstName')
    return this.authService.getInformation()?.firstName;
  }
  public getLastName(){
    // return this.authService.getValidatedData('lastName');
    return this.authService.getInformation()?.lastName;
  }
  public getPhone(){
    // return this.authService.getValidatedData('phone');
    return this.authService.getInformation()?.phone;
  }
  public getEmail(){
    // return this.authService.getValidatedData('email');
    return this.authService.getInformation()?.email;
  }
  public getGender(){
    // return this.authService.getValidatedData('gender');
    return this.authService.getInformation()?.gender;
  }
  public getArea(){
    // return this.authService.getValidatedData('area');
    return this.authService.getInformation()?.area;
  }
  public getBrand(){
    // return this.authService.getValidatedData('brand');
    return this.authService.getInformation()?.brand;
  }

}
