import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthenticationUrls, CityUrls } from '../utils/urls.constant';
import { PasswordChangeDTO, UserDetails, UserRegistration } from '../model/model';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  constructor(private http: HttpClient) { }
  public login(loginRequest: any): Observable<any> {
    return this.http.post(AuthenticationUrls.LOGIN, loginRequest);
  }

  public isLoggedIn(token: any): Promise<any> {
    let params = new HttpParams();
    params = params.append("token", token);
    return this.http.get(AuthenticationUrls.CHECK_IS_LOGGEDIN, { params: params }).toPromise();
  }

  public register(userModel: UserDetails): Observable<any> {
    return this.http.post(AuthenticationUrls.REGISTER_USER, userModel);
  }

  public changePassword(model: PasswordChangeDTO): Observable<any> {
    return this.http.post(AuthenticationUrls.CHANGE_PASSWORD, model);
  }

  public fetchLocationList(): Observable<any> {
    return this.http.get(CityUrls.CITY_LIST);
  }
}
