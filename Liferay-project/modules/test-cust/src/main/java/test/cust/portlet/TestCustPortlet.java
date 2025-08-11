package test.cust.portlet;

import test.cust.constants.TestCustPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

import employe.db.layer.model.employee;
import employe.db.layer.service.employeeLocalServiceUtil;

/**
 * @author Admin
 */
@Component(property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=TestCust", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp", "javax.portlet.name=" + TestCustPortletKeys.TESTCUST,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class TestCustPortlet extends MVCPortlet {

	public String filttercompany(ActionRequest actionRequest, ActionResponse actionResponse) {
		System.out.println("filtter method inside::::");
		String company = ParamUtil.getString(actionRequest, "company");
		System.out.println("slected values" + company);
		/* List<employee> employees; */

		//List<employee> employees = employeeLocalServiceUtil.getRegisterByLastNames(company);

		//actionRequest.setAttribute("employees", employees);
		actionRequest.setAttribute("company", company);
		return company;

	
	}
}