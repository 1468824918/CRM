package com.lanou.hr.dao.impl;

import com.lanou.hr.dao.PostDao;
import com.lanou.hr.domain.Department;
import com.lanou.hr.domain.Post;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dllo on 17/11/10.
 */
@Repository("postDao")
public class PostDaoImpl extends HibernateDaoSupport implements PostDao{


    /**
     * 职务管理(插入职务)
     * @param post
     */
    @Override
    public void addSavePost(Post post) {
        if ("".equals(post.getPostId())){
            getHibernateTemplate().save(post);
        }else {
            getHibernateTemplate().saveOrUpdate(post);
        }
    }

    /**
     * 查询所有职务
     */
    @Override
    public List<Post> findPost() {
        return (List<Post>) getHibernateTemplate().find("from Post post");
    }

    /**
     * 查询所有部门
     * @return
     */
    @Override
    public List<Department> findDepartment() {
        return (List<Department>) getHibernateTemplate().find("from Department dept");
    }


}
