import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserDetails } from 'src/app/model/model';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  userRegistrationForm!: FormGroup;
  userType:string = "USER";
  cities!:any[];
  constructor(
    private formBuilder: FormBuilder,
    private authService:AuthService,
    private router:Router,
  ) { }

  ngOnInit(): void {
    this.prepareForm();
    this.fetchLocationList();
  }
  prepareForm() {
    let formData = new UserDetails();
    this.userRegistrationForm = this.formBuilder.group({
      userName: [formData.userName, [Validators.required, Validators.pattern(/^\S*$/)]],
      userType: ["USER", [Validators.required]],
      password: [formData.password, [Validators.required]],
      driverName: [formData.driverName],
      phone: [formData.phone, [Validators.required]],
      ambulanceNumber: [formData.ambulanceNumber],
      hospitalName: [formData.hospitalName],
      location: [formData.location],
    });

    this.userRegistrationForm.get('userType')?.valueChanges.subscribe((type)=>{
      if(type == "HOSPITAL"){
        this.userRegistrationForm.get('driverName')?.setValidators(Validators.required);
        this.userRegistrationForm.get('hospitalName')?.setValidators(Validators.required);
      }else if(type == "AMBULANCE"){
  
      }else{
  
      }
    })
  }

  fetchLocationList(){
    this.authService.fetchLocationList().subscribe({
      next: (res:any)=>{
        console.log(res)
        this.cities = res.body;
      }
    })
  }
  onTypeChange(type:string){
    console.log(type);
    if(type == "USER"){

    }else if(type == "AMBULANCE"){

    }else{

    }
  }
  onSubmit(){
    if(!this.userRegistrationForm.valid){
      alert("Error in form");
      return;
    }
    let payload = this.userRegistrationForm.value;
    this.authService.register(payload).subscribe({
      next:(res)=>{
        console.log(res);
        if(res.success){
          this.router.navigate(['auth']);
        }else{
          alert(res.message)
        }
        
      },
      error:(err)=>{
        alert("Registration Failed")
      }
    })
  }
}
