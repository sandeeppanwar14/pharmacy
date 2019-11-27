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
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *
 * @author sandeep
 */
public class newOrder extends HttpServlet {

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
        String username,medicine,phone,address;
        double total,tax,net;
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpServletResponse httpResponse = (HttpServletResponse)response;
        HttpSession session=request.getSession(false);
httpResponse.setHeader("Cache-Control","no-cache, no-store, must-revalidate"); 
response.addHeader("Cache-Control", "post-check=0, pre-check=0");
httpResponse.setHeader("Pragma","no-cache"); 
httpResponse.setDateHeader ("Expires", 0); 
if (session==null || session.getAttribute("username") == null || ((String)session.getAttribute("role")).compareTo("3")!=0 ) {                               
                 response.sendRedirect("admin.jsp");
                 return;
 }     
             Connection con=null;
        try{
        con=GetCon.getCon();
        HttpSession sess= request.getSession(false); //use false to use the existing session  
        username=(String)sess.getAttribute("username");//this will return username anytime in the session
        medicine=request.getParameter("code");
        phone=request.getParameter("phone");
        address=request.getParameter("addr");
        List<String> items =Arrays.asList(medicine.split("\\s*,\\s*"));
        PreparedStatement ps1=con.prepareStatement("select username from login where username=?");
        ps1.setString(1,username);
        ResultSet rs1=ps1.executeQuery();
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
                   " <a href=\"medlist\">Medicine</a>\n"+
             "<a class=\"active\" href=\"customerfirst.jsp\">Customer</a>\n" +
"            \n" +
"       	    <a id=\"rgt\"  href=\"logout\">Logout </a>\n" +
"            <a href=\"javascript:void(0);\" class=\"icon\" onclick=\"myFunction()\">\n" +
"    <i class=\"fa fa-bars\"></i>\n" +
"  </a>\n" +
"    </div>");
             out.println("<h1 style=\"text-align:center\">Details of Order</h1>");
           out.println("<h5 style=\"text-align:center\">* Rate are listed in Rupees</h5>");
           
           
           
             String str="<table style=\"width:70vh;border-collapse:collapse;margin: 1% auto 5% auto;\"><tr><th style=\"border: 1px solid #222222;\">Username</th><th style=\"border: 1px solid #222222;\">"+username+"</th></tr><tr><th style=\"border: 1px solid #222222;\">Phone</th><th style=\"border: 1px solid #222222;\">"+phone+"</th></tr><tr><th style=\"border: 1px solid #222222;\">Address</th><th style=\"border: 1px solid #222222;\">"+address+"</th></tr>><tr><th style=\"border: 1px solid #222222;\">Medicine Name</th><th style=\"border: 1px solid #222222;\">Rate</th></tr>";
          //out.println(str);
             total=0;
           int i;
        for(i=0;i<items.size();i++)
        {
        PreparedStatement ps2=con.prepareStatement("SELECT MAXAMOUNT,RATE FROM MEDICINE WHERE MNAME=?");
        int a=items.get(i).indexOf("(");
        int b=items.get(i).indexOf(")");
        String med=items.get(i).substring(0, a);
        int amt=Integer.parseInt(items.get(i).substring(a+1,b));
        ps2.setString(1,med);
        //System.out.println(med+" "+amt);
        ResultSet rs=ps2.executeQuery();
        boolean sta=rs.next();
        if(sta==false)
        {
            flag=true;
        str=str+"<tr><th style=\"border: 1px solid #222222;\">"+med+"</th><th style=\"border: 1px solid #222222;color:red;\">Not Found</th></tr>";
        }
        else if(rs.getInt(1)<amt)
        {
            flag=true;
        str=str+"<tr><th style=\"border: 1px solid #222222;\">"+med+"</th><th style=\"border: 1px solid #222222;color:red;\">(only "+rs.getInt(1)+" unit remaining)</th></tr>"; 
        }
        else
        {
        str=str+"<tr><th style=\"border: 1px solid #222222;\">"+med+"</th><th style=\"border: 1px solid #222222;\">"+(rs.getInt(2)*amt)+"</th></tr>";
        total=total+rs.getInt(2)*amt;
        }
        }
        //out.println(str);
        str=str+"<tr><th style=\"border: 1px solid #222222;\">Amount</th><th style=\"border: 1px solid #222222;\">"+total+"</th></tr>";
        tax=0.18*total;
        str=str+"<tr><th style=\"border: 1px solid #222222;\">Tax</th><th style=\"border: 1px solid #222222;\">"+tax+"</th></tr>";
        net=total+tax;
        str=str+"<tr><th style=\"border: 1px solid #222222;\">Net</th><th style=\"border: 1px solid #222222;\">"+net+"</th></tr></table>"; 
        out.println(str);
        
        
        if(flag==true)
        {
        out.println("<a class=\"cona\" style=\"width:20%;margin:2% auto 3% auto;\"href=\"neworder.jsp\">Please fill the details Correctly</a>");
        }
        else
        {
            
        
      int flag1=0;
        for(i=0;i<items.size();i++)
        {
        PreparedStatement ps3=con.prepareStatement("UPDATE MEDICINE SET MAXAMOUNT=MAXAMOUNT-? WHERE MNAME=?");
        int a1=items.get(i).indexOf("(");
        int b1=items.get(i).indexOf(")");
        String med1=items.get(i).substring(0, a1);
        int amt1=Integer.parseInt(items.get(i).substring(a1+1,b1));
        ps3.setInt(1,amt1);
        ps3.setString(2,med1);
        int sta1=ps3.executeUpdate();
        if(sta1==0)
        {
        flag1=1;
        }
        }
        
    if(flag1==1)
    {
   out.println("<h5 style=\"text-align:center\">*Order Unsuccessfull </h5>");
    out.println("<a class=\"cona\" style=\"width:20%;margin:0% auto 3% auto;\"href=\"neworder.jsp\">Try Again</a>");
                 
    }
    else
    {
        
        int a=Confirm.confirmOrder(username,medicine,phone,address,total,tax);
        if(a==1){
        out.println("<h5 style=\"text-align:center\">*Order Successfull(Please go My Orders to see Order No.) </h5>");
        out.println("<a class=\"cona\" style=\"width:20%;margin:0% auto 3% auto;\"href=\"neworder.jsp\">New Order</a>");
        }
        else{
        out.println("<h5 style=\"text-align:center\">*Order Unsuccessfull </h5>");
    out.println("<a class=\"cona\" style=\"width:20%;margin:0% auto 3% auto;\"href=\"neworder.jsp\">Try Again</a>");
        }
    }
    }
        
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
