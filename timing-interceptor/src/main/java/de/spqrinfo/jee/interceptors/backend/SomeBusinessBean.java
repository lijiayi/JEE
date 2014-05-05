package de.spqrinfo.jee.interceptors.backend;

import de.spqrinfo.jee.interceptors.measurement.TimeMeasurement;

import java.util.concurrent.TimeUnit;

public class SomeBusinessBean {

    @TimeMeasurement
    public void businessMethod() {
        try {
            // Note: this is in actually not supported and not recommended!
            TimeUnit.SECONDS.sleep(10);
        } catch (final InterruptedException e) {
            throw new RuntimeException("Interrupted");
        }
    }

}
