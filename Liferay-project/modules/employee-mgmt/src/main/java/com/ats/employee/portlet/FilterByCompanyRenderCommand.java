package com.ats.employee.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import employe.db.layer.model.employee;
import employe.db.layer.service.employeeLocalService;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
    property = {
        "javax.portlet.name=your_portlet_name",
        "mvc.command.name=kavya"
    },
    service = MVCRenderCommand.class
)
public class FilterByCompanyRenderCommand implements MVCRenderCommand {

    @Reference
    private employeeLocalService employeeLocalService;

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * @Override public String render(RenderRequest renderRequest, RenderResponse
	 * renderResponse) { System.out.println("filtter method inside::::"); String
	 * company = ParamUtil.getString(renderRequest, "company");
	 * System.out.println("slected values"+company); List<employee> employees;
	 * 
	 * if (Validator.isNotNull(company)) { employees =
	 * employeeLocalService.getRegisterByLastName(company); } else { employees =
	 * employeeLocalService.getemployees(-1, -1); // all employees }
	 * 
	 * renderRequest.setAttribute("employees", employees);
	 * renderRequest.setAttribute("company", company);
	 * 
	 * return "/view.jsp"; // your JSP path }
	 */
}
