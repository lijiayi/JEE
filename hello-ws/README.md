JEE6 hello webservice project
=============================

Key features:

- JAX-WS webservice
- Java client using the webservice

The project consists of the following artifacts:

- hello-ws: Hello webservice web project
- hello-ws-client: Hello webservice client project

Running
=======

1) `mvn package`

2) Deploy `hello-ws/target/hello-ws.war` in application server

3) Run the client

    java -jar hello-ws-client/target/hello-ws-client.jar YourName
    
    # Resulting output
    result Hello, YourName!

Client development notes
========================

The client build process (see `pom.xml`) contains the `jaxws-maven-plugin` which is bound to the lifecycle phase `generate-sources` which is automatically run during the `package` phase. The plugin processes the configured WSDLs in the `src/wsdl` directory to generate Java stubs for accessing the webservice. Internally it runs the `wsimport` utility. The configuration may contain optionally wildcards to process many WSDL files. The generated classes are put into the `target/generated-sources/jaxws-wsimport` directory.

The WSDL and XSD files must be added manually to the `src/wsdl` directory. These files are put into the Git repository but not the generated sources.

EOF
