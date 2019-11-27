/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sandeep
 */
package com.pharmacy;
import javax.servlet.*;
import java.sql.*;

public class Listener implements ServletContextListener{

	public void contextInitialized(ServletContextEvent arg0) {
		int status=0;
		Connection con=null;
	try{
		con=GetCon.getCon();
		PreparedStatement ps1=con.prepareStatement("Select * from login");
		try{
		status=ps1.executeUpdate();
		}catch(SQLSyntaxErrorException e)
		{
                 e.printStackTrace();
		 status=2;
		 System.out.println("my staus is "+status);
		 }		
		
		if(status==0)
		{
                    System.out.println("your table name already exist "+status);
                }
		else if(status==2) 
		{
                System.out.println("table does not exist new table has to be created" +status);
                PreparedStatement ps=con.prepareStatement("CREATE TABLE LOGIN(USERNAME VARCHAR2(20),ADMIN NUMBER NOT NULL,DISTRIBUTOR NUMBER NOT NULL,CUSTOMER NUMBER NOT NULL,EMAIL VARCHAR2(30) UNIQUE NOT NULL,PHONE CHAR(10) UNIQUE NOT NULL,ADDRESS VARCHAR2(60) NOT NULL,PASSWORD VARCHAR2(70) NOT NULL,FIRST_NAME CHAR(15) NOT NULL,MIDDL_NAME CHAR(15) ,LAST_NAME CHAR(15) NOT NULL,PRIMARY KEY(USERNAME))");
		ps.executeUpdate();
                String s=hash.getSha256(DBIntializer.apassword);
		PreparedStatement ps2=con.prepareStatement("INSERT INTO LOGIN VALUES(?,?,?,?,?,?,?,?,?,?,?)");
                ps2.setString(1,DBIntializer.admin);
                ps2.setString(2,"1");
                ps2.setString(3, "0");
                ps2.setString(4, "0");
                 ps2.setString(5, DBIntializer.email);
                  ps2.setString(6, DBIntializer.phone);
                   ps2.setString(7, DBIntializer.address);
                    ps2.setString(8, s);
                     ps2.setString(9, DBIntializer.first);
                      ps2.setString(10, "");
                       ps2.setString(11, DBIntializer.last);
                ps2.executeUpdate();
                PreparedStatement ps3=con.prepareStatement("CREATE TABLE MEDICINE(MNAME VARCHAR2(20),MAXAMOUNT NUMERIC(10) NOT NULL,RATE FLOAT NOT NULL,PRIMARY KEY(MNAME))");
		ps3.executeUpdate();
                PreparedStatement ps4=con.prepareStatement("CREATE TABLE NEWORDER(USERNAME VARCHAR2(20) NOT NULL,MEDICINE VARCHAR2(300) NOT NULL,PHONE CHAR(10) NOT NULL,ADDRESS VARCHAR2(300) NOT NULL,TOTAL FLOAT NOT NULL,TAX FLOAT NOT NULL,NET FLOAT NOT NULL,ORDERNO DECIMAL(4) NOT NULL,DIST VARCHAR2(20) NOT NULL,PRIMARY KEY(ORDERNO))");
                ps4.executeUpdate();
                }
                /*("CREATE TABLE LOGIN(USERNAME VARCHAR2(20),ADMIN NUMBER NOT NULL,DISTRIBUTOR NUMBER NOT NULL,CUSTOMER NUMBER NOT NULL,EMAIL VARCHAR2(30) UNIQUE NOT NULL,PHONE CHAR(10) UNIQUE NOT NULL,ADDRESS VARCHAR2(60) NOT NULL,PASSWORD VARCHAR2(70) NOT NULL,FIRST_NAME CHAR(15) NOT NULL,MIDDL_NAME CHAR(15) ,LAST_NAME CHAR(15) NOT NULL,PRIMACY KEY(USERNAME))");*/
		else
                {
                    System.out.println("else part "+status);
		}
        
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
	public void contextDestroyed(ServletContextEvent arg0)
            {
		System.out.println("project undeployed");
		
	    }
}

