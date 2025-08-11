package employe.db.layer.service.persistence.impl;

import com.liferay.portal.dao.orm.custom.sql.CustomSQL;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import employe.db.layer.model.employee;
import employe.db.layer.model.impl.employeeImpl;
import employe.db.layer.service.persistence.employeeFinder;

@Component(
	service = employeeFinder.class
)

public class employeeFinderImpl extends employeeFinderBaseImpl implements employeeFinder {
	
	 @Reference
	    private CustomSQL customSQL;

	    public List<employee> getByCompany(String company) {
	    	
	    	System.out.println("Inside the getByCompany in employeeFinderImpl class ::: ");
	        List<employee> register = new ArrayList<>();
	        Session session = null;

	        try {
	            // Open Liferay ORM session
	            session = openSession();

	            // Get the SQL from default.xml using the key "customeQuery"
	            String sql = customSQL.get(getClass(), "getEmployeeByCompany");
	            System.out.println("SQL ===> " + sql);

	            SQLQuery sqlQuery = session.createSQLQuery(sql);
	            sqlQuery.setCacheable(false);

	            // Add the entity to map result rows to employee objects
	            sqlQuery.addEntity("employee", employeeImpl.class);

	            // Set the query parameter
	            QueryPos queryPos = QueryPos.getInstance(sqlQuery);
	            queryPos.add(company + "%");

	            // Execute the query
	            register = (List<employee>) sqlQuery.list();

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            closeSession(session);
	        }

	        return register;
	    }


}
