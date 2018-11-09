package com.settleUpService;


import com.settleup.entity.SearchResults;
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
import java.util.stream.Collectors;

@Path("/settleUpService")
public class SettleUpService {

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/json/{rent}/{activity}/{numberOfBedrooms}")
    public Response getAllJSON(@PathParam("rent") int rent,
                               @PathParam("activity") String activity,
                               @PathParam("numberOfBedrooms") int numberOfBedrooms) {

        List<SettleUp> results = getDataFromDatabase(rent, activity, numberOfBedrooms);

        return Response.status(200).entity(results).build();
    }


/*
    @GET
    @Produces({MediaType.APPLICATION_XML})
    @Path("/xml/{rent}/{activity}/{numberOfBedrooms}")
    public Response getAllXML(@PathParam("rent") int rent,
                              @PathParam("activity") String activity,
                              @PathParam("numberOfBedrooms") int numberOfBedrooms) {


        List<SettleUp> results = getDataFromDatabase(rent, activity, numberOfBedrooms);

        SearchResults searchResults = new SearchResults();
        searchResults.setSearchResults(results);

        return Response.status(200).entity(searchResults).build();

    }

    @GET
    @Produces({MediaType.TEXT_PLAIN})
    @Path("/text/{rent}/{activity}/{numberOfBedrooms}")
    public Response getAllText(@PathParam("rent") int rent,
                               @PathParam("activity") String activity,
                               @PathParam("numberOfBedrooms") int numberOfBedrooms) {

        GenericDAO<SettleUp> dao = new GenericDAO<>(SettleUp.class);

        List<SettleUp> results = getDataFromDatabase(rent, activity, numberOfBedrooms);
        //Found the below method here https://stackoverflow.com/questions/599161/best-way-to-convert-an-arraylist-to-a-string
        String returnText = results.stream().map(SettleUp::toString).collect(Collectors.joining(", "));

        return Response.status(200).entity(returnText).build();

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


    private List<SettleUp> getDataFromDatabase(int rent, String activity, int numberOfBedrooms) {
        String numberOfBedroomsColumn = getNumberOfBedroomsColumn(numberOfBedrooms);

        GenericDAO<SettleUp> dao = new GenericDAO<>(SettleUp.class);

        int minimumPrice = rent - 50;
        int maximumPrice = rent + 50;

        return dao.getElementsByRangeAndValues(minimumPrice, maximumPrice, numberOfBedroomsColumn, "activity", activity);
    }

}