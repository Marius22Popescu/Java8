package com.marius.MavenCoreJava;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CallableStatementTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{ 
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/db?serverTimezone=UTC","root","M442333244m");
		Statement st = con.createStatement();
		CallableStatement cst = con.prepareCall("{Call getEmployName2(?, ?, ?)}");
		cst.setInt(1, 1010); 
		//cst.setString(2, "Aku");
		cst.registerOutParameter(2,  java.sql.Types.VARCHAR);
		cst.registerOutParameter(3,  java.sql.Types.NUMERIC);
		cst.executeUpdate();
		String ename = cst.getString(2);
		int esa1 = cst.getInt(3);
		
//		System.out.println("retrieved");
		System.out.println("Emp name "+ename);
		System.out.println("Emp sal"+esa1);
	}
}
