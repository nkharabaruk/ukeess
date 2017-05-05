import {Injectable} from "@angular/core";
import "rxjs/add/operator/map";
import {Http} from "@angular/http";
import {Employee} from "../model/employee.model";
import {Observable} from "rxjs/Observable";
import {environment} from "../../environments/environment";

@Injectable()
export class EmployeeDetailsService {
  baseUrl: string = `${environment.rest}/employees`;

  constructor(private http: Http) {
  }

  getEmployee(id: number): Observable<Employee> {
    return this.http.get(`${this.baseUrl}/${id}`)
      .map(response => response.json() as Employee);
  }

  save(employee: Employee) {
    return this.http.put(`${this.baseUrl}/${employee.id}`, employee);
  }
}
