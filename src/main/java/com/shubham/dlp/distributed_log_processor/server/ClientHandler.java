package com.shubham.dlp.distributed_log_processor.server;

import java.net.Socket;

public class ClientHandler extends Thread {
	
	private Socket socket;
	
	
	public ClientHandler(Socket socket) {
		
		this.socket = socket;
		
	}
	

	public void run() {
		
	    System.out.println(
                "Handling Client : "
                        + socket.getInetAddress().getHostAddress());	
	}
	
}
