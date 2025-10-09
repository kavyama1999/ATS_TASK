package HospitalMngPortlet.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import org.osgi.service.component.annotations.Component;
import AddAmbulanceDb.model.Hospital;
import AddAmbulanceDb.service.HospitalLocalServiceUtil;


import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.List;

import HospitalMngPortlet.constants.HospitalMngPortletKeys;
//import HospitalMngPortlet.model.Hospital;
//import HospitalMngPortlet.service.HospitalLocalServiceUtil;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + HospitalMngPortletKeys.HOSPITALMNG,
                "mvc.command.name=/view_hospitals"
        },
        service = MVCRenderCommand.class
)
public class ViewHospitalsRenderCommand implements MVCRenderCommand {

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) {

        try {
            // Fetch all hospitals from the database
            List<Hospital> hospitalList = HospitalLocalServiceUtil.getHospitals(-1, -1); // -1, -1 = fetch all
            renderRequest.setAttribute("hospitalList", hospitalList);
        } catch (Exception e) {
            e.printStackTrace();
            renderRequest.setAttribute("errorMessage", "Failed to fetch hospital data.");
        }

        return "/view_Hospitals.jsp"; // The JSP to display data
    }
}
