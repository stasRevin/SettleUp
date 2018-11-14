package com.settleUpService;

import com.settleup.entity.SettleUp;
import com.settleup.persistence.GenericDAO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Path("/SettleUpFormData")
public class SettleUpFormData {

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAllJSON() {


        GenericDAO<SettleUp> dao = new GenericDAO<>(SettleUp.class);
        List<SettleUp> results = dao.getAll();
        Set<String> activities = new HashSet<>();

        for( SettleUp set : results ) {
            activities.add(set.getActivity());
        }

        return Response.status(200).entity(activities).build();
    }
}
