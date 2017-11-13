package com.lanou.hr.service.impl;

import com.lanou.hr.dao.DepartmentDao;
import com.lanou.hr.domain.Department;
import com.lanou.hr.service.DepartmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/11/10.
 */
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService{

    @Resource(name = "departmentDao")
    private DepartmentDao departmentDao;

    /**
     * 查询所有部门
     * @return
     */
    @Override
    public List<Department> findAll() {
        return departmentDao.findAll();
    }

    /**
     * 插入部门
     * @param department
     */
    @Override
    public void addOrEditPre(Department department) {
        departmentDao.addOrEditPre(department);
    }

    public void setDepartmentDao(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }
}
