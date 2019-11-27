package com.pharmacy;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
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
public class verifyuser extends HttpServlet {

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
        String username=request.getParameter("uname");
        String password=request.getParameter("psw");
        password=hash.getSha256(password);
        
        int sta=0;
         sta=verifyrole.checkLogin(username,password);
         request.getSession().invalidate();
        HttpSession session= request.getSession();
         session.setAttribute("username",username);
        session.setAttribute("password",password);
        String stat=String.valueOf(sta);
         session.setAttribute("role",stat);
         session.setMaxInactiveInterval(30*60);
                if(sta==1)
                {
             
	               response.sendRedirect("adminfirst.jsp");
                }
                else if(sta==2)
                {
                    response.sendRedirect("distributor.jsp");
                }
                else if(sta==3)
                {     
	               response.sendRedirect("customerfirst.jsp");
                }
                else
                {
                    request.setAttribute("err1","Invalid Username or Password");
	               RequestDispatcher rd=request.getRequestDispatcher("admin.jsp");
			rd.include(request, response);
                }
            /* TODO output your page here. You may use following sample code. */
            
       
            out.close();
        
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
