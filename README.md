# Distributed Log Processor

A multi-threaded Java-based Distributed Log Processor that receives logs from multiple clients using Socket Programming, validates them, stores them in MySQL, provides searching and statistics through a Dashboard, and exports logs to CSV.


# Project Overview

Distributed Log Processor is a client-server application built using Core Java. Multiple clients generate logs simultaneously and send them to a server. The server processes each client using multithreading, validates logs, stores them in MySQL, and provides dashboard features such as searching, statistics, and CSV export.


# Features

- Multi-threaded Server
- Multiple Client Support
- Socket Programming
- Random Log Generation
- Log Validation
- Log Parsing
- MySQL Database Integration
- DAO Pattern
- Dashboard Menu
- View All Logs
- Search Logs by Level
- Search Logs by Client
- View Log Statistics
- Export Logs to CSV


# Tech Stack

- Java 17
- Maven
- Socket Programming
- Multithreading
- JDBC
- MySQL
- Eclipse IDE


# Project Structure

distributed-log-processor
│
├── client
├── server
├── model
├── processor
├── database
├── dashboard
├── export
└── generator


# How to Run

1. Start MySQL Server
2. Create the `distributed_log_processor` database
3. Run `Server.java`
4. Run multiple client instances
5. Run `Dashboard.java`
6. Explore logs and statistics


# Dashboard Features

- View All Logs
- Search Logs by Level
- Search Logs by Client
- View Statistics
- Export Logs to CSV


# CSV Export

Logs can be exported into a CSV file for reporting and analysis.


# Author

**Shubham Gangurde**

MCA Student

Java Backend Developer

GitHub:
https://github.com/shubhamgangurde58
