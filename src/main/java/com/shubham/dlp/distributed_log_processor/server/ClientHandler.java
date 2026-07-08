package com.shubham.dlp.distributed_log_processor.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

import com.shubham.dlp.distributed_log_processor.model.Log;
import com.shubham.dlp.distributed_log_processor.processor.LogParser;

public class ClientHandler extends Thread {
	
	private Socket socket;
	
	
	public ClientHandler(Socket socket) {
		
		this.socket = socket;
		
	}
	

	public void run() {
		
	    System.out.println(
                "Handling Client : "
                        + socket.getInetAddress().getHostAddress());	
	    
	    try {
	    	
	    		BufferedReader reader= new BufferedReader( new InputStreamReader(socket.getInputStream()));
	    	
	    		String receivedLog  = reader.readLine();

	    		System.out.println("Received Log : " + receivedLog);
	    		
	    		 LogParser parser = new LogParser();

	    	     Log log = parser.parse(receivedLog);

	    	     System.out.println(log);
	    	
	    }catch(Exception e) {
	    	
	    	e.printStackTrace();
	    }
	}
	
}
