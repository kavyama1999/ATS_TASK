<%@page import="com.ats.bank.model.bank"%>
<%@page import="com.ats.bank.service.bankLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ include file="./init.jsp"%>

<%
    long bankId = ParamUtil.getLong(renderRequest, "bankId");
    bank bankData = bankLocalServiceUtil.fetchbank(bankId);
%>

<portlet:actionURL name="editBankData" var="editBankDataURL" />

<aui:form action="${editBankDataURL}" method="post">
    <aui:input name="bankId" type="hidden" value="<%= bankData.getBankId() %>" />

    <aui:input name="name" label="Name" type="text" value="<%= bankData.getName() %>" required="true" />
    <aui:input name="address" label="Address" type="text" value="<%= bankData.getAddress() %>" required="true" />

    <aui:button type="submit" value="Update Bank" />
</aui:form>
