
<%-- 
    Document   : admin.jsp
    Created on : Jun 18, 2018, 6:06:59 AM
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
            <%
            HttpSession sess=request.getSession(false);
           String rol;
            if(sess==null)
           {
           rol="0";
           }
           else
           {
           rol=(String)sess.getAttribute("role");
           }
// int role=Integer.parseInt(rol);
            
            if(rol!=null && rol.compareTo("1")==0)
            {
           out.println("<div class=\"topnav\" id=\"myTopnav\">\n" +
"            <a class=\"active\" href=\"index.jsp\">Home</a>\n" +
                    "<a href=\"medlist\">Medicine</a>\n"+
             "<a  href=\"adminfirst.jsp\">Admin</a>\n" +
"            \n" +
"       	    <a id=\"rgt\"  href=\"logout\">Logout </a>\n" +
"            <a href=\"javascript:void(0);\" class=\"icon\" onclick=\"myFunction()\">\n" +
"    <i class=\"fa fa-bars\"></i>\n" +
"  </a>\n" +
"    </div>");}
           
            else if(rol!=null && rol.compareTo("3")==0)
            {
           out.println("<div class=\"topnav\" id=\"myTopnav\">\n" +
"            <a class=\"active\" href=\"index.jsp\">Home</a>\n" +
                    "<a href=\"medlist\">Medicine</a>\n"+
             "<a  href=\"customerfirst.jsp\">Customer</a>\n" +
"            \n" +
"       	    <a id=\"rgt\"  href=\"logout\">Logout </a>\n" +
"            <a href=\"javascript:void(0);\" class=\"icon\" onclick=\"myFunction()\">\n" +
"    <i class=\"fa fa-bars\"></i>\n" +
"  </a>\n" +
"    </div>");}
            else if(rol!=null && rol.compareTo("2")==0)
            {
           out.println("<div class=\"topnav\" id=\"myTopnav\">\n" +
"            <a class=\"active\" href=\"index.jsp\">Home</a>\n" +
                    "<a href=\"medlist\">Medicine</a>\n"+
             "<a  href=\"distributor.jsp\">Distributor</a>\n" +
"            \n" +
"       	    <a id=\"rgt\"  href=\"logout\">Logout </a>\n" +
"            <a href=\"javascript:void(0);\" class=\"icon\" onclick=\"myFunction()\">\n" +
"    <i class=\"fa fa-bars\"></i>\n" +
"  </a>\n" +
"    </div>");}
            
else
            {
           out.println("<div class=\"topnav\" id=\"myTopnav\">\n" +
"            <a class=\"active\" href=\"index.jsp\">Home</a>\n" +
                    "<a href=\"medlist\">Medicine</a>\n"+
             "<a  href=\"register.jsp\">Register</a>\n" +
"            \n" +
"       	    <a id=\"rgt\"  href=\"admin.jsp\">Login </a>\n" +
"            <a href=\"javascript:void(0);\" class=\"icon\" onclick=\"myFunction()\">\n" +
"    <i class=\"fa fa-bars\"></i>\n" +
"  </a>\n" +
"    </div>");}
            %>
            <%@ page import="java.sql.*"%>
      <%@ page import="java.io.*" %>
      <%@ page import="javax.servlet.*"%>
      <%@ page import="com.pharmacy.*" %>
            <a href="javascript:void(0);" class="icon" onclick="myFunction()">
    <i class="fa fa-bars"></i>
  </a>
  
    </div>
    <img src="images/home.jpg" alt="photo" class="img">
  
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
