package casemngt.headless.delivery.internal.resource.v1_0;

import casemngt.headless.delivery.dto.v1_0.CaseMngt;
import casemngt.headless.delivery.resource.v1_0.CaseMngtResource;
import io.swagger.v3.oas.annotations.Parameter;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.petra.function.UnsafeBiConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.vulcan.pagination.Page;

import org.osgi.service.component.annotations.Component;

import CaseManagementDB.service.CaseMngtLocalServiceUtil;

import java.util.ArrayList;

//
//import CaseManagementDB.model.CaseMngt as CaseMngtEntity;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Component(
    properties = "OSGI-INF/liferay/rest/v1_0/case-mngt.properties",
    service = CaseMngtResource.class
)
public class CaseMngtResourceImpl extends BaseCaseMngtResourceImpl {
    
    private static final Log _log = LogFactoryUtil.getLog(CaseMngtResourceImpl.class);

    @Override
    public CaseMngt addCases(CaseMngt caseModel) throws Exception {
        _log.info("addCases() called - Adding new case");

        try {
            // Validate required fields
            if (Validator.isNull(caseModel.getCaseNumber())) {
                throw new IllegalArgumentException("Case number is required");
            }
            if (Validator.isNull(caseModel.getCaseType())) {
                throw new IllegalArgumentException("Case type is required");
            }
            if (Validator.isNull(caseModel.getPatientName())) {
                throw new IllegalArgumentException("Patient name is required");
            }
            if (Validator.isNull(caseModel.getPatientGender())) {
                throw new IllegalArgumentException("Patient gender is required");
            }
            if (caseModel.getPatientAge() == null || caseModel.getPatientAge() <= 0) {
                throw new IllegalArgumentException("Valid patient age is required");
            }
            if (Validator.isNull(caseModel.getContactNumber())) {
                throw new IllegalArgumentException("Contact number is required");
            }

            // Step 1: Generate unique primary key
            long caseId = CounterLocalServiceUtil.increment("CaseManagementDB.model.CaseMngt");

            // Step 2: Create entity using fully qualified class name
            CaseManagementDB.model.CaseMngt caseEntity = 
                CaseManagementDB.service.CaseMngtLocalServiceUtil.createCaseMngt(caseId);

            // Step 3: Set Liferay context info
            long companyId = (contextCompany != null) ? contextCompany.getCompanyId() : 0L;
            long userId = (contextUser != null) ? contextUser.getUserId() : 0L;
            String userName = (contextUser != null) ? contextUser.getFullName() : "Guest";
            long groupId = companyId > 0 ? companyId : 20123L;

            caseEntity.setCompanyId(companyId);
            caseEntity.setGroupId(groupId);
            caseEntity.setUserId(userId);
            caseEntity.setUserName(userName);
            caseEntity.setCreateDate(new Date());
            caseEntity.setModifiedDate(new Date());

            // Step 4: Map request data to entity
            caseEntity.setCaseNumber(caseModel.getCaseNumber());
            caseEntity.setCaseType(caseModel.getCaseType());
            caseEntity.setPatientName(caseModel.getPatientName());
            caseEntity.setPatientGender(caseModel.getPatientGender());
            caseEntity.setContactNumber(caseModel.getContactNumber());
            caseEntity.setDescription(caseModel.getDescription());
            caseEntity.setPatientAge(caseModel.getPatientAge());
            caseEntity.setLocation(caseModel.getLocation());

            // Step 5: Persist entity
            caseEntity = CaseManagementDB.service.CaseMngtLocalServiceUtil.addCaseMngt(caseEntity);

            _log.info("Case added successfully with ID: " + caseEntity.getCaseId());

            // Step 6: Prepare response DTO
            CaseMngt response = toDTO(caseEntity);
            
            return response;

        } catch (Exception e) {
            _log.error("Error adding case: " + e.getMessage(), e);
            throw e;
        }
    }

    // Helper method to convert DB Entity to DTO
    private CaseMngt toDTO(CaseManagementDB.model.CaseMngt entity) {
        CaseMngt dto = new CaseMngt();
        
        // Set primary key and IDs
        dto.setCaseId(entity.getCaseId());
        dto.setCompanyId(entity.getCompanyId());
        dto.setGroupId(entity.getGroupId());
        dto.setUserId(entity.getUserId());
        
        // Set user information
        dto.setUserName(entity.getUserName());
        
        // Set audit dates
        dto.setCreateDate(entity.getCreateDate());
        dto.setModifiedDate(entity.getModifiedDate());
        
        // Set business fields
        dto.setCaseNumber(entity.getCaseNumber());
        dto.setCaseType(entity.getCaseType());
        dto.setPatientName(entity.getPatientName());
        dto.setPatientGender(entity.getPatientGender());
        dto.setPatientAge(entity.getPatientAge());
        dto.setContactNumber(entity.getContactNumber());
        dto.setDescription(entity.getDescription());
        dto.setLocation(entity.getLocation());

        return dto;
    }

