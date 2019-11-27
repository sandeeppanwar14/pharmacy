<%-- 
    Document   : forgetPassword
    Created on : Jun 28, 2018, 6:59:55 AM
    Author     : sandeep
--%>


<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>PHARMACY MANAGEMENT SYSTEM</title>
<link href="style.css" rel="stylesheet" type="text/css"> 
<link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>
<div class="topnav" id="myTopnav">
            <a href="index.jsp">Home</a>
            <a href="medlist">Medicine</a>
            <a href="register.jsp">Register </a>
            <a href="admin.jsp">Login</a>
       	     <a href="javascript:void(0);" class="icon" onclick="myFunction()">
    <i class="fa fa-bars"></i>
  </a>
<div class="modal">
  <form class="modal-content" action="forgetpassword2.jsp" method="post">
    <div class="container">
      <h1>Forget Password</h1>
      <p>Please provide following details  to move further</p>
      <%
          boolean status=false;
          boolean sta=false;
      String username=(String)request.getParameter("username");
      String email=(String)request.getParameter("email");
      String phone=(String)request.getParameter("phone");
      String password=(String)request.getParameter("password");
      String repassword=(String)request.getParameter("repassword");
      status=GetCon.checkForForgotPassword(username,email,phone);
      if(status==true)
      {
          if(password.compareTo(repassword)==0)
          {
         
                        sta=GetCon.updatePassword(username,password);
                        if(sta==true)
                        {
                         %>
			<jsp:forward page="admin.jsp"></jsp:forward> 
			<%
                        }
                        else{
                        request.setAttribute("noSuch","Sorry, An unexpected error occured");
                         %>
			<jsp:forward page="forgetpassword.jsp"></jsp:forward> 
			<%
                        }
          }
          else
             {
                       request.setAttribute("noSuch","Sorry, password and repassword didnot match");
                         %>
			<jsp:forward page="forgetpassword.jsp"></jsp:forward> 
			<%
              }
      }
      else
      {
                   request.setAttribute("noSuch","Sorry, No such user exist");
                        %>
			<jsp:forward page="forgetpassword.jsp"></jsp:forward> 
			<%
      }
      %>
     
      <%@ page import="java.sql.*"%>
      <%@ page import="java.io.*" %>
      <%@ page import="javax.servlet.*"%>
      <%@ page import="com.pharmacy.*" %>
      
      
</div>

   <script type="text/javascript">
function myFunction() {
    var x = document.getElementById("myTopnav");
    if (x.className === "topnav") {
        x.className += " responsive";
    } else {
        x.className = "topnav";
    }
}
</script>

</body>
</html>
