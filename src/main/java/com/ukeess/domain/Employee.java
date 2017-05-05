package com.ukeess.domain;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "tblEmployees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    String empName;
    Boolean empActive;
    @ManyToOne
    Department emp_dpID;
}
