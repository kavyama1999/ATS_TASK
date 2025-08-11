<%@ include file="/init.jsp" %>

<p>
	<b><liferay-ui:message key="bank_portlet.caption"/></b>
</p>


<h2>Banking Appplication</h2>

<portlet:renderURL var="regiURL">
    <portlet:param name="mvcPath" value="/saveBankData.jsp" />
</portlet:renderURL>

<h2><a href="${regiURL}">Banking Registration</a></h2>


<!-- To view Bank Data -->

<portlet:renderURL var="viewDataURL">
    <portlet:param name="mvcPath" value="/viewBankData.jsp" />
</portlet:renderURL>
<h2><a href="${viewDataURL}">View Bank Data</a></h2>