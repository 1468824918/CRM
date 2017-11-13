package com.lanou.hr.interceptor;

import com.lanou.hr.domain.Staff;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import org.apache.struts2.ServletActionContext;

/**
 * 登录拦截器
 */
public class StaffInterceptor extends MethodFilterInterceptor {
    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        Staff staff = (Staff)  ServletActionContext.getRequest().getSession().getAttribute("staff");
        System.out.println("不是管理员瞎点啥");
        if (!staff.getLoginName().equals("admin")){
            return "login";
        }
        return actionInvocation.invoke();
    }
}
