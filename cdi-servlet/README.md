JEE CDI Servlet Project
=======================

Key features:

- Three counters with application, session and request scope
- Servlet acting as controller
- JSP realizing the view
- POJO to pass state between controller and view

The project consists of the following artifacts:

- cdi-servlet.war: Web app with beans

Running
=======

1) `mvn package`

2) Run in embedded glassfish container: `mvn embedded-glassfish:run`

3) Navigate to <a href="http://localhost:8080/myapp/">http://localhost:8080/myapp/</a>

4) Perform several reloads of the web page.

5) Open a different browser to display the same web page.

6) Notice the different counter values depending on the bean scope.

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
