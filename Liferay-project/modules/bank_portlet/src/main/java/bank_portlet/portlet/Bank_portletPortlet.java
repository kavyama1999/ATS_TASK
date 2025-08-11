package bank_portlet.portlet;

import bank_portlet.constants.Bank_portletPortletKeys;

import com.ats.bank.model.bank;
import com.ats.bank.service.bankLocalServiceUtil;
import com.liferay.portal.dao.orm.hibernate.PublicFieldPropertyAccessor;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Admin
 */
@Component(property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Bank_portlet", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + Bank_portletPortletKeys.BANK_PORTLET, "javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class Bank_portletPortlet extends MVCPortlet {

	private static final Log log = LogFactoryUtil.getLog(Bank_portletPortlet.class);

	public void bankSaving(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {

		log.info("saving bank data");
		String name = ParamUtil.getString(actionRequest, "name");
		String address = ParamUtil.getString(actionRequest, "address");

		bank save = bankLocalServiceUtil.getInstance();

		save.setName(name);
		save.setAddress(address);

		bank saveData = bankLocalServiceUtil.addbank(save);
		log.info("Data saved SuccessFully :" + saveData);
//		log.info("Data saved successfully: {}", saveData);

	}

//	for view

	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		List<bank> data = bankLocalServiceUtil.getbanks(-1, -1);
		renderRequest.setAttribute("bankList", data);
		/* bankList */
		super.render(renderRequest, renderResponse);

	}

//update

	
	@ProcessAction(name = "editBankData")
	public void editBankData(ActionRequest actionRequest, ActionResponse actionResponse)
	        throws IOException, PortletException {

	    Log log = LogFactoryUtil.getLog(this.getClass());
	    log.info("Updating Bank Data");

	    long bankId = ParamUtil.getLong(actionRequest, "bankId");
	    String name = ParamUtil.getString(actionRequest, "name");
	    String address = ParamUtil.getString(actionRequest, "address");

	    bank existingBank = bankLocalServiceUtil.fetchbank(bankId);

	    if (existingBank != null) {
	        existingBank.setName(name);
	        existingBank.setAddress(address);

	        bank updatedBank = bankLocalServiceUtil.updatebank(existingBank);
	        log.info("Bank Data Updated: " + updatedBank);
	    } else {
	        log.error("Bank record not found for ID: " + bankId);
	    }

	    // Redirect back to view.jsp
	    actionResponse.setRenderParameter("jspPage", "/view.jsp");
	}

	
	
//	delete bank data
	
	@ProcessAction(name = "deleteBankData")
	public void deleteBankData(ActionRequest actionRequest, ActionResponse actionResponse)
	        throws IOException, PortletException, PortalException {

	    long data = ParamUtil.getLong(actionRequest, "bankId");

	    bank bankDelete = bankLocalServiceUtil.fetchbank(data);

	    if (bankDelete != null) {
	        bankLocalServiceUtil.deletebank(bankDelete);
	    }

	   
	    // ✅ Redirect to view.jsp after delete
	    actionResponse.setRenderParameter("jspPage", "/viewBankData.jsp");
	}

   
}
