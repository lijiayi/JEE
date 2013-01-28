package de.spqrinfo.jee6.joblogtimer.backend;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup
public class AppInit {

    @EJB
    ProgrammaticTimerBean programmaticTimerBean;

    @PostConstruct
    private void init() {
        this.programmaticTimerBean.createTimeoutEverySeconds(12);
    }
}
