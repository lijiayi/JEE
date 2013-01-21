JEE6 calc SFSB project
======================

Key features:

- Statefull session bean with remote interface implementing a trivial calculator
- Java client using the SLSB

The project consists of the following artifacts:

- calc-interface: Calc interface packaged
- calc-module: EJB Module containing Calc SFSB
- calc-ear: EAR packing of calc-module with calc-interface
- calc-client: Client

Running
=======

1) `mvn package`

2) Deploy `calc-ear/target/calc.ear`

3) Run the CDI based client

    $GLASSFISH_HOME/bin/appclient \
        -cp calc-client/target/calc-client.jar:calc-interface/target/calc-interface.jar \
        de.spqrinfo.jee6.calc.client.MainCDI

    # Resulting output
    USAGE:
    put n - stored n into the memory
    get   - retrieves stored value from memory
    add n - adds value n to value from memory and stores it
    rem   - calls @Remove method on SFSB
    q     - quits the client


4) Run the JNDI based client:

    $GLASSFISH_HOME/bin/appclient \
        -cp calc-client/target/calc-client.jar:calc-interface/target/calc-interface.jar \
        de.spqrinfo.jee6.calc.client.MainJNDI

    # Resulting output
    Creating InitialContext
    JNDI lookup for 'java:global/calc/calc-module/CalcBean'
    ...

Windows note
============

On Windows use %GLASSFISH_HOME% or replace it with your installation
path of the Glassfish server. Replace `/` with `\` and `:` with `;`.

EOF
