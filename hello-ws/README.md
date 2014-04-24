JEE hello webservice project
============================

Key features:
- JAX-WS webservice
- Webservice is implemented as stateless session bean
- Java client using the webservice

The project consists of the following artifacts:
- hello-ws: Hello webservice web project
- hello-ws-client: Hello webservice client project

Running
=======

1. Run the server part `hello-ws/target/hello-ws.war`:
```shell
mvn package
cd hello-ws
mvn embedded-glassfish:run
```

3. Run the client
```shell
cd $PROJECT_ROOT/hello-ws-client
mvn package
java -jar target/hello-ws-client.jar YourName
```

Output displayed
```
result Hello, YourName!
```

Client development notes
========================

The client build process (see `pom.xml`) contains the `jaxws-maven-plugin` which is bound to the lifecycle phase `generate-sources` which is automatically run during the `package` phase. The plugin processes the configured WSDLs in the `src/wsdl` directory to generate Java stubs for accessing the webservice. Internally it runs the `wsimport` utility. The configuration may contain optionally wildcards to process many WSDL files. The generated classes are put into the `target/generated-sources/jaxws-wsimport` directory.

The WSDL and XSD files must be added manually to the `src/wsdl` directory. These files are put into the Git repository but not the generated sources.

SOAP/WSDL Bindings
==================

Technical background: http://www.ibm.com/developerworks/webservices/library/ws-whichwsdl/

Windows note
============

On Windows replace `/` with `\` and `:` with `;`.


EOF
