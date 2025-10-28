package casemngt.headless.delivery.internal.graphql.servlet.v1_0;

import casemngt.headless.delivery.internal.graphql.mutation.v1_0.Mutation;
import casemngt.headless.delivery.internal.graphql.query.v1_0.Query;
import casemngt.headless.delivery.resource.v1_0.CaseMngtResource;

import com.liferay.portal.vulcan.graphql.servlet.ServletData;

import javax.annotation.Generated;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentServiceObjects;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceScope;

/**
 * @author Admin
 * @generated
 */
@Component(immediate = true, service = ServletData.class)
@Generated("")
public class ServletDataImpl implements ServletData {

	@Activate
	public void activate(BundleContext bundleContext) {
		Mutation.setCaseMngtResourceComponentServiceObjects(
			_caseMngtResourceComponentServiceObjects);

		Query.setCaseMngtResourceComponentServiceObjects(
			_caseMngtResourceComponentServiceObjects);
	}

	@Override
	public Mutation getMutation() {
		return new Mutation();
	}

	@Override
	public String getPath() {
		return "/casemngt-headless-delivery-graphql/v1_0";
	}

	@Override
	public Query getQuery() {
		return new Query();
	}

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<CaseMngtResource>
		_caseMngtResourceComponentServiceObjects;

}