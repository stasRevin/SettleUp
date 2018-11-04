package com.settleUpService;

import javax.ws.rs.ApplicationPath;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;

@ApplicationPath("/services")
public class SettleUpServiceConfiguration extends Application {

    @Override
    public Set<Class<?>> getClasses() {

        Set set = new HashSet<Class<?>>();
        set.add(SettleUpService.class);

        return set;
    }
}
