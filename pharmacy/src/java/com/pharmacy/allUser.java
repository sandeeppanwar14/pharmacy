/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pharmacy;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sandeep
 */
public class allUser extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpServletResponse httpResponse = (HttpServletResponse)response;
        HttpSession session=request.getSession(false);
httpResponse.setHeader("Cache-Control","no-cache, no-store, must-revalidate"); 
response.addHeader("Cache-Control", "post-check=0, pre-check=0");
httpResponse.setHeader("Pragma","no-cache"); 
httpResponse.setDateHeader ("Expires", 0); 
if (session==null || session.getAttribute("username") == null || ((String)session.getAttribute("role")).compareTo("1")!=0) {                               
                 response.sendRedirect("admin.jsp");
                 return;
 }     
             Connection con=null;
        try{
        con=GetCon.getCon();
        PreparedStatement ps1=con.prepareStatement("SELECT * FROM  LOGIN");
        ResultSet rs1=ps1.executeQuery();
        if(rs1.next()==false)
        {
        request.setAttribute("errorMessage","* No Users");
	               RequestDispatcher rd=request.getRequestDispatcher("adminfirst.jsp");
			rd.include(request, response);
        }
        else
        {
            boolean flag=false;
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");
            out.println("<title>PHARMACY MANAGEMENT SYSTEM</title>"); 
            out.println("<link href=\"style.css\" rel=\"stylesheet\" type=\"text/css\"> \n" +
"<link rel=\"stylesheet\" href=\"http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"topnav\" id=\"myTopnav\">\n" +
"            <a href=\"index.jsp\">Home</a>\n" +
"                    <a href=\"medlist\">Medicine</a>\n"+
        "<a class=\"active\" href=\"adminfirst.jsp\">Admin</a>\n" +
"            \n" +
"       	    <a id=\"rgt\"  href=\"logout\">Logout </a>\n" +
"            <a href=\"javascript:void(0);\" class=\"icon\" onclick=\"myFunction()\">\n" +
"    <i class=\"fa fa-bars\"></i>\n" +
"  </a>\n" +
"    </div>");
             out.println("<h1 style=\"text-align:center\">List Of All Users</h1>");
           String str="<table style=\"width:70vh;border-collapse:collapse;margin: 1% auto 5% auto;\"> <tr><th style=\"border: 1px solid #222222;\">Name</th><th style=\"border: 1px solid #222222;\">Username</th><th style=\"border: 1px solid #222222;\">Role</th><th style=\"border: 1px solid #222222;\">Email</th> <th style=\"border: 1px solid #222222;\">Phone</th><th style=\"border: 1px solid #222222;\">Address</th></tr>";
                
                  do{
                      String role,middle="";
                      if(rs1.getInt(2)==1)
                          role="Admin";
                      else if(rs1.getInt(3)==1)
                          role="Distributor";
                      else
                          role="Customer";
                      
                      if(rs1.getString(10)!=null)
                          middle=rs1.getString(10);
                   str+=("<tr><th style=\"border: 1px solid #222222;\">"+rs1.getString(9)+" "+middle+" "+rs1.getString(11)+"</th><th style=\"border: 1px solid #222222;\">"+rs1.getString(1)+"</th><th style=\"border: 1px solid #222222;\">"+role+"</th> <th style=\"border: 1px solid #222222;\">"+rs1.getString(5)+"</th><th style=\"border: 1px solid #222222;\">"+rs1.getString(6)+"</th><th style=\"border: 1px solid #222222;\">"+rs1.getString(7)+"</th></tr>" );
                   }while(rs1.next());
               str=str+"</table>";
               out.println(str);
               
       
        
        out.println("<script type=\"text/javascript\">\n" +
"function myFunction() {\n" +
"    var x = document.getElementById(\"myTopnav\");\n" +
"    if (x.className === \"topnav\") {\n" +
"        x.className += \" responsive\";\n" +
"    } else {\n" +
"        x.className = \"topnav\";\n" +
"    }\n" +
"}");
                    
            out.println("</body>");
            out.println("</html>");
        }
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
