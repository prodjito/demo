package com.example.demo;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Path("/hello-world")
public class HelloResource {

    @GET
    @Produces("text/plain")
    public String hello() {
        foo();
        return "Hello, World!!";
    }

    @Trace
    private void foo() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}