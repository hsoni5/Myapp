<%@ page language="java" import="java.util.*" import="com.candidate.hr.Propertylist" %>
<%@include file="header.jsp" %>
<%Iterator itr = null;%>
<html>
<link href="<%=request.getContextPath()%>/css/jamcracker.css" rel="stylesheet" type="text/css"><style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
-->
</style>
  <div id="lypsum">
  <body> 

<br>
<center><span class="sbHeadingText">Edit Candidate Details</span><br></center>
  <form  method="GET" ACTION="StoreEditData">
		<TABLE width="600" align="center" cellpadding="5">
		<input type="hidden"  name="candidate_id" value="<%=((String)request.getAttribute("candidate_id")).trim()%>">
			<TR>
			<TD ALIGN="RIGHT" VALIGN="MIDDLE" class="sbListText">Name :
			<TD ALIGN="LEFT">
			<INPUT NAME="Name" TYPE="text" class="sbTextField" VALUE="<%=request.getAttribute("name")%>" SIZE="40" MAXLENGTH="150"> </TR>
			
			<TR>
			<TD ALIGN="RIGHT" VALIGN="MIDDLE" class="sbListText">Phone :
			<TD ALIGN="LEFT">
			<INPUT NAME="Phone" TYPE="text" class="sbTextField" VALUE="<%=request.getAttribute("phone")%>" SIZE="40" MAXLENGTH="150"> </TR>
			
			<TR>
			<TD ALIGN="RIGHT" VALIGN="MIDDLE" class="sbListText">Email  :
			<TD ALIGN="LEFT">
			<INPUT NAME="Email" TYPE="text" class="sbTextField" VALUE="<%=request.getAttribute("email")%>" SIZE="40" MAXLENGTH="150"> </TR>
			
			<TR>
			<TD ALIGN="RIGHT" VALIGN="MIDDLE" class="sbListText">Source :
			<TD ALIGN="LEFT">
		<select NAME="Source" class="sbTextField" > 
			<%
			itr = Propertylist.getProperties(com.candidate.hr.SearchServlet.path+"source.properties").iterator();
			
    	    while (itr.hasNext()) {
	    	    String key = (String)itr.next();
            	if(key.equals(request.getAttribute("source"))){%>
	    	   <option selected value="<%=key%>"><%=key%><% 	
            	} else %>
			<option value="<%=key%>"><%=key%>
			<%}%>
		</select> </TR>			
			<TR>
			<TD ALIGN="RIGHT" VALIGN="MIDDLE" class="sbListText">Status :
			<TD ALIGN="LEFT">
		<select name="Status" class="sbTextField" >
			<%
			itr = Propertylist.getProperties(com.candidate.hr.SearchServlet.path+"status.properties").iterator();
			
    	    while (itr.hasNext()) {
	    	    String key = (String)itr.next();
	    	    if(key.equals(request.getAttribute("status"))){%>
	    	   <option selected value="<%=key%>"><%=key%> 	
            	<%} else %>
			<option value="<%=key%>"><%=key%>
			<%}%>
		</select> </TR>
			
			<TR>
			<TD ALIGN="RIGHT" VALIGN="MIDDLE" class="sbListText">Reason :
			<TD ALIGN="LEFT">
		<select name="Reason" class="sbTextField" >
			<%
			itr = Propertylist.getProperties(com.candidate.hr.SearchServlet.path+"reason.properties").iterator();
			
    	    while (itr.hasNext()) {
	    	    String key = (String)itr.next();
	    	    	    	    
            	if(key.equals(request.getAttribute("reason"))){%>
	    	   <option selected value="<%=key%>"><%=key%><% 	
            	} else %>
			<option value="<%=key%>"><%=key%>
			<%}%>
		</select> </TR>
			
			<TR>
			<TD ALIGN="RIGHT" VALIGN="MIDDLE" class="sbListText">Resume :
			<TD ALIGN="LEFT">
			<INPUT NAME="Resume" TYPE="text" class="sbTextField" VALUE="<%=request.getAttribute("resume")%>" SIZE="40" MAXLENGTH="150"> </TR>
			
			<TR>
			<TD ALIGN="RIGHT" VALIGN="MIDDLE" class="sbListText">Updated By :
			<TD ALIGN="LEFT">
		<select name="Updatedby" class="sbTextField"  >
			<%
			itr = Propertylist.getProperties(com.candidate.hr.SearchServlet.path+"updatedby.properties").iterator();
			
    	    while (itr.hasNext()) {
	    	    String key = (String)itr.next();
	      	   
            	if(key.equals(request.getAttribute("updatedby"))){%>
	    	   <option selected value="<%=key%>"><%=key%><% 	
            	} else %>
			<option value="<%=key%>"><%=key%>
			<%}%>
		</select> </TR>
			
		</TABLE>
		<table width="600" align="center">
  		<tr><td width="236"></td>
  		<td width="352">
	<INPUT TYPE="reset" class="button">
	<INPUT NAME="submit" TYPE="submit" class="button" VALUE="Submit"></td>
  		</tr>
  		</table>
  		
  </form> 
  <div align="center">
 <a href="../views/candidate/candidateHome.jsp" class="sbLinkText">Go Candidate Home</a>&nbsp;&nbsp;&nbsp;
   <a href="../views/candidate/search.jsp?edit=edit" class="sbLinkText">Back</a>
    </div>
  </body>
  </div>
  <%@include file="footer.jsp" %>
</html>
