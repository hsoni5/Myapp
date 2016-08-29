 
<%@page import="com.candidate.hr.Propertylist"%>
<%@ page language="java" import="java.util.*" import="com.candidate.hr.Propertylist" %>
<%Iterator itr = null;%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <%
       boolean bEdit = false;
       String title = "Candidate Feedback";
    	String strEdit = request.getParameter("edit");
		if(strEdit != null && strEdit.equals("edit")){
		bEdit = true;
		}
	    if(bEdit){
	    title = "Edit Candidate";
    	}
    
    %>
    
    <title><%=title%></title>
    
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
   <center>

<span class="sbHeadingText">
<%=title%></span>
   </center>
 
   <FORM name="SearchForm" method="POST" ACTION="hr/SearchServlet">
    <table>
    <div align="center"><span class="sbListText"></span></div>
    <tr>
    <td>Enter Candidate Name:</td>
    <td><INPUT NAME="name" TYPE="text" class="sbTextField"></td>
      </tr>
      <% if(bEdit){%>
          <tr>
          <td>or</td></tr>
         
	    
    	
      <tr> 
       <div align="center"><span class="sbListText"></span></div><td>Enter Candidate Statuts:</td>
       <td><select name="status" class="sbTextField">     
      		<%
			itr =Propertylist.getProperties(com.candidate.hr.SearchServlet.path+"status.properties").iterator();
			while (itr.hasNext()) {
	    	String key = (String)itr.next();
            %>
           <option value="<%=key%>" ><%=key%> </option>
          	<%}%>
         	</select>
         	</td></tr><%}%>
   </table>
       <INPUT type="hidden" value="<%=strEdit%>" name='Src'>
       <br>
       <br>
       <INPUT TYPE="submit" class="button" VALUE="Search">
     
   </FORM>

  </body>
  </div>
</html>
