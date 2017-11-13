package com.lanou.hr.service;

import com.lanou.hr.domain.Department;
import com.lanou.hr.domain.Staff;

import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
public interface StaffService {
    Staff login(Staff staff);

    List<Staff> find(Staff staff);

    List<Department> staffFindDepartment();
}
