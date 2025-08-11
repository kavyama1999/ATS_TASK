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
import java.util.List;

@Component(immediate = true, property = { "javax.portlet.name=" + CheckOutHrmsPortletKeys.CHECKOUTHRMS,
		"mvc.command.name=checkOut" }, service = MVCActionCommand.class)
public class CheckOutMVCActionCommand implements MVCActionCommand {

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) {

		System.out.println("checkOut MVC Action Command");

		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			long userId = themeDisplay.getUserId();

			Date today = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String todayStr = sdf.format(today);

			List<check> records = checkLocalServiceUtil.getchecks(0, checkLocalServiceUtil.getchecksCount());

			for (check record : records) {
				String recordDateStr = sdf.format(record.getDate());

				if (record.getUserId() == userId && recordDateStr.equals(todayStr)) {
					record.setCheckOutTime(new Date());
					record.setTotalHours(todayStr);

					checkLocalServiceUtil.updatecheck(record);
					break;
				}
			}

			actionResponse.setRenderParameter("mvcPath", "/view.jsp");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return true;
	}
}
