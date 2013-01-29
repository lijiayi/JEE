package de.spqrinfo.jee6.interceptors.backend;

import de.spqrinfo.jee6.interceptors.measurement.TimeMeasurement;

import java.util.concurrent.TimeUnit;

public class SomeBusinessBean {

    @TimeMeasurement
    public void businessMethod() {
        try {
            // Note: this is in actually not supported and not recommended!
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException("Interrupted");
        }
    }

}
