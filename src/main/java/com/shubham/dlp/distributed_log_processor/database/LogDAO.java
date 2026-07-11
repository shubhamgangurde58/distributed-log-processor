package com.shubham.dlp.distributed_log_processor.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shubham.dlp.distributed_log_processor.model.Log;
import com.shubham.dlp.distributed_log_processor.model.LogLevel;

public class LogDAO {
	
	public void showStatistics() {}
	
	public int getLogCountByLevel(String level) {

	    int count = 0;

	    try {

	        Connection connection = DBConnection.getConnection();

	        String sql = "SELECT COUNT(*) FROM logs WHERE log_level = ?";

	        PreparedStatement ps = connection.prepareStatement(sql);

	        ps.setString(1, level);

	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {

	            count = rs.getInt(1);

	        }

	        rs.close();
	        ps.close();
	        connection.close();

	    } catch (Exception e) {

	        e.printStackTrace();

	    }

	    return count;
	}
	
	public int getTotalLogs() {

	    int total = 0;

	    try {

	        Connection connection = DBConnection.getConnection();

	        String sql = "SELECT COUNT(*) FROM logs";

	        PreparedStatement ps = connection.prepareStatement(sql);

	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {

	            total = rs.getInt(1);

	        }

	        rs.close();
	        ps.close();
	        connection.close();

	    } catch (Exception e) {

	        e.printStackTrace();

	    }

	    return total;
	}

		
	public boolean saveLog(Log log) {

        String sql = "INSERT INTO logs(timestamp, client_name, log_level, message) VALUES (?, ?, ?, ?)";

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setTimestamp(1, java.sql.Timestamp.valueOf(log.getTimestamp()));
            
            statement.setString(2, log.getClientName());

            statement.setString(3, log.getLogLevel().name());

            statement.setString(4, log.getMessage());

            int rows = statement.executeUpdate();

            statement.close();
            connection.close();

            return rows > 0;

        } catch (SQLException e) {

           System.out.println(e.getMessage());
        }

        return false;
    }
	
	
	public List<Log> getAllLogs() {

	    List<Log> logs = new ArrayList<>();

	    String sql = "SELECT * FROM logs";

	    try {

	        Connection connection = DBConnection.getConnection();

	        PreparedStatement statement = connection.prepareStatement(sql);

	        ResultSet resultSet = statement.executeQuery();

	        while (resultSet.next()) {

	            Log log = new Log();

	            log.setId(resultSet.getLong("id"));

	            log.setTimestamp(resultSet.getTimestamp("timestamp").toLocalDateTime());

	            log.setClientName(resultSet.getString("client_name"));

	            log.setLogLevel(LogLevel.valueOf(resultSet.getString("log_level")));

	            log.setMessage(resultSet.getString("message"));

	            logs.add(log);
	        }

	        resultSet.close();
	        statement.close();
	        connection.close();

	    } catch (Exception e) {

	        System.out.println(e.getMessage());
	    }

	    return logs;
	}
	
	
	public List<Log> getLogsByLevel(LogLevel level) {

	    List<Log> logs = new ArrayList<>();

	    String sql = "SELECT * FROM logs WHERE log_level = ?";

	    try {

	        Connection connection = DBConnection.getConnection();

	        PreparedStatement statement = connection.prepareStatement(sql);

	        statement.setString(1, level.name());

	        ResultSet resultSet = statement.executeQuery();

	        while (resultSet.next()) {

	            Log log = new Log();

	            log.setId(resultSet.getLong("id"));
	            log.setTimestamp(resultSet.getTimestamp("timestamp").toLocalDateTime());
	            log.setClientName(resultSet.getString("client_name"));
	            log.setLogLevel(LogLevel.valueOf(resultSet.getString("log_level")));
	            log.setMessage(resultSet.getString("message"));

	            logs.add(log);

	        }

	        resultSet.close();
	        statement.close();
	        connection.close();

	    } catch (Exception e) {

	        System.out.println(e.getMessage());

	    }

	    return logs;
	}
	
	
	public List<Log> getLogsByClient(String clientName) {

	    List<Log> logs = new ArrayList<>();

	    String sql = "SELECT * FROM logs WHERE client_name = ?";

	    try {

	        Connection connection = DBConnection.getConnection();

	        PreparedStatement statement = connection.prepareStatement(sql);

	        statement.setString(1, clientName);

	        ResultSet resultSet = statement.executeQuery();

	        while (resultSet.next()) {

	            Log log = new Log();

	            log.setId(resultSet.getLong("id"));
	            
	            log.setTimestamp(resultSet.getTimestamp("timestamp").toLocalDateTime());
	            
	            log.setClientName(resultSet.getString("client_name"));
	            
	            log.setLogLevel(LogLevel.valueOf(resultSet.getString("log_level")));
	            
	            log.setMessage(resultSet.getString("message"));

	            logs.add(log);
	        }

	        resultSet.close();
	        
	        statement.close();
	        
	        connection.close();

	    } catch (Exception e) {

	        System.out.println(e.getMessage());
	    }

	    return logs;
	}
	
}
