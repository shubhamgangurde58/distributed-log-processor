package com.shubham.dlp.distributed_log_processor.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	

    private static final String URL =
            "jdbc:mysql://localhost:3306/distributed_log_processor";

    private static final String USERNAME = "root";

    private static final String PASSWORD = "root";

    public static Connection getConnection() {

        try {

            return DriverManager.getConnection(URL, USERNAME, PASSWORD);

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return null;
    }

}