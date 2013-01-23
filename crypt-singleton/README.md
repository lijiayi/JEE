JEE6 singleton project
======================

This example demonstrates how to use a singleton EJB to initialize the server side
application logic. It implements a simple symetric encryption service.

Key features:

- Singleton bean to initialize server side application logic
- Stateless session bean with remote interface accessible by the client
- Java client using the SLSB

The project consists of the following artifacts:

- crypt-interface: Interface packaged
- crypt-module: EJB Module containing the singleton and SLSB
- crypt-ear: EAR packing of crypt-module with crypt-interface
- crypt-client: Client

Running
=======

1) `mvn package`

2) Deploy `crypt-ear/target/crypt.ear` in AS

3) Run the CDI based client

    $GLASSFISH_HOME/bin/appclient \
        -cp crypt-client/target/crypt-client.jar:crypt-interface/target/crypt-interface.jar \
        de.spqrinfo.jee6.cryptsingleton.client.MainCDI

Windows note
============

On Windows use %GLASSFISH_HOME% or replace it with your installation
path of the Glassfish server. Replace `/` with `\` and `:` with `;`.

EOF
