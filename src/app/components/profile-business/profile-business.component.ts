import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {AuthService} from "../../security/services/auth.service";

@Component({
  selector: 'app-profile-business',
  templateUrl: './profile-business.component.html',
  styleUrls: ['./profile-business.component.css']
})
export class ProfileBusinessComponent implements OnInit {

  constructor(private router: Router,
              private authService: AuthService) { }

  ngOnInit(): void {
  }
  public getName(){
    // return this.authService.getValidatedData('name')
    return this.authService.getInformation()?.name;
  }
  public getPhone(){
    return this.authService.getInformation()?.phone;
    //return this.authService.getValidatedData('phone');
  }
  public getEmail(){
    // return this.authService.getValidatedData('email');
    return this.authService.getInformation()?.email;
  }
}
