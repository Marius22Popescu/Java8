package com.marius.MavenCoreJava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JDBCTest {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?serverTimezone=UTC","root", "M442333244m");
		Statement st = con.createStatement();
//		boolean s1 = st.execute("Create table emp(eno numeric(10), ename varchar(50), esa1 numeric(10), primary key(eno))");
//		boolean s2 = st.execute("insert into emp values(1001, 'Trupti', 12345)");
//		boolean s3 = st.execute("insert into emp values(1002, 'Umair', 12345)");
//		boolean s4 = st.execute("insert into emp values(1003, 'David', 12345)");
//		boolean s5 = st.execute("insert into emp values(1004, 'Saran', 12345)");
		
		boolean s6 = st.execute("update emp set ename = 'Cameron' where eno= 1003");
		boolean s7 = st.execute("delete from emp where eno=1005");
		
		ResultSet rs = st.executeQuery("select * from emp");
		while (rs.next()) {
			System.out.println("Emp Number "+ rs.getInt(1));
			System.out.println("Emp Number "+ rs.getString(2));
			System.out.println("Emp Number "+ rs.getInt(3));
		}
		
		rs.close();
		st.close();
		con.close();
	}

}
