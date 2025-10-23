package AddDriversPortlet.portlet;

import AddDriversPortlet.constants.AddDriversPortletKeys;

import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.Address;
import com.liferay.portal.kernel.service.AddressLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + AddDriversPortletKeys.ADDDRIVERS,
        "mvc.command.name=updateDriver"
    },
    service = MVCActionCommand.class
)
public class UpdateDriverMVCActionCommand extends BaseMVCActionCommand {

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        ServiceContext serviceContext = ServiceContextFactory.getInstance(User.class.getName(), actionRequest);

        long userId = ParamUtil.getLong(actionRequest, "driverId");
        String firstName = ParamUtil.getString(actionRequest, "driverName");
        String lastName = ParamUtil.getString(actionRequest, "lastName");
        String email = ParamUtil.getString(actionRequest, "email");
        String contactNumber = ParamUtil.getString(actionRequest, "contactNumber");
        String addressText = ParamUtil.getString(actionRequest, "address");
        String password = ParamUtil.getString(actionRequest, "password");

        try {
            User user = UserLocalServiceUtil.fetchUser(userId);

            if (user != null) {

                // ✅ Update User table fields
                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setEmailAddress(email);
                UserLocalServiceUtil.updateUser(user);

                // ✅ Update contact number (Expando)
                try {
                    if (user.getExpandoBridge() != null) {
                        user.getExpandoBridge().setAttribute("contactNumber", contactNumber);
                    }
                } catch (Exception expandoEx) {
                    System.out.println("⚠️ Expando field 'contactNumber' not found. Please create it in Control Panel → Custom Fields → User.");
                }

                // ✅ Update address in Liferay Address table (street1)
                List<Address> addresses = AddressLocalServiceUtil.getAddresses(
                    user.getCompanyId(), User.class.getName(), user.getUserId()
                );

                if (addresses != null && !addresses.isEmpty()) {
                    Address addr = addresses.get(0);
                    addr.setStreet1(addressText);
                    AddressLocalServiceUtil.updateAddress(addr);
                } else {
                    // If no address exists yet, add a new one
                    AddressLocalServiceUtil.addAddress(
                        password, user.getUserId(),
                        User.class.getName(),
                        user.getUserId(),
                        "Home", // name
                        addressText, // street1
                        "", // street2
                        "", // street3
                        "", // city
                        password, password, 0, // regionId
                        0, // countryId
                        0, // typeId
                        true, // mailing
                        true, // primary
                        password, serviceContext
                    );
                }

                // ✅ Update password only if entered
                if (password != null && !password.isEmpty()) {
                    UserLocalServiceUtil.updatePassword(userId, password, password, false);
                }

                SessionMessages.add(actionRequest, "driver-updated-successfully");

            } else {
                SessionErrors.add(actionRequest, "driver-not-found");
            }

        } catch (Exception e) {
            e.printStackTrace();
            SessionErrors.add(actionRequest, "error-updating-driver");
        }
    }
}
