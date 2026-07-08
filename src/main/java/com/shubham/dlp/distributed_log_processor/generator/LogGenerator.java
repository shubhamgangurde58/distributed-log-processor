package com.shubham.dlp.distributed_log_processor.generator;

import java.time.LocalDateTime;

import java.util.Random;

import com.shubham.dlp.distributed_log_processor.model.LogLevel;


public class LogGenerator {
	
		private static final String[] MESSAGES = {

	            "Application Started",
	            "User Login Successful",
	            "Database Connection Failed",
	            "Memory Usage High",
	            "File Uploaded",
	            "Payment Successful",
	            "Network Timeout",
	            "Server Restarted"

	    };
	

		 private Random random = new Random();
		 
		 public String generateLog() {

		        String timestamp = LocalDateTime.now().toString();
		        

		        LogLevel[] levels = LogLevel.values();
		        

		        LogLevel level = levels[random.nextInt(levels.length)];
		        

		        String message = MESSAGES[random.nextInt(MESSAGES.length)];
		        

		        return timestamp + "|" + level + "|" + message;

		    }
		
}
