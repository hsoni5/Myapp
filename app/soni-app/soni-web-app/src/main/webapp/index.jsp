<!DOCTYPE html>
<%@include file="/views/profile/common.jsp" %>
<html lang="en">

<head>
  <meta charset="utf-8" />
      <link rel="stylesheet" href="<%=request.getContextPath()%>/css/loginOrReg.css" type="text/css" />
       <link rel="stylesheet" href="<%=request.getContextPath()%>/css/common.css" type="text/css" />
  
   
     <script type="text/javascript">
     $(document).ready(function() {
    	 $("#regOrloginTab").tabs({
    		    // The event that switches the panel
    		    event: "click",
    		    // Effects: fadeIn, fadeOut, slideDown, slideUp, animate
    		    show: "fadeIn",
    		    hide: "fadeOut",
    		    // Starting panel
    		    active: 2,
    		    // Collapse by clicking the current tab
    		    collapsible: true,
    		    // Height based on content (content) or largest (auto)
    		    heightStyle: "auto"
    		    
    		  });
    	 $(".ui-tabs").css({
    		    "height": "1000px",
    		    "margin": "-33px",
    		    "padding": "0.2em",
    		    "position": "relative",
    		    "width": "696px"});
    	
    	 
    	 $("#dob").datepicker({
    		    // Show month dropdown
    		    changeMonth: true,
    		    // Show year dropdown
    		    changeYear: true,
    		    dateFormat: "dd/mm/yy",
    		    // Number of months to display
    		    numberOfMonths: 1,
    		    // Define maxDate
    		    maxDate: 3650000,
    		    // Define minDate
    		    minDate: -3650000,
    		    
    		    yearRange: '-125:+10', 
    		  });
    	 
    	 $("#accordion").accordion({
    		    // Slide animation or not or length
    		    animate: 1500,
    		    // Starting tab
    		    active: 1,
    		    // Collapsible if same tab is clicked
    		    collapsible: true,
    		    // Event that triggers
    		    event: "click",
    		    // Height based on content (content) or largest (auto)
    		    heightStyle: "content"
    		  });
     });
     </script>
   
</head>
<body>
  <div class="wrapper">

    <header>
      <h1>Hari Soni is Coming</h1>
    </header>

    <!-- Left Navigation -->
   
    <div class="left-nav">
      <ul>
        <li>Drop Bear</li>
        <li>Elwetritsch</li>
        <li>Hoop Snake</li>
        <li>Jackalope</li>
        <li>Skvader</li>
        <li>Snipe</li>
        <li>Wild Haggis</li>
        <li>Wolpertinger</li>
        <li> <a href="personHome">P Home</a></li>
      </ul>
    </div>

    <main>
   

<div id="regOrloginTab">
 <div id="accordion" >
<h4>Guest user please regiser here</h4>
<div>
<form action="">
<div id="registration">
 <div class="formRowContainer clearfix">
      <div class="leftDiv"><label for="firstName" >First Name:</label></div>
      <div class="rightDiv">
     	<input type="text" name="firsName" placeholder="First Name"  class="inputField" />
      </div>
  </div>
  <div class="formRowContainer clearfix">
      <div class="leftDiv"><label for="lastName" >Last Name:</label></div>
      <div class="rightDiv">
     	<input type="text" name="lastName" placeholder="First Name"  class="inputField" />
      </div>
  </div>
  <div class="formRowContainer clearfix">
      <div class="leftDiv"><label for="lastName" >Email:</label></div>
      <div class="rightDiv">
     	<input type="email" name="email" placeholder="Email"  class="inputField" />
      </div>
  </div>
  <div class="formRowContainer clearfix">
      <div class="leftDiv"><label for="lastName" >User Name:</label></div>
      <div class="rightDiv">
     	<input type="text" name="username" placeholder="username"  class="inputField" />
      </div>
  </div>
   <div class="formRowContainer clearfix">
      <div class="leftDiv"><label for="dateOfBirth" >Date of Birth:</label></div>
      <div class="rightDiv">
     	<input type="date" name="dateOfBirth" placeholder="Date of Birth" id="dob" class="inputField" />
      </div>
  </div>
   <div class="formRowContainer clearfix">
      <div class="leftDiv"><label for="gender" >Gender:</label></div>
      <div class="rightDiv">
     	<select type="select" placeholder="Select gender" class="inputField" >
     	<option value="selected">Select gender</option>
     	<option>Male</option>
     	<option>Female</option>
     	</select>
      </div>
  </div>
  
  <div class="formRowContainer clearfix">
      <div class="leftDiv"><label for="password" >Password:</label></div>
      <div class="rightDiv">
     	<input type="password" name="password" placeholder="Password"  class="inputField" />
      </div>
  </div>
  <div class="formRowContainer clearfix">
      <div class="leftDiv"><label for="cpassword" >Confirm Password:</label></div>
      <div class="rightDiv">
     	<input type="password" name="cpassword" placeholder="Confirm Password"  class="inputField" />
      </div>
  </div>

<div>
<a href="#"><div id="btn2">Sign Up</div></a> <!-- End Btn2 -->
  </div>

</div>
</form></div>
<h4>Login</h4>
<div>
<form action="">
<div id="login">
   <div class="formRowContainer clearfix">
      <div class="leftDiv"><label for="mailingaddress2" >User Name:</label></div>
      <div class="rightDiv">
     	<input type="email" name="username" placeholder="Username" class="inputField"/>
      </div>
  </div>
  <div class="formRowContainer clearfix">
      <div class="leftDiv"><label for="mailingaddress2" >Password:</label></div>
      <div class="rightDiv">
     	<input type="password" name="password" placeholder="Password"  class="inputField" />
      </div>
  </div>
 <div> 
<a href="#"><div class="btn">Sign In</div></a> <!-- End Btn -->
  </div>
</div>
</form></div>
<h4>Know more about us</h4>
<div>
Superman is a fictional superhero appearing in American comic books published by DC Comics. The character is considered an American cultural icon. The Superman character was created by writer Jerry Siegel and artist Joe Shuster in 1933; the character was sold to Detective Comics, Inc. (later DC Comics) in 1938. Superman first appeared in Action Comics #1 (June 1938) and subsequently appeared in various radio serials, newspaper strips, television programs, films, and video games. With the character's success, Superman helped to create the superhero genre and establish its primacy within the American comic book.
</div>
</div>      
    
    </main>

          



    </div> <!-- End of wrapper -->
           <footer>
               </footer>
              </body>
        </html>
        
        
        
        

     