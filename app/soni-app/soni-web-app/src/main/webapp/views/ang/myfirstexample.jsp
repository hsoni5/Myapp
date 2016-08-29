<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script language="javascript" src="<%=request.getContextPath()%>/js/angular.min.js"></script>
<title>my first ang application</title>

<script type="text/javascript">
angular.module("myapp",[])
 .controller("HelloController",function($scope){
	 $scope.helloTo={};
	 $scope.helloTo.title="Anjular Js";
 });
</script>
</head>
<body ng-app="myapp">
<div ng-controller="HelloController"">
<h2>Welcome {{helloTo.title}} to the world of soni</h2>
</div>
</body>
</html>