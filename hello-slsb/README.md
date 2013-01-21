JEE6 hello SLSB project
=======================

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

1) `mvn package`

2) Deploy `hello-ear/target/hello.ear`

3) Run the CDI based client

    $GLASSFISH_HOME/bin/appclient \
        -cp hello-client/target/hello-client.jar:hello-interface/target/hello-interface.jar \
        de.spqrinfo.jee6.hello.client.MainCDI

    # Resulting output
    Calling remote EJB hello
    Result: Hello, World!

4) Run the JNDI based client:

    $GLASSFISH_HOME/bin/appclient \
        -cp hello-client/target/hello-client.jar:hello-interface/target/hello-interface.jar \
        de.spqrinfo.jee6.hello.client.MainJNDI

    # Resulting output
    Creating InitialContext
    JNDI lookup for 'java:global/hello/hello-module/HelloBean'
    Calling remote EJB hello
    Result: Hello, World!

Windows note
============

On Windows use %GLASSFISH_HOME% or replace it with your installation
path of the Glassfish server. Replace `/` with `\` and `:` with `;`.

EOF
