package de.spqrinfo.jee.cdiservlet.web;

import de.spqrinfo.jee.cdiservlet.beans.ApplicationCounter;
import de.spqrinfo.jee.cdiservlet.beans.RequestCounter;
import de.spqrinfo.jee.cdiservlet.beans.SessionCounter;
import de.spqrinfo.jee.cdiservlet.beans.ValueHolder;

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

    private final AtomicInteger servletApplicationCounter = new AtomicInteger();
    private final AtomicInteger servletRequestCounter = new AtomicInteger();

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
        this.valueHolder.setCdiApplicationScopedCount(this.applicationCounter.incrementAndGet());
        this.valueHolder.setCdiSessionScopedCount(this.sessionCounter.incrementAndGet());
        this.valueHolder.setCdiRequestScopedCount(this.requestCounter.incrementAndGet());
        this.valueHolder.setServletApplicationScopedCount(this.servletApplicationCounter.incrementAndGet());
        this.valueHolder.setServletRequestScopedCount(this.servletRequestCounter.incrementAndGet());
        request.setAttribute("valueHolder", this.valueHolder);

        request.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);
    }
}
