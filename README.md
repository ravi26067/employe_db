
# Spring Boot application

Spring boot project with postgres db integration

## 1.Steps to install and configure postgres on windows

1. First of all you need to install the postgres in your windows setup. Click on the link below to download and install:
https://www.postgresql.org/download/windows/
2. Download the latest version from this link and click on install with the default settings.
3. Go to start -> psql (search it)  and open psql command line.
4.  Login into it and create the database employee. Command is:
	CREATE DATABASE dbname;
5. Create the employees table using command:
	CREATE TABLE employees(  
   ID INT PRIMARY KEY     NOT NULL,  
   NAME           TEXT    NOT NULL,  
   AGE            INT     NOT NULL,  
   ADDRESS        CHAR(50),  
   SALARY         REAL  
); 
6. Insert the data into db or you can directly download this project and add data through postman.
