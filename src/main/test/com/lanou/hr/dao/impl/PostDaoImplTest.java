package com.lanou.hr.dao.impl;

import com.HibernateUtil;
import com.lanou.hr.domain.Department;
import com.lanou.hr.domain.Post;
import org.hibernate.Session;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dllo on 17/11/15.
 */
public class PostDaoImplTest {
    @Test
    public void addSavePost() throws Exception {
        Session session = HibernateUtil.openSession();
        Department department = new Department("市场部");

        Post post = new Post("销售");

        post.setDepartment(department);


        department.getPosts().add(post);


        session.save(post);

        session.save(department);
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
    public void findDepartment() throws Exception {
        Session session = HibernateUtil.openSession();
        Department department = session.get(Department.class,"2c9090525fb50111015fb50113e90002");
        System.out.println(department.getDepName());
        HibernateUtil.commit();

    }

}