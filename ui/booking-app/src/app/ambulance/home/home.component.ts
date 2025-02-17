import { Component, OnInit } from '@angular/core';
import { AmbulanceService } from 'src/app/services/ambulance.service';
import { BookingService } from 'src/app/services/booking.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  bookingList!:any[];
  constructor(
    private bookingService:BookingService,
    private ambulanceService: AmbulanceService,
  ) { }

  ngOnInit(): void {
    this.fetAllBookingRequest();
  }
  fetAllBookingRequest(){
    let driverId = +localStorage.getItem("userId")!;
    this.ambulanceService.getAllBookingByDriverId(driverId).subscribe({
      next:(res=>{
          console.log(res);
          this.bookingList = res;
      })
    })
  }
  buttonLabel(status:string){
    let updatedStatus = "PENDING"
    switch(status){
      case "PENDING":
        updatedStatus = "MARK CONFIRMED";
        break;
      case "CONFIRMED":
        updatedStatus = "MARK COMPLETED";
        break;
      case "COMPLETED":
          updatedStatus = "COMPLETED";
        break;
    }
    return updatedStatus;
  }
  updateStatus(booking:any){
    let updatedStatus = "PENDING"
    switch(booking.status){
      case "PENDING":
        updatedStatus = "CONFIRMED";
        break;
      case "CONFIRMED":
        updatedStatus = "COMPLETED";
        break;
      case "COMPLETED":
          updatedStatus = "COMPLETED";
        break;
    }
    this.ambulanceService.updateAmbulanceBookingStatus(booking.id,updatedStatus).subscribe({
      next:(res)=>{
        console.log(res);
        this.fetAllBookingRequest();
      }
    })
  }
  logout(){
    localStorage.removeItem("userId");
    localStorage.removeItem("token");
    localStorage.removeItem("username");
    localStorage.removeItem("userRole");
  }
  generateClass(status:string){
    let className = "btn-warning";
    switch(status){
      case "PENDING":
        className = 'btn-info';
        break;
      case "CONFIRMED":
        className = 'btn-primary';
        break;
      case "COMPLETED":
        className = 'btn-success';
        break;
    }
    return className;
  }
}
