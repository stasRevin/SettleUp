package com.settleUpService;

import com.settleup.entity.ServerSideException;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ServerSideExceptionMapper implements ExceptionMapper<ServerSideException> {

    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public Response toResponse(ServerSideException exception) {

        Response.ResponseBuilder responseBuilder = Response.status(Response.Status.BAD_GATEWAY);
        responseBuilder.entity(exception.getErrors());

        return responseBuilder.build();
    }
}
