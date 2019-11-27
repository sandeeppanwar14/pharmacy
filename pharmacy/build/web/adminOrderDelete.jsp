<%-- 
    Document   : adminOrderDelete
    Created on : Jul 5, 2018, 8:55:04 AM
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
if (session.getAttribute("username") == null || ((String)session.getAttribute("role")).compareTo("1")!=0) {                               
                 response.sendRedirect("admin.jsp");
                 return;
 }
%>
<div class="topnav" id="myTopnav">
            <a href="index.jsp">Home</a>
            <a href="medlist">Medicine</a>
            <a class="active" href="adminfirst.jsp">Admin </a>
            
            <a href="logout">Logout</a>
       	     <a href="javascript:void(0);" class="icon" onclick="myFunction()">
    <i class="fa fa-bars"></i>
  </a>

            <div class="modal">
  <form class="modal-content" action="adminOrderDelete" method="post">
    <div class="container">
      <h1>Delete Order</h1>
      <p>Please provide the order no. to be deleted.</p>
      <div class="errormessage">${errorMessage}</div>
       <label for="order"><b>Order Number</b></label>
      <input type="text" placeholder="Enter Order No." name="order" required>
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


