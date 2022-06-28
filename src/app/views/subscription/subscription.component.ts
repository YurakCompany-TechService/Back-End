import { Component, OnInit } from '@angular/core';
import {DialogSubscriptionComponent} from "../../components/dialogSubscription/dialogSubscription.component";
import {MatDialog} from "@angular/material/dialog";

@Component({
  selector: 'app-subscription',
  templateUrl: './subscription.component.html',
  styleUrls: ['./subscription.component.css']
})
export class SubscriptionComponent implements OnInit{
  constructor(public dialog: MatDialog) {}

  ngOnInit() {
    const dialogRef = this.dialog.open(DialogSubscriptionComponent, {
      data: {name: 'test', type: 'test'}
    });
  }
}
