import {Injectable} from "@angular/core";
import "rxjs/add/operator/map";
import {Http} from "@angular/http";
import {environment} from "../../environments/environment";
import {Department} from "../model/department.model";

@Injectable()
export class DepartmentsService {
  baseUrl: string = `${environment.rest}/departments`;

  constructor(private http: Http) {
  }

  getAll() {
    return this.http.get(`${this.baseUrl}`).map(
      response => {
        return response.json() as Department[];
      });
  }
}
