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

    /**
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
     */

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/json/{rent}/{activity}/{numberOfBedrooms}")
    public Response getAllJSON(@PathParam("rent") int rent,
                               @PathParam("activity") String activity,
                               @PathParam("numberOfBedrooms") int numberOfBedrooms) {

        //get number of bedrooms column name
        String numberOfBedroomsColumn = getNumberOfBedroomsColumn(numberOfBedrooms);

        GenericDAO<SettleUp> dao = new GenericDAO<>(SettleUp.class);
        int minimumPrice = rent - 500;
        int maximumPrice = rent + 500;

        List<SettleUp> results = dao.getElementsByRangeAndValues(minimumPrice, maximumPrice, numberOfBedroomsColumn, "activity", activity);

        return Response.status(200).entity(results).build();

    }


/*
    @GET
    @Produces({MediaType.APPLICATION_XML})
    @Path("/xml/{rent}/{activities}/{numberOfBedrooms}")
    public Response getAllXML() {

        GenericDAO<SettleUp> dao = new GenericDAO<>(SettleUp.class);

        List<SettleUp> results = dao.getAll();

        //query db
        //cast to object

        return Response.status(200).entity(results).build();

    }

    @GET
    @Produces({MediaType.TEXT_HTML})
    @Path("/html/{rent}/{activities}/{numberOfBedrooms}")
    public Response getAllHTML() {

        GenericDAO<SettleUp> dao = new GenericDAO<>(SettleUp.class);

        List<SettleUp> results = dao.getAll();

        //query db
        //cast to object

        return Response.status(200).entity(results).build();

    }

    @GET
    @Produces({MediaType.TEXT_PLAIN})
    @Path("/text/{rent}/{activities}/{numberOfBedrooms}")
    public Response getAllText() {

        GenericDAO<SettleUp> dao = new GenericDAO<>(SettleUp.class);

        List<SettleUp> results = dao.getAll();

        //query db
        //cast to object

        return Response.status(200).entity(results).build();

    }*/

    private String getNumberOfBedroomsColumn(int numberOfBedrooms) {

        String columnName = "";

        switch (numberOfBedrooms) {

            case 0:
                columnName = "rent_0";
                break;
            case 1:
                columnName = "rent_1";
                break;
            case 2:
                columnName = "rent_2";
                break;
            case 3:
                columnName = "rent_3";
                break;
            case 4:
                columnName = "rent_4";
                break;
        }

        return columnName;
    }
}