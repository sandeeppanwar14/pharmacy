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
            <a class="active" href="#">Register </a>
            <a href="admin.jsp">Login</a>
       	     <a href="javascript:void(0);" class="icon" onclick="myFunction()">
    <i class="fa fa-bars"></i>
  </a>
<div class="modal">
  <form class="modal-content" action="registerser" method="post">
    <div class="container">
      <h1>Sign Up</h1>
      <p>Please fill in this form to create an account.</p>
      
      <div class="errormessage">${errorMessage}</div>
      <hr>
      <label for="username"><b>UserName</b></label>
      <input type="text" placeholder="Enter UserName" name="username" required>
      <label for="first"><b>First Name</b></label>
      <input type="text" placeholder="Enter First Name" name="first" required>
      <label for="middle"><b>Middle Name</b></label>
      <input type="text" placeholder="Enter Middle Name" name="middle">
      <label for="last"><b>Last Name</b></label>
      <input type="text" placeholder="Enter Last Name" name="last" required>
      <label for="email"><b>Email</b></label>
      <input type="text" placeholder="Enter Email" name="email" required>
      <label for="phone"><b>Mobile Number</b></label>
      <input type="text" placeholder="Enter Mobile Number" name="phone" required>
      <label for="addr"><b>Address</b></label>
      <input type="text" placeholder="Enter Address" name="addr" required>
      <label for="role"><b>Role</b></label><br/></br>
      <input type="radio" name="role" value="customer" checked>Customer</input><br/></br>
      <input type="radio" name="role" value="distributor" >Distributor</input></br></br>
      <label for="psw"><b>Password</b></label>
      <input type="password" placeholder="Enter Password" name="psw" required>

      <label for="psw1"><b>Repeat Password</b></label>
      <input type="password" placeholder="Repeat Password" name="psw1" required>
      
      <label>
        <input type="checkbox" checked="checked" name="remember" style="margin-bottom:15px"> Remember me
      </label>

      <p>By creating an account you agree to our Policies.</p>

      <div class="clearfix">
        <button type="submit" class="signupbtn">Sign Up</button>
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
