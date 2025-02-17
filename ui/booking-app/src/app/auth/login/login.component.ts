import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm!: FormGroup;
  message!:string;
  userType:string = "USER";
  constructor(
    private authService:AuthService,
    private router:Router,
    private formBuilder: FormBuilder
  ) { }

  ngOnInit(): void {
    this.prepareForm();
  }
  prepareForm() {
    this.loginForm = this.formBuilder.group({
      username: ["", [Validators.required]],
      password: ["", [Validators.required]]
    });
  }
  signIn(){
    const user = this.loginForm.value;
    this.authService.login(user).subscribe({
      next:(response:any)=>{
        this.userType = response.userType;
        localStorage.setItem("userId", response.userId);
        localStorage.setItem("token", response.token);
        localStorage.setItem("username", response.userName);
        localStorage.setItem("userRole", response.userType);
        if (this.userType === 'HOSPITAL') {
          this.router.navigate(['hospital']);
        }
        if (this.userType === 'AMBULANCE') {
          this.router.navigate(['ambulance']);
        }
        if (this.userType === 'USER') {
          this.router.navigate(['booking']);
        }
      },
      error:(err)=>{
        alert('Wrong Credentials Entered');
      },
      complete: ()=>{}
    })
  }

}
