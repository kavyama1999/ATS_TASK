<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/init.jsp" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>

<h2>Timesheet</h2>

<portlet:renderURL var="filterURL">
    <portlet:param name="mvcPath" value="/timesheet.jsp" />
</portlet:renderURL>

<aui:form action="${filterURL}" method="post" name="fm">
    <aui:select name="selectedMonth" label="Month">
        <aui:option value="-1" label="All Months" selected="${selectedMonth == -1}" />
        <c:forEach var="i" begin="0" end="11">
            <aui:option value="${i}"
                label="${['January','February','March','April','May','June','July','August','September','October','November','December'][i]}"
                selected="${selectedMonth == i}" />
        </c:forEach>
    </aui:select>

    <aui:select name="selectedYear" label="Year">
        <aui:option value="-1" label="All Years" selected="${selectedYear == -1}" />
        <c:forEach var="y" begin="2023" end="2025">
            <aui:option value="${y}" label="${y}" selected="${selectedYear == y}" />
        </c:forEach>
    </aui:select>

    <aui:button type="submit" value="Get Data" />
</aui:form>

<br/>

<table class="table table-bordered">
    <tr>
        <th>Day</th>
        <th>Date</th>
        <th>Check-In</th>
        <th>Check-Out</th>
        <th>Total Hours</th>
        <th>Created At</th>
    </tr>

    <c:choose>
        <c:when test="${not empty userTimeList}">
            <c:forEach var="record" items="${userTimeList}">
                <tr>
                    <td>${record.day}</td>
                    <td><fmt:formatDate value="${record.date}" pattern="yyyy-MM-dd" /></td>
                    <td><fmt:formatDate value="${record.checkInTime}" pattern="HH:mm:ss" /></td>
                    <td><fmt:formatDate value="${record.checkOutTime}" pattern="HH:mm:ss" /></td>
                    <td>${record.totalHours}</td>
                    <td><fmt:formatDate value="${record.createdAt}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
                </tr>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <tr>
                <td colspan="6" style="text-align:center;">No records found for selected Month and Year.</td>
            </tr>
        </c:otherwise>
    </c:choose>
</table>