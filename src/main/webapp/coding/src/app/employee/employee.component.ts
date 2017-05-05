import {Component, OnInit} from "@angular/core";
import {EmployeesService} from "../../shared/service/employees.service";
import {Employee} from "../../shared/model/employee.model";
import {Router} from "@angular/router";

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {
  title = "Employees";
  employees: Employee[];
  pageNumbers: number[];
  pageNumber: number;
  first: boolean;
  last: boolean;
  search: string;

  constructor(private employeesService: EmployeesService,
              private router: Router) {
  }

  ngOnInit() {
    this.getPage(0);
  }

  getPage(number: number) {
    let req;
    if (!!this.search) {
      req = this.employeesService.findByEmpNameStartsWith(this.search, number, 10);
    } else {
      req = this.employeesService.getPage(number, 10);
    }
    req.subscribe(page => {
      this.employees = page.content;
      this.pageNumbers = this.getPageNumbers(page.totalPages);
      this.pageNumber = page.number;
      this.first = page.first;
      this.last = page.last;
    });
  }

  getPageNumbers(totalPages: number) {
    let pages = [];
    for (let i = 0; i < totalPages; i++) {
      pages.push(i);
    }
    return pages;
  }

  delete(id: number) {
    if (confirm("Are you sure to delete employee with id " + id)) {
      this.employeesService.deleteEmployeeById(id)
        .subscribe(response => {
          this.getPage(0)
        });
    }
  }
}
