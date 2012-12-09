package de.spqrinfo.jee6.hello.ws;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

// Test URL:    http://localhost:8080/helloService/hello?tester
// WSDL:        http://localhost:8080/helloService/hello?wsdl
@WebService(serviceName = "helloService", name = "hello")
@Stateless
public class HelloBean {

    @WebMethod(operationName = "hello")
    public String getHello(@WebParam(name = "userName") String name) {
        return "Hello, " + name + "!";
    }
}
