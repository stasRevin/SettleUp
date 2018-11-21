package com.settleUpService;


import com.settleup.entity.*;
import com.settleup.persistence.GenericDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * This is SettleUpService class designed to serve as a RESTful service resource for the application. This service
 * takes rent price, type of recreational activity and a number of bedrooms for an apartment to produce a list
 * of cities featuring provided by the user activities where one can find a similar type of apartment
 * with a similar monthly rental price.
 * @author srevin
 */
@Path("/settleUpService")
public class SettleUpService {

    /**
     * This method produces JSON response
     * @param rent The rent price.
     * @param activity The activity name.
     * @param numberOfBedrooms Number of bedrooms.
     * @return JSON response
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/json/{rent}/{activity}/{numberOfBedrooms}")
    public Response getAllJSON(@PathParam("rent") int rent,
                               @PathParam("activity") String activity,
                               @PathParam("numberOfBedrooms") int numberOfBedrooms) {

        List<SettleUp> results = getDataFromDatabase(rent, activity, numberOfBedrooms);

        if (Objects.isNull(results)) {

            return createErrorMessage(Response.Status.INTERNAL_SERVER_ERROR, "json");

        } else if (results.size() == 0) {

            return createErrorMessage(Response.Status.NOT_FOUND, "json");

        }

        return Response.status(200).entity(results).build();
    }

    /**
     * This method creates a service error message for both JSON and XML output formats.
     * @param statusInput The status input.
     * @param responseType The response type.
     * @return response with a specified error message
     */
    private Response createErrorMessage(Response.Status statusInput, String responseType) {

        Response.Status status = statusInput;

        List<ErrorDescription> exceptions = new ArrayList<>();
        ErrorDescription description = new ErrorDescription();
        int statusCode = status.getStatusCode();
        description.setErrorCode(statusCode + "");
        description.setMessage(status.getReasonPhrase());
        exceptions.add(description);
        SettleUpException settleUpException = new SettleUpException();
        settleUpException.setErrors(exceptions);
        SettleUpExceptionMapper settleUpExceptionMapper = new SettleUpExceptionMapper();

        if (responseType.equals("xml")) {

            return settleUpExceptionMapper.toXMLResponse(settleUpException, statusCode);

        }

        return settleUpExceptionMapper.toJsonResponse(settleUpException, statusCode);

    }


    /**
     * This method produces an XML response.
     * @param rent The rent price.
     * @param activity The activity name.
     * @param numberOfBedrooms Number of bedrooms.
     * @return XML response
     */
    @GET
    @Produces({MediaType.APPLICATION_XML})
    @Path("/xml/{rent}/{activity}/{numberOfBedrooms}")
    public Response getAllXML(@PathParam("rent") int rent,
                              @PathParam("activity") String activity,
                              @PathParam("numberOfBedrooms") int numberOfBedrooms) {


        List<SettleUp> results = getDataFromDatabase(rent, activity, numberOfBedrooms);

        if (Objects.isNull(results)) {

            return createErrorMessage(Response.Status.INTERNAL_SERVER_ERROR, "xml");

        } else if (results.size() == 0) {

            return createErrorMessage(Response.Status.NOT_FOUND, "xml");

        }

        SearchResults searchResults = new SearchResults();
        searchResults.setSearchResults(results);

        return Response.status(200).entity(searchResults).build();

    }

    /**
     * This method produces a plain text response.
     * @param rent The rent price.
     * @param activity The activity name.
     * @param numberOfBedrooms Number of bedrooms.
     * @return Plain text response
     */
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

    }

    /**
     * This method returns the name of the column that lists rent prices for the specified number of bedrooms.
     * @param numberOfBedrooms Number of bedrooms.
     * @return columnName
     */
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

    /**
     * This method retrieves required data from the database.
     * @param rent The rent price.
     * @param activity The activity name.
     * @param numberOfBedrooms Number of bedrooms.
     * @return results The list of the results found.
     */
    private List<SettleUp> getDataFromDatabase(int rent, String activity, int numberOfBedrooms) {
        String numberOfBedroomsColumn = getNumberOfBedroomsColumn(numberOfBedrooms);

        GenericDAO<SettleUp> dao = new GenericDAO<>(SettleUp.class);
        List<SettleUp> results = null;
        int minimumPrice = rent - 50;
        int maximumPrice = rent + 50;

        try {
            results = dao.getElementsByRangeAndValues(minimumPrice, maximumPrice, numberOfBedroomsColumn, "activity", activity);
        } catch (Exception exception) {

            return null;
        }
        return results;
    }

}