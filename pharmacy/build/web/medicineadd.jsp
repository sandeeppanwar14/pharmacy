<%-- 
    Document   : medicineaddd
    Created on : Jul 4, 2018, 5:35:06 PM
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
            <a href="distributor.jsp">Distributor</a>
            <a href="logout">Logout</a>
       	     <a href="javascript:void(0);" class="icon" onclick="myFunction()">
    <i class="fa fa-bars"></i><%
        HttpServletResponse httpResponse = (HttpServletResponse)response;

httpResponse.setHeader("Cache-Control","no-cache, no-store, must-revalidate"); 
response.addHeader("Cache-Control", "post-check=0, pre-check=0");
httpResponse.setHeader("Pragma","no-cache"); 
httpResponse.setDateHeader ("Expires", 0); 
if (session.getAttribute("username") == null || ((String)session.getAttribute("role")).compareTo("2")!=0) {                               
                 response.sendRedirect("admin.jsp");
                 return;
 }
%>
  </a>
<div class="modal">
     
  <form class="modal-content" action="medicineAdd" method="post">
    <div class="container">
      <h1>Add Medicine</h1>
      <p>Please provide following details Medicine to be added.</p>
      
      <div class="errormessage">${errorMessage}</div>
      <hr>
      <label for="mname"><b>Medicine Name</b></label>
      <input type="text" placeholder="Enter Medicine Name" name="mname" required>
      <label for="ra"><b>Rate</b></label>
      <input type="text" placeholder="Enter Rate of one unit" name="ra" required>
      <label for="amt"><b>Amount</b></label>
      <input type="text" placeholder="Enter number of units" name="amt" required>
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
