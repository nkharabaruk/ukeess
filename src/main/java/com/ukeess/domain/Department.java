package com.ukeess.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tblDepartments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer dpID;
    String dpName;
}
