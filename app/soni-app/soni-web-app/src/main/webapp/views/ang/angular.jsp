<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>First Angular js application</title>
<script language="javascript" src="<%=request.getContextPath()%>/js/angular.min.js"></script>
 

</head>
<body>
<div>
<lable>Name:</lable>
<input type="text" ng-model="yourName" placeholder="Enter a Name here">
</hr>
<h1>Hello {{yourName}}</h1>
</div>
</body>
<a href="myfirstexample.jsp">FIrst</a>
</html>