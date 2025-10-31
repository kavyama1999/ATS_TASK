<%@ include file="./init.jsp" %>

<portlet:actionURL name="addEmployee" var="addEmployeeURL" />

<portlet:renderURL var="viewPageURL">
    <portlet:param name="jspPage" value="/view.jsp"/>
</portlet:renderURL>
   
   
    <aui:form name="emp" action="${addEmployeeURL}" method="POST">
    
    
   
    
    <aui:input name="name" type="text" required="true" />
    <aui:input name="salary" type="text" required="true" />
    <aui:input name="age" type="number" required="true" />
    <aui:input name="company" type="text" required="true" />
    <aui:select name="gender">
    <aui:option label="select gender" />
    <aui:option value="1" label="male" />
    <aui:option value="0" label="female" />
    
    </aui:select>
    
      <div class="d-flex justify-content-between">
        <aui:button type="submit" value="Submit"/>
        <a class="btn btn-dark" href="${viewPageURL}">Back</a>
    </div>

</aui:form>




public void addEmployee(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException,PortletException {
    	
	    ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

    	
    	log.info("Inside Action Method");
    	
    	String name = ParamUtil.getString(actionRequest, "name");
    	String salary = ParamUtil.getString(actionRequest, "salary");
    	String gender = ParamUtil.getString(actionRequest, "gender");
    	String company = ParamUtil.getString(actionRequest, "company");
    	int age = ParamUtil.getInteger(actionRequest, "age");
    	int status = ParamUtil.getInteger(actionRequest, "status");

    	
    	employee empObj = employeeLocalServiceUtil.getInstance();
    	
    	long empId = CounterLocalServiceUtil.increment(employee.class.getName());    	
    	
    	empObj.setName(name);
    	empObj.setSalary(salary);;
    	empObj.setGender(gender);
    	empObj.setCompany(company);
    	empObj.setAge(age);
    	empObj.setStatus(status);
    	
    	empObj = employeeLocalServiceUtil.addemployee(empObj);
    	