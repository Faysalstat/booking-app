import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AMBULANCE_URL, BOOKING_URL } from '../utils/urls.constant';

@Injectable({
  providedIn: 'root'
})
export class AmbulanceService {

  constructor(private http: HttpClient) {}

  getAmbulancesByLocation(location: string): Observable<any> {
    let params = new HttpParams();
    params = params.append('location', location);
    return this.http.get<any>(AMBULANCE_URL.CLOSEST, { params });
  }
  getAllBookingByDriverId(driverId:number): Observable<any> {
    let payload = {
      userType:"USER",
      userId:driverId
    }
    return this.http.put<any>(AMBULANCE_URL.GET_ALL_AMBULANCE_BOOKING, payload);
  }
  updateAmbulanceBookingStatus(bookingId:number,status:string): Observable<any> {
    let payload = {
      id:bookingId,
      status:status
    }
    return this.http.put<any>(AMBULANCE_URL.UPDATE_AMBULANCE_BOOKING_STATUS,payload);
  }
}
