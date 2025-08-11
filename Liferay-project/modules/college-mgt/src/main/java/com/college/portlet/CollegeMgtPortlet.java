/*
 * package com.college.portlet;
 * 
 * import com.college.constants.CollegeMgtPortletKeys; import
 * com.college.model.college; import
 * com.college.service.collegeLocalServiceUtil; import
 * com.liferay.portal.kernel.log.Log; import
 * com.liferay.portal.kernel.log.LogFactoryUtil; import
 * com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet; import
 * com.liferay.portal.kernel.util.ParamUtil;
 * 
 * import java.io.IOException; import java.util.List;
 * 
 * import javax.portlet.ActionRequest; import javax.portlet.ActionResponse;
 * import javax.portlet.Portlet; import javax.portlet.PortletException; import
 * javax.portlet.RenderRequest; import javax.portlet.RenderResponse;
 * 
 * import org.osgi.service.component.annotations.Component;
 * 
 * 
 *//**
	 * @author Admin
	 *//*
		 * @Component(property = {
		 * "com.liferay.portlet.display-category=category.sample",
		 * "com.liferay.portlet.header-portlet-css=/css/main.css",
		 * "com.liferay.portlet.instanceable=true",
		 * "javax.portlet.display-name=CollegeMgt",
		 * "javax.portlet.init-param.template-path=/",
		 * "javax.portlet.init-param.view-template=/view.jsp", "javax.portlet.name=" +
		 * CollegeMgtPortletKeys.COLLEGEMGT,
		 * "javax.portlet.resource-bundle=content.Language",
		 * "javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
		 * public class CollegeMgtPortlet extends MVCPortlet {
		 * 
		 * private static final Log log =
		 * LogFactoryUtil.getLog(CollegeMgtPortlet.class);
		 * 
		 * public void collegeRegistration(ActionRequest actionRequest, ActionResponse
		 * actionResponse) throws IOException, PortletException {
		 * 
		 * log.info("College Registration successfull");
		 * 
		 * String name = ParamUtil.getString(actionRequest, "name"); String address =
		 * ParamUtil.getString(actionRequest, "address"); String gender =
		 * ParamUtil.getString(actionRequest, "gender");
		 * 
		 * college clgObj = collegeLocalServiceUtil.getInstance(); clgObj.setName(name);
		 * clgObj.setGender(gender); clgObj.setAddress(address);
		 * 
		 * college colg1 = collegeLocalServiceUtil.addcollege(clgObj);
		 * log.info("College Registration Successfull :" + colg1);
		 * 
		 * }
		 * 
		 * // fir viewing data
		 * 
		 * @Override public void render(RenderRequest renderRequest, RenderResponse
		 * renderResponse) throws IOException, PortletException {
		 * 
		 * List<college> colleges = collegeLocalServiceUtil.getcolleges(-1, -1);
		 * renderRequest.setAttribute("colleges", colleges); super.render(renderRequest,
		 * renderResponse); } // updating data
		 * 
		 * public void editcollegeRegistration(ActionRequest actionRequest,
		 * ActionResponse actionResponse) throws IOException, PortletException {
		 * 
		 * log.info("College Edit successfull");
		 * 
		 * long collegeID = ParamUtil.getLong(actionRequest, "collegeId");
		 * 
		 * log.info("College ID :" + collegeID);
		 * 
		 * String name = ParamUtil.getString(actionRequest, "name"); String address =
		 * ParamUtil.getString(actionRequest, "address"); String gender =
		 * ParamUtil.getString(actionRequest, "gender");
		 * 
		 * college data = collegeLocalServiceUtil.fetchcollege(collegeID);
		 * data.setName(name); data.setGender(gender); data.setAddress(address);
		 * 
		 * college saveData = collegeLocalServiceUtil.updatecollege(data);
		 * log.info("College Edit succefully : " + saveData);
		 * System.out.println("College Edited Successfully :" + saveData);
		 * 
		 * }
		 * 
		 * // to delete data
		 * 
		 * public void deleteCollege(ActionRequest actionRequest, ActionResponse
		 * actionResponse) throws IOException, PortletException {
		 * log.info("College  Delete Successfully");
		 * 
		 * long collegeId = ParamUtil.getLong(actionRequest, "collegeId");
		 * 
		 * college clg = collegeLocalServiceUtil.fetchcollege(collegeId);
		 * 
		 * if (clg != null) { collegeLocalServiceUtil.deletecollege(clg); } }
		 * 
		 * }
		 */