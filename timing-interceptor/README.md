JEE Timing Interceptor
======================
Key features:
- Sample interceptor performing method call time measurement
- Annotation @TimeMeasurement for interceptor binding
- beans.xml enabling the interceptor
- Trivial CDI bean containing business method to be timed
- JSF 2.0 view with button calling business method

The project consists of the following artifacts:
- timing-interceptor.war: containing everything above

Running
=======
1. `mvn package`
2. Run in embedded glassfish container: `mvn embedded-glassfish:run`
3. Navigate to <a href="http://localhost:8080/timing-interceptor/">http://localhost:8080/timing-interceptor/</a>
4. Click push button to invoke long running business method to be timed
5. Watch glassfish console to see the time measurement printed to System.out
6. Exit embedded glashfish by entering `x ENTER`, or press just `ENTER` to redeploy.

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
