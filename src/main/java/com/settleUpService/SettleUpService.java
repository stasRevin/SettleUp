package com.settleUpService;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/settleUpService")
public class SettleUpService {

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_HTML, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
    @Path("{rent}/{activities}")
    public Response getAreasWithSimilarRentCostAndMatchingActivities(@PathParam("rent") int rent,
                                                                     @PathParam("activities") String activities) {


        return Response.status(200).entity("").build();

    }

}