package com.marius.MavenCoreJava;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

public class DataSourceTest {
	private static BasicDataSource dataSource; //
	
	private static BasicDataSource getDataSource() {
		if (dataSource == null) {
				if(dataSource == null) {
					BasicDataSource bs = new BasicDataSource();
					bs.setUrl("jdbc:mysql://localhost:3306/db?serverTimezone=UTC");
					bs.setUsername("root");
					bs.setPassword("M442333244m");
					bs.setMinIdle(5);
					bs.setMaxIdle(10);
					bs.setMaxOpenPreparedStatements(100);
					dataSource = bs;
					
				}
				
			}
		return dataSource;
	}
		
	public static void main (String[] args) throws SQLException {
		try (BasicDataSource dSource = DataSourceTest.getDataSource(); //try with resources, you do not need to close it
			Connection con = dSource.getConnection();
			PreparedStatement pst = con.prepareStatement ("select * from emp");){
			try (ResultSet rs = pst.executeQuery();){
				while(rs.next()) {
					System.out.println("Emp No: "+rs.getInt(1));
					System.out.println("Emp Name: "+rs.getString(2));
					System.out.println("Emp Sal: "+rs.getInt(3));
					
				}
			} catch (Exception e) {System.out.println(e);}
		}
	}
}

