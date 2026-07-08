package com.shubham.dlp.distributed_log_processor.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

import com.shubham.dlp.distributed_log_processor.database.LogDAO;
import com.shubham.dlp.distributed_log_processor.model.Log;
import com.shubham.dlp.distributed_log_processor.processor.LogParser;
import com.shubham.dlp.distributed_log_processor.processor.LogValidator;

public class ClientHandler extends Thread {
	
	private Socket socket;
	
	
	public ClientHandler(Socket socket) {
		
		this.socket = socket;
		
	}
	

	public void run() {
		
		System.out.println(
			    "Handling Client : "
			    + socket.getInetAddress().getHostAddress()
			    + " | Thread : "
			    + Thread.currentThread().getName()
			);	
	    
	    try {
	    	
	    		BufferedReader reader= new BufferedReader( new InputStreamReader(socket.getInputStream()));
	    	
	    		String receivedLog;
	    		
	    		while ((receivedLog = reader.readLine()) != null) {


		    		System.out.println("Received Log : " + receivedLog);
		    		
		    		 LogParser parser = new LogParser();
	
		    	     Log log = parser.parse(receivedLog);
	
		    	     System.out.println(log);
	    	     
	    	     		LogValidator validator = new LogValidator();    
		    	     
		    	     LogDAO dao = new LogDAO();

		    	     if (validator.validate(log)) {

		    	         System.out.println("Log Validation : SUCCESS");

		    	         boolean saved = dao.saveLog(log);

		    	         if(saved) {

		    	             System.out.println("Log Stored Successfully.");

		    	         } else {

		    	             System.out.println("Failed To Store Log.");

		    	         }

		    	     } else {

		    	         System.out.println("Log Validation : FAILED");

		    	     }
	    		}
		    	     
		    	reader.close();
		    	socket.close();
		    	     
		    	        	
	    }catch(Exception e){
	    	
	    	
	    	System.out.println("Client Disconnected : "
	                + socket.getInetAddress().getHostAddress());
	    }
	}
	
}
