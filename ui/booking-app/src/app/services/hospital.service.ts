import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HOSPITAL_URL } from '../utils/urls.constant';

@Injectable({
  providedIn: 'root'
})
export class HospitalService {
  constructor(private http: HttpClient) {}

  getHospitalsByLocation(location: string): Observable<any> {
    let params = new HttpParams();
    params = params.append('location', location);
    return this.http.get<any>(HOSPITAL_URL.CLOSEST_AMBULANCE, { params });
  }
}
