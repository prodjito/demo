package com.example.demo;

import com.newrelic.api.agent.NewRelic;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

@Path("/error")
public class ErrorResource {
    @GET
    @Produces("text/plain")
    public void error() {
        WebApplicationException e = new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        NewRelic.noticeError(e);
        throw e;
    }
}
