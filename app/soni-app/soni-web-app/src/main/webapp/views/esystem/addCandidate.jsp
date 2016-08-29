
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<style>
.legendBody {
	background-color: #FAF0E6;
	margin-right: 0px;
	margin-left: 0px;
	margin-top: 0px;
	width: 1000px;
}
</style>
<title>Candidate Resume</title>
</head>
<body>
	<table width="1000">
	<form:form action="addCandidate" method="POST" modelAttribute="candidate">
	
	
	<table width="500" align="center" cellpadding="5">
							<tr>
								<td align="RIGHT" valign="MIDDLE" class="cbListText">Name :</td>
								<td align="left">
								<form:input path="name" cssClass="sbListText"	size="40" maxlength="150" />
								</td>
							</tr>
						
							<tr>
								<td align="right" valign="middle" class="sbListText">Phone:</td>
								<td align="left">
								 <form:input path="phone" cssClass="sbListText" size="40" maxlength="15" />
								</td>
								</td>
							</tr>
							
							<tr>
								<td align="right" valign="middle" class="sbListText">Email:</td>
								<td align="left">
								 <form:input path="email" cssClass="sbListText"	size="40" maxlength="150" />
								</td>
								</td>
							</tr>
						
							 <tr>
								<td align="right" valign="middle" class="sbListText">Source:</td>
								<td align="left">
								<form:select path="source"	class="sbTextField">
								<form:options items="sourceList"/>
							
								</form:select>
								</td>
							</tr> 

							
							
							
	</table>						
	
	
	</form:form>
	
		<%-- <form:form action="addCandidate" method="POST" modelAttribute="candidate">
			<tr>
				<td>
					<fieldset class="legendBody" align="center">
						<legend align="center">Please Enter candidate details</legend>
						
						<table width="500" align="center" cellpadding="5">
							<tr>
								<td align="RIGHT" valign="MIDDLE" class="cbListText">Name :</td>
								<td align="left">
								<form:input path="name" cssClass="sbListText"	size="40" maxlength="150" />
								</td>
							</tr>
						
							<tr>
								<td align="right" valign="middle" class="sbListText">Phone:</td>
								<td align="left">
								<td align="left">
								 <form:input path="phone" cssClass="sbListText" size="40" maxlength="15" />
								</td>
								</td>
							</tr>

							<tr>
								<td align="right" valign="middle" class="sbListText">Email:</td>
								<td align="left">
								<td align="left">
								 <form:input path="email" cssClass="sbListText"	size="40" maxlength="150" />
								</td>
								</td>
							</tr>
						
							<tr>
								<td align="right" valign="middle" class="sbListText">Source:</td>
								<td align="left">
								<form:select path="source"	class="sbTextField">
									<form:options items="sourceList" />
								</form:select>
								</td>
							</tr>

							<tr>
								<td align="right" valign="middle" class="sbListText">Status	:</td>
								<td align="left">
								<form:select path="status"	class="sbTextField">
								 <form:options items="statusList" />
								</form:select>
								</td>
							</tr>

							<tr>
								<td align="right" valign="middle" class="sbListText">Reason:</td>
								<td align="left">
								 <form:select path="source"	class="sbTextField">
									<form:options items="reasonList" />
									</form:select>
								</td>
							</tr>

							<tr>
								<td align="right" valign="middle" class="sbListText">Skill:</td>
								<td align="left">
								 <form:select path="skill" class="sbTextField">
								  <form:options items="skillList" />
								 </form:select>
								</td>
							</tr>

							
							<tr>
								<td align="right" valign="middle" class="sbListText">Rating:</td>
								<td align="left">
								<td align="left">
								<form:select path="rating"	class="sbTextField">
								  <form:options items="ratingList" />
								</form:select>
								</td>
								</td>
							</tr>
							
							<tr>
								<td align="right" valign="middle" class="sbListText">Remark:</td>
								<td align="left">
								<form:input path="remark" 	cssClass="sbTextField" maxlength="15" />
								</td>
							</tr>

							<tr>
								<td align="right" valign="middle" class="sbListText">Resume:</td>
								<td align="left">
								<td align="left">
								<form:input path="resume" cssClass="sbListText" size="40" maxlength="150" />
								</td>
								</td>
							</tr>
							<tr>
								<td align="right" valign="middle" class="sbListText">Updated By :</td>
								<td align="left">
								<form:select path="updatedBy"	class="sbTextField">
									<form:options items="updatedList" />
								</form:select>
								</td>
							</tr>
							
							<tr>
								<td align="right" valign="middle" class="sbListText">Comments:</td>
								<td align="left">
								<form:textarea path="comments" cols="26"/>
									Please enter your special instructions or comments</td>
							</tr>
							</tr>
						</table>
						<table width="500" align="center">
							
							<tr>
								<td width="261"></td>
								<td width="227">
								<form:button name="reset" value="submit" />
								<form:button name="submit" value="submit" />
								</td>
							</tr>
							<form:form />

						</table>

						</form>

					</fieldset>
				</td>
			</tr>
	 --%>
	</table>
</body>
</html>
