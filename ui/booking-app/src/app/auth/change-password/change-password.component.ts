import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-change-password',
  templateUrl: './change-password.component.html',
  styleUrls: ['./change-password.component.css']
})
export class ChangePasswordComponent implements OnInit {
  passwordChangeForm!: FormGroup;
  constructor(
    private authService: AuthService,
    private router: Router,
    private formBuilder: FormBuilder
  ) { }

  ngOnInit(): void {
    this.prepareForm();
  }
  prepareForm() {
    this.passwordChangeForm = this.formBuilder.group({
      userName: ["", [Validators.required, Validators.pattern(/^\S*$/)]],
      previousPassword: ["", [Validators.required, Validators.pattern(/^\S*$/)]],
      newPassword: ["", [Validators.required, Validators.pattern(/^\S*$/)]]
    });
  }
  changePassword() {
    const user = this.passwordChangeForm.value;
    this.authService.changePassword(user).subscribe({
      next: (response: any) => {
        localStorage.removeItem("userId");
        localStorage.removeItem("token");
        localStorage.removeItem("username");
        localStorage.removeItem("userRole");
        this.router.navigate(['auth']);
      },
      error: (err) => {
        alert('Wrong Credentials Entered');
      },
      complete: () => { }
    })
  }

}
