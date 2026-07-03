package com.shubham.dlp.distributed_log_processor.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class LogServer {
	
	public static void main(String args[]) {
	
		 System.out.println("=================================");
	     System.out.println(" Distributed Log Processor ");
	     System.out.println(" Server Starting...");
	     System.out.println("=================================");
     
	     try {
	    		 
		    	 	ServerSocket  serversocket = new ServerSocket(5000);
		    	 	
		    	 	System.out.println("Server Started on port 5000 ! ");
		    	 
		    	 	
		     while(true) {
		    	 
		    	 	System.out.println("Waiting for Client Connection..");	
		    	 	
		    	 	Socket socket = serversocket.accept();
		    	 	
		    	 	System.out.println("Client Connected : "
		    	            + socket.getInetAddress().getHostAddress());	
		    	 	
		    	 	ClientHandler clienthandler = new ClientHandler(socket);
		    	 	clienthandler.start();
		    	 	
	    	 }
		     
	     } catch (IOException e) {
			
			e.printStackTrace();
	     }
	    
	}

}
