package AccountMgmtSystem.Headless_API.internal.jaxrs.application;

import javax.annotation.Generated;

import javax.ws.rs.core.Application;

import org.osgi.service.component.annotations.Component;

/**
 * @author Admin
 * @generated
 */
@Component(
	property = {
		"liferay.jackson=false",
		"osgi.jaxrs.application.base=/AccountMgmtSystem-Headless_API",
		"osgi.jaxrs.extension.select=(osgi.jaxrs.name=Liferay.Vulcan)",
		"osgi.jaxrs.name=AccountMgmtSystemHeadlessAPI"
	},
	service = Application.class
)
@Generated("")
public class AccountMgmtSystemHeadlessAPIApplication extends Application {
}