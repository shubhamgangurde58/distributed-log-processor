package com.shubham.dlp.distributed_log_processor.model;

import java.time.LocalDateTime;

public class Log {
	
	private long id;
	private LocalDateTime timestamp;
	private LogLevel logLevel;
	private String message;
	
	
	public Log() {
		
	}
	
	public Log(long id , LocalDateTime timestamp , LogLevel logLevel , String message) {
		
		this.id = id;
		this.timestamp = timestamp;
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

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	

	@Override
	public String toString() {
		return "Log [id=" + id + ", timestamp=" + timestamp + ", logLevel=" + logLevel + ", message=" + message + "]";
	}
	
	
	
	
	
}
