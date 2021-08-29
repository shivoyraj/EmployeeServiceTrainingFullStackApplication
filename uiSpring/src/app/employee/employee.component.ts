import { HttpResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Asset } from './Asset';
import { Employee, Iemployee } from './employee';
import { EmployeeService } from './employee.service';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {


  empId: number = 0;

  f1: boolean = false
  f2: boolean = false
  f3: boolean = false
  f4: boolean = false

  flagGET: boolean = false;
  flagGETs: boolean = false;

  errorMessage: string | null = null;
  getsErrorMessage: string | null = null;


  postResponseMessage: any | null = null;
  postErrorMessage: string | null = null;

  putResponseMessage: any | null = null;
  putErrorMessage: string | null = null;

  deleteResponseMessage: any | null = null;
  deleteErrorMessage: string | null = null;

  public employees = [{
    "asset": {
      "assetId": "",
      "assetName": "",
      "assetType": ""
    },
    "empAddress": "",
    "empId": 0,
    "empName": ""
  }];

  public employee = {
    "asset": {
      "assetId": "",
      "assetName": "",
      "assetType": ""
    },
    "empAddress": "",
    "empId": 0,
    "empName": ""
  };

  asset: Asset = new Asset("", "", "");
  emp: Employee = new Employee(0, "", "", this.asset);

  constructor(private empService: EmployeeService) {

  }

  ngOnInit(): void {
  }

  getEmps() {
    this.empService.getEmployees()
      .subscribe(
        (data) => {this.employees = data;
          this.flagGETs = true;
          this.getsErrorMessage = null
        },
        (error) => {
          this.getsErrorMessage = <any>error.error.errorMessage;
          this.flagGETs = false;
        }
      );


  }


  getEmp(empId: string): void {

    this.empId = Number(empId);
    this.flagGET = (!this.flagGET);
    this.empService.getEmployee(this.empId)
      .subscribe(
        (data) => { this.employee = data; this.errorMessage = null },
        (error) => {
          this.errorMessage = <any>error.error.errorMessage;
        }
      );

  }

  addEmp(empObj: any) {
    this.emp.empId = empObj.empId;
    this.emp.empName = empObj.empName;
    this.emp.empAddress = empObj.empAddress;
    this.emp.asset.assetId = empObj.assetId;

    this.empService.addEmployee(this.emp)
      .subscribe(
        (msg) => {
          this.postErrorMessage=null;
          console.log(msg.successMessage);
          this.postResponseMessage=msg.successMessage;
      },
        (errorMessage) => {
          this.postResponseMessage = null;
          this.postErrorMessage = errorMessage.error.errorMessage;
          console.log(errorMessage);

        },
        
      );
  }

  updateEmp(empObj: any) {
    this.emp.empId = empObj.empId;
    this.emp.empName = empObj.empName;
    this.emp.empAddress = empObj.empAddress;
    this.emp.asset.assetId = empObj.assetId;

    this.empService.updateEmployee(this.emp)
      .subscribe(
        (msg) => {
          this.putErrorMessage=null;
          console.log(msg.successMessage);
          this.putResponseMessage=msg.successMessage;
      },
        (errorMessage) => {
          this.putResponseMessage = null;
          this.putErrorMessage = errorMessage.error.errorMessage;
          console.log(errorMessage);

        },
        
      );
  }

  deleteEmp(empId:string):void{

    this.emp.empId=Number(empId)
    this.empService.deleteEmployee(this.emp.empId)
      .subscribe(
        (msg) => {
          this.deleteErrorMessage=null;
          console.log(msg.successMessage);
          this.deleteResponseMessage=msg.successMessage;
      },
        (errorMessage) => {
          this.deleteResponseMessage = null;
          this.deleteErrorMessage = errorMessage.error.errorMessage;
          console.log(errorMessage);

        },
        
      );

  }

 



  getEnable1() {
    this.f1 = (!this.f1)
    this.f2 = false;
    this.f3 = false;
    this.f4 = false;
  }
  getEnable2() {
    this.f1 = false;
    this.f2 = (!this.f2);
    this.f3 = false;
    this.f4 = false;
  }
  getEnable3() {
    this.f1 = false;
    this.f2 = false;
    this.f3 = (!this.f3);
    this.f4 = false;
  }
  getEnable4() {
    this.f1 = false;
    this.f2 = false;
    this.f3 = false;
    this.f4 = (!this.f4);
  }
}




