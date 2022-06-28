import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {AuthService} from "../../security/services/auth.service";
import {MatDialog} from "@angular/material/dialog";
import { DialogComponent } from "../dialog/dialog.component";
import { NavbarService } from "./service/navbar.service";
import {NotificationComponent} from "../notification/notification.component";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  hide: boolean = false;
  type: string = '';
  ngOnInit(): void {
    this.type = this.service.type;
  }

  constructor(private router: Router,
              private authService: AuthService,
              public dialog: MatDialog,
              public service: NavbarService) {
  }

  public getCurrentTargetSegment(){
    console.log(this.authService.getInformation()?.type)
    return this.authService.getInformation()?.type;
    //return this.authService.getValidatedData('type')
  }
  public getCurrentUserEmail() {
    return this.authService.getValidatedData('email');
  }
  public getCurrentFirstName() {
    return this.authService.getValidatedData('firstName');
  }
  public getCurrentLastName() {
    return this.authService.getValidatedData('lastName');
  }
  public getCurrentName() {
    return this.authService.getValidatedData('name');
  }

  signOut() {
    this.authService.signOut();
    this.router.navigate(['home']).then();
    console.log("Signed Out");
  }

  goToProfile() {
    this.router.navigate(['profile']).then();
    console.log('profile')
  }

  goToProfileBusiness() {
    this.router.navigate(['profile-business']).then();
    console.log('profile')
  }
  openDialog(){
    this.dialog.open(DialogComponent);
  }
  isSignedIn(){
    return this.authService.isSignedIn();
  }
  openDialogNoty(){
    const dialogRef = this.dialog.open(NotificationComponent, {
      data: {name: 'test', animal: 'test'}
    });
  }
}
