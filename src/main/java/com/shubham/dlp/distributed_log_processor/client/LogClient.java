package com.shubham.dlp.distributed_log_processor.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import com.shubham.dlp.distributed_log_processor.generator.LogGenerator;
import java.util.Scanner;

public class LogClient {
	
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the Client Name : ");
		
		String clientName = sc.nextLine();
		
		LogGenerator generator = new LogGenerator(clientName);
		
		
		System.out.println("Starting Client....");
		
		try {
			
				Socket socket = new Socket("localhost",5000);
				
				System.out.println("Connected to Server Successfully ! ");
				
				PrintWriter writer = new PrintWriter(socket.getOutputStream(),true);
				
				while(true) {
				
					String log = generator.generateLog();
	
					writer.println(log);
	
					System.out.println("Sent : " + log);
					
					try {
						
						Thread.sleep(2000);
						
					} catch (InterruptedException e) {
						
						System.out.println(e.getMessage());
					}
					
				}
				
		}catch(IOException ex) {
			
			System.out.println("ERROR message "+ex.getMessage());
			
		}
		
		
		
	}

}
