
package com.ats.employee.portlet;

import com.ats.employee.constants.EmployeeMgmtPortletKeys;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.EmailAddressLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import employe.db.layer.model.employee;
import employe.db.layer.service.employeeLocalServiceUtil;
import employe.db.layer.service.employeeServiceUtil;

/**
 * @author Admin
 */
@Component(
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=EmployeeMgmt",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + EmployeeMgmtPortletKeys.EMPLOYEEMGMT,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = javax.portlet.Portlet.class
)


public class EmployeeMgmtPortlet extends MVCPortlet {
	
	 private static final Log
	    log = LogFactoryUtil.getLog(EmployeeMgmtPortlet.class);
	 
	 
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		
		List<employee> employees = employeeLocalServiceUtil.getemployees(-1, -1);
		renderRequest.setAttribute("employees", employees);
		super.render(renderRequest, renderResponse);
	}
	
    public void addEmployee(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException,PortletException {
    	
    	log.info("Inside Action Method");
    	
    	String name = ParamUtil.getString(actionRequest, "name");
    	String salary = ParamUtil.getString(actionRequest, "salary");
    	String gender = ParamUtil.getString(actionRequest, "gender");
    	String company = ParamUtil.getString(actionRequest, "company");
    	int age = ParamUtil.getInteger(actionRequest, "age");
    	
    	employee empObj = employeeLocalServiceUtil.getInstance();
    	
    	//long empId = CounterLocalServiceUtil.increment(employee.class.getName());    	
    	
    	empObj.setName(name);
    	empObj.setSalary(salary);;
    	empObj.setGender(gender);
    	empObj.setCompany(company);
    	empObj.setAge(age);
    	
    	empObj = employeeLocalServiceUtil.addemployee(empObj);
    }
    
    
    //for edit
    public void editEmployee(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException,PortletException {
    	
    	
    	log.info("Edit employee Data");
    	
    	long employeeId=ParamUtil.getLong(actionRequest, "empId");
    	
    	log.info("emp:"+employeeId);
    	
    	String name=ParamUtil.getString(actionRequest, "name");
    	String salary=ParamUtil.getString(actionRequest, "salary");
    	String company=ParamUtil.getString(actionRequest, "company");
    	String gender=ParamUtil.getString(actionRequest, "gender");
    	int age=ParamUtil.getInteger(actionRequest, "age");
    	
    	employee employeeObj=employeeLocalServiceUtil.fetchemployee(employeeId);
    	employeeObj.setName(name);
    	
    	employeeObj.setAge(age);
    	employeeObj.setCompany(company);
    	employeeObj.setSalary(salary);
    	employeeObj.setGender(gender);
    	
    employee  emp2=employeeLocalServiceUtil.updateemployee(employeeObj);
    log.info("Data Saved");
    
    	
    }
    
    // Delete
    public void deleteEmployee(ActionRequest actionRequest, ActionResponse actionResponse)
            throws IOException, PortletException, PortalException {

        long employeeId = ParamUtil.getLong(actionRequest, "empId");

        employee emp = employeeLocalServiceUtil.fetchemployee(employeeId);

        if (emp != null) {
            employeeLocalServiceUtil.deleteemployee(emp);
        }
    }
    
    //for  custom query

    /*
    public String filttercompany(ActionRequest actionRequest, ActionResponse actionResponse) {
    	System.out.println("filtter method inside::::");
        String company = ParamUtil.getString(actionRequest, "company");
        System.out.println("slected values"+company);
        List<employee> employees;

       
        if (Validator.isNotNull(company)) {
            employees = employeeLocalServiceUtil.getEmployeeByCompany(company);
        } else {
            employees = employeeLocalServiceUtil.getemployees(-1, -1); // all employees
        }

        actionRequest.setAttribute("employees", employees);
     
        actionRequest.setAttribute("company", company);

        return "/view.jsp"; // your JSP path
    }
    */
    
    public void filttercompany(ActionRequest actionRequest, ActionResponse actionResponse)
    		throws IOException, PortletException {
    	ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
    	
    	String company = ParamUtil.getString(actionRequest, "company");
        System.out.println("slected values"+company);
        /*
        List<employee> employees = null;
        
        try {
        	employees = employeeLocalServiceUtil.getemployees(-1, -1);
        	if(Validator.isNotNull(company)) {
        		employees = employeeLocalServiceUtil.getEmployeeByCompany(company);
        	}
        	actionRequest.setAttribute("comEmployees", employees);
        	actionResponse.setRenderParameter("mvcPath", "/view.jsp");
		} catch (Exception e) {
			// TODO: handle exception
		}
		*/
        
        actionResponse.setRenderParameter("company", company);
        actionResponse.setRenderParameter("mvcPath", "/view.jsp");
        
    }
}