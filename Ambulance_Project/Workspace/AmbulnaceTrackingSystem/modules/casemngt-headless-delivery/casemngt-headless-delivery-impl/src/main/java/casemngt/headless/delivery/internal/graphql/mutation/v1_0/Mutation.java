package casemngt.headless.delivery.internal.graphql.mutation.v1_0;

import casemngt.headless.delivery.dto.v1_0.CaseMngt;
import casemngt.headless.delivery.resource.v1_0.CaseMngtResource;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;

import java.util.function.BiFunction;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.UriInfo;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author Admin
 * @generated
 */
@Generated("")
public class Mutation {

	public static void setCaseMngtResourceComponentServiceObjects(
		ComponentServiceObjects<CaseMngtResource>
			caseMngtResourceComponentServiceObjects) {

		_caseMngtResourceComponentServiceObjects =
			caseMngtResourceComponentServiceObjects;
	}

	@GraphQLField(description = "Add a new emergency case.")
	public CaseMngt addCases(@GraphQLName("caseMngt") CaseMngt caseMngt)
		throws Exception {

		return _applyComponentServiceObjects(
			_caseMngtResourceComponentServiceObjects,
			this::_populateResourceContext,
			caseMngtResource -> caseMngtResource.addCases(caseMngt));
	}

	@GraphQLField(description = "Update an existing case.")
	public CaseMngt updateCases(@GraphQLName("caseMngt") CaseMngt caseMngt)
		throws Exception {

		return _applyComponentServiceObjects(
			_caseMngtResourceComponentServiceObjects,
			this::_populateResourceContext,
			caseMngtResource -> caseMngtResource.updateCases(caseMngt));
	}

	@GraphQLField(description = "Delete a case by ID.")
	public CaseMngt deleteCases(@GraphQLName("caseId") Long caseId)
		throws Exception {

		return _applyComponentServiceObjects(
			_caseMngtResourceComponentServiceObjects,
			this::_populateResourceContext,
			caseMngtResource -> caseMngtResource.deleteCases(caseId));
	}

	private <T, R, E1 extends Throwable, E2 extends Throwable> R
			_applyComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeFunction<T, R, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			return unsafeFunction.apply(resource);
		}
		finally {
			componentServiceObjects.ungetService(resource);
		}
	}

	private <T, E1 extends Throwable, E2 extends Throwable> void
			_applyVoidComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeConsumer<T, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			unsafeFunction.accept(resource);
		}
		finally {
			componentServiceObjects.ungetService(resource);
		}
	}

	private void _populateResourceContext(CaseMngtResource caseMngtResource)
		throws Exception {

		caseMngtResource.setContextAcceptLanguage(_acceptLanguage);
		caseMngtResource.setContextCompany(_company);
		caseMngtResource.setContextHttpServletRequest(_httpServletRequest);
		caseMngtResource.setContextHttpServletResponse(_httpServletResponse);
		caseMngtResource.setContextUriInfo(_uriInfo);
		caseMngtResource.setContextUser(_user);
		caseMngtResource.setGroupLocalService(_groupLocalService);
		caseMngtResource.setRoleLocalService(_roleLocalService);
	}

	private static ComponentServiceObjects<CaseMngtResource>
		_caseMngtResourceComponentServiceObjects;

	private AcceptLanguage _acceptLanguage;
	private com.liferay.portal.kernel.model.Company _company;
	private GroupLocalService _groupLocalService;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private RoleLocalService _roleLocalService;
	private BiFunction<Object, String, Sort[]> _sortsBiFunction;
	private UriInfo _uriInfo;
	private com.liferay.portal.kernel.model.User _user;

}