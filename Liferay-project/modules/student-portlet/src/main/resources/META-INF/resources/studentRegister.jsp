<%@ include file="./init.jsp" %>


<portlet:actionURL name="addStudent" var="addStudentURL" />



<portlet:renderURL var="viewPageURL">
    <portlet:param name="jspPage" value="/view.jsp"/>
</portlet:renderURL>


 <aui:form name="stud"  method="POST">
    
    <aui:input name="name" type="text" required="true" />
    <aui:input name="qualification" type="text" required="true" />
    <aui:input name="fees" type="number" required="true" />
    <aui:input name="address" type="text" required="true" />
    <aui:select name="gender">
    <aui:option label="select gender" />
    <aui:option value="1" label="male" />
    <aui:option value="0" label="female" />
   
    
    </aui:select>
    

</aui:form>