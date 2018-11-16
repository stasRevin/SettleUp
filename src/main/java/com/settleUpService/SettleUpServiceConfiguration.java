package com.settleUpService;

import javax.ws.rs.ApplicationPath;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;

/**
 * Class to get access to the service classes that produce the search results
 */
@ApplicationPath("/services")
public class SettleUpServiceConfiguration extends Application {

    /**
     * Method that accesses the classes.
     * @return set
     */
    @Override
    public Set<Class<?>> getClasses() {

        Set set = new HashSet<Class<?>>();
        set.add(SettleUpService.class);
        set.add(SettleUpFormData.class);

        return set;
    }

}