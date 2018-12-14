# Credit Card Management System

The Credit_Card_Management_System is a Java based program that can display a list of credit card transactions and modify a customer's personal information from a MySQL database via a JDBC Driver. This respository not only includes the source code for the credit card management system, it also includes other files that are useful for creating a data pipeline to the Hadoop file system (Hortonworks Sandbox).

### Table of Contents

1)  ___Credit_Card_Management_System___
    *  bin
    *  src
    *  mysql-connector-java-5.1.45
    *  CDW_SAPP(updated).sql.zip
    *  Change_Authentication.sql
2) ___Data Extraction and Transportation using Sqoop___
    * sqoop.txt   
3) ___Data Loading with Hive___
    * hive.txt
4) ___Automating the process with Oozie___
    * job.properties
    * oozie_workflow
    * sqoop_jobs
    * java-json.jar
5) ___Optimizing the process___
    * optimized_job.properties
    * oozie_workflow_optimized
    * sqoop_jobs(optimized)
    * java-json.jar
6) ___Visualization of Dataset___
    * Data_Visualization.txt
    * Top_20_zips_by_total_transactions.png
    * Total_transaction_value_for_each_transaction_by_quarter_2018.png
7) ___Requirements___
    * casestudy Flow(1.2).pdf
    * Mapping Document.xlsx
    * Credit Card Management System_SRD.pdf
    * deliverable.xlsx
    * Functional Requirements.pdf

For instructions on how to use the contents of each folder (except Credit_Card_Management_System), simply click on the link of these folders and read the README.md file.

To use the Credit_Card_Management_System:
1) Download the Credit_Card_Management_System folder
2) Unzip the CDW_SAPP(updated).sql.zip folder and open it using MySQL Workbench under the root user. Run the file so that you will have the CDW_SAPP database.
3) Open the Credit_Card_Management_System via Eclipse, then run the code.

__Note__: Make sure eclipse references the mysql driver file as it is connect to the mysql database. Moreover, when running the java code, the program will ask for a user name and password when accessing the transaction module or the customer module. In that case, the user name is root and the password is whatever password you used for root user. If it doesn't, then you can change the type of password for root user to mysql native password (See Change_Authentication.sql in the Credit_Card_Management_System folder).

___For other projects, feel free to take a look at my personal Github https://github.com/xnell90___
