package com.lanou.hr.dao;

import com.lanou.hr.domain.Department;
import com.lanou.hr.domain.Post;

import java.util.List;

/**
 * Created by dllo on 17/11/10.
 */
public interface PostDao {

    void addSavePost(Post post);

    List<Post> findPost();

    List<Department> findDepartment();
}
