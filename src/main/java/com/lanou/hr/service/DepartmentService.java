package com.lanou.hr.service;

import com.lanou.hr.domain.Department;

import java.util.List;

/**
 * Created by dllo on 17/11/10.
 */
public interface DepartmentService {

    List<Department> findAll();

    void addOrEditPre(Department department);
}
