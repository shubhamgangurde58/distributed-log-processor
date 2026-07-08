package com.shubham.dlp.distributed_log_processor.model;

import java.time.LocalDateTime;

public class Log {
	
	private long id;
	private LocalDateTime timestamp;
	private String clientName;
	private LogLevel logLevel;
	private String message;
	
	
	public Log() {
		
	}
	
	public Log(long id , LocalDateTime timestamp ,  String clientName,  LogLevel logLevel , String message) {
		
		this.id = id;
		this.timestamp = timestamp;
		this.clientName = clientName;
		this.logLevel = logLevel;
		this.message = message;
		
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		
		this.id = id ;
	}
	
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getClientName() {
	    return clientName;
	}

	public void setClientName(String clientName) {
	    this.clientName = clientName;
	}
	
	public LogLevel getLogLevel() {
		return logLevel;
	}

	public void setLogLevel(LogLevel logLevel) {
		this.logLevel = logLevel;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Log [id=" + id + ", timestamp=" + timestamp + ", clientName=" + clientName + ", logLevel=" + logLevel
				+ ", message=" + message + "]";
	}
	
	

}
