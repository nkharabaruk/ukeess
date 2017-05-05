import {Department} from "./department.model";

export class Employee {
  id: number;
  empName: string;
  empActive: boolean;
  emp_dpID: Department;
}
