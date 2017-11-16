package com.lanou.hr.action;

import com.lanou.hr.domain.Department;
import com.lanou.hr.domain.Post;
import com.lanou.hr.domain.Staff;
import com.lanou.hr.service.StaffService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
@Controller("staffAction")
@Scope("prototype")
public class StaffAction extends ActionSupport implements ModelDriven<Staff> {
    private Staff staff = new Staff();
    private Post post = new Post();
    private String depID;
    private String postId;
    @Resource(name = "staffService")
    private StaffService staffService;
    private List<Department> departmentList;
    private List<Post> postList;
    private List<Staff> staffs;

    private String oldPassword;
    private String newPassword;
    private String reNewPassword;


    /**
     * 员工登录
     *
     * @return
     */
    public String login() {
        Staff s = staffService.login(staff.getLoginName(), staff.getLoginPwd());
        if (s != null) {
            ServletActionContext.getRequest().getSession().setAttribute("staff", staff);
            return SUCCESS;
        }
        addFieldError("msg", "用户名密码不匹配");
        return ERROR;
    }


    /**
     * 登录拦截
     *
     * @return
     */
    @SkipValidation
    public String interceptor() {
        return SUCCESS;
    }

    /**
     * 查询所有员工部门
     *
     * @return
     */
    @SkipValidation
    public String staffFindDepartment() {
        departmentList = staffService.staffFindDepartment();
        return SUCCESS;
    }

    /**
     * 查询员工的职位
     *
     * @return
     */
    @SkipValidation
    public String findPosts() {
        postList = staffService.findPost(depID);
        return SUCCESS;
    }

    /**
     * 高级查询
     * 根据 postId  depID 查询员工
     *
     * @return
     */
    @SkipValidation
    public String findAll() {
        departmentList = staffService.staffFindDepartment();
        staffs = staffService.findPostPostIdAndDepID(postId, depID, staff.getStaffName());
        return SUCCESS;
    }


    /**
     * 添加
     * 员工的表单数据
     *
     * @param
     */
    @SkipValidation
    public String saveStaff() {
        staffService.saveStaff(staff);
        departmentList = staffService.staffFindDepartment();
        return SUCCESS;
    }

    /**
     * 编辑
     * 修改员工信息
     *
     * @return
     */
    @SkipValidation
    public String updateStaff() {
        staffService.updateStaff(staff);
        departmentList = staffService.staffFindDepartment();
        return SUCCESS;
    }

    /**
     * 修改密码
     *
     * @return
     */
    @SkipValidation
    public String updatePassword() {
        Staff staff1 = (Staff) ServletActionContext.getRequest().getSession().getAttribute("staff");
        if (!(staff1.getLoginPwd().equals(oldPassword)) || !newPassword.equals(reNewPassword)) {
            addActionError("密码输入错误");
            return ERROR;
        } else {
            staffService.updateStaffLoginPwd(staff1, reNewPassword);
            return SUCCESS;
        }
    }
        @Override
        public Staff getModel () {
            return staff;
        }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

    public String getDepID() {
        return depID;
    }

    public void setDepID(String depID) {
        this.depID = depID;
    }

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public List<Staff> getStaffs() {
        return staffs;
    }

    public void setStaffs(List<Staff> staffs) {
        this.staffs = staffs;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getReNewPassword() {
        return reNewPassword;
    }

    public void setReNewPassword(String reNewPassword) {
        this.reNewPassword = reNewPassword;
    }
}
