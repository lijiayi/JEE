package de.spqrinfo.jee6.async.web;

import de.spqrinfo.jee6.async.backend.FibonacciCalculationBean;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.Future;

@WebServlet(urlPatterns = "/home.do")
public class HomeController extends HttpServlet {

    private static final String VIEW = "/WEB-INF/views/home.jsp";

    private static final BigInteger DEFAULT_FIB_N = new BigInteger("223443");

    @EJB
    private FibonacciCalculationBean fibonacciCalculationBean;

    @Inject
    private Fibonacci fibonacci;

    @Override
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        if (null == this.fibonacci.getInputValue()) {
            this.fibonacci.setInputValue(DEFAULT_FIB_N);
        }

        if (null == this.fibonacci.getInputValueSynchronous()) {
            this.fibonacci.setInputValueSynchronous(DEFAULT_FIB_N);
        }

        request.setAttribute("servletId", this.toString());
        request.setAttribute("fibonacci", this.fibonacci);
        request.getRequestDispatcher(VIEW).forward(request, response);
    }

    @Override
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        final String operation = request.getParameter("operation");

        if (null == operation) {
            throw new RuntimeException("Unknown operation; Parameter missing");
        } else if (operation.equals("calculate")) {
            calculateAsynchronous(request);
        } else if (operation.equals("check")) {
            System.out.println("Check");
        } else if (operation.equals("calculateSynchronous")) {
            calculateSynchronous(request);
        } else {
            throw new RuntimeException("Unknown operation '" + operation + "'");
        }

        request.setAttribute("servletId", this.toString());
        request.setAttribute("fibonacci", this.fibonacci);
        request.getRequestDispatcher(VIEW).forward(request, response);
    }

    private void calculateAsynchronous(final HttpServletRequest request) throws ServletException, IOException {
        System.out.println("Asynchronous calculate");

        final String inputValueStr = request.getParameter("inputValue");
        final BigInteger inputValue = new BigInteger(inputValueStr);

        final Future<BigInteger> result = this.fibonacciCalculationBean.asyncFibonacci(inputValue);

        this.fibonacci.setInputValue(inputValue);
        this.fibonacci.setResult(result);
    }

    private void calculateSynchronous(final HttpServletRequest request) throws ServletException, IOException {
        System.out.println("Synchronous calculate");

        final String inputValueStr = request.getParameter("inputValueSynchronous");
        final BigInteger inputValue = new BigInteger(inputValueStr);

        final BigInteger result = this.fibonacciCalculationBean.synchronousFibonacci(inputValue);

        this.fibonacci.setInputValueSynchronous(inputValue);
        this.fibonacci.setResultSynchronous(result);
    }
}
