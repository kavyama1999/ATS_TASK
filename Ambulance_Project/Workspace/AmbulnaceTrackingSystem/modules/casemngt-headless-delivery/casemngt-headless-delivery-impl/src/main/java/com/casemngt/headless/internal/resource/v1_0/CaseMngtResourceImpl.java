package com.casemngt.headless.internal.resource.v1_0;

import casemngt.headless.delivery.dto.v1_0.CaseMngt;
import casemngt.headless.delivery.internal.resource.v1_0.BaseCaseMngtResourceImpl;
import casemngt.headless.delivery.resource.v1_0.CaseMngtResource;

import com.liferay.petra.function.UnsafeBiConsumer;
import com.liferay.petra.function.UnsafeFunction;

import java.util.Collection;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author Admin
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/case-mngt.properties",
	scope = ServiceScope.PROTOTYPE, service = CaseMngtResource.class
)
public class CaseMngtResourceImpl extends BaseCaseMngtResourceImpl {

	@Override
	public void setContextBatchUnsafeBiConsumer(
			UnsafeBiConsumer<Collection<CaseMngt>, UnsafeFunction<CaseMngt, CaseMngt, Exception>, Exception> contextBatchUnsafeBiConsumer) {
		// TODO Auto-generated method stub
		
	}
}