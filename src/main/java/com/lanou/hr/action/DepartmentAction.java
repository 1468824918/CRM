package com.lanou.hr.action;

import com.lanou.hr.domain.Department;
import com.lanou.hr.service.DepartmentService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/11/10.
 */
@Controller("departmentAction")
@Scope("prototype")
public class DepartmentAction extends ActionSupport implements ModelDriven<Department>{

    @Resource(name = "departmentService")
    private DepartmentService departmentService;

    private Department department = new Department();
    private List<Department> list;

    /**
     * 查询所有部门
     * @return
     */
    public String findAll(){
        list = departmentService.findAll();
        return SUCCESS;
    }

    /**
     * 插入部门
     * @return
     */
    public String addOrEditPre(){
        if (department.getDepName().equals("")){
            addActionError("部门不能为空");
            return ERROR;
        }else {
            departmentService.addOrEditPre(department);
        }
        return SUCCESS;
    }



    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Department> getList() {
        return list;
    }

    public void setList(List<Department> list) {
        this.list = list;
    }

    @Override
    public Department getModel() {
        return department;
    }

}
