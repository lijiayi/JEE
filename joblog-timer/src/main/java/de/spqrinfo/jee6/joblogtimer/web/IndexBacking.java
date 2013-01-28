package de.spqrinfo.jee6.joblogtimer.web;

import de.spqrinfo.jee6.joblogtimer.backend.JobLogBean;
import de.spqrinfo.jee6.joblogtimer.backend.LogEntry;

import javax.ejb.EJB;
import javax.enterprise.inject.Model;
import java.util.List;

@Model
public class IndexBacking {

    @EJB
    private JobLogBean jobLogBean;

    public boolean getHaveJobLogs() {
        return this.jobLogBean.hasMessages();
    }

    public List<LogEntry> getJobLogs() {
        return this.jobLogBean.getLogMessages();
    }
}
