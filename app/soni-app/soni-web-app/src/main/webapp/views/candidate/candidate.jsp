
<%@page import="com.candidate.hr.SearchServlet"%>
<%@ page language="java" import="java.util.*"
	import="com.candidate.hr.Propertylist" import="java.sql.*"%>
<%
	Iterator itr = null;
%>
<%
	String path = request.getContextPath();
    getServletConfig().getServletContext();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<style>
.legendBody {
	
	background-color: #FAF0E6;
	margin-right:0px;
	margin-left:0px;
	margin-top: 0px;
	width:1000px;
	
}

</style>

<base href="<%=basePath%>">

<title>Candidate Resume</title>

</head>
	<body>
	<table width="1000">
		<tr>
			<td>
				<fieldset class="legendBody" align="center">
					<legend align="center">Please Enter candidate details</legend>
					<form action="hr/CandidateServlet" method="POST" name="myform">
						<table width="500" align="center" cellpadding="5">
							<tr>
								<td align="RIGHT" valign="MIDDLE" class="cbListText">Name :</td>
								<td align="left"><input name="Name" type="text"
									class="sbTextField" value="" size="40" maxlength="150"></td>
							</tr>
							<tr>
								<td align="right" valign="middle" class="sbListText">Phone
									:</td>
								<td align="left"><input name="Phone" type="text"
									class="sbTextField" value="" size="40" maxlength="15"></td>
							</tr>

							<tr>
								<td align="right" valign="middle" class="sbListText">Email
									:</td>
								<td align="left"><input name="Email" type="text"
									class="sbTextField" value="" size="40" maxlength="15"></td>
							</tr>
							<tr>
								<td align="right" valign="middle" class="sbListText">Source
									:</td>
								<td align="left"><select name="Source" class="sbTextField">
										<%
											itr = Propertylist.getProperties(
													com.candidate.hr.SearchServlet.path + "source.properties")
													.iterator();

											while (itr.hasNext()) {
												String key = (String) itr.next();
										%>
										<option value="<%=key%>"><%=key%>
											<%
												}
											%>
										
								</select></td>
							</tr>


							<tr>
								<td align="right" valign="middle" class="sbListText">Status
									:</td>
								<td align="left"><select name="Status" class="sbTextField">
										<%
											itr = Propertylist.getProperties(
													com.candidate.hr.SearchServlet.path + "status.properties")
													.iterator();

											while (itr.hasNext()) {
												String key = (String) itr.next();
										%>
										<option value="<%=key%>"><%=key%>
											<%
												}
											%>
										
								</select></td>
							</tr>

							<tr>
								<td align="right" valign="middle" class="sbListText">Reason
									:</td>
								<td align="left"><select name="Reason" class="sbTextField">
										<%
											itr = Propertylist.getProperties(
													com.candidate.hr.SearchServlet.path + "reason.properties")
													.iterator();

											while (itr.hasNext()) {
												String key = (String) itr.next();
										%>
										<option value="<%=key%>"><%=key%>
											<%
												}
											%>
										
								</select></td>
							</tr>
							
							<tr>
								<td align="right" valign="middle" class="sbListText">Skill
									:</td>
								<td align="left"><select name="Skill" class="sbTextField">
										<%
											itr = Propertylist.getProperties(
													com.candidate.hr.SearchServlet.path + "reason.properties")
													.iterator();

											while (itr.hasNext()) {
												String key = (String) itr.next();
										%>
										<option value="<%=key%>"><%=key%>
											<%
												}
											%>
										
								</select></td>
							</tr>
							
							<tr>
								<td align="right" valign="middle" class="sbListText">Rating
									:</td>
								<td align="left"><input name="Rating" type="text"
									class="sbTextField" value="" size="40" maxlength="15"></td>
							</tr>
							<tr>
								<td align="right" valign="middle" class="sbListText">Remark
									:</td>
								<td align="left"><input name="Remark" type="text"
									class="sbTextField" value="" size="40" maxlength="15"></td>
							</tr>
							
							
							
							
							
							<tr>
								<td align="right" valign="middle" class="sbListText">Resume
									:</td>
								<td align="left"><input name="Resume" type="text"
									class="sbTextField" value="" size="40" maxlength="15"></td>
							</tr>
							<tr>
								<td align="right" valign="middle" class="sbListText">Updated
									By :</td>
								<td align="left"><select name="Updatedby" class="sbTextField">
										<%
											itr = Propertylist.getProperties(
													com.candidate.hr.SearchServlet.path
															+ "updatedby.properties").iterator();

											while (itr.hasNext()) {
												String key = (String) itr.next();
										%>
										<option value="<%=key%>"><%=key%>
											<%
												}
											%>
										
								</select></td>
							</tr>
							<tr>
								<td align="right" valign="middle" class="sbListText">Comments 
									:</td>
								   <td align="left"><TEXTAREA NAME="Comments" 
                                             ROWS="3" COLS="25"> Please enter your special instructions or comments
                         </TEXTAREA></td>
							</tr>
							
                         </tr>
							
							
							
							
						</table>
						<table width="500" align="center">
							<tr>
							<td width="261">
								
								</td>
							<td width="227"><input type="reset" class="button">
									<input type="submit" class="button" value="Submit">
									</td>
								
								
							</tr>
							
							
							
							
						</table>

					</form>
					
				</fieldset>
			</td>
		</tr>
	</table>
</body>
</html>
