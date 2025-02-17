import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BookingService } from 'src/app/services/booking.service';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  bookingList!:any[];
  constructor(
    private bookingService:BookingService,
    private router:Router) { }

  ngOnInit(): void {
    this.fetchAllBookingRequest();
  }

  fetchAllBookingRequest(){
    let userId = +localStorage.getItem("userId")!;
    this.bookingService.fetchAllBookingRequestByUserId(userId,"USER").subscribe({
      next:(res)=>{
        console.log(res)
        this.bookingList = res;
      }
    })
  }

  addNew(){
    this.router.navigate(["booking"]);
  }

}
