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
        if (null == fibonacci.getInputValue()) {
            fibonacci.setInputValue(DEFAULT_FIB_N);
        }
        if (null == fibonacci.getInputValueSynchronous()) {
            fibonacci.setInputValueSynchronous(DEFAULT_FIB_N);
        }
        request.setAttribute("fibonacci", fibonacci);
        request.getRequestDispatcher(VIEW).forward(request, response);
    }

    @Override
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        final String operation = request.getParameter("operation");
        if (null == operation) {
            throw new RuntimeException("Unknown operation; Parameter missing");
        } else if (operation.equals("calculate")) {
            System.out.println("Calculation");
            final String inputValueStr = request.getParameter("inputValue");
            final BigInteger inputValue = new BigInteger(inputValueStr);
            final Future<BigInteger> result = this.fibonacciCalculationBean.asyncFibonacci(inputValue);
            this.fibonacci.setInputValue(inputValue);
            this.fibonacci.setResult(result);
        } else if (operation.equals("check")) {
            System.out.println("Check");
        } else if (operation.equals("calculateSynchronous")) {
            System.out.println("Synchronous calculate");
            final String inputValueStr = request.getParameter("inputValueSynchronous");
            final BigInteger inputValue = new BigInteger(inputValueStr);
            final BigInteger result = this.fibonacciCalculationBean.synchronousFibonacci(inputValue);
            this.fibonacci.setInputValueSynchronous(inputValue);
            this.fibonacci.setResultSynchronous(result);
        } else {
            throw new RuntimeException("Unknown operation '" + operation + "'");
        }
        request.setAttribute("fibonacci", fibonacci);
        request.getRequestDispatcher(VIEW).forward(request, response);
    }
}
