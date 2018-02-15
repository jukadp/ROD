package com.utp.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SpreadsheetParser {

	public void parseFile() {
		String path = "C:\\Users\\Adam Przedlacki\\Desktop\\project\\e.xls";
		File file = new File(path);
		
		Connection connect = null;
		Statement s = null;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			
			try {
				Class.forName("com.postgresql.jdbc.Driver");
				connect =  DriverManager.getConnection("jdbc:postgresql://johnny.heliohost.org:5432/hostdb_allotments" +
						"?user=hostdb_administrator&password=administrator");
				
				s = connect.createStatement();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			while ((line = br.readLine()) != null) {
				
	             try {
	            	String[] arr = line.split(",");
	 				String sql = "INSERT INTO dzialki " +
							"(Nr_dzialki, Powierzchnia, Nr_dzialkowicza) " + 
							"VALUES ('" + arr[0] + "','" + arr[1] + "','" + arr[2] + "') ";
					s.execute(sql);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	             System.out.println("Import success!");
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}