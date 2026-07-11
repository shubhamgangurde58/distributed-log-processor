package com.shubham.dlp.distributed_log_processor.processor;

import com.shubham.dlp.distributed_log_processor.model.Log;
import com.shubham.dlp.distributed_log_processor.model.LogLevel;

public class LogStatistics {
	

    private int totalLogs;

    private int infoCount;

    private int errorCount;

    private int warningCount;

    private int debugCount;
    
    public synchronized void printStatistics() {

        System.out.println("\n====================================");
        
        System.out.println("        LOG STATISTICS");
        
        System.out.println("====================================");

        System.out.println("Total Logs : " + totalLogs);
        
        System.out.println("INFO       : " + infoCount);
        
        System.out.println("ERROR      : " + errorCount);
        
        System.out.println("WARNING    : " + warningCount);
        
        System.out.println("DEBUG      : " + debugCount);

        System.out.println("====================================\n");

    }
    
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
