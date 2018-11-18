package com.settleUpService;



import com.settleup.entity.SettleUpException;

import javax.ws.rs.*;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class SettleUpExceptionMapper {

    @Produces({MediaType.APPLICATION_JSON})
    public Response toJsonResponse(SettleUpException exception, int statusCode) {

        return Response.status(statusCode).entity(exception.getErrors()).build();
    }

    @Produces({MediaType.APPLICATION_XML})
    public Response toXMLResponse(SettleUpException exception, int statusCode) {

        return Response.status(statusCode).entity(exception).build();
    }

}
