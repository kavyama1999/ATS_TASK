<%@ include file="./init.jsp" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.TimeZone" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<portlet:defineObjects />

<!-- for view User Timesheet -->

<portlet:renderURL var="viewUserTimeSheetURL">
    <portlet:param name="jspPage" value="/timesheet.jsp"/>
</portlet:renderURL>

<h2><a href="${viewUserTimeSheetURL}">TimeSheet</a></h2>

<%
    long userId = themeDisplay.getUserId();
    String userName = themeDisplay.getUser().getFullName();
    Date checkInTime = (Date) request.getAttribute("checkInTime");
    Date checkOutTime = (Date) request.getAttribute("checkOutTime");

    // ✅ Date format with IST (India Standard Time)
    SimpleDateFormat fullFormat = new SimpleDateFormat("E MMM dd hh:mm a yyyy");
    fullFormat.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));

    String checkInStr = (checkInTime != null) ? fullFormat.format(checkInTime) : "-";
    String checkOutStr = (checkOutTime != null) ? fullFormat.format(checkOutTime) : "-";

    long diffMillis = 0;
    long hours = 0;
    long minutes = 0;

    if (checkInTime != null && checkOutTime != null) {
        diffMillis = checkOutTime.getTime() - checkInTime.getTime();
        hours = diffMillis / (1000 * 60 * 60);
        minutes = (diffMillis / (1000 * 60)) % 60;
    }
%>

<portlet:actionURL name="checkIn" var="checkInURL" />
<portlet:actionURL name="checkOut" var="checkOutURL" />

<div style="max-width: 400px; margin: auto; background: #f9f9f9; padding: 20px; border-radius: 10px; text-align: center;">
    <h3>Welcome, <%= userName %>!</h3>
    <p>Role: Trainee </p>

    <p><strong>Check-in:</strong> <%= checkInStr %></p>
    <p><strong>Check-out:</strong> <%= checkOutStr %></p>

    <% if (checkInTime == null) { %>
        <aui:form action="<%=checkInURL%>" method="post">
            <aui:button type="submit" value="Check-in" />
        </aui:form>
    <% } else if (checkOutTime == null) { %>
        <aui:form action="<%=checkOutURL %>" method="post">
            <aui:button type="submit" value="Check-out" />
        </aui:form>
    <% } %>

    <% if (checkInTime != null && checkOutTime != null) { %>
        <div style="margin-top: 10px;">
            <strong>Your Today's Working Hours:</strong>
            <p><%= hours %>h : <%= minutes %>m</p>
        </div>
    <% } %>
</div>
