import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeComponent } from './home/home.component';
import { ListComponent } from './list/list.component';
import { BookingRoutingModule } from './booking.routing.module';
import { HttpClientModule } from '@angular/common/http';
import { MaterialModule } from 'src/material.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { SharedModule } from '../shared/shared.module';



@NgModule({
  declarations: [
    HomeComponent,
    ListComponent,
  ],
  imports: [
    CommonModule,
    HttpClientModule,
    MaterialModule,
    FormsModule,
    ReactiveFormsModule,
    BookingRoutingModule,
    SharedModule
  ]
})
export class BookingModule { }
