<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>
  <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/common.css" type="text/css" media="screen, projection"/>


<title>Default</title>
</head>
<body class="defaultBody">
<div class="container" style="border: #C1C1C1 solid 1px; border-radius:10px;">
<tiles:insertAttribute value="header"/>
<div class="span-5  border" style="height:400px;background-color:#FCFCFC;">
<tiles:importAttribute value="menu"/>
</div>
<!-- Body Page -->
<div class="span-19 last">
<tiles:insertAttribute value="body"/>
</div>
<tiles:insertAttribute value="footer"/>
</div>
</body>
</html>