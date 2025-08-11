package CheckOutHrmsPortlet.portlet.action;

import checkIndb3.model.check;
import checkIndb3.service.checkLocalServiceUtil;
import CheckOutHrmsPortlet.constants.CheckOutHrmsPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component(
    immediate = true,
    property = {
       "javax.portlet.name=" + CheckOutHrmsPortletKeys.CHECKOUTHRMS,
       "mvc.command.name=checkIn"
    },
    service = MVCActionCommand.class
)
public class CheckInMVCActionCommand implements MVCActionCommand {

    @Override
    public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) {
       System.out.println("checkIn MVC Action Command");
    	
    	try {
        	
            ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
            long userId = themeDisplay.getUserId();
            String userName = themeDisplay.getUser().getFullName();

            
            // Use current date for consistency
            Date now = new Date();
            
            // Get day of week from date
            String dayOfWeek = new SimpleDateFormat("EEEE").format(now);

        
            check checkIn = checkLocalServiceUtil.createcheck(0); // Auto-increment ID
            checkIn.setUserId(userId);
            checkIn.setUserName(userName);
            checkIn.setDate(new Date());
            checkIn.setDay(dayOfWeek);
            checkIn.setCheckInTime(new Date());
            checkIn.setCheckOutTime(null);
            checkIn.setCreatedAt(now);        // ✅ record created time

            checkLocalServiceUtil.addcheck(checkIn);

            actionResponse.setRenderParameter("mvcPath", "/view.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }
}
