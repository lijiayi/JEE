package de.spqrinfo.jee.joblogtimer.backend;

import java.util.Date;

public class LogEntry {

    private final Date created = new Date();
    private final String message;

    public LogEntry(final String message) {
        this.message = message;
    }

    public Date getCreated() {
        return this.created;
    }

    public String getMessage() {
        return this.message;
    }
}
