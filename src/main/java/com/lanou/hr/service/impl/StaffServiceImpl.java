package com.lanou.hr.service.impl;

import com.lanou.hr.dao.StaffDao;
import com.lanou.hr.domain.Department;
import com.lanou.hr.domain.Post;
import com.lanou.hr.domain.Staff;
import com.lanou.hr.service.StaffService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */

@Service("staffService")
public class StaffServiceImpl implements StaffService {

    @Resource(name = "staffDao")
    private StaffDao staffDao;


    /**
     * 员工登录
     */
    @Override
    public Staff login(String loginName,String loginPwd) {
        return staffDao.login(loginName, loginPwd);

    }

    /**
     * 员工查询
     * @param staff
     * @return
     */
    @Override
    public List<Staff> find(Staff staff) {
        return staffDao.find(staff);
    }


    /**
     * 查询员工的部门
     * @return
     */
    @Override
    public List<Department> staffFindDepartment() {
        return staffDao.staffFindDepartment();
    }

    /**
     * 查询员工的职务
     * @param depID
     * @return
     */
    @Override
    public List<Post> findPost(String depID) {
        return staffDao.findPost(depID);
    }

    /**
     * postId  depID staffName 查询数据
     * @param postId
     * @param depID
     * @param staffName
     * @return
     */
    @Override
    public List<Staff> findPostPostIdAndDepID(String postId, String depID,String staffName) {
        return staffDao.findPostPostIdAndDepID(postId,depID,staffName);
    }


    /**
     * 员工的表单数据
     * @param staff
     */
    @Override
    public void saveStaff(Staff staff) {
        staffDao.saveStaff(staff);
    }


    /**
     * 修改员工信息
     * @param staff
     */
    @Override
    public void updateStaff(Staff staff) {
        staffDao.updateStaff(staff);
    }


    /**
     * 修改密码
     * @param staff
     */
    @Override
    public void updateStaffLoginPwd(Staff staff,String reNewPassword) {
        staffDao.updateStaffLoginPwd(staff,reNewPassword);
    }


    public void setStaffDao(StaffDao staffDao) {
        this.staffDao = staffDao;
    }
}
