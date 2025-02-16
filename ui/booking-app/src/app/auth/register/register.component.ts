import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
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
    private authService:AuthService
  ) { }

  ngOnInit(): void {
    this.prepareForm();
    this.fetchLocationList();
  }
  prepareForm() {
    let formData = new UserDetails();
    this.userRegistrationForm = this.formBuilder.group({
      username: [formData.userName, [Validators.required]],
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

  }
}
