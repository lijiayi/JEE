package de.spqrinfo.jee6.cdiservlet.web;

import de.spqrinfo.jee6.cdiservlet.beans.ApplicationCounter;
import de.spqrinfo.jee6.cdiservlet.beans.RequestCounter;
import de.spqrinfo.jee6.cdiservlet.beans.SessionCounter;
import de.spqrinfo.jee6.cdiservlet.beans.ValueHolder;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

@WebServlet(urlPatterns = "/home.do")
public class CdiServlet extends HttpServlet {

    private AtomicInteger servletApplicationCounter = new AtomicInteger();
    private AtomicInteger servletRequestCounter = new AtomicInteger();

    @Inject
    private ApplicationCounter applicationCounter;
    @Inject
    private SessionCounter sessionCounter;
    @Inject
    private RequestCounter requestCounter;

    @Inject
    private ValueHolder valueHolder;

    @Override
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        valueHolder.setCdiApplicationScopedCount(this.applicationCounter.incrementAndGet());
        valueHolder.setCdiSessionScopedCount(this.sessionCounter.incrementAndGet());
        valueHolder.setCdiRequestScopedCount(this.requestCounter.incrementAndGet());
        valueHolder.setServletApplicationScopedCount(this.servletApplicationCounter.incrementAndGet());
        valueHolder.setServletRequestScopedCount(this.servletRequestCounter.incrementAndGet());
        request.setAttribute("valueHolder", valueHolder);

        request.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);
    }
}
