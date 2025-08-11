package com.practice.employee.portlet;

import com.practice.employee.constants.PractiveEmployeePortletKeys;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;

import employe.db.layer.model.employee;
import employe.db.layer.service.employeeLocalServiceUtil;

/**
 * @author Admin
 */
@Component(
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=PractiveEmployee",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + PractiveEmployeePortletKeys.PRACTIVEEMPLOYEE,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class PractiveEmployeePortlet extends MVCPortlet {
	
	public void employeeByCompany(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		
		String company = ParamUtil.getString(actionRequest, "comapny");
		System.out.println("Company Name ::: " + company);
		
		List<employee> employeeList = employeeLocalServiceUtil.getEmployeeByCompany(company);
		//if(Validator.isNotNull(employeeList)) {
			for(employee emp : employeeList) {
				System.out.println("Company Name ::: " + emp.getCompany());
				System.out.println("Company employee name ::: " + emp.getName());
				System.out.println("employee Salary ::: " + emp.getSalary());
			}
		//} else {
			//System.out.println("employeeList is empty ::: " );
		//}

		
	}
}