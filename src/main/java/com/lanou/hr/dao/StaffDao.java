package com.lanou.hr.dao;

import com.lanou.hr.domain.Department;
import com.lanou.hr.domain.Post;
import com.lanou.hr.domain.Staff;
import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
public interface StaffDao {

     Staff login(String loginName,String loginPwd);

     List<Staff> find(Staff staff);

     List<Department> staffFindDepartment();

     List<Post> findPost(String depID);

     List<Staff> findPostPostIdAndDepID(String postId,String depID,String staffName);

     void saveStaff(Staff staff);

     void updateStaff(Staff staff);

    void updateStaffLoginPwd(Staff staff,String reNewPassword);
}
