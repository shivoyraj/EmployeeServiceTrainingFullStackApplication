import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AssetComponent } from './asset/asset.component';
import { EmployeeTrainingComponent } from './employee-training/employee-training.component';
import { EmployeeComponent } from './employee/employee.component';

const routes: Routes = [
  {path:'employee',component:EmployeeComponent},
  {path:'asset',component:AssetComponent},
  {path:'training',component:EmployeeTrainingComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponent=[EmployeeComponent,AssetComponent]
