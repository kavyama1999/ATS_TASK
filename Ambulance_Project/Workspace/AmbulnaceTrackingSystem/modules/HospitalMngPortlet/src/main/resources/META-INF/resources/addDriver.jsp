<%@ include file="./init.jsp" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<div class="container mt-5">
    <div class="card shadow-lg p-4 rounded">

<div class="card-header bg-primary text-white text-center rounded-top-4 py-3">
   <h2 class="mb-0 emoji-header">
     🧑‍✈️ Add Ambulance Driver    
  </h2>
</div>


        <portlet:actionURL name="addDriver" var="addDriverURL" />
                <div class="card-body p-4">

        <aui:form action="<%= addDriverURL %>" method="post" name="fm">

            <aui:input name="driverName" label="Driver Name" required="true" placeholder="Enter full name" />

            <aui:input name="contactNumber" label="Contact Number" required="true" placeholder="Enter phone number" />

            <aui:input name="email" label="Email" required="true" placeholder="Enter email address" />

            <aui:input name="address" label="Address" type="textarea" rows="2" placeholder="Enter full address" />

            <div class="text-center mt-4">
                <aui:button type="submit" value="Add Driver" cssClass="btn btn-primary" />
<%--                 <aui:button type="reset" value="Clear" cssClass="btn btn-secondary ml-2" />
 --%>            </div>
        </aui:form>
    </div>
   </div>
    
</div>

<style>
.container {
    max-width: 700px;
}
.card {
    background: #ffffff;
    border-radius: 15px;
    border: 1px solid #ddd;
}
.text-primary {
    color: #007bff !important;
}
.btn-primary {
    background-color: #007bff;
    border-color: #007bff;
}
.btn-primary:hover {
    background-color: #0056b3;
}
.btn-secondary {
    background-color: #6c757d;
    border-color: #6c757d;
}


.emoji-header {
    font-family: "Segoe UI Emoji", "Apple Color Emoji", "Noto Color Emoji", sans-serif;
}
</style>
