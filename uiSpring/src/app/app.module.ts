import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule, routingComponent } from './app-routing.module';
import { AppComponent } from './app.component';

import {HttpClientModule} from '@angular/common/http';
import { EmployeeService } from './employee/employee.service';
import { FormsModule } from '@angular/forms';
import { EmployeeTrainingComponent } from './employee-training/employee-training.component';

@NgModule({
  declarations: [
    AppComponent,
    routingComponent,
    EmployeeTrainingComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [EmployeeService],
  bootstrap: [AppComponent]
})
export class AppModule { }
