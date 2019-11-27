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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class verifyrole {

public static int checkLogin(String username,String s)
{
    int p=0;	
    boolean status;
    Connection con=null;
	
	try {
                   con=GetCon.getCon();		
		PreparedStatement ps;
                        ps=con.prepareStatement("SELECT * FROM LOGIN WHERE USERNAME = ? and PASSWORD = ?");
		//ps.setInt(1,accountno);
                ps.setString(1,username);
		ps.setString(2,s);
		ResultSet rs=ps.executeQuery();
		status=rs.next();
                if(status==true && rs.getInt(2)==1)
                p=1;
                else if(status==true && rs.getInt(3)==1)
                p=2;
                else if(status==true && rs.getInt(4)==1)
                p=3;
                else
                p=0;
	} catch (SQLException e) {
		e.printStackTrace();
        }
        return p;
}
}


