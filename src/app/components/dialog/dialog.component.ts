import { Component, OnInit } from '@angular/core';
import { NavbarService } from "../navbar/service/navbar.service";
import { AuthService } from "../../security/services/auth.service";

@Component({
  selector: 'app-dialog',
  templateUrl: './dialog.component.html',
  styleUrls: ['./dialog.component.css']
})
export class DialogComponent implements OnInit {

  constructor() { }
  ngOnInit(): void {

  }

}
