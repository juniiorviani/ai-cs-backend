package com.nukk.resource;

import com.nukk.model.Customer;
import com.nukk.service.AiAgentClient;
import com.nukk.service.CustomerService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Map;

@Path("/customers")
@Produces(MediaType.APPLICATION_JSON)
public class CustomerResource {

    @Inject
    CustomerService customerService;

    @Inject
    AiAgentClient aiAgentClient;

    @GET
    public List<Customer> listCustomers() {
        return customerService.findAll();
    }

    @GET
    @Path("/{id}")
    public Response getCustomer(@PathParam("id") String id) {
        Customer customer = customerService.findById(id);
        if (customer == null) {
            return notFound();
        }
        return Response.ok(customer).build();
    }

    @POST
    @Path("/{id}/analyze")
    public Response analyze(@PathParam("id") String id) {
        Customer customer = customerService.findById(id);
        if (customer == null) {
            return notFound();
        }
        try {
            Object result = aiAgentClient.analyze(customer);
            return Response.ok(result).build();
        } catch (AiAgentClient.AiAgentException e) {
            return Response.status(e.statusCode)
                .entity(Map.of("error", "ai_agent_error", "message", e.getMessage()))
                .build();
        }
    }

    private Response notFound() {
        return Response.status(Response.Status.NOT_FOUND)
            .entity(Map.of("error", "customer_not_found"))
            .build();
    }
}
