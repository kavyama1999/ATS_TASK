<%@ include file="./init.jsp" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>


<%@ page import="java.util.List" %>
<%@ page import="AddAmbulanceDb.model.Hospital" %>



<%
    List<Hospital> hospitalList = (List<Hospital>) request.getAttribute("hospitalList");
    String errorMessage = (String) request.getAttribute("errorMessage");
%>

<div class="container mt-5">
    <h2 class="text-center mb-4">Registered Hospitals</h2>

    <c:if test="${not empty errorMessage}">
        <div class="alert alert-danger text-center">${errorMessage}</div>
    </c:if>

    <c:if test="${not empty hospitalList}">
        <div class="table-responsive shadow rounded">
            <table class="table table-striped table-hover">
                <thead class="table-dark">
                    <tr>
                        <th>#</th>
                        <th>Hospital Name</th>
                        <th>Location</th>
                        <th>Address</th>
                        <th>Contact Number</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="hospital" items="${hospitalList}" varStatus="status">
                        <tr>
                            <td><c:out value="${status.index + 1}" /></td>
                            <td><c:out value="${hospital.hospitalName}" /></td>
                            <td><c:out value="${hospital.location}" /></td>
                            <td><c:out value="${hospital.address}" /></td>
                            <td><c:out value="${hospital.contactNumber}" /></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </c:if>

    <c:if test="${empty hospitalList}">
        <div class="alert alert-info text-center">No hospitals found.</div>
    </c:if>
</div>

<style>
.table-responsive {
    border-radius: 10px;
    overflow: hidden;
}

.table {
    background-color: #fff;
}

.table-striped > tbody > tr:nth-of-type(odd) {
    background-color: #f2f2f2;
}

.table-hover tbody tr:hover {
    background-color: #d1ecf1;
    cursor: pointer;
}

.table-dark {
    background: linear-gradient(135deg, #007bff, #0056b3);
    color: white;
}
</style>




