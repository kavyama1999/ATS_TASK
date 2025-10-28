package casemngt.headless.delivery.internal.jaxrs.application;

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
		"osgi.jaxrs.application.base=/casemngt-headless-delivery",
		"osgi.jaxrs.extension.select=(osgi.jaxrs.name=Liferay.Vulcan)",
		"osgi.jaxrs.name=CasemngtHeadlessDelivery"
	},
	service = Application.class
)
@Generated("")
public class CasemngtHeadlessDeliveryApplication extends Application {
}