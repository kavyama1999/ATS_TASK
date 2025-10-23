/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package AddAmbulanceDb.service.impl;

import AddAmbulanceDb.model.Driver;
import AddAmbulanceDb.model.impl.DriverImpl;
import AddAmbulanceDb.service.base.DriverLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=AddAmbulanceDb.model.Driver",
	service = AopService.class
)
public class DriverLocalServiceImpl extends DriverLocalServiceBaseImpl {
	
	public Driver getInstance() {
		Driver driver = new DriverImpl();
		return driver;
	}

	@Override
	public List<Driver> findByDriver(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Driver> findByPatient(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

//	
//	public List<Driver> findByDriver(long userId) {
//		return driverPersistence.findByUserId(userId);
//	}
//@Override
//public List<Driver> findByPatient(long userId) {
//	// TODO Auto-generated method stub
//	return null;
//}

	
	
}