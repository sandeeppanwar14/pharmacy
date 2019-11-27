<%-- 
    Document   : order
    Created on : Jul 2, 2018, 7:06:14 AM
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
     <%
        HttpServletResponse httpResponse = (HttpServletResponse)response;

httpResponse.setHeader("Cache-Control","no-cache, no-store, must-revalidate"); 
response.addHeader("Cache-Control", "post-check=0, pre-check=0");
httpResponse.setHeader("Pragma","no-cache"); 
httpResponse.setDateHeader ("Expires", 0); 
if (session.getAttribute("username") == null || ((String)session.getAttribute("role")).compareTo("3")!=0) {                               
                 response.sendRedirect("admin.jsp");
                 return;
 }
%>
<div class="topnav" id="myTopnav">
            <a href="index.jsp">Home</a>
            <a href="medlist">Medicine</a>
            <a class="active" href="customerfirst.jsp">Customer </a>
            <a href="logout">Logout</a>
       	     <a href="javascript:void(0);" class="icon" onclick="myFunction()">
    <i class="fa fa-bars"></i>
  </a>
<div class="modal">
  <form class="modal-content" action="newOrder" method="post">
    <div class="container">
      <h1>New Order</h1>
      <p>Please fill in this form to create an new order.</p>
      <div class="errormessage">${errorMessage}</div>
      <label for="code"><b>Medicine</b></label>
      <p style="font-family:serif;font-size:11px;">eg. abcd(40),abc1(30). Where abcd and abc1 are medicine name and 40 and 30 are unit required. Separate two medicine by comma(,).</p>
      <input type="text" placeholder="Enter Medicine Name" name="code" required>
      <label for="phone"><b>Mobile Number</b></label>
      <input type="text" placeholder="Enter Mobile Number" name="phone" required>
      <label for="addr"><b>Address</b></label>
      <input type="text" placeholder="Enter Address" name="addr" required>
      <label>
        <input type="checkbox" checked="checked" name="remember" style="margin-bottom:15px"> Remember me
      </label>

      <p>please check all details before submitting.</p>

      <div class="clearfix">
        <button type="submit" class="signupbtn">Order</button>
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
