//package casemngt.headless.delivery.internal.resource.v1_0;
//
//import casemngt.headless.delivery.dto.v1_0.CaseMngt;
//import casemngt.headless.delivery.resource.v1_0.CaseMngtResource;
//
//import com.liferay.petra.function.UnsafeBiConsumer;
//import com.liferay.petra.function.UnsafeFunction;
//
//import java.util.Collection;
//
//import org.osgi.service.component.annotations.Component;
//import org.osgi.service.component.annotations.ServiceScope;
//
///**
// * @author Admin
// */
//@Component(
//	properties = "OSGI-INF/liferay/rest/v1_0/case-mngt.properties",
//	scope = ServiceScope.PROTOTYPE, service = CaseMngtResource.class
//)
//public class CaseMngtResourceImpl extends BaseCaseMngtResourceImpl {
//
//	@Override
//	public void setContextBatchUnsafeBiConsumer(
//			UnsafeBiConsumer<Collection<CaseMngt>, UnsafeFunction<CaseMngt, CaseMngt, Exception>, Exception> contextBatchUnsafeBiConsumer) {
//		// TODO Auto-generated method stub
//		
//	}
//}

//package casemngt.headless.delivery.internal.resource.v1_0;
//
//import casemngt.headless.delivery.dto.v1_0.CaseMngt;
//import casemngt.headless.delivery.resource.v1_0.CaseMngtResource;
//
//import com.liferay.petra.function.UnsafeBiConsumer;
//import com.liferay.petra.function.UnsafeFunction;
//import com.liferay.portal.kernel.service.ServiceContext;
//import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
//import com.liferay.portal.kernel.service.UserLocalServiceUtil;
//import com.liferay.portal.kernel.util.GetterUtil;
//
//import java.util.Collection;
//import java.util.Date;
//
//import org.osgi.service.component.annotations.Component;
//import org.osgi.service.component.annotations.ServiceScope;
//
///**
// * @author Admin
// */
//@Component(
//	properties = "OSGI-INF/liferay/rest/v1_0/case-mngt.properties",
//	scope = ServiceScope.PROTOTYPE, service = CaseMngtResource.class
//)
//public class CaseMngtResourceImpl extends BaseCaseMngtResourceImpl {
//
//	public CaseMngt postCaseMngt(CaseMngt caseMngt) throws Exception {
//		
//		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
//		
//		// Use fully qualified class name to avoid conflicts
//		CaseManagementDB.model.CaseMngt caseMngtEntity = 
//			CaseManagementDB.service.CaseMngtLocalServiceUtil.createCaseMngt(0);
//		
//		// Set fields from DTO
//		caseMngtEntity.setCaseNumber(caseMngt.getCaseNumber());
//		caseMngtEntity.setCaseType(caseMngt.getCaseType());
//		caseMngtEntity.setPatientName(caseMngt.getPatientName());
//		caseMngtEntity.setPatientAge(GetterUtil.getInteger(caseMngt.getPatientAge()));
//		caseMngtEntity.setDescription(caseMngt.getDescription());
//		caseMngtEntity.setPatientGender(caseMngt.getPatientGender());
//		caseMngtEntity.setLocation(caseMngt.getLocation());
//		caseMngtEntity.setContactNumber(caseMngt.getContactNumber());
//		
//		// Set audit fields
//		caseMngtEntity.setGroupId(serviceContext.getScopeGroupId());
//		caseMngtEntity.setCompanyId(serviceContext.getCompanyId());
//		caseMngtEntity.setUserId(serviceContext.getUserId());
//		
//		String userName = UserLocalServiceUtil.getUser(serviceContext.getUserId()).getFullName();
//		caseMngtEntity.setUserName(userName);
//		
//		Date now = new Date();
//		caseMngtEntity.setCreateDate(now);
//		caseMngtEntity.setModifiedDate(now);
//		
//		// Save entity
//		caseMngtEntity = CaseManagementDB.service.CaseMngtLocalServiceUtil.addCaseMngt(caseMngtEntity);
//		
//		return _toCaseMngtDTO(caseMngtEntity);
//	}
//
//	@Override
//	public void setContextBatchUnsafeBiConsumer(
//		UnsafeBiConsumer<Collection<CaseMngt>, UnsafeFunction<CaseMngt, CaseMngt, Exception>, Exception> contextBatchUnsafeBiConsumer) {
//		// Implementation for batch operations if needed
//	}
//
//	/**
//	 * Convert entity to DTO
//	 */
//	private CaseMngt _toCaseMngtDTO(CaseManagementDB.model.CaseMngt entity) {
//		CaseMngt dto = new CaseMngt();
//		
//		dto.setCaseId(entity.getCaseId());
//		dto.setCaseNumber(entity.getCaseNumber());
//		dto.setCaseType(entity.getCaseType());
//		dto.setPatientName(entity.getPatientName());
//		dto.setPatientAge(entity.getPatientAge());
//		dto.setDescription(entity.getDescription());
//		dto.setPatientGender(entity.getPatientGender());
//		dto.setLocation(entity.getLocation());
//		dto.setContactNumber(entity.getContactNumber());
//		dto.setGroupId(entity.getGroupId());
//		dto.setCompanyId(entity.getCompanyId());
//		dto.setUserId(entity.getUserId());
//		dto.setUserName(entity.getUserName());
//		dto.setCreateDate(entity.getCreateDate());
//		dto.setModifiedDate(entity.getModifiedDate());
//		
//		return dto;
//	}
//}



