package com.lanou.hr.dao.impl;

import com.lanou.hr.dao.DepartmentDao;
import com.lanou.hr.domain.Department;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dllo on 17/11/10.
 */
@Repository("departmentDao")
public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao {

    /**
     * 查询所有部门
     *
     * @return
     */
    @Override
    public List<Department> findAll() {
        return (List<Department>) getHibernateTemplate().find("from Department crm_department");

    }

    /**
     * 插入部门
     *
     * @param department
     */
    @Override
    public void addOrEditPre(Department department) {
        if (department.getDepID().equals("")) {
            getHibernateTemplate().save(department);
        }else {
            getHibernateTemplate().saveOrUpdate(department);
        }
    }
}
