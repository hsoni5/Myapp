<%@ page language="java" contentType="text/html; charset=UTF-8"  
 pageEncoding="UTF-8"%>  
<%@ taglib uri="/struts-tags" prefix="form"%>  
  
<html>  
<head>  
<title>Welcome</title>  
</head>  
<body>  
 <center>  
  
  <h2>SONY Guys | Registration Form</h2>  
    
   
  
  <form:form action="details.action">  
   <form:textfield name="firstName" label="First Name: " />  
   <form:textfield name="lastName" label="Last Name: " />  
   <form:textfield name="email" label="Email: " />  
   <form:textfield name="phone" label="Phone: " />  
   <form:submit />  
  </form:form>  
 </center>  
</body>  
</html>  