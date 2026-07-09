package com.shubham.dlp.distributed_log_processor.processor;

import com.shubham.dlp.distributed_log_processor.model.Log;
import com.shubham.dlp.distributed_log_processor.model.LogLevel;

public class LogStatistics {
	

    private int totalLogs;

    private int infoCount;

    private int errorCount;

    private int warningCount;

    private int debugCount;
    
    public synchronized void updateStatistics(Log log) {

        totalLogs++;

        if (log.getLogLevel() == LogLevel.INFO) {

            infoCount++;

        } else if (log.getLogLevel() == LogLevel.ERROR) {

            errorCount++;

        } else if (log.getLogLevel() == LogLevel.WARNING) {

            warningCount++;

        } else if (log.getLogLevel() == LogLevel.DEBUG) {

            debugCount++;

        }

    }

}
