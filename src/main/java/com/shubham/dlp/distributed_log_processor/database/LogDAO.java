package com.shubham.dlp.distributed_log_processor.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.shubham.dlp.distributed_log_processor.model.Log;

public class LogDAO {

		
	public boolean saveLog(Log log) {

        String sql = "INSERT INTO logs(timestamp, log_level, message) VALUES (?, ?, ?)";

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setTimestamp(1, java.sql.Timestamp.valueOf(log.getTimestamp()));

            statement.setString(2, log.getLogLevel().name());

            statement.setString(3, log.getMessage());

            int rows = statement.executeUpdate();

            statement.close();
            connection.close();

            return rows > 0;

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return false;
    }
	
	
}
