package com.ats.employee.portlet;

import employe.db.layer.model.employee;
import employe.db.layer.service.employeeLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.workflow.BaseWorkflowHandler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandler;

import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;

import java.io.Serializable;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;



@Component(
    property = {
        "model.class.name=employe.db.layer.model.employee"
    },
    service = WorkflowHandler.class
)

public class EmployeeWorkFlowHandler extends BaseWorkflowHandler<employee>{

	@Override
	public String getClassName() {
		
		return employee.class.getName();
	}

	@Override
	public String getType(Locale locale) {
		
		return "employee_workflow";
	}

	@Override
public employee updateStatus(int status, Map<String, Serializable> workflowContext) throws PortalException {

    long userId = GetterUtil.getLong(
        (String) workflowContext.get(WorkflowConstants.CONTEXT_USER_ID));

    long empId = GetterUtil.getLong(
        (String) workflowContext.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));

    ServiceContext serviceContext = (ServiceContext) workflowContext.get(
        WorkflowConstants.CONTEXT_SERVICE_CONTEXT);

    return employeeLocalServiceUtil.updateEmployeeStatus(userId, empId, status, serviceContext);
}


}