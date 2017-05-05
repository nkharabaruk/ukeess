import {Component, OnInit} from "@angular/core";
import {Employee} from "../../shared/model/employee.model";
import {ActivatedRoute, Router} from "@angular/router";
import {EmployeeDetailsService} from "../../shared/service/employee-details.service";
import {Location} from "@angular/common";
import {Department} from "../../shared/model/department.model";
import {DepartmentsService} from "../../shared/service/departments.service";

@Component({
  selector: 'app-employee-details',
  templateUrl: './employee-details.component.html',
  styleUrls: ['./employee-details.component.css']
})
export class EmployeeDetailsComponent implements OnInit {
  employee: Employee;
  employeeId: number;
  isEdit: boolean;
  departments: Department[];
  emp_dpID: number;

  constructor(private employeeDetailsService: EmployeeDetailsService,
              private departmentsService: DepartmentsService,
              private activatedRoute: ActivatedRoute,
              private router: Router,
              private location: Location) {
  }

  ngOnInit() {
    this.activatedRoute.params.subscribe(params => {
      this.employeeId = params['id'];
    });
    this.employeeDetailsService.getEmployee(this.employeeId).subscribe(employee => {
      this.employee = employee;
      this.emp_dpID = employee.emp_dpID ? employee.emp_dpID.dpID : 0;
    });
    this.isEdit = (this.router.url == `/employees/${this.employeeId}/edit`);
    this.departmentsService.getAll().subscribe(departments => this.departments = departments);
  }

  save() {
    this.employee.emp_dpID = this.departments.find(dep => dep.dpID == this.emp_dpID);
    this.employeeDetailsService.save(this.employee).subscribe(employee => {
      this.router.navigate(['employees']);
    });
  }

  backClicked() {
    this.location.back();
  }
}
