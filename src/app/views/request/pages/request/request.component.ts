import { Component, OnInit } from '@angular/core';
import { RequestService } from "../../service/request.service";
import { FormBuilder, FormGroup } from "@angular/forms";
import { Router } from "@angular/router";
import { catchError, Observable, retry } from "rxjs";
import { RequestInfo } from "../../model/requestInfo";
import { AuthService } from "../../../../security/services/auth.service";

@Component({
  selector: 'app-request',
  templateUrl: './request.component.html',
  styleUrls: ['./request.component.css']
})
export class RequestComponent implements OnInit {
  public hide: boolean = true;
  requestForm: FormGroup;
  constructor(public service: RequestService,
              public builder: FormBuilder,
              public router: Router) {
    this.requestForm = this.builder.group({
      type: [''],
      model: [''],
      brand: [''],
      address: [''],
      description: ['']
    });
  }
  get type() { return this.requestForm.controls['type'];}
  get model() { return this.requestForm.controls['model'];}
  get brand() { return this.requestForm.controls['brand'];}
  get address() { return this.requestForm.controls['address'];}
  get description() { return this.requestForm.controls['description'];}

  create(){
    this.service.create(this.requestForm.value).subscribe((response: any)=>{
      console.log(JSON.stringify(response.user));
    })
  }
  ngOnInit(): void {
  }
}
