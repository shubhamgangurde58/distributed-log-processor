package com.shubham.dlp.distributed_log_processor.processor;

import com.shubham.dlp.distributed_log_processor.model.Log;

public class LogValidator {

		public boolean validate(Log log) {
			
			if(log == null) {
				
				return false;
			}
			
			if(log.getMessage() == null || log.getMessage().trim().isEmpty()) {
				
				return false;
			}
			
			if(log.getLogLevel() == null) {
				
				return false;
			}
			
			if(log.getTimestamp() == null){
				
				return false;
			}
			
				return true;	
		}
	
}
