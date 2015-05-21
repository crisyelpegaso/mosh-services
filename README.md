==========================
		MOSH Server
==========================

********************
 Tech Requirements
********************
 
-MySQL server 5.0 or higher
-Apache Tomcat Server 7.0 or higher

********************
 DB creation
********************

1) Create DB manually in mysql server. By console mode:

```
mysql> CREATE DATABASE mosh;
```

2) Create a new connection in MySQL workbench, with schema name "mosh". 

NOTE: User and schema configuration in MySQL must match persistence.properties. 
Verify this file if you are having trouble creating the db.

3) PersistenceTest creates the tables when it's ran. THIS IS TERRIBLY AWFUL, NEEDS TO BE MODIFIED BY A BETTER MECHANISM 

Helpful links:
> Creating db in mysql server by console
https://dev.mysql.com/doc/refman/5.0/en/creating-database.html
> Creating new users in mysql server
https://dev.mysql.com/doc/refman/5.1/en/adding-users.html


********************
Import and building
********************

Import project as maven project.
Build it with "mvn clean install".
Inside "mosh-services/target/" there's the generated war. 
Deploying it in the tomcat server should work just fine.
Once deployed, in a browser go to "localhost:{tomcat.port}/mosh-services/" and it should displays API reference.