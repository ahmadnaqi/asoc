package com.test.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String databaseURL = "jdbc:oracle:thin:@localhost:1521:XE";
        String user = "fareuser";
        String password = "aspire123";
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(databaseURL, user, password);
            if (conn != null) {
                System.out.println("Connected to the database");
            }
            
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM fare");
            System.out.println("id  name    job");
            
            while (rs.next()) {
               int id = rs.getInt("id");
               String name = rs.getString("fare");
               String job = rs.getString("flight_date");
               String jobs = rs.getString("flight_number");
               System.out.println(id+"   "+name+"    "+job+"  "+jobs);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Could not find database driver class");
            ex.printStackTrace();
        } catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
	}

}
