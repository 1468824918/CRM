package com.lanou.hr.action;

import com.lanou.hr.domain.Department;
import com.lanou.hr.domain.Post;
import com.lanou.hr.service.PostService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/11/10.
 */
@Controller("postAction")
@Scope("prototype")
public class PostAction extends ActionSupport implements ModelDriven<Post> {

    private Post post = new Post();
    private Department department = new Department();
    private String depID;
    private String depName;

    @Resource(name = "postService")
    private PostService postService;
    private List<Post> posts;
    private List<Department> departmentList;


    /**
     * 职务管理(插入职务)
     *
     * @return
     */
    public String addSavePost() {
        post.setDepartment(new Department(depID,depName));
        postService.addSavePost(post);

        return SUCCESS;
    }

    /**
     * 查询所有职务
     *
     * @return
     */
    public String findPost() {
        posts = postService.findPost();
        return SUCCESS;
    }


    /**
     * 查询所有部门
     * @return
     */
    public String findDepartment(){
        departmentList = postService.findDepartment();
        return SUCCESS;
    }

    @Override
    public Post getModel() {
        return post;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }


    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getDepID() {
        return depID;
    }

    public void setDepID(String depID) {
        this.depID = depID;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }
}
