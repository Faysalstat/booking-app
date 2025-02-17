import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeComponent } from './home/home.component';
import { ListComponent } from './list/list.component';
import { HospitalRoutingModule } from './hospital.module.routing';
import { SharedModule } from '../shared/shared.module';
import { HttpClientModule } from '@angular/common/http';
import { MaterialModule } from 'src/material.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';



@NgModule({
  declarations: [
    HomeComponent,
    ListComponent
  ],
  imports: [
    CommonModule,
    SharedModule,
    HttpClientModule,
    MaterialModule,
    FormsModule,
    ReactiveFormsModule,
    HospitalRoutingModule
  ]
})
export class HospitalModule { }
