<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>savecontact</title>
</head>
<body>
    <h2>SaveContact</h2>
    <a href="/contactinfo/getallcontacts">ViewAllContacts</a>
    <p><font color='green'> ${succmsg}</font></p>
   <p><font color='red'> ${errmsg}</font></p>
  <form:form id="regester-form" action="/contactinfo/saveContact" method="POST" modelAttribute="contact" >
  <table>

			<tr>
			<form:hidden path="contactId"/>
				<td>Name</td>
				<td><form:input path="contactName" name="contactName"/></td>
			</tr>

			<tr>
				<td>Email</td> 
				<td><form:input path="contactEmail" name="contactEmail"/></td>
			</tr>
			<tr>
				<td>MobileNo</td>
				<td><form:input path="contactNumber" name="contactNumber"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="Register"></td>
			</tr>
    </table>
  </form:form>
  
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
   <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/jquery.validate.min.js"></script>
  <script type="text/javascript">
$(function() {
      $("#regester-form").validate({
      rules: {
    	  contactName: {
          required: true
        },
        contactEmail: {
          required: true
        },
        contactNumber: {
          required: true
        }
      },
      messages: {
    	  contactName: {
          required: " Name is a required field!!!"
        },
        contactEmail: {
          required: "email is a required field!!!"
        },
        contactNumber: {
          required: "contact number is required!!!"
        }
          }
      });
});
</script>
</body>
</html>