<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>javaguides.net</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
 rel="stylesheet">
<%@ page isELIgnored="false"%>
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>
 <div class="container">
  <div class="col-md-offset-1 col-md-10">
   <h3 class="text-center">Spring MVC 5 + Spring Data JPA 2 + JSP +
    MySQL - Request Management</h3>
   <hr />

   <input type="button" value="Add Request"
    onclick="window.location.href='showForm'; return false;"
    class="btn btn-primary" /> <br />
   <br />
   <div class="panel panel-info">
    <div class="panel-heading">
     <div class="panel-title">Request List</div>
    </div>
    <div class="panel-body">
     <table class="table table-striped table-bordered">
      <tr>
       <th>Code</th>
       <th>Description</th>
       <th>Summary</th>
      </tr>

      <!-- loop over and print our requests -->
      <c:forEach var="tempRequest" items="${requests}">

       <!-- construct an "update" link with request id -->
       <c:url var="updateLink" value="/request/updateForm">
        <c:param name="requestId" value="${tempRequest.id}" />
       </c:url>

       <!-- construct an "delete" link with request id -->
       <c:url var="deleteLink" value="/request/delete">
        <c:param name="requestId" value="${tempRequest.id}" />
       </c:url>

       <tr>
        <td>${tempRequest.code}</td>
        <td>${tempRequest.description}</td>
        <td>${tempRequest.summary}</td>

        <td>
         <!-- display the update link --> <a href="${updateLink}">Update</a>
         | <a href="${deleteLink}"
         onclick="if (!(confirm('Are you sure you want to delete this request?'))) return false">Delete</a>
        </td>

       </tr>

      </c:forEach>

     </table>

    </div>
   </div>
  </div>

 </div>
 <div class="footer">
  <p>Footer</p>
 </div>
</body>

</html>