package de.spqrinfo.jee6.interceptors.web;

import de.spqrinfo.jee6.interceptors.backend.SomeBusinessBean;

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
