import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {AuthService} from "../../services/auth.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {
  public hide: boolean = true;
  signUpForm: FormGroup;
  constructor(private builder: FormBuilder,
              private authService: AuthService,
              private router: Router) {
    this.signUpForm = this.builder.group({
      gender: ['', [Validators.required]],
      firstName: ['', [Validators.required]],
      lastName: ['', [Validators.required]],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]],
      phone: [0, [Validators.required, Validators.maxLength(9)]],
      brand: ['', [Validators.required]],
      area: ['', [Validators.required]],
      type: ['']
    });
  }
  get email() { return this.signUpForm.controls['email'];}
  get password() { return this.signUpForm.controls['password'];}
  get firstName() {return this.signUpForm.controls['firstName'];}
  get lastName() {return this.signUpForm.controls['lastName'];}
  get phone() {return this.signUpForm.controls['phone'];}
  get brand() {return this.signUpForm.controls['brand'];}
  get area() {return this.signUpForm.controls['area'];}
  get gender() {return this.signUpForm.controls['gender'];}
  get type() {return this.signUpForm.controls['type'];}

  signUp(){
    this.signUpForm.value.type = 'technician'
    this.authService.signUp(this.signUpForm.value).subscribe((response: any)=>{
      console.log(JSON.stringify(response), response.user);
      this.authService.setCurrentUser(JSON.stringify(response));
      this.signUpForm.reset();
      this.router.navigate(['sign-in']).then();
  })
  }
  cancelSignUp() {
    console.log('Cancelled');
    this.router.navigate(['home']).then();
  }
  ngOnInit(): void {
  }

}