    @Override
    public void setContextBatchUnsafeBiConsumer(
        UnsafeBiConsumer<Collection<CaseMngt>, 
        UnsafeFunction<CaseMngt, CaseMngt, Exception>, 
        Exception> contextBatchUnsafeBiConsumer) {
        // Not implemented for batch operations
    }


    
    //getData
    @Override
    public Page<CaseMngt> getCases() throws Exception {
        _log.info("=== GET /get-cases CALLED ===");

        try {
            // Step 1: Fetch all CaseMngt records
            List<CaseManagementDB.model.CaseMngt> allCases =
                CaseManagementDB.service.CaseMngtLocalServiceUtil.getCaseMngts(-1, -1);

            // Step 2: Handle empty database
            if (allCases == null || allCases.isEmpty()) {
                _log.warn("⚠️ No cases found in CaseManagementDB_CaseMngt table");
                return Page.of(new ArrayList<>());
            }

            // Step 3: Convert entities to DTOs
            List<CaseMngt> caseDTOs = new ArrayList<>(allCases.size());
            for (CaseManagementDB.model.CaseMngt entity : allCases) {
                caseDTOs.add(toDTO(entity));
                _log.info("Data :"+caseDTOs);
            }

            // Step 4: Return as pageable response
            _log.info("✅ Returning " + caseDTOs.size() + " cases from database");
            return Page.of(caseDTOs);

        } catch (Exception e) {
            _log.error("❌ Error retrieving cases: " + e.getMessage(), e);
            throw new Exception("Error retrieving case records", e);
        }
    }

    
 //update
@Override
public CaseMngt updateCases(CaseMngt caseModel) throws Exception {
    _log.info("=== PUT /update-cases CALLED ===");

    try {
        // Step 1: Validate caseId
        if (caseModel.getCaseId() <= 0) {
            throw new IllegalArgumentException("caseId is required for update");
        }

        // Step 2: Fetch existing record
        CaseManagementDB.model.CaseMngt existingCase =
            CaseManagementDB.service.CaseMngtLocalServiceUtil.fetchCaseMngt(caseModel.getCaseId());

        if (existingCase == null) {
            _log.warn("⚠️ No case found with ID: " + caseModel.getCaseId());
            throw new Exception("Case not found with ID: " + caseModel.getCaseId());
        }

        // Step 3: Update modified fields
        if (Validator.isNotNull(caseModel.getCaseNumber()))
            existingCase.setCaseNumber(caseModel.getCaseNumber());

        if (Validator.isNotNull(caseModel.getCaseType()))
            existingCase.setCaseType(caseModel.getCaseType());

        if (Validator.isNotNull(caseModel.getPatientName()))
            existingCase.setPatientName(caseModel.getPatientName());

        if (caseModel.getPatientAge() > 0)
            existingCase.setPatientAge(caseModel.getPatientAge());

        if (Validator.isNotNull(caseModel.getPatientGender()))
            existingCase.setPatientGender(caseModel.getPatientGender());

        if (Validator.isNotNull(caseModel.getContactNumber()))
            existingCase.setContactNumber(caseModel.getContactNumber());

        if (Validator.isNotNull(caseModel.getDescription()))
            existingCase.setDescription(caseModel.getDescription());

        if (Validator.isNotNull(caseModel.getLocation()))
            existingCase.setLocation(caseModel.getLocation());

        // Step 4: Update metadata
        existingCase.setModifiedDate(new Date());

        // Step 5: Persist updated entity
        CaseManagementDB.model.CaseMngt updatedCase =
            CaseManagementDB.service.CaseMngtLocalServiceUtil.updateCaseMngt(existingCase);

        _log.info("✅ Case updated successfully with ID: " + updatedCase.getCaseId());

        // Step 6: Return updated DTO
        return toDTO(updatedCase);

    } catch (IllegalArgumentException e) {
        _log.error("❌ Validation error: " + e.getMessage());
        throw e;

    } catch (Exception e) {
        _log.error("❌ Error updating case: " + e.getMessage(), e);
        throw new Exception("Failed to update case", e);
    }
}





/////delete
@AccessControlled(guestAccessEnabled = true)
@Override
public CaseMngt deleteCases(@Parameter(hidden = true) Long caseId) throws Exception {
    _log.info("=== DELETE /delete-cases CALLED ===");

    try {
        // Step 1: Validate input
        if (caseId == null || caseId <= 0) {
            throw new IllegalArgumentException("caseId is required for deletion");
        }

        // Step 2: Fetch the existing case
        CaseManagementDB.model.CaseMngt existingCase =
            CaseManagementDB.service.CaseMngtLocalServiceUtil.fetchCaseMngt(caseId);

        if (existingCase == null) {
            _log.warn("⚠️ No case found with ID: " + caseId);
            throw new Exception("No case found with ID: " + caseId);
        }

        // Step 3: Delete from DB
        CaseManagementDB.service.CaseMngtLocalServiceUtil.deleteCaseMngt(caseId);

        _log.info("✅ Case deleted successfully with ID: " + caseId);

        // Step 4: Optionally return the deleted DTO
        return toDTO(existingCase);

    } catch (IllegalArgumentException e) {
        _log.error("❌ Validation error: " + e.getMessage());
        throw e;

    } catch (Exception e) {
        _log.error("❌ Error deleting case: " + e.getMessage(), e);
        throw new Exception("Failed to delete case", e);
    }
}

}
    
    
