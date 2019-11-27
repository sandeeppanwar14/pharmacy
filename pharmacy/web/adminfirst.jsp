<%-- 
    Document   : adminfirst
    Created on : Jun 26, 2018, 11:43:33 AM
    Author     : sandeep
--%>

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
            <a id="rgt" class="active" href="adminfirst.jsp">Admin</a>
       	    <a id="rgt" href="logout">Logout </a>
            <a href="javascript:void(0);" class="icon" onclick="myFunction()">
    <i class="fa fa-bars"></i>
  </a>
    </div>
        <div style="width:20%; float:left;" class="errormessage">${errorMessage}</div>
    <img src="images/home.jpg" alt="photo" class="img">
    <table class="hedo">
        
        
        <tr>
            <td>
                <a class="cona" href="allUser">All Users</a> 
            </td>
            <td>
                
            </td>
        </tr>
        <tr>
            <td>
                <a class="cona" href="adminAllOrder">All Orders</a> 
            </td>
        </tr>
        <tr>
            <td>
                <a class="cona" href="deleteuser.jsp">Delete a User</a>
            </td>
        </tr>
        <tr>
            <td>
                <a class="cona" href="adminOrderDelete.jsp">Delete a Order</a>
            </td>
        </tr>
    </table>
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

