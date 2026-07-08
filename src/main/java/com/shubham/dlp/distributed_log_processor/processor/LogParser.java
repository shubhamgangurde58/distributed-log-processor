package com.shubham.dlp.distributed_log_processor.processor;

import java.time.LocalDateTime;

import com.shubham.dlp.distributed_log_processor.model.Log;
import com.shubham.dlp.distributed_log_processor.model.LogLevel;

public class LogParser {

	    public Log parse(String rawLog) {

	        String[] parts = rawLog.split("\\|");

	        Log log = new Log();

	        log.setTimestamp(LocalDateTime.parse(parts[0]));
	        log.setClientName(parts[1]);
	        log.setLogLevel(LogLevel.valueOf(parts[2]));
	        log.setMessage(parts[3]);

	        return log;
	    }
}
