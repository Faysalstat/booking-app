import { Component, OnInit } from '@angular/core';
import { BookingService } from 'src/app/services/booking.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  bookingList!:any[];
  constructor(
    private bookingService:BookingService
  ) { }
  ngOnInit(): void {
    this.fetchAllBookingRequest();
  }
  fetchAllBookingRequest(){
    let userId = +localStorage.getItem("userId")!;
    this.bookingService.fetchAllBookingRequestByUserId(userId,"HOSPITAL").subscribe({
      next:(res)=>{
        console.log(res)
        this.bookingList = res;
      }
    })
  }

}
