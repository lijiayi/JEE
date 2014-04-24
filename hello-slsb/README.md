JEE hello SLSB project
======================

Key features:

- Stateless session bean with remote interface
- Java client using the SLSB

The project consists of the following artifacts:

- hello-interface: Hello Interface packaged
- hello-module: EJB Module containing Hello SLSB
- hello-ear: EAR packing of hello-module with hello-interface
- hello-client: Client

Running
=======

1. `mvn package`

2. Run the server part `hello-ear/target/hello.ear`:
```shell
cd hello-ear
mvn embedded-glassfish:run
```

3. Run the CDI based client
```shell
$GLASSFISH_HOME/bin/appclient \
    -cp hello-client/target/hello-client.jar:hello-interface/target/hello-interface.jar \
    de.spqrinfo.jee.hello.client.MainCDI
```

Output displayed
```
Calling remote EJB hello
Result: Hello, World!
```

4. Run the JNDI based client:
```shell
$GLASSFISH_HOME/bin/appclient \
    -cp hello-client/target/hello-client.jar:hello-interface/target/hello-interface.jar \
    de.spqrinfo.jee.hello.client.MainJNDI
```

Output displayed
```
Creating InitialContext
JNDI lookup for 'java:global/hello/hello-module/HelloBean'
Calling remote EJB hello
Result: Hello, World!
```

Windows note
============

On Windows use %GLASSFISH_HOME% or replace it with your installation
path of the Glassfish server. Replace `/` with `\` and `:` with `;`.

EOF
