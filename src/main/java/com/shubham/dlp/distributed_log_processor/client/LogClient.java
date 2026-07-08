package com.shubham.dlp.distributed_log_processor.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class LogClient {
	
	
	public static void main(String args[]) {
		
		
		System.out.println("Starting Client....");
		
		try {
			
				Socket socket = new Socket("localhost",5000);
				
				System.out.println("Connected to Server Successfully ! ");
				
				PrintWriter writer = new PrintWriter(socket.getOutputStream(),true);
				
				writer.println("2026-07-03T18:30:45|INFO|Application Started");

				System.out.println("Log Sent Successfully.");
				
				writer.close();
				socket.close();
				
		}catch(IOException ex) {
			
			System.out.println("ERROR message "+ex.getMessage());
			
		}
		
		
		
	}

}
