JEE6 joblog timer EJB project
=============================

Key features:

- Stateless session bean configured with two job timers
- JSF 2.0

The project consists of the following artifacts:

- joblog-timer.war: EJBs plus web frontend

Running
=======

1) `mvn package`

2) Increase memory available to maven `export MAVEN_OPTS="-Xmx=1024m -XX:MaxPermSize=1024m"`
   or `set MAVEN_OPTS="-Xmx=1024m -XX:MaxPermSize=1024m"`

3) Run in embedded glassfish container: `mvn embedded-glassfish:run`

4) Navigate to <a href="http://localhost:8080/myapp/">http://localhost:8080/myapp/</a>

5) Watch job execution in glassfish output, give it some time to launch the jobs

6) Reload the webpage to view the job logs

7) Exit embedded glashfish by entering `x ENTER`, or press just `ENTER` to redeploy.

Windows note
============

On Windows use %GLASSFISH_HOME% or replace it with your installation
path of the Glassfish server. Replace `/` with `\` and `:` with `;`.

EOF
