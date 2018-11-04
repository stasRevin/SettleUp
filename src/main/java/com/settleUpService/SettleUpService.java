package com.settleUpService;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/services")
public class SettleUpService extends Application {

    @Override
    public Set<Class<?>> getClasses() {

        Set set = new HashSet<Class<?>>();
        set.add(SettleUpService.class);

        return set;
    }
}