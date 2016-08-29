
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html" ; charset="UTF-8">

<title>Welcome</title>

<LINK REL="StyleSheet" href="<%=request.getContextPath()%>/css/main.css">

<script language="javascript" src="<%=request.getContextPath()%>/js/Menu.js"></script>

<style>
body {
	background-color: #FFF;
}

#header {
	background-color: PINK;
	color: BLACK;
	padding: 20px;
}

#footer {
	background-color: #006;
	color: #FFF;
	padding: 20px;
}

#lypsum {
	padding: 15px;
	background-color: #FAF0E6;
	margin-right: 220px;
	margin-top: 5px;
	height:500px; 
}

#brain2 {padding 5px;
	padding-bottom: 15px;
	border-width: 2px;
	border-style: dotted;
	border-color: #4682B4;
	background-color: #E0FFFF;
	width: 200px;
	text-align: center;
	float: right;
	margin-left: 10px;
	margin-right: 5px;
	margin-top: 5px;
}
</style>

</head>

<body>

	<div id="menu">

		<table class="navbar" width="1355">
			<tr>
			<td class="menuNormal" width="180" onmouseover="expand(this);"	onmouseout="collapse(this);">
			<b><p align="center">Home</p></b>
					<div class="menuNormal" width="155">
						<table class="menu" width="155">
							<tr>
								<td class="menuNormal"><a href="personHome" class="menuitem">My profile</a></td>
							</tr>

							<tr>
								<td class="menuNormal"><a href="viewPeson" class="menuitem">View List</a></td>
							</tr>

							<tr>
								<td class="menuNormal"><a href="users" class="menuitem">View Users</a></td>
							</tr>

							<tr>
								<td class="menuNormal"><a href="signOut" class="menuitem">Sign Out</a></td>
							</tr>

						</table>

					</div>

				</td>
				<td class="menuNormal" width="180" onmouseover="expand(this);" onmouseout="collapse(this);">
					<b><p align="center">Spring Tutorial</p></b>
					<div class="menuNormal" width="155">

						<table class="menu" width="155">

							<tr>
								<td class="menuNormal"><a href="users" class="menuitem">Core IOC
										</a></td>
							</tr>

							<tr>
								<td class="menuNormal"><a href="pages/common/module/ang/angular.jsp" class="menuitem">Spring MVC
										JS</a></td>
							</tr>

							<tr>
								<td class="menuNormal"><a href="page.htm" class="menuitem">Spring AOP
										3</a></td>
							</tr>

							<tr>
								<td class="menuNormal"><a href="page.htm" class="menuitem">SPring JDBC template
										4</a></td>
							</tr>

						</table>

					</div>

				</td>
		<td class="menuNormal" width="180" onmouseover="expand(this);"	onmouseout="collapse(this);">

<b><p align="center">Employee Hiring System</p></b>
<div class="menuNormal" width="155">
						<table class="menu" width="155">
							<tr>
								<td class="menuNormal"><a href="candidate" class="menuitem">Candidate </a></td>
							</tr>

							<tr>
								<td class="menuNormal"><a href="editCandidate" class="menuitem">edit</a></td>
  							</tr>

							<tr>
								<td class="menuNormal"><a href="searchCandidate" class="menuitem">Search</a></td>
							</tr>
							<tr>
								<td class="menuNormal"><a href="callFeedback" class="menuitem">Candidate Feedback</a></td>
							</tr>
						</table>

					</div>
		</td>		

	
 <td class="menuNormal" width="180" onmouseover="expand(this);"	onmouseout="collapse(this);">
		<b><p align="center">Web technology</p></b>
					<div class="menuNormal" width="155">
						<table class="menu" width="155">
							<tr>
								<td class="menuNormal"><a href="pages/common/module/payment/paymentHome.jsp" class="menuitem">HTMl 5</a></td>
							</tr>

							<tr>
								<td class="menuNormal"><a href="page.htm" class="menuitem">CSS 3</a></td>
							</tr>

							<tr>
								<td class="menuNormal"><a href="page.htm" class="menuitem">Java script</a></td>
							</tr>

							<tr>
								<td class="menuNormal"><a href="page.htm" class="menuitem">Jquery</a></td>
							</tr>

						</table>

					</div>

				</td>

	<td class="menuNormal" width="180" onmouseover="expand(this);"	onmouseout="collapse(this);">

	<b><p align="center">J2EE</p></b>

<div class="menuNormal" width="155">
						<table class="menu" width="155">
							<tr>
								<td class="menuNormal"><a href="web/pages/common/search.jsp" class="menuitem">EJB</a></td>
							</tr>

							<tr>
								<td class="menuNormal"><a href="page.htm" class="menuitem">JMS</a></td>
							</tr>

							<tr>
								<td class="menuNormal"><a href="page.htm" class="menuitem">WEB services</a></td>
							</tr>

							<tr>
								<td class="menuNormal"><a href="page.htm" class="menuitem">Maven</a></td>
							</tr>

						</table>

					</div>
				</td>

				<td class="menuNormal" width="180" onmouseover="expand(this);"	onmouseout="collapse(this);">

    <b><p align="center">Hibernate</p></b>
<div class="menuNormal" width="155">
						<table class="menu" width="155">
							<tr>
								<td class="menuNormal"><a href="page.htm" class="menuitem">Hibernate 3.0</a></td>
							</tr>

							<tr>
								<td class="menuNormal"><a href="page.htm" class="menuitem">Advance Hibernate</a></td>
							</tr>

							<tr>
								<td class="menuNormal"><a href="page.htm" class="menuitem">JDBC</a></td>
							</tr>

							<tr>
								<td class="menuNormal"><a href="page.htm" class="menuitem">JDBC</a></td>
							</tr>

						</table>

					</div>				</td>
					
		<td class="menuNormal" width="180" onmouseover="expand(this);"	onmouseout="collapse(this);">

	<b><p align="center">Pending</p></b>

<div class="menuNormal" width="155">
						<table class="menu" width="155">
							<tr>
								<td class="menuNormal"><a href="form.action" class="menuitem">Struts</a></td>
							</tr>

							<tr>
								<td class="menuNormal"><a href="page.htm" class="menuitem">Item2</a></td>
							</tr>

							<tr>
								<td class="menuNormal"><a href="page.htm" class="menuitem">Item3</a></td>
  							</tr>

							<tr>
								<td class="menuNormal"><a href="page.htm" class="menuitem">Item4</a></td>
							</tr>

						</table>

					</div>
		</td>		

		<td class="menuNormal" width="180">

	<b><p align="center">
	<a href="signOut"><h6><b>Sign Out</b></h6></a></p></b>


		</td>		

			</tr>

		</table>

	</div>
</body>

</html>








