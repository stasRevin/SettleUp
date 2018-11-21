package com.settleUpService;



import com.settleup.entity.SettleUpException;

import javax.ws.rs.*;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * This is SettleUpExceptionMapper class designed to map exceptions to either JSON or XML format.
 * @author srevin
 */
@Provider
public class SettleUpExceptionMapper {

    /**
     * This method maps exceptions to JSON format.
     * @param exception The generic exception.
     * @param statusCode The error status code.
     * @return JSON response
     */
    @Produces({MediaType.APPLICATION_JSON})
    public Response toJsonResponse(SettleUpException exception, int statusCode) {

        return Response.status(statusCode).entity(exception.getErrors()).build();
    }

    /**
     * This method maps exceptions to XML format.
     * @param exception The generic exception.
     * @param statusCode The error status code.
     * @return XML response
     */
    @Produces({MediaType.APPLICATION_XML})
    public Response toXMLResponse(SettleUpException exception, int statusCode) {

        return Response.status(statusCode).entity(exception).build();
    }

}
