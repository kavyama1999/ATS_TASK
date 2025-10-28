package com.ats.internal.resource.v1_0;

import com.ats.dto.v1_0.Student;
import com.ats.resource.v1_0.StudentResource;
import com.liferay.petra.function.UnsafeBiConsumer;
import com.liferay.petra.function.UnsafeFunction;

import java.util.Collection;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author Admin
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/student.properties",
	scope = ServiceScope.PROTOTYPE, service = StudentResource.class
)
public class StudentResourceImpl extends BaseStudentResourceImpl {

	@Override
	public void setContextBatchUnsafeBiConsumer(
			UnsafeBiConsumer<Collection<Student>, UnsafeFunction<Student, Student, Exception>, Exception> contextBatchUnsafeBiConsumer) {
		// TODO Auto-generated method stub
		
	}
}