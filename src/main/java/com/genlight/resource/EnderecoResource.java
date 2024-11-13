package com.genlight.resource;

import com.genlight.bo.EnderecoBO;
import com.genlight.to.EnderecoTO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/endereco")
public class EnderecoResource {
    EnderecoBO enderecoBO;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        enderecoBO = new EnderecoBO();
        ArrayList<EnderecoTO> resultado = enderecoBO.findAll();
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.ok();
        } else {
            response = Response.status(404);
        }
        response.entity(resultado);
        return response.build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") int id) {
        enderecoBO = new EnderecoBO();
        EnderecoTO resultado = enderecoBO.findById(id);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.ok();
        } else {
            response = Response.status(404);
        }
        response.entity(resultado);
        return response.build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(EnderecoTO endereco) {
        enderecoBO = new EnderecoBO();
        EnderecoTO resultado = enderecoBO.save(endereco);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.ok();
        } else {
            response = Response.status(404);
        }
        response.entity(resultado);
        return response.build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response update(@PathParam("id") int id, EnderecoTO endereco) {
        enderecoBO = new EnderecoBO();
        endereco.setId(id);
        EnderecoTO resultado = enderecoBO.update(endereco);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.ok();
        } else {
            response = Response.status(404);
        }
        response.entity(resultado);
        return response.build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") int id) {
        enderecoBO = new EnderecoBO();
        Response.ResponseBuilder response = null;
        if (enderecoBO.delete(id)) {
            response = Response.status(204);
        } else {
            response = Response.status(404);
        }
        return response.build();
    }
}