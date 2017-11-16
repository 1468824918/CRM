package com.lanou.hr.dao.impl;

import com.HibernateUtil;
import com.lanou.hr.domain.Department;
import com.lanou.hr.domain.Post;
import com.lanou.hr.domain.Staff;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by dllo on 17/11/15.
 */
public class StaffDaoImplTest {
    @Test
    public void login() throws Exception {

        Session session = HibernateUtil.openSession();
        Staff staff = new Staff("小贱人");
        session.save(staff);
        HibernateUtil.commit();

    }

    @Test
    public void find() throws Exception {
        Session session = HibernateUtil.openSession();
        Staff staff = session.get(Staff.class, "2c9090525fb813a5015fb8149a180001");
        System.out.println(staff);
        HibernateUtil.commit();

    }

    @Test
    public void staffFindDepartment() throws Exception {

        Session session = HibernateUtil.openSession();
        Department department = session.get(Department.class, "2c9090525fb50111015fb50113e90002");
        System.out.println(department);
        HibernateUtil.commit();

    }

    @Test
    public void findPost() throws Exception {

        Session session = HibernateUtil.openSession();
        Post post = session.get(Post.class, "2c9090525fb50111015fb50113d90000");
        System.out.println(post.getPostName());
        HibernateUtil.commit();

    }


    @Test
    public void saveStaff() throws Exception {

        Session session = HibernateUtil.openSession();

        Staff staff = new Staff();
        staff.setStaffId("2c9090525fb84ee7015fb851444b0011");
        staff.setLoginName("李白");
        staff.setStaffName("李白");
        staff.setLoginPwd("111");
        Date day = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(df.format(day));
        staff.setOnDutyDate(day);
        staff.setGender("男");
        session.save(staff);
        HibernateUtil.commit();

    }

    @Test
    public void updateStaff() throws Exception {

        Session session = HibernateUtil.openSession();
        Staff staff = session.get(Staff.class, "2c9090525fbd6c01015fbd6c03150000");
        System.out.println(staff);
        staff.setStaffName("韩信");
        session.update(staff);
        HibernateUtil.commit();
    }


}