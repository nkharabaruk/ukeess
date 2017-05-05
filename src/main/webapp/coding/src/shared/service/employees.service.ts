import {Injectable} from "@angular/core";
import "rxjs/add/operator/map";
import {Http} from "@angular/http";
import {Employee} from "../model/employee.model";
import {Page} from "../model/page.model";
import {environment} from "../../environments/environment";
import {Observable} from "rxjs/Observable";

@Injectable()
export class EmployeesService {
  baseUrl: string = `${environment.rest}/employees`;

  constructor(private http: Http) {
  }

  getPage(page: number, size: number) {
    return this.http.get(`${this.baseUrl}`, {params: {page: page, size: size}}).map(
      response => {
        return response.json() as Page<Employee>;
      });
  }

  deleteEmployeeById(id: number) {
    return this.http.delete(`${this.baseUrl}/${id}`);
  }

  findByEmpNameStartsWith(search: string, page: number, size: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/find`, {params: {empName: search, page: page, size: size}})
      .map(res => res.json());
  }
}
