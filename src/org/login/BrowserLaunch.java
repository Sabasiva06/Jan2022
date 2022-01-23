package org.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserLaunch {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "admin");
		
		String query = "Select * from Employees";
		
		PreparedStatement prepareStatement = connection.prepareStatement(query);
		
		ResultSet executeQuery = prepareStatement.executeQuery();
		
		while(executeQuery.next()) {
			String string = executeQuery.getString("first_name");
			System.out.println(string);
		}
		connection.close();
	}

}














