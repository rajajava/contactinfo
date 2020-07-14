 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css" rel="stylesheet">
<title>ViewContacts</title>
</head>
<body>
    <h2>ViewContacts</h2>
     <a href="/contactinfo/getindex">+AddContact</a>
    <table border="1" id="example">
    <thead>
  <tr>
    <th>SL.No</th>         
    <th>Name</th> 
    <th>Email</th>
    <th>MobileNo</th>
    <th>Action</th>
  </tr>
   </thead>
   <tbody>
   <c:forEach items="${contactList}" var="c" varStatus="index" >
  <tr>
    <td> ${index.count}</td>
    <td>${c.contactName}</td>
    <td>${c.contactEmail}</td>
     <td>${c.contactNumber}</td>
      <td>
      <a href="/contactinfo/editcontact?contactId=${c.contactId}">Edit</a>
       <a href="/contactinfo/deletecontact?contactId=${c.contactId}"  onclick="deleteConfirn()">Delete</a>
      </td>
  </tr>
  </c:forEach>
    <tbody> 
  </table>
 <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
 <script src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
 <script>
 $(document).ready(function() {
	    $('#example').DataTable( {
	        "pagingType": "full_numbers"
	    } );
	} );
 </script>
 <script>
 function deleteConfirn(){
	 return confirm("Are you sure,you want to delete the record?");
 }
 </script>
</body>


</html>