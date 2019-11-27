/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pharmacy;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *
 * @author sandeep
 */
public class  medlist extends HttpServlet {

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
        
        Statement ps=null;
        try{
        Connection con=GetCon.getCon();
        ps=con.createStatement();
        ResultSet rs=ps.executeQuery("SELECT MNAME,RATE FROM MEDICINE");
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
"            <a  href=\"index.jsp\">Home</a>\n" +
                    "<a class=\"active\" href=\"medlist\">Medicine</a>\n"+
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
"            <a href=\"index.jsp\">Home</a>\n" +
                    "<a class=\"active\" href=\"medlist\">Medicine</a>\n"+
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
"            <a href=\"index.jsp\">Home</a>\n" +
                    "<a class=\"active\" href=\"medlist\">Medicine</a>\n"+
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
"            <a  href=\"index.jsp\">Home</a>\n" +
                    "<a class=\"active\" href=\"medlist\">Medicine</a>\n"+
             "<a  href=\"register.jsp\">Register</a>\n" +
"            \n" +
"       	    <a id=\"rgt\"  href=\"admin.jsp\">Login </a>\n" +
"            <a href=\"javascript:void(0);\" class=\"icon\" onclick=\"myFunction()\">\n" +
"    <i class=\"fa fa-bars\"></i>\n" +
"  </a>\n" +
"    </div>");}
            out.println("<h1 style=\"text-align:center\">List Of Available Medicine</h1>");
            String str="<table style=\"width:50vh;border-collapse:collapse;margin: 5% auto 5% auto;\"><tr ><th style=\"border: 1px solid #222222;\">Name</th><th style=\"border: 1px solid #222222;\">Rate</th></tr>";
            while(rs.next())
            {
                str+="<tr><th style=\"border: 1px solid #222222;\">"+rs.getString(1)+"</th><th style=\"border: 1px solid #222222;\">"+rs.getString(2)+"</th></tr>";
            }
            str+="</table>";        
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
