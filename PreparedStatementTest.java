package com.marius.MavenCoreJava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class PreparedStatementTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{ 
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/db?serverTimezone=UTC","root","M442333244m");
		Statement st = con.createStatement();
		PreparedStatement pst = con.prepareStatement("insert into emp values(?, ?, ?)");
		pst.setInt(1, 1011); pst.setString(2, "Aku"); pst.setInt(3, 12345);
		
		int x = pst.executeUpdate();
		System.out.println(x+"recordscinserted");
		
		pst = con.prepareStatement("delete from emp where eno=?");
		pst.setInt(1,10);
		int y=pst.executeUpdate();
		System.out.println(y+"records deleted");
		
		con.close();
		
	}

}
