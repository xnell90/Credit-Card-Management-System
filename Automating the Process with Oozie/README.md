### Prerequisite Instructions ###

1)
    a) __(Creating sqoop jobs with metastore)__ Open two terminals (IP:4200). On one terminal type sqoop-metastore and let it run. On the other terminal copy each sqoop command from the sqoop_jobs(meta-store).txt file and run them [This step is important since all the code uses sqoop jobs in metastore].
    
    b) __(Creating sqoop jobs without metastore)__ Open one terminal (IP:4200) and ach sqoop command from the sqoop_jobs.txt file and run them.

___Remark___: Each sqoop command is seperated by an astericks line (\*\*\*...\*\*\*) for both files.
Also, both files are in the sqoop_jobs folder

2) Upload the java-json.jar file to the hadoop file system. *(/user/oozie/share/lib/lib_20161025075203/sqoop/)*.
3) Create the Credit_Card_System folder in the hadoop file system (*/user/maria_dev/*) that contains four folders: CDW_SAPP_CUSTOMER, CDW_SAPP_BRANCH,CDW_SAPP_TIME, and CDW_SAPP_CREDITCARD.

### Instructions on How to run Oozie Workflow with coordinator ###

1) Upload oozie_workflow_optimized folder into hdfs (/user/maria_dev).
2) Upload optimized_job.properties into the local file system (/home/maria_dev).
3) Run the following command: *oozie job -oozie http://localhost:11000/oozie -config /home/maria_dev/job.properties -run*.

__Note__: To kill the command simply type *oozie job  -oozie http://localhost:11000/oozie  -kill (job_name)* [see the job name after you run the oozie command at 2)]
