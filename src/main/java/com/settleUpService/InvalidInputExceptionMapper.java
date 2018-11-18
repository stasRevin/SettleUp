package com.settleUpService;


import com.settleup.entity.InvalidInputException;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class InvalidInputExceptionMapper implements ExceptionMapper<InvalidInputException> {

    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public Response toResponse(InvalidInputException exception) {

        Response.ResponseBuilder responseBuilder = Response.status(Response.Status.BAD_REQUEST);
        responseBuilder.entity(exception.getErrors());

        return responseBuilder.build();
    }

}
