import {Routes, RouterModule} from "@angular/router";
import {EmployeeComponent} from "./employee/employee.component";
import {ModuleWithProviders} from "@angular/core";
import {EmployeeDetailsComponent} from "./employee-details/employee-details.component";

export const router: Routes = [
  {path: '', redirectTo: 'employees', pathMatch: 'full'},
  {path: 'employees', component: EmployeeComponent},
  {path: 'employees/:id/view', component: EmployeeDetailsComponent},
  {path: 'employees/:id/edit', component: EmployeeDetailsComponent}
];

export const routes: ModuleWithProviders = RouterModule.forRoot(router);
