package com.pharmacy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sandeep
 */
public class Confirm {
    public static int confirmOrder(String username,String medicine,String phone,String address,double total,double tax)
    {
        int status=0;
        Connection con=GetCon.getCon();
	PreparedStatement ps;
	try {
		ps = con.prepareStatement("INSERT INTO NEWORDER values(?,?,?,?,?,?,?,?,?)");
	        ps.setString(1,username);
                ps.setString(2,medicine);
		ps.setString(3,phone);
		ps.setString(4,address);
     
                ps.setDouble(5,total);
 
		ps.setDouble(6,tax);
		ps.setDouble(7,(total+tax));
                
                ResultSet rs1=null;
                int order=0;
                do
                {
                order=(int)(Math.random()*10000);
                PreparedStatement ps1=con.prepareStatement("SELECT ORDERNO FROM NEWORDER WHERE ORDERNO=?");
                ps1.setInt(1,order);
                rs1=ps1.executeQuery();
                }while(rs1.next() || order<=999);
		ps.setInt(8,order);
		ps.setString(9,"unknown");
		status=ps.executeUpdate();
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
        
        return status;
	
    
    }    
}
