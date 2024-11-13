package com.genlight.resource;

import com.genlight.bo.AparelhoGeradorBO;
import com.genlight.to.AparelhoGeradorTO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/gerador")
public class AparelhoGeradorResource {
    AparelhoGeradorBO aparelhoGeradorBO;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        aparelhoGeradorBO = new AparelhoGeradorBO();
        ArrayList<AparelhoGeradorTO> resultado = aparelhoGeradorBO.findAll();
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
        aparelhoGeradorBO = new AparelhoGeradorBO();
        AparelhoGeradorTO resultado = aparelhoGeradorBO.findById(id);
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
    public Response save(AparelhoGeradorTO aparelho) {
        aparelhoGeradorBO = new AparelhoGeradorBO();
        AparelhoGeradorTO resultado = aparelhoGeradorBO.save(aparelho);
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
    public Response update(@PathParam("id") int id, AparelhoGeradorTO aparelho) {
        aparelhoGeradorBO = new AparelhoGeradorBO();
        aparelho.setId(id);
        AparelhoGeradorTO resultado = aparelhoGeradorBO.update(aparelho);
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
        aparelhoGeradorBO = new AparelhoGeradorBO();
        Response.ResponseBuilder response = null;
        if (aparelhoGeradorBO.delete(id)) {
            response = Response.status(204);
        } else {
            response = Response.status(404);
        }
        return response.build();
    }
}