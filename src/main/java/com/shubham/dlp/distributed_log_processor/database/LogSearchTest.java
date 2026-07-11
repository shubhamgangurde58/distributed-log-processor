package com.shubham.dlp.distributed_log_processor.database;

import java.util.List;

import com.shubham.dlp.distributed_log_processor.model.Log;
import com.shubham.dlp.distributed_log_processor.model.LogLevel;

public class LogSearchTest {
	
	 public static void main(String[] args) {

	        LogDAO dao = new LogDAO();

	        List<Log> logs = dao.getLogsByLevel(LogLevel.ERROR);

	        System.out.println("===== ERROR LOGS =====");

	        for (Log log : logs) {

	            System.out.println(log);

	        }

	    }

}
