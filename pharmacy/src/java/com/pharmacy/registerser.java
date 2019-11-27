/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pharmacy;

/**
 *
 * @author sandeep
 */

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class registerser extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
        {

		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String username=request.getParameter("username");
                String first=request.getParameter("first");
                String middle=request.getParameter("middle");
                String last=request.getParameter("last");
                String email=request.getParameter("email");
                String phone=request.getParameter("phone");
                String r=request.getParameter("role");
                int customer,distributor,admin;
                customer=distributor=admin=0;
                
                if(r.equals("customer"))
                    customer=1;
                
                if(r.equals("distributor"))
                    distributor=1;
                String address=request.getParameter("addr");
                String password=request.getParameter("psw");
		String repassword=request.getParameter("psw1");
                if(phone.length()!=10 || (GetCon.checkPhoneKey(phone)==true))
                {       
		    request.setAttribute("errorMessage","Either Mobile number is invalid or already in use");
	               RequestDispatcher rd=request.getRequestDispatcher("register.jsp");
			rd.include(request, response);
                }
                else if(GetCon.checkEmailKey(email)==true)
                {
                request.setAttribute("errorMessage","This email id is already in use");
			RequestDispatcher rd=request.getRequestDispatcher("register.jsp");
			rd.include(request, response);
                }
                else if(GetCon.checkPrimaryKey(username)==true)
                {
                     request.setAttribute("errorMessage","Username already exist");
			RequestDispatcher rd=request.getRequestDispatcher("register.jsp");
			rd.include(request, response);
                }
                else if(password.compareTo(repassword)!=0)
                {
                     request.setAttribute("errorMessage","Password and Re-password doesn't match");
			RequestDispatcher rd=request.getRequestDispatcher("register.jsp");
			rd.include(request, response);
                }
                else
                {
	    int status;
            status=RegisterUser.register(username,admin,distributor,customer,email,phone,address,password,first,middle,last);
	   
	    
		if(status>0){
				
			request.setAttribute("welcome","WELCOME! YOU HAVE BEEN REGISTERD");
			RequestDispatcher rd=request.getRequestDispatcher("admin.jsp");
			rd.include(request, response);
		}
		else{
		        request.setAttribute("errorMessage","Sorry,Registration failed. please try later");
			RequestDispatcher rd=request.getRequestDispatcher("register.jsp");
			rd.include(request, response);
		}
                }
	out.close();	
	}

}

