package de.spqrinfo.jee6.joblogtimer.backend;

import java.util.Date;

public class LogEntry {

    private final Date created = new Date();
    private final String message;

    public LogEntry(final String message) {
        this.message = message;
    }

    public Date getCreated() {
        return created;
    }

    public String getMessage() {
        return message;
    }
}
