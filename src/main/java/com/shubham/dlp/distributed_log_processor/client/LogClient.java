package com.shubham.dlp.distributed_log_processor.client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class LogClient {
	
	
	public static void main(String args[]) {
		
		
		System.out.println("Starting Client....");
		
		try {
			
				Socket socket = new Socket("localhost",5000);
				
				System.out.println("Connected to Server Successfully ! ");
				
				
				
		}catch(IOException ex) {
			
			System.out.println("ERROR message "+ex.getMessage());
			
		}
		
		
		
	}

}
