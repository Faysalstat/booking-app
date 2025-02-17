import { Injectable } from "@angular/core";
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from "@angular/router";
import { Observable } from "rxjs";
import { AuthService } from "./auth.service";

@Injectable({
    providedIn: 'root',
  })
  export class HospitalAuthGuard implements CanActivate {
    constructor(
      private router: Router,
      private authService :AuthService,
    ){}
    canActivate(
      route: ActivatedRouteSnapshot,
      state: RouterStateSnapshot
    ):
      | Observable<boolean | UrlTree>
      | Promise<boolean | UrlTree>
      | boolean
      | UrlTree {
      const idToken = localStorage.getItem('token');
      return this.verifyAdmin(idToken);
    }
    async verifyAdmin(token: any) {
      if (!token) {
        this.router.navigate(['auth']);
      }
      let authenticated = await this.authService.isLoggedIn(token);
      if (!authenticated) {
        this.router.navigate(['auth']);
      }
      let userRole = localStorage.getItem('userRole');
      if (userRole != 'HOSPITAL') {
        alert("Not a Hospital User")
        this.router.navigate(['hospital']);
      } 
      return authenticated;
    }
  }