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
      
      <div class="errormessage">${noSuch}</div>
      <hr>
      <label for="username"><b>UserName</b></label>
      <input type="text" placeholder="Enter UserName" name="username" required>
      <label for="email"><b>Email</b></label>
      <input type="text" placeholder="Enter Email" name="email" required>
      <label for="phone"><b>Mobile Number</b></label>
      <input type="text" placeholder="Enter Mobile Number" name="phone" required>
      <label for="password"><b>Password</b></label>
      <input type="password" placeholder="Enter Password" name="password" required>
      <label for="repassword"><b>Repassword</b></label>
      <input type="password" placeholder="Enter Password" name="repassword" required>
      
      <div class="clearfix">
        <button type="submit" class="signupbtn">Submit</button>
      </div>
    </div>
  </form>
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
