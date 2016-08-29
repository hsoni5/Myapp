<%@ page language="java" import="java.util.*" import="com.candidate.hr.Propertylist" import="com.candidate.hr.Skills" import="com.candidate.hr.Status" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html><style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
-->
</style>
<link  rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/servlet.css">
<div id="lypsum">
<body>

<center><span class="sbHeadingText">Candidate Feedback Form</span><br></center>
<form action="Store" method="get">
<input type="hidden"  name="candidate_id" value="<%=((String)request.getAttribute("candidate_id")).trim()%>" >
<table width="100%" align="center" cellpadding="5">
  	<tr><td>
    <div align="center"><h3><%=request.getAttribute("name")%></h3>
      
    </div></td></tr>
      <tr>
        <td bgcolor="#F3F3F3" height="1"></td>
      </tr>	
</table>
<table width="600" align="center" cellpadding="5">
  <tr><td class="sbHeadingText" colspan="3"><div align="center">Technical Skill set</div></td>
  </tr>
<tr>

<td class="sbListText">Skills</td>
<td class="sbListText">Rating</td>
<td>Remark</td>
</tr>
<tr>
<% 	Iterator itr = null;
	boolean bReadFromList = false;
	
	ArrayList skill_list = new ArrayList();
	ArrayList status_list = new ArrayList();
	skill_list = (ArrayList)request.getAttribute("skill_list"); 
	status_list = (ArrayList)request.getAttribute("status_list");

	Iterator skillItr = skill_list.iterator();
	Skills sk = null;
	Status st = null;
	int count = 1;
	if(  status_list.size()>0 && skill_list.size()>0)
	{
		bReadFromList = true;
	}
	for (int i=0;i<5;i++){
		if(bReadFromList){
		sk = (Skills)skill_list.get(i);
		st = (Status)status_list.get(0);
		}
		
	 %>
	
			<td><select name="skill_<%=count%>" class="sbTextField">     
      		<%
			itr =Propertylist.getProperties(com.candidate.hr.SearchServlet.path+"feedback.properties").iterator();
			
			while (itr.hasNext()) {
	    	String key = (String)itr.next();
	    		    	
	    	  if(sk != null && sk.getSkill().equals(key)){%>
	    		<option selected value="<%=key%>" ><%=key%> </option>
           	  <%} else{ %>
           		<option value="<%=key%>" ><%=key%> </option>
          	<%}}%>
         	</select>
    		</td>
    
    		<td> <select name="rating_<%=count%>">
    		<%for (int j=0; j<=10; j++){
    		 if(sk != null && Integer.parseInt(sk.getRating())==j){%>
	    		<option selected value="<%=j%>"><%=j%></option>
	    	<%} else {%>
          		<option value=<%=j%>><%=j%></option>
	     	 <%}}%>
	     	</select>
    		</td> 
   
    		<td>
    		<%if(sk != null ){
    		%>
       		 <input type="text" class="sbTextField" name="remark_<%=count%>" value="<%=sk.getRemark()==null?"":sk.getRemark()%>" >
       		 <%} else{ %>
       		 <input type="text" class="sbTextField" name="remark_<%=count%>">
       		 <%}%>
    		</td>
			</tr>
				<%count++;
				
 				}%>
			</table>
			
	<table width="100%">
 	 <tr>
        <td bgcolor="#F3F3F3" height="1" colspan="3"></td>
     </tr>	
	</table>
	
	<table width="600" align="center">      
	 <tr><td class="sbHeadingText" colspan="3">
  	 <div align="center">Status
  	 
     
     <select name="status" class="sbTextField">     
      		<%
			itr =Propertylist.getProperties(com.candidate.hr.SearchServlet.path+"status.properties").iterator();
			while (itr.hasNext()) {
	    	String key = (String)itr.next();
            if(st != null && st.getStatus().equals(key)){%>
	    		<option selected value="<%=key%>" ><%=key%> </option>
           	  <%} else 
           	  { %>
           <option value="<%=key%>" ><%=key%> </option>
          	<%} }%>
         	</select>
     
  	  </div></td></tr>
  	
  	<tr><td class="sbHeadingText" colspan="3">
     <div align="center">Conducted by
       <select name="conducted_by" class="sbTextField"/> 
        <%
			itr =Propertylist.getProperties(com.candidate.hr.SearchServlet.path+"conductedBy.properties").iterator();
			while (itr.hasNext()) {
	    	String key = (String)itr.next();
           if(st != null && st.getUpdatedby().equals(key)){%>
	    		<option selected value="<%=key%>" ><%=key%> </option>
           	  <%}  else {%>
           <option value="<%=key%>" ><%=key%> </option>
          	<%}}%>
        </select>
     </div></td></tr>
    
    <tr><td class="sbHeadingText" colspan="3">
     <div align="center">Comments<br></div>
    </td></tr>
    
    <tr><td class="sbListText" colspan="3">
     <div align="center">
		<% 
		String comments=(String)request.getAttribute("comments");
		if(comments==null)
		comments="";
		%>

    	<textarea name="comments" rows="2" cols="40"><%=comments%></textarea>
	</div></td></tr>
   </table>
   
   <table width="100%">
      <tr>
        <td bgcolor="#F3F3F3" height="1" colspan="3"></td>
      </tr>		
   </table>
   <table width="600" align="center">      
      <tr><td colspan="3">
      <div align="center">
      <INPUT TYPE="reset" class="button" />
        <input type="submit" class="button" value="submit" />
     </div></td></tr>
   </table>

</form>
<div align="center">

<a href="<%=request.getContextPath()%>/views/candidate/search.jsp" class="sbLinkText">Back to Search Page</a>
</div>
</body>
</div>
</html>
