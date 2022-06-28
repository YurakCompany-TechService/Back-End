// modal.component.ts

import { Component, OnInit, Inject } from '@angular/core';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
import { DialogData } from '../../DialogData';

@Component({
  selector: 'app-modal',
  templateUrl: 'dialogSubscription.component.html',
  styleUrls: ['dialogSubscription.component.css']
})
export class DialogSubscriptionComponent implements OnInit {

  constructor(
    public dialogRef: MatDialogRef<DialogSubscriptionComponent>,
    @Inject(MAT_DIALOG_DATA) public data: DialogData) {}

  onNoClick(): void {
    this.dialogRef.close();
  }

  ngOnInit() {
  }

}
