/**
 *
 * @author sandeep
 */
package com.pharmacy;
import java.sql.*;
public class GetCon {
private GetCon(){}

public static Connection con;
static{
	try {
		Class.forName(DBIntializer.DRIVER);
		con=DriverManager.getConnection(DBIntializer.CON_STRING,DBIntializer.USERNAME,DBIntializer.PASSWORD);
	} catch (ClassNotFoundException e) {
		
		e.printStackTrace();
                
                
                
                
                
                
	} catch (SQLException e) {
	
		System.out.println("Exception in GetCon");
	}
	
}
public static Connection getCon(){
	return con;
}

public static boolean checkPrimaryKey(String Username){
	boolean status=false;
	Connection con;
        con=GetCon.getCon();
	PreparedStatement ps2;
	try {
	
	ps2=con.prepareStatement("select * from LOGIN where USERNAME=?");
	ps2.setString(1,Username);
	ResultSet rs=ps2.executeQuery();
	status=rs.next();
	

	
	
} catch (SQLException e) {
		
		e.printStackTrace();
	}
return status;

}
public static boolean checkEmailKey(String email){
	boolean status=false;
	Connection con;
        con=GetCon.getCon();
	PreparedStatement ps2;
	try {
	
	ps2=con.prepareStatement("select * from LOGIN where EMAIL=?");
	ps2.setString(1,email);
	ResultSet rs=ps2.executeQuery();
	status=rs.next();
	

	
	
} catch (SQLException e) {
		
		e.printStackTrace();
	}
return status;

}
public static boolean checkPhoneKey(String phone){
	boolean status=false;
	Connection con;
        con=GetCon.getCon();
	PreparedStatement ps2;
	try {
	
	ps2=con.prepareStatement("select * from LOGIN where PHONE=?");
	ps2.setString(1,phone);
	ResultSet rs=ps2.executeQuery();
	status=rs.next();
	

	
	
} catch (SQLException e) {
		
		e.printStackTrace();
	}
return status;

}
public static boolean checkForForgotPassword(String username,String email,String phone){
	boolean status=false;
	Connection con;
        con=GetCon.getCon();
	PreparedStatement ps2;
	try {
	
	ps2=con.prepareStatement("select * from LOGIN where USERNAME=? and  EMAIL=? and PHONE=? ");
	ps2.setString(1,username);
        ps2.setString(2, email);
        ps2.setString(3,phone);
	ResultSet rs=ps2.executeQuery();
	status=rs.next();
	

	
	
} catch (SQLException e) {
		
		e.printStackTrace();
	}
return status;

}
public static boolean updatePassword(String username,String password){
	boolean stat=false;
	Connection con;
        con=GetCon.getCon();
        password=hash.getSha256(password);
	PreparedStatement ps2;
	try {
	
	ps2=con.prepareStatement("UPDATE LOGIN SET PASSWORD=? WHERE USERNAME=?");
	ps2.setString(1,password);
        ps2.setString(2,username);
	ResultSet rs=ps2.executeQuery();
	stat=rs.next();
	

	
	
} catch (SQLException e) {
		
		e.printStackTrace();
	}
return stat;

} 
}

