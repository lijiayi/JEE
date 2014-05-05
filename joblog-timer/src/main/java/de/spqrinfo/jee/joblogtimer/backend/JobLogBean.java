package de.spqrinfo.jee.joblogtimer.backend;

import javax.ejb.*;
import java.util.ArrayList;
import java.util.List;

@Startup
@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
public class JobLogBean {

    private final List<LogEntry> logEntries = new ArrayList<LogEntry>();

    @Lock(LockType.READ)
    public boolean hasMessages() {
        return !this.logEntries.isEmpty();
    }

    @Lock(LockType.READ)
    public List<LogEntry> getLogMessages() {
        return this.logEntries;
    }

    @Lock(LockType.WRITE)
    public void addLogMessage(final String message) {
        this.logEntries.add(new LogEntry(message));
    }
}
