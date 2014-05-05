package de.spqrinfo.jee.joblogtimer.web;

import de.spqrinfo.jee.joblogtimer.backend.JobLogBean;
import de.spqrinfo.jee.joblogtimer.backend.LogEntry;

import javax.ejb.EJB;
import javax.enterprise.inject.Model;
import java.util.List;

@Model
public class IndexBacking {

    @EJB
    private JobLogBean jobLogBean;

    public boolean getHasJobLogs() {
        return this.jobLogBean.hasMessages();
    }

    public List<LogEntry> getJobLogs() {
        return this.jobLogBean.getLogMessages();
    }
}
