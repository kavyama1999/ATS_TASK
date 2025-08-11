package CheckOutHrmsPortlet.portlet;

import CheckOutHrmsPortlet.constants.CheckOutHrmsPortletKeys;
import checkIndb3.model.check;
import checkIndb3.service.checkLocalServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Component(property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=CheckOutHrms", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + CheckOutHrmsPortletKeys.CHECKOUTHRMS, "javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class CheckOutHrmsPortlet extends MVCPortlet {

	private static final Log log = LogFactoryUtil.getLog(CheckOutHrmsPortlet.class);

	
	public void timesheet(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		log.info("Inside the timesheet method ::::: ");
	}
	
//    @Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		System.out.println("This the main class");
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		try {
			long userId = themeDisplay.getUserId();

			Date now = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String todayStr = sdf.format(now);

			List<check> records = checkLocalServiceUtil.getchecks(0, checkLocalServiceUtil.getchecksCount());

			for (check record : records) {
				String recordDateStr = sdf.format(record.getDate());
				if (record.getUserId() == userId && recordDateStr.equals(todayStr)) {
					renderRequest.setAttribute("checkInTime", record.getCheckInTime());
					renderRequest.setAttribute("checkOutTime", record.getCheckOutTime());
					break;
				}
			}

		} catch (Exception e) {
			log.error("Error in doView(): ", e);
		}
		
		super.doView(renderRequest, renderResponse);
	}
	
	// to view Timesheet

//	@Override
//	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
//			throws IOException, PortletException {
//
//		log.info("View User TimeSheet");
//		System.out.println("View Time sheet");
//
////	    long userId = PortalUtil.getUserId(renderRequest);
//
////	    // Get all records from DB
//
//		List<check> timeSheetData = checkLocalServiceUtil.getchecks(-1, -1);
//
////	    // Send all data to JSP
//		renderRequest.setAttribute("userTimeList", timeSheetData);
//		super.render(renderRequest, renderResponse);
//
//	}

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
	        throws IOException, PortletException {

	    log.info("View User TimeSheet");
	    
	    // Get filter parameters from request
	    int selectedMonth = ParamUtil.getInteger(renderRequest, "selectedMonth", -1);
	    int selectedYear = ParamUtil.getInteger(renderRequest, "selectedYear", -1);
	    
//	    List<check> allRecords ;= checkLocalServiceUtil.getchecks(-1, -1);
	    List<check> timeSheetData;


	    
	    if (selectedMonth >= 0 && selectedYear > 0) {
	        // Filter data by month and year
	        Calendar cal = Calendar.getInstance();
	        List<check> filteredList = new ArrayList<>();
	        
	        for (check record : checkLocalServiceUtil.getchecks(-1, -1)) {
	            cal.setTime(record.getDate());
	            int recordMonth = cal.get(Calendar.MONTH);
	            int recordYear = cal.get(Calendar.YEAR);
	            
	            if (recordMonth == selectedMonth && recordYear == selectedYear) {
	                filteredList.add(record);
	            }
	        }
	        timeSheetData = filteredList;
	    } else {
	        // Get all records if no filter is applied
	        timeSheetData = checkLocalServiceUtil.getchecks(-1, -1);
	    }
	    
	    // Set attributes for JSP
	    renderRequest.setAttribute("userTimeList", timeSheetData);
	    
	    renderRequest.setAttribute("selectedMonth", selectedMonth);
	    renderRequest.setAttribute("selectedYear", selectedYear);
	    
	    super.render(renderRequest, renderResponse);
	}
	
	
	
}

