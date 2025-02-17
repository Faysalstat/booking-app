import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { BookingDTO } from '../model/model';
import { BOOKING_URL } from '../utils/urls.constant';

@Injectable({
  providedIn: 'root'
})
export class BookingService {

  constructor(private http: HttpClient) { }


  bookAmbulance(payload: BookingDTO): Observable<any> {
    return this.http.post<any>(BOOKING_URL.BOOK_NOW, payload);
  }
}
