<%@ include file="./init.jsp" %>


<portlet:actionURL name="bankSaving" var="regiURL" />

<aui:form action="<%= regiURL %>" method="POST">

	<aui:input name="name" type="text" required="true" />
	<aui:input name="address" type="text" required="true" />
	
	<aui:button type="submit" value="Submit" />



	<%--  <div class="d-flex justify-content-between">
        <aui:button type="submit" value="Submit"/>
        <a class="btn btn-dark" href="${viewPageURL}">Back</a>
    </div> --%>

</aui:form>