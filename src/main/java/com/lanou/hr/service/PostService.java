package com.lanou.hr.service;

import com.lanou.hr.domain.Department;
import com.lanou.hr.domain.Post;

import java.util.List;

public interface PostService {

    void addSavePost(Post post);

    List<Post> findPost();

    List<Department> findDepartment();
}
