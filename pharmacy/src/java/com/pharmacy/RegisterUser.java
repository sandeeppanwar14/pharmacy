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
import java.sql.*;
public class RegisterUser {
static int status=0;
//int accountno=1;
public static int register(String username,int admin,int distributor,int customer,String email,String phone,String address,String password,String first,String middle,String last) 
{
	password=hash.getSha256(password);
        Connection con=GetCon.getCon();
	PreparedStatement ps;
	try {
		ps = con.prepareStatement("INSERT INTO LOGIN values(?,?,?,?,?,?,?,?,?,?,?)");
	        ps.setString(1,username);
                ps.setInt(2,admin);
                ps.setInt(3,distributor);
		ps.setInt(4,customer);
		ps.setString(5,email);
		ps.setString(6,phone);
		ps.setString(7,address);
		ps.setString(8,password);
		ps.setString(9,first);
		ps.setString(10,middle);
		ps.setString(11,last);
		
		status=ps.executeUpdate();
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	return status;
	
}
}
