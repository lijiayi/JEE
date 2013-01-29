package de.spqrinfo.jee6.joblogtimer.backend;

import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Schedules;
import javax.ejb.Stateless;

@Stateless
public class JobBean {

    @EJB
    private JobLogBean jobLogBean;

    @Schedules({
            @Schedule(second = "*/10", minute = "*", hour = "*"),    // every 10 seconds
            @Schedule(dayOfWeek = "Sun", hour = "0", minute = "17")  // another schedule
    })
    public void someJob() { // public access to permit testing
        // do some work

        // log result
        System.out.println("someJob");
        this.jobLogBean.addLogMessage("someJob finished");
    }

    @Schedule(minute = "*/1", hour = "*") // every minute
    public void anotherJob() { // public access to permit testing
        // do some work

        // log result
        System.out.println("anotherJob");
        this.jobLogBean.addLogMessage("anotherJob finished");
    }
}
