
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
	padding: 5px;
}

#footer {
	background-color: #006;
	color: #FFF;
	padding: 20px;
}

#lypsum {
	padding: 5px;
	background-color: #FAF0E6;
	margin-right:0px;
	margin-left:0px;
	margin-top: 0px;
	height:550px; 
}

</style>

</head>

<body>

	<div id="header">
		<h2 style="font-family: cursive;bold;">
		
		<marquee behavior="slide" direction="left">Welcome...</marquee></h2>
		<b><p align="center"><a href="./personHome">Home</a></p></b>
	</div>

	<div id="menu">

		<table class="navbar" width="1345">
			<tr>
		 <td class="menuNormal" width="200" onmouseover="expand(this);" onmouseout="collapse(this);">
					<b><p align="center"><a href="./views/candidate/candidate.jsp">Candidate Home</a></p></b>
	    </td>
		<td class="menuNormal" width="200" onmouseover="expand(this);" onmouseout="collapse(this);">
					<b><p align="center"><a href="./views/candidate/search.jsp?edit=edit">Edit Candidate</a></p></b>
	   </td>
	   
		<td class="menuNormal" width="200" onmouseover="expand(this);" onmouseout="collapse(this);">
					<b><p align="center"><a href="./views/candidate/search.jsp">Candidate Feedback</a></p></b>
	   </td>
	  
	   
	   
	   <td class="menuNormal" width="200" onmouseover="expand(this);" onmouseout="collapse(this);">
					<b><p align="center"><a href="./views/candidate/search.jsp">Search</a></p></b>
	   </td>
		
  </tr>


		</table>

	</div>
</body>

</html>

