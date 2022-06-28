import { Injectable } from '@angular/core';
import { MatDialog } from "@angular/material/dialog";
import { DialogComponent } from "../../dialog/dialog.component";

@Injectable({
  providedIn: 'root'
})
export class NavbarService {
  type: string = ''
  constructor() { }

}
