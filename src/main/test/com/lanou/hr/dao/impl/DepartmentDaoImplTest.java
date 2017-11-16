package com.lanou.hr.dao.impl;

import com.HibernateUtil;
import com.lanou.hr.domain.Department;
import org.hibernate.Session;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dllo on 17/11/15.
 */
public class DepartmentDaoImplTest {
    @Test
    public void findAll() throws Exception {
        Session session = HibernateUtil.openSession();
        Department department = session.get(Department.class, "2c9090525fb50111015fb50113e90002");
        System.out.println(department);
        HibernateUtil.commit();
    }

    @Test
    public void addOrEditPre() throws Exception {
        Session session = HibernateUtil.openSession();
        Department department = new Department("财务部");
        session.save(department);
        HibernateUtil.commit();
    }

}