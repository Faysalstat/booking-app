import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AmbulanceAuthGuard } from './auth/ambulance-auth.guard';
import { HospitalAuthGuard } from './auth/hospital-auth.guard';
import { UserAuthGuard } from './auth/user-auth.guard';
import { WelcomeComponent } from './welcome/welcome.component';

const routes: Routes = [
  {path: '',component: WelcomeComponent},
  { path: 'auth',  loadChildren: () => import('./auth/auth.module').then(m => m.AuthModule)},
  { path: 'booking',  loadChildren: () => import('./booking/booking.module').then(m => m.BookingModule),canActivate: [UserAuthGuard]},
  { path: 'ambulance',  loadChildren: () => import('./ambulance/ambulance.module').then(m => m.AmbulanceModule),canActivate: [AmbulanceAuthGuard]},
  { path: 'hospital',  loadChildren: () => import('./hospital/hospital.module').then(m => m.HospitalModule),canActivate: [HospitalAuthGuard] },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
