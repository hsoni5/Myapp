<%@include file="header.jsp" %>
<%@ page language="java" import="java.util.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title> Welcome to Candidate Management System </title>
    
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
  <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1"><style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
-->
</style>
  <link href="<%=request.getContextPath()%>/css/jamcracker.css" rel="stylesheet" type="text/css">
  </head>
  <div id="lypsum">
  <body>
   
    <br>  
    <table align="center" cellpadding="15">
      <tr>
        <td><div align="center">
        <div align="center"><a href="./views/candidate/candidate.jsp" class="sbLinkText">Add New Candidate Details</a></div></td></tr><tr>
<td>
        <div align="center"><a href="pages/common/module/candidate/search.jsp?edit=edit" class="sbLinkText">Edit Existing Records</a></div></td></tr></table>
    </div>
  </body>
  </div>
  <%@include file="footer.jsp" %>
</html>
