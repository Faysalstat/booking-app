import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/auth/auth.service';
import { BookingDTO } from 'src/app/model/model';
import { AmbulanceService } from 'src/app/services/ambulance.service';
import { BookingService } from 'src/app/services/booking.service';
import { HospitalService } from 'src/app/services/hospital.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  ambulanceBookingForm!: FormGroup;
  cities!: any[];
  ambulanceList: any[] = [];
  HospitalList: any[]=[];
  isAmbulanceBooked: boolean = false;
  isHospitalBooked: boolean = false;
  selectedAmbulance: any;
  selectedHospital: any;
  constructor(
    private formBuilder: FormBuilder,
    private authService: AuthService,
    private ambulanceService: AmbulanceService,
    private hospitalService: HospitalService,
    private bookingService:BookingService,
    private router:Router
  ) { }

  ngOnInit(): void {
    this.prepareForm();
    this.fetchLocationList();
    this.ambulanceBookingForm.get("userId")?.setValue(localStorage.getItem("userId"));
  }
  prepareForm() {
    let formData = new BookingDTO();
    this.ambulanceBookingForm = this.formBuilder.group({
      id: [formData.id],
      userId: [formData.userId, [Validators.required]],
      ambulanceDriverId: [formData.ambulanceDriverId, [Validators.required]],
      hospitalId: [formData.hospitalId, [Validators.required]],
      pickupLocation: [formData.pickupLocation, [Validators.required]]
    });
  }

  fetchLocationList() {
    this.authService.fetchLocationList().subscribe({
      next: (res: any) => {
        console.log(res)
        this.cities = res.body;
      }
    })
  }
  onCitySelect() {
    this.fetchNearestAmbulances();
  }

  fetchNearestAmbulances() {
    let location = this.ambulanceBookingForm.get("pickupLocation")?.value;
    this.ambulanceService.getAmbulancesByLocation(location).subscribe({
      next: (res) => {
        console.log(res);
        this.ambulanceList = res;
      }
    })
  }
  fetchNearestHospitals() {
    let location = this.ambulanceBookingForm.get("pickupLocation")?.value;
    this.hospitalService.getHospitalsByLocation(location).subscribe({
      next: (res) => {
        console.log(res);
        this.HospitalList = res;
      }
    })
  }
  selectAmbulance(ambulance: any) {
    this.isAmbulanceBooked = true;
    this.selectedAmbulance = ambulance;
    this.ambulanceBookingForm.get("ambulanceDriverId")?.setValue(ambulance.id);
    this.fetchNearestHospitals();
    
    
  }
  selectHospital(hospital: any) {
    this.isHospitalBooked = true;
    this.selectedHospital = hospital;
    this.ambulanceBookingForm.get("hospitalId")?.setValue(hospital.id);
  }
  bookNow(){
    let payload = this.ambulanceBookingForm.value;
    this.bookingService.bookAmbulance(payload).subscribe({
      next:(res)=>{
        console.log(res);
        this.router.navigate(["list"]);
      }
    })
  }
  isBookedAmbulance(ambulance: any): boolean {
    return this.isAmbulanceBooked && (this.selectedAmbulance == ambulance);
  }

  isBookedHospital(hospital: any): boolean {
    return this.isHospitalBooked && (this.selectedHospital == hospital);
  }
  logout(){
    localStorage.removeItem("userId");
    localStorage.removeItem("token");
    localStorage.removeItem("username");
    localStorage.removeItem("userRole");
  }
}
