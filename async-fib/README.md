JEE6 joblog timer EJB project
=============================

Key features:

- Stateless session bean providing synchronous and asynchronous fibonacci calculation
- Servlet acting as controller
- JSP realizing the view
- POJO to pass state between controller and view

The project consists of the following artifacts:

- async-fib.war: EJBs plus web frontend

Running
=======

1) `mvn package`

2) Run in embedded glassfish container: `mvn embedded-glassfish:run`

3) Navigate to <a href="http://localhost:8080/myapp/">http://localhost:8080/myapp/</a>

4) Perform asynchronous calculation and check the results via the check button.

5) Perform synchronous calculation and notice its blocking behaviour.

6) Exit embedded glashfish by entering `x ENTER`, or press just `ENTER` to redeploy.

Windows note
============

On Windows use %GLASSFISH_HOME% or replace it with your installation
path of the Glassfish server. Replace `/` with `\` and `:` with `;`.

Out of memory
=============

It may happen depending on your environment. Optionally increase memory available to maven (JDK6 syntax):

* OSX/Linux `export MAVEN_OPTS="-Xmx=1024m -XX:MaxPermSize=1024m"`
* Windows `set MAVEN_OPTS="-Xmx=1024m -XX:MaxPermSize=1024m"`

EOF
