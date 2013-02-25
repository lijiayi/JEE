package de.spqrinfo.jee6.cdiservlet.beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class ValueHolder {

    private int cdiApplicationScopedCount;
    private int cdiSessionScopedCount;
    private int cdiRequestScopedCount;
    private int servletApplicationScopedCount;
    private int servletRequestScopedCount;

    public int getCdiApplicationScopedCount() {
        return cdiApplicationScopedCount;
    }

    public void setCdiApplicationScopedCount(final int cdiApplicationScopedCount) {
        this.cdiApplicationScopedCount = cdiApplicationScopedCount;
    }

    public int getCdiSessionScopedCount() {
        return cdiSessionScopedCount;
    }

    public void setCdiSessionScopedCount(final int cdiSessionScopedCount) {
        this.cdiSessionScopedCount = cdiSessionScopedCount;
    }

    public int getCdiRequestScopedCount() {
        return cdiRequestScopedCount;
    }

    public void setCdiRequestScopedCount(final int cdiRequestScopedCount) {
        this.cdiRequestScopedCount = cdiRequestScopedCount;
    }

    public int getServletApplicationScopedCount() {
        return servletApplicationScopedCount;
    }

    public void setServletApplicationScopedCount(final int servletApplicationScopedCount) {
        this.servletApplicationScopedCount = servletApplicationScopedCount;
    }

    public int getServletRequestScopedCount() {
        return servletRequestScopedCount;
    }

    public void setServletRequestScopedCount(final int servletRequestScopedCount) {
        this.servletRequestScopedCount = servletRequestScopedCount;
    }

    @Override
    public String toString() {
        return "ValueHolder{" +
                "cdiApplicationScopedCount=" + cdiApplicationScopedCount +
                ", cdiSessionScopedCount=" + cdiSessionScopedCount +
                ", cdiRequestScopedCount=" + cdiRequestScopedCount +
                ", servletApplicationScopedCount=" + servletApplicationScopedCount +
                ", servletRequestScopedCount=" + servletRequestScopedCount +
                '}';
    }
}
