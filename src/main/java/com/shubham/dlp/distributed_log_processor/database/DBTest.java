package com.shubham.dlp.distributed_log_processor.database;

import java.sql.Connection;

public class DBTest {

    public static void main(String[] args) {

        Connection connection = DBConnection.getConnection();

        if(connection != null) {

            System.out.println("Database Connected Successfully.");

        } else {

            System.out.println("Connection Failed.");
        }

    }

}