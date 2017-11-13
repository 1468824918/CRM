package com.lanou.hr.dao.impl;

import com.lanou.hr.dao.StaffDao;
import com.lanou.hr.domain.Department;
import com.lanou.hr.domain.Staff;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
public class StaffDaoImpl extends HibernateDaoSupport implements StaffDao {

    /**
     * 员工的登录
     * @param staff
     * @return
     */
    @Override
    public Staff login(Staff staff) {
        getHibernateTemplate().save(staff);
        return staff;
    }

    /**
     * 查询员工信息
     * @param staff
     * @return
     */
    @Override
    public List<Staff> find(Staff staff) {
        return (List<Staff>) getHibernateTemplate().find("from Staff crm_staff");
    }

    /**
     * 查找员工所有部门
     * @return
     */
    @Override
    public List<Department> staffFindDepartment() {
        return (List<Department>) getHibernateTemplate().find("from Department dept");
    }


}
