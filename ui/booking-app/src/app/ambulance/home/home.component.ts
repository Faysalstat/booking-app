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
  }
  fetAllBookingRequest(){
    let driverId = +localStorage.getItem("userId")!;
    this.ambulanceService.getAllBookingByDriverId(driverId).subscribe({
      next:(res=>{

      })
    })
  }
  logout(){
    localStorage.removeItem("userId");
    localStorage.removeItem("token");
    localStorage.removeItem("username");
    localStorage.removeItem("userRole");
  }
}
