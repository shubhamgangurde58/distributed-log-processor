package com.shubham.dlp.distributed_log_processor.dashboard;

import java.util.List;
import java.util.Scanner;

import com.shubham.dlp.distributed_log_processor.database.LogDAO;
import com.shubham.dlp.distributed_log_processor.model.Log;
import com.shubham.dlp.distributed_log_processor.model.LogLevel;
import com.shubham.dlp.distributed_log_processor.processor.LogStatistics;
import com.shubham.dlp.distributed_log_processor.server.ClientHandler;

public class Dashboard {

	
	 public static void main(String[] args) {

	        Scanner scanner = new Scanner(System.in);

	        while (true) {
	        	

	            System.out.println("\n====================================");
	            
	            System.out.println(" Distributed Log Processor ");
	            
	            System.out.println("====================================");
	            
	            System.out.println("1. View All Logs");
	            
	            System.out.println("2. Search Logs By Level");
	            
	            System.out.println("3. Search Logs By Client");
	            
	            System.out.println("4. View Statistics");
	            
	            System.out.println("5. Export Logs To CSV");
	            
	            System.out.println("6. Exit");
	            
	            System.out.println("====================================");

	            
	            System.out.print("Enter Your Choice : ");
	            

	            int choice = scanner.nextInt();
	            

	            switch (choice) {

	                case 1:
	                	
	                	 LogDAO dao = new LogDAO();

	                	    List<Log> logs = dao.getAllLogs();

	                	    System.out.println("\n========== ALL LOGS ==========");

	                	    for (Log log : logs) {

	                	        System.out.println(log);

	                	    }
	                    
	                    break;

	                case 2:
	                	
	                	  System.out.print("Enter Log Level (INFO, ERROR, WARNING, DEBUG): ");

	                	    String inputLevel = scanner.next();

	                	    try {

	                	        LogLevel level = LogLevel.valueOf(inputLevel.toUpperCase());

	                	        LogDAO dao2 = new LogDAO();

	                	        List<Log> logsByLevel = dao2.getLogsByLevel(level);

	                	        System.out.println("\n========== " + level + " LOGS ==========");

	                	        if (logsByLevel.isEmpty()) {

	                	            System.out.println("No Logs Found.");

	                	        } else {

	                	            for (Log log : logsByLevel) {

	                	                System.out.println(log);

	                	            }

	                	        }

	                	    } catch (IllegalArgumentException e) {

	                	        System.out.println("Invalid Log Level.");

	                	    }

	                	    break;

	                case 3:
	                	
	                	  System.out.print("Enter Client Name (Example: Client-1): ");

	                	    String clientName = scanner.next();

	                	    LogDAO dao3 = new LogDAO();

	                	    List<Log> clientLogs = dao3.getLogsByClient(clientName);

	                	    System.out.println("\n========== " + clientName + " LOGS ==========");

	                	    if (clientLogs.isEmpty()) {

	                	        System.out.println("No Logs Found.");

	                	    } else {

	                	        for (Log log : clientLogs) {

	                	            System.out.println(log);

	                	        }

	                	    }
	                    
	                    break;
	                   
	                case 4:
	                		

	                		LogDAO dao4 = new LogDAO();
	                		
	                	    System.out.println("\n========== LOG STATISTICS ==========");

	                	    System.out.println("Total Logs : " + dao4.getTotalLogs());
	                	    
	                	    System.out.println("INFO       : " + dao4.getLogCountByLevel("INFO"));

	                	    System.out.println("ERROR      : " + dao4.getLogCountByLevel("ERROR"));

	                	    System.out.println("WARNING    : " + dao4.getLogCountByLevel("WARNING"));

	                	    System.out.println("DEBUG      : " + dao4.getLogCountByLevel("DEBUG"));

	                	    
	                	break;

	                case 5:
	                	
	                	
	                	
	                	break;
	                	
	                case 6:
	                	
	                    System.out.println("Thank You...");
	                    
	                    scanner.close();
	                    
	                    System.exit(0);

	                default:
	                	
	                    System.out.println("Invalid Choice");

	            }

	        }

	    }

	
}
