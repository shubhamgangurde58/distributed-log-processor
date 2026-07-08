package com.shubham.dlp.distributed_log_processor.processor;

import java.time.LocalDateTime;

import com.shubham.dlp.distributed_log_processor.model.Log;
import com.shubham.dlp.distributed_log_processor.model.LogLevel;

public class LogParser {

	    public Log parse(String rawLog) {

	        String[] parts = rawLog.split("\\|");

	        Log log = new Log();

	        log.setTimestamp(LocalDateTime.parse(parts[0]));
	        log.setLogLevel(LogLevel.valueOf(parts[1]));
	        log.setMessage(parts[2]);

	        return log;
	    }
}
