import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { iTraining, Training } from './employeeTraining';

@Injectable({
  providedIn: 'root'
})
export class EmployeeTrainingService {


  constructor(private http:HttpClient) { }

  getTrainings(): Observable<iTraining[]> {

    const getsUrl = "http://localhost:8081/Infy/Trainings";
    return this.http.get<iTraining[]>(getsUrl);

  }

  getTraining(empId: number): Observable<iTraining> {
 
    const getUrl = "http://localhost:8081/Infy/Training/" + empId;
    return this.http.get<iTraining>(getUrl);

  }

  addTraining(training: Training): Observable<any> {
    const baseURL = "http://localhost:8081/Infy/Training";
    const headers = { 'content-type': 'application/json' };
    const body = JSON.stringify(training);
    return this.http.post<any>(baseURL, body, { headers })
  }

  updateTraining(training: Training): Observable<any> {
    const baseURL = "http://localhost:8081/Infy/Training/" + training.empId;
    const headers = { 'content-type': 'application/json' };
    const body = JSON.stringify(training);
    console.log(training)
    return this.http.put<any>(baseURL, body, { headers })
  }

  deleteTraining(empId: number): Observable<any> {

    const u ="http://localhost:8081/Infy/Training/" + empId;
    console.log(empId)
    return this.http.delete<any>(u);

  }

}
