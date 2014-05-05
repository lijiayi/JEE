package de.spqrinfo.jee.interceptors.web;

import de.spqrinfo.jee.interceptors.backend.SomeBusinessBean;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

@Model
public class IndexBacking {

    @Inject
    SomeBusinessBean someBusinessBean;

    public void callBusinessMethod() {
        this.someBusinessBean.businessMethod();
    }
}
