JEE6 JDBC Bean Managed Transactions Project
===========================================

Key features:

- Stateless session bean using bean managed transaction performing JDBC operations
- CDI bean acting as backing bean
- JSF 2.0 view

The project consists of the following artifacts:

- jdbc.war: EJBs plus web frontend

Running
=======

1. Install MySQL

2. Login to MySQL and set a root password (this is really required):
```shell
mysql -u root -p
```

```sql
mysql> use mysql;
user> update user set password=PASSWORD("NEWPASSWORD") where User='root';
```

3. Create database `jee` and create the table `message`:
```sql
CREATE TABLE message (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  msg varchar(256) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB;
```

4. Package project via `mvn package`

5. Downloads Mysql <a href="https://dev.mysql.com/downloads/connector/j/">Connector/J</a>

6. Copy Connector/J Jar file into glassfish lib dir (e.g. `mysql-connector-java-5.1.30-bin` -> `$GLASSFISH_HOME/glassfish4/lib`).

7. Start the Glassfish application server
```shell
$GLASSFISH_HOME/bin/asadmin start-domain
```

8. Navigate to the Glassfish server admin console via [http://localhost:4848/](http://localhost:4848/)

9. Open the JDBC/JDBC Connection Pools node and create a new Connection Pool named `MySqlPool`.
    1. For Resource type enter `javax.sql.DataSource`
    2. For the Database Driver Vendor select `MySql`
    3. Click Next
    4. Scroll to the bottom of the page and ensure the following properties are set as follows:
        * User: `root`
        * ServerName: `localhost`
        * DatabaseName: `jee`
        * Password: `NEWPASSWORD`
    5. Click Save
10. Again open the new Connection Pool `MySqlPool`, click advanced properties and delete the `url` property.

11. Open the JDBC/JDBC Resources node and create a new Resource named `jdbc/jee` and select the new Connection Pool `MySqlPool`.

12. Deploy the application `target/jdbc-bean-tx.war`.

13. Navigate to [http://localhost:8080/jdbc-bean-tx/](http://localhost:8080/jdbc-bean-tx/)


EOF
