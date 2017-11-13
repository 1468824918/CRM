package com.lanou.hr.dao.impl;

import com.HibernateUtil;
import com.lanou.hr.domain.Department;
import com.lanou.hr.domain.Post;
import org.hibernate.Session;
import org.junit.Test;

/**
 * Created by dllo on 17/11/11.
 */
public class PostDaoImplTest {


    @Test
    public void save(){
        Session session = HibernateUtil.openSession();

        Department department = new Department("教学部");
        Department department1 = new Department("职规部");

        Post post = new Post("讲师");
        Post post1 = new Post("职规");

        post.setDepartment(department);
        post1.setDepartment(department1);

        department.getPosts().add(post);
        department1.getPosts().add(post1);

        session.save(post);
        session.save(post1);

        session.save(department);
        session.save(department1);

        HibernateUtil.commit();


    }

}