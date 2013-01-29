package de.spqrinfo.jee6.joblogtimer.backend;

import javax.annotation.Resource;
import javax.ejb.*;
import java.io.Serializable;

@Stateless
public class ProgrammaticTimerBean {

    @Resource
    private TimerService timerService;

    @EJB
    private JobLogBean jobLogBean;

    public void createTimeoutEverySeconds(final long seconds) {
        System.out.println("setting up programmatic timer(s) for each " + seconds + " s");

        final TimerConfig timerConfig = new TimerConfig("programatic timer " + seconds + "s", false);
        this.timerService.createIntervalTimer(0, seconds * 1000, timerConfig);
    }

    @Timeout
    public void programmaticTimeout(final Timer timer) {
        final Serializable name = timer.getInfo();

        // do some work

        // log result
        System.out.println(name);
        this.jobLogBean.addLogMessage(name + " finished");
    }
}
