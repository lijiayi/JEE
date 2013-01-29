JEE6 joblog timer EJB project
=============================

Key features:

- Stateless session bean configured with job timers (schedule and programmatic creation)
- Singleton bean to keep job execution log
- Singleton bean to initialize programmatic timers
- Stateless session bean acting as backing bean
- JSF 2.0 view

The project consists of the following artifacts:

- joblog-timer.war: EJBs plus JSF web frontend

Running
=======

1) `mvn package`

2) Run in embedded glassfish container: `mvn embedded-glassfish:run`

3) Navigate to <a href="http://localhost:8080/myapp/">http://localhost:8080/myapp/</a>

4) Watch job execution in glassfish output, give it some time to launch the jobs

5) Reload the webpage to view the job logs, or wait until the page reloads automatically (5 seconds)

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
