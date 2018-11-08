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
import java.util.List;

@Path("/settleUpService")
public class SettleUpService {

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_HTML, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
    @Path("{rent}/{activities}/{numberOfBedrooms}")
    public Response getAreasWithSimilarRentCostAndMatchingActivities(@PathParam("rent") int rent,
                                                                     @PathParam("activities") List<String> activities,
                                                                     @PathParam("numberOfBedrooms") int numberOfBedrooms) {
        int minimumPrice = rent - 500;
        int maximumPrice = rent + 500;

        GenericDAO<SettleUp> dao = new GenericDAO<>(SettleUp.class);

        List<SettleUp> results = dao.getAll();

        //query db
        //cast to object

        return Response.status(200).entity(results).build();

    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAll() {

        GenericDAO<SettleUp> dao = new GenericDAO<>(SettleUp.class);

        List<SettleUp> results = dao.getAll();

        //query db
        //cast to object

        return Response.status(200).entity(results).build();

    }



}