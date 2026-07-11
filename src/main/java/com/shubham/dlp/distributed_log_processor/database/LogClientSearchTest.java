package com.shubham.dlp.distributed_log_processor.database;

import java.util.List;

import com.shubham.dlp.distributed_log_processor.model.Log;

public class LogClientSearchTest {
	

    public static void main(String[] args) {

        LogDAO dao = new LogDAO();

        List<Log> logs = dao.getLogsByClient("Client-1");

        System.out.println("===== CLIENT-1 LOGS =====");

        for (Log log : logs) {

            System.out.println(log);

        }

    }

}
