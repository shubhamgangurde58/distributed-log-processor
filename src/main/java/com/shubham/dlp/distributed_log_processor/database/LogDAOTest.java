package com.shubham.dlp.distributed_log_processor.database;

import java.util.List;

import com.shubham.dlp.distributed_log_processor.model.Log;


public class LogDAOTest {
	

    public static void main(String[] args) {

        LogDAO dao = new LogDAO();

        List<Log> logs = dao.getAllLogs();

        for (Log log : logs) {

            System.out.println(log);

        }

    }

}
