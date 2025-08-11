package com.liferay.portlet;

//import com.ats.employee.portlet.EmployeeMgmtPortlet;
import com.liferay.constants.StudentPortletKeys;
import com.liferay.model.student;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.service.studentLocalServiceUtil;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Admin
 */
@Component(property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", 
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Student11", 
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/init.jsp", 
		"javax.portlet.name=" + StudentPortletKeys.STUDENT,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" 
		}, 
		service = Portlet.class)

public class StudentPortlet extends MVCPortlet {

	private static final Log log = LogFactoryUtil.getLog(StudentPortlet.class);

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

	}

	public void addStudent(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {

//		 ParamUtil is a utility class provided by Liferay, a popular Java-based portal framework. 
//		 It is used to retrieve parameters from the request (such as form inputs or query parameters)
//		 safely and conveniently in portlet or servlet-based applications.
//
//		 ✅ Common Use Case:
//		 In a Liferay portlet, when a form is submitted or when you want to fetch request parameters, 
//		 you use ParamUtil to avoid NullPointerException and to provide default values if parameters are missing.

//		 Window > Preferences > Java > Code Style > Formatter

		log.info("Student Data");

		String name = ParamUtil.getString(actionRequest, "name");
		String qualification = ParamUtil.getString(actionRequest, "qualification");
		long fees = ParamUtil.getLong(actionRequest, "fees");
		String address = ParamUtil.getString(actionRequest, "address");

		String gender = ParamUtil.getString(actionRequest, "gender");

		student stud = studentLocalServiceUtil.getInstacnce();

    	//long empId = CounterLocalServiceUtil.increment(employee.class.getName());    	
		stud.setName(name);
		stud.setQualification(qualification);
		stud.setAddress(address);
		stud.setFees(fees);
		stud.setGender(gender);
		
		
	student data=	studentLocalServiceUtil.addstudent(stud);
	log.info("Data :"+data);
		
	
	}

}