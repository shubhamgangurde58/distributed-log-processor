package com.shubham.dlp.distributed_log_processor.export;

import java.io.FileWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.shubham.dlp.distributed_log_processor.database.DBConnection;

public class CSVExporter {
	

    public void exportLogs() {
    	

        try {

	            Connection connection = DBConnection.getConnection();
	            
	
	            String sql = "SELECT * FROM logs";
	            
	
	            PreparedStatement ps = connection.prepareStatement(sql);
	            
	
	            ResultSet rs = ps.executeQuery();
	
	            
	            FileWriter writer = new FileWriter("logs.csv");
	            
	
	            writer.append("ID,Timestamp,Client,Level,Message\n");
	            
	
	            while (rs.next()) {
	            	
	
	                writer.append(String.valueOf(rs.getInt("id")));
	                
	                writer.append(",");
	                
	
	                writer.append(rs.getString("timestamp"));
	                
	                writer.append(",");
	                
	
	                writer.append(rs.getString("client_name"));
	                
	                writer.append(",");
	                
	
	                writer.append(rs.getString("log_level"));
	                
	                writer.append(",");
	                
	
	                writer.append(rs.getString("message"));
	                
	                writer.append("\n");
	                
	
	            }

            writer.flush();
            
            writer.close();
            

            rs.close();
            
            ps.close();
            
            connection.close();

            System.out.println("\nLogs Exported Successfully.");
            
            System.out.println("File Name : logs.csv");
            

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }

    }

}