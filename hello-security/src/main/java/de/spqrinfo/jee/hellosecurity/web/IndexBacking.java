package de.spqrinfo.jee.hellosecurity.web;

import javax.enterprise.inject.Model;

@Model
public class IndexBacking {

    public String getSomeMessage() {
        return "Hello";
    }
}
