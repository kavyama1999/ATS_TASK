/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package checkIndb3.service.impl;

import checkIndb3.model.check;
import checkIndb3.model.impl.checkImpl;
import checkIndb3.service.base.checkLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=checkIndb3.model.check",
	service = AopService.class
)
public class checkLocalServiceImpl extends checkLocalServiceBaseImpl {
	
	
public check getInstance() {
		return new checkImpl();
	}

//public List<check> getByCheckInMonthAndYear(long userId, Date startDate, Date endDate) {
//    return checkPersistence.findByCheckInDateRange(userId, startDate, endDate);
//}

}
