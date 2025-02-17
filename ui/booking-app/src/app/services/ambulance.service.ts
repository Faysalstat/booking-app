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
    return this.http.get<any>(AMBULANCE_URL.CLOSEST_AMBULANCE, { params });
  }
  getAllBookingByDriverId(driverId:number): Observable<any> {
    let params = new HttpParams();
    params = params.append('id', driverId);
    return this.http.get<any>(BOOKING_URL.GET_ALL_BOOKING, { params });
  }
  updateAmbulanceBookingStatus(bookingId:number,status:string): Observable<any> {
    let params = new HttpParams();
    params = params.append('bookingId', bookingId);
    params = params.append('status', status);
    return this.http.put<any>(AMBULANCE_URL.UPDATE_AMBULANCE_BOOKING_STATUS, { params });
  }
}
