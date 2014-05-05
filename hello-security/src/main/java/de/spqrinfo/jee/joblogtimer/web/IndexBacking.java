package de.spqrinfo.jee.joblogtimer.web;

import javax.enterprise.inject.Model;

@Model
public class IndexBacking {

    public String getSomeMessage() {
        return "Hello";
    }
}
