import { Component, OnInit } from '@angular/core';
import { EmployeeTrainingService } from './employee-training.service';
import { Training } from './employeeTraining';

@Component({
  selector: 'app-employee-training',
  templateUrl: './employee-training.component.html',
  styleUrls: ['./employee-training.component.css']
})
export class EmployeeTrainingComponent implements OnInit {

  empId: number = 0;

  f1: boolean = false
  f2: boolean = false
  f3: boolean = false
  f4: boolean = false

  flagGET: boolean = false;
  flagGETs: boolean = false;

  errorMessage: string | null = null;

  postResponseMessage: any | null = null;
  postErrorMessage: string | null = null;

  putResponseMessage: any | null = null;
  putErrorMessage: string | null = null;

  deleteResponseMessage: any | null = null;
  deleteErrorMessage: string | null = null;

  date:Date= new Date()

  public trainings = [
    {
      "empId": 0,
      "courseCode": "",
      "courseName": "",
      "score": 0,
      "hourSpend": 0,
      "dateOfComplition": this.date,
      "status": ""
    }];

  public training = {
    "empId": 0,
    "courseCode": "",
    "courseName": "",
    "score": 0,
    "hourSpend": 0,
    "dateOfComplition": this.date,
    "status": ""
  };

  train: Training = new Training(0,"", "",0,0,this.date,"");

  constructor(private trainingService: EmployeeTrainingService) {

  }

  ngOnInit(): void {

    this.trainingService.getTrainings()
      .subscribe(
        data => this.trainings = data,
        error => this.errorMessage = <any>error
      );


  }

  getTraining(empId: string): void {

    this.empId =Number(empId);
    this.flagGET = (!this.flagGET);
    this.trainingService.getTraining(this.empId)
      .subscribe(
        (data) => { this.training = data; this.errorMessage = null },
        (error) => {
          this.errorMessage = <any>error.error.errorMessage;
        }
      );

  }

  addTraining(trainObj: any) {
   
    this.train.empId=trainObj.empId;
    this.train.courseCode=trainObj.courseCode;
    this.train.courseName=trainObj.courseName;
    this.train.dateOfComplition=trainObj.dateOfComplition;
    this.train.hourSpend=trainObj.hourSpend;
    this.train.score=trainObj.score;
    this.train.status=trainObj.status;


    this.trainingService.addTraining(this.train)
      .subscribe(
        (msg) => {
          this.postErrorMessage = null;
          console.log(msg.successMessage);
          this.postResponseMessage = msg.successMessage;
        },
        (errorMessage) => {
          this.postResponseMessage = null;
          this.postErrorMessage = errorMessage.error.errorMessage;
          console.log(errorMessage);

        },

      );
  }

  updateTraining(trainObj: any) {

    this.train.empId=trainObj.empId;
    this.train.courseCode=trainObj.courseCode;
    this.train.courseName=trainObj.courseName;
    this.train.dateOfComplition=trainObj.dateOfComplition;
    this.train.hourSpend=trainObj.hourSpend;
    this.train.score=trainObj.score;
    this.train.status=trainObj.status;

  

    this.trainingService.updateTraining(this.train)
      .subscribe(
        (msg) => {
          this.putErrorMessage = null;
          console.log(msg.successMessage);
          this.putResponseMessage = msg.successMessage;
        },
        (errorMessage) => {
          this.putResponseMessage = null;
          this.putErrorMessage = errorMessage.error.errorMessage;
          console.log(errorMessage);

        },

      );
  }

  deleteTraining(empId: string): void {


    console.log(empId)
    this.trainingService.deleteTraining(Number(empId))
      .subscribe(
        (msg) => {
          this.deleteErrorMessage = null;
          console.log(msg.successMessage);
          this.deleteResponseMessage = msg.successMessage;
        },
        (errorMessage) => {
          this.deleteResponseMessage = null;
          this.deleteErrorMessage = errorMessage.error.errorMessage;
          console.log(errorMessage);

        },

      );

  }

  getsClick() {
    this.flagGETs = (!this.flagGETs)
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
