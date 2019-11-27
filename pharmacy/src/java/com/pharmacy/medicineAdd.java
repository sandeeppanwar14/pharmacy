/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pharmacy;
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author sandeep
 */
public class medicineAdd extends HttpServlet {

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
        String ra,am,mname;
        mname=(String)request.getParameter("mname");
        ra=(String)request.getParameter("ra");
        am=(String)request.getParameter("amt");
        double rate=Double.parseDouble(ra);
        int amount=Integer.parseInt(am);
         Connection con=null;
         try{
         con=GetCon.getCon();
         PreparedStatement ps=con.prepareStatement("SELECT MNAME,RATE FROM MEDICINE WHERE MNAME=?");
         ps.setString(1,mname);
         ResultSet rs=ps.executeQuery();
         if(rs.next())
         {
             
         if(rate!=rs.getDouble(2))
         {
         request.setAttribute("errorMessage","WRONG RATE");
         RequestDispatcher rd=request.getRequestDispatcher("medicineadd.jsp");
         rd.include(request, response);
         }
         else
         {
         PreparedStatement ps1=con.prepareStatement("UPDATE MEDICINE SET MAXAMOUNT=MAXAMOUNT+? WHERE MNAME=?");
         ps1.setInt(1,amount);
         ps1.setString(2, mname);
         int sta=ps1.executeUpdate();
         if(sta==0)
         {
         request.setAttribute("errorMessage","Unexpected Error");
         RequestDispatcher rd=request.getRequestDispatcher("medicineadd.jsp");
         rd.include(request, response);
         }
         else
         {
         request.setAttribute("errorMessage","Successfully Added");
         RequestDispatcher rd=request.getRequestDispatcher("medicineadd.jsp");
         rd.include(request, response);
         }
         }
         }
         else
         {
           PreparedStatement ps2=con.prepareStatement("INSERT INTO MEDICINE VALUES (?,?,?)");
           ps2.setString(1,mname);
           ps2.setInt(3,amount);
           ps2.setDouble(2,rate);
           
           int stat=ps2.executeUpdate();
           if(stat==0)
            {
            request.setAttribute("errorMessage","Unexpected Error");
            RequestDispatcher rd=request.getRequestDispatcher("medicineadd.jsp");
            rd.include(request, response);
             }
           else
            {
             request.setAttribute("errorMessage","Successfully Added");
             RequestDispatcher rd=request.getRequestDispatcher("medicineadd.jsp");
             rd.include(request, response);
            }
         
         
         }
         
         
         }catch(SQLException e)
         {
         e.printStackTrace();
         }
         
         finally{
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
