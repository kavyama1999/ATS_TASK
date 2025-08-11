/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package employe.db.layer.service.impl;

import com.liferay.portal.aop.AopService;

import java.util.List;

import employe.db.layer.model.employee;
import employe.db.layer.model.impl.employeeImpl;
import employe.db.layer.service.base.employeeLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=employe.db.layer.model.employee",
	service = AopService.class
)
public class employeeLocalServiceImpl extends employeeLocalServiceBaseImpl {
	
	public employee getInstance() {
		return new employeeImpl();
	}	
	
	// custom sql registerFinder for lastName
    public List<employee> getEmployeeByCompany(String company) {
    	System.out.println("Inside the getRegisterByLastNames :::: ");
        return employeeFinder.getByCompany(company);
    }
    

}


