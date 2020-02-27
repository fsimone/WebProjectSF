<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Test Spring JSP</title>
<link href="<c:url value="webjars/bootstrap/3.3.7/js/bootstrap.min.css" />"
 rel="stylesheet">
<script src="<c:url value="webjars/jquery/1.9.1/jquery.min.js" />"></script>
<script src="<c:url value="webjars/bootstrap/3.3.7/js/bootstrap.min.js" />"></script>
</head>
<body>
 <div class="container">
  <div class="col-md-offset-1 col-md-10">
   <h2>TEST INTEGRATION Spring Boot 2.2 - Hibernate 5 - Postgres 12</h2>
   <hr />

   <input type="button" value="Add Test"
    onclick="window.location.href='showForm'; return false;"
    class="btn btn-primary" />
    <br/><br/>
   <div class="panel panel-info">
    <div class="panel-heading">
     <div class="panel-title">Database List</div>
    </div>
    <div class="panel-body">
     <table class="table table-striped table-bordered">
      <tr>
       <th>Column Description from database</th>
      </tr>

      <!-- loop over and print our databaserow -->
      <c:forEach var="tempDatabaserow" items="${databaserow}">

       <tr>
        <td>${tempDatabaserow.description}</td>
       </tr>

      </c:forEach>

     </table>

    </div>
   </div>
  </div>

 </div>
</body>
</html>