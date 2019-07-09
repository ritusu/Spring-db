package com.lti.component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Component;

@Component("carPartsImpl1")
public class CarPartsInventoryImpl1 implements CarPartsInventory{

	public void addNewPart(CarPart carPart) {
		
		Connection conn=null;
		PreparedStatement stmt=null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//Establish connection with the Database
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
			
			String sql="insert into TBL_CARPARTS values(?,?,?,?)";
			stmt=conn.prepareStatement(sql);
			
			stmt.setInt(1,carPart.getPartNo());
			stmt.setString(2,carPart.getPartName());
			stmt.setString(3,carPart.getCarModel());
			stmt.setInt(4,carPart.getQuantity());
			stmt.executeUpdate();
		
		}	catch (ClassNotFoundException e) {
			System.out.println("JDBC driver not found");
			//throw new DataAccessException("Unable to load the JDBC");
			
		}
		catch(SQLException e) {
				
				e.printStackTrace();
			//throw new DataAccessException("Problem while fetching Products from DataBase",e);
		}
		finally {
			try { conn.close(); } catch(Exception e) {  }
		
			}
  }
		
		
		
	

	public List<CarPart> getAvailableParts() {

		return null;
	}
	
	

}