package casemngt.headless.delivery.internal.resource.v1_0;

import casemngt.headless.delivery.dto.v1_0.CaseMngt;
import casemngt.headless.delivery.resource.v1_0.CaseMngtResource;

import com.liferay.petra.function.UnsafeBiConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;

import java.util.Collection;
import java.util.Date;

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

	// Add the @Override annotation to ensure you're overriding the correct method
	public CaseMngt postCaseMngt(CaseMngt caseMngt) throws Exception {
		
		// Validate input
		if (caseMngt == null) {
			throw new IllegalArgumentException("CaseMngt data cannot be null");
		}
		
		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
		
		if (serviceContext == null) {
			throw new IllegalStateException("ServiceContext is not available");
		}
		
		// Use fully qualified class name to avoid conflicts
		CaseManagementDB.model.CaseMngt caseMngtEntity = 
			CaseManagementDB.service.CaseMngtLocalServiceUtil.createCaseMngt(0);
		
		// Set fields from DTO with null checks
		caseMngtEntity.setCaseNumber(GetterUtil.getString(caseMngt.getCaseNumber()));
		caseMngtEntity.setCaseType(GetterUtil.getString(caseMngt.getCaseType()));
		caseMngtEntity.setPatientName(GetterUtil.getString(caseMngt.getPatientName()));
		caseMngtEntity.setPatientAge(GetterUtil.getInteger(caseMngt.getPatientAge()));
		caseMngtEntity.setDescription(GetterUtil.getString(caseMngt.getDescription()));
		caseMngtEntity.setPatientGender(GetterUtil.getString(caseMngt.getPatientGender()));
		caseMngtEntity.setLocation(GetterUtil.getString(caseMngt.getLocation()));
		caseMngtEntity.setContactNumber(GetterUtil.getString(caseMngt.getContactNumber()));
		
		// Set audit fields
		caseMngtEntity.setGroupId(serviceContext.getScopeGroupId());
		caseMngtEntity.setCompanyId(serviceContext.getCompanyId());
		caseMngtEntity.setUserId(serviceContext.getUserId());
		
		// Get user name properly with error handling
		String userName = "Unknown User";
		try {
			userName = UserLocalServiceUtil.getUser(serviceContext.getUserId()).getFullName();
		} catch (Exception e) {
			// Log warning but continue
			System.out.println("Could not get user name: " + e.getMessage());
		}
		caseMngtEntity.setUserName(userName);
		
		Date now = new Date();
		caseMngtEntity.setCreateDate(now);
		caseMngtEntity.setModifiedDate(now);
		
		// Save entity
		caseMngtEntity = CaseManagementDB.service.CaseMngtLocalServiceUtil.addCaseMngt(caseMngtEntity);
		
		// Return the created entity as DTO
		return _toCaseMngtDTO(caseMngtEntity);
	}

	@Override
	public void setContextBatchUnsafeBiConsumer(
		UnsafeBiConsumer<Collection<CaseMngt>, UnsafeFunction<CaseMngt, CaseMngt, Exception>, Exception> contextBatchUnsafeBiConsumer) {
		// Implementation for batch operations if needed
	}

	/**
	 * Convert entity to DTO
	 */
	private CaseMngt _toCaseMngtDTO(CaseManagementDB.model.CaseMngt entity) {
		CaseMngt dto = new CaseMngt();
		
		// Set basic fields
		dto.setCaseId(entity.getCaseId());
		dto.setCaseNumber(entity.getCaseNumber());
		dto.setCaseType(entity.getCaseType());
		dto.setPatientName(entity.getPatientName());
		dto.setPatientAge(entity.getPatientAge());
		dto.setDescription(entity.getDescription());
		dto.setPatientGender(entity.getPatientGender());
		dto.setLocation(entity.getLocation());
		dto.setContactNumber(entity.getContactNumber());
		
		// Set audit fields
		dto.setGroupId(entity.getGroupId());
		dto.setCompanyId(entity.getCompanyId());
		dto.setUserId(entity.getUserId());
		dto.setUserName(entity.getUserName());
		dto.setCreateDate(entity.getCreateDate());
		dto.setModifiedDate(entity.getModifiedDate());
		
		return dto;
	}
}