package com.lanou.hr.service.impl;

import com.lanou.hr.dao.StaffDao;
import com.lanou.hr.domain.Department;
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
    public Staff login(Staff staff) {
        staffDao.login(staff);
        return staff;
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


    public void setStaffDao(StaffDao staffDao) {
        this.staffDao = staffDao;
    }
}
