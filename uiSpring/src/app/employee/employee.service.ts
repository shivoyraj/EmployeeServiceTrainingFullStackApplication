import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee, Iemployee } from './employee';


const httpOptions = { headers: new HttpHeaders({ 'Access-Control-Allow-Origin': '*', }), };

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {



 

  constructor(private http: HttpClient) { }



  getEmployees(): Observable<Iemployee[]> {

    const getsUrl = "http://localhost:8081/InfyEmployee/employees";
    return this.http.get<Iemployee[]>(getsUrl, httpOptions);

  }

  getEmployee(empId: number): Observable<Iemployee> {

    const u = "http://localhost:8081/InfyEmployee/employee/" + empId;
    return this.http.get<Iemployee>(u, httpOptions);

  }

  addEmployee(emp: Employee): Observable<any> {
    const baseURL = "http://localhost:8081/InfyEmployee/employee";
    const headers = { 'content-type': 'application/json' };
    const body = JSON.stringify(emp);
    return this.http.post<any>(baseURL, body, { headers })
  }

  updateEmployee(emp: Employee): Observable<any> {
    const baseURL = "http://localhost:8081/InfyEmployee/employee/" + emp.empId;
    const headers = { 'content-type': 'application/json' };
    const body = JSON.stringify(emp);
    return this.http.put<any>(baseURL, body, { headers })
  }

  deleteEmployee(empId: number): Observable<any> {

    const u = "http://localhost:8081/InfyEmployee/employee/" + empId;
    return this.http.delete<any>(u, httpOptions);

  }

}
