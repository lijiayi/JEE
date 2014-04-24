package de.spqrinfo.jee.cdiservlet.beans;

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
        return this.cdiApplicationScopedCount;
    }

    public void setCdiApplicationScopedCount(final int cdiApplicationScopedCount) {
        this.cdiApplicationScopedCount = cdiApplicationScopedCount;
    }

    public int getCdiSessionScopedCount() {
        return this.cdiSessionScopedCount;
    }

    public void setCdiSessionScopedCount(final int cdiSessionScopedCount) {
        this.cdiSessionScopedCount = cdiSessionScopedCount;
    }

    public int getCdiRequestScopedCount() {
        return this.cdiRequestScopedCount;
    }

    public void setCdiRequestScopedCount(final int cdiRequestScopedCount) {
        this.cdiRequestScopedCount = cdiRequestScopedCount;
    }

    public int getServletApplicationScopedCount() {
        return this.servletApplicationScopedCount;
    }

    public void setServletApplicationScopedCount(final int servletApplicationScopedCount) {
        this.servletApplicationScopedCount = servletApplicationScopedCount;
    }

    public int getServletRequestScopedCount() {
        return this.servletRequestScopedCount;
    }

    public void setServletRequestScopedCount(final int servletRequestScopedCount) {
        this.servletRequestScopedCount = servletRequestScopedCount;
    }

    @Override
    public String toString() {
        return "ValueHolder{" +
                "cdiApplicationScopedCount=" + this.cdiApplicationScopedCount +
                ", cdiSessionScopedCount=" + this.cdiSessionScopedCount +
                ", cdiRequestScopedCount=" + this.cdiRequestScopedCount +
                ", servletApplicationScopedCount=" + this.servletApplicationScopedCount +
                ", servletRequestScopedCount=" + this.servletRequestScopedCount +
                '}';
    }
}
