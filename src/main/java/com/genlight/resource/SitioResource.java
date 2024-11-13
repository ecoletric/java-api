package com.genlight.resource;

import com.genlight.bo.SitioBO;
import com.genlight.to.SitioTO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/sitio")
public class SitioResource {
    SitioBO sitioBO;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        sitioBO = new SitioBO();
        ArrayList<SitioTO> resultado = sitioBO.findAll();
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
        sitioBO = new SitioBO();
        SitioTO resultado = sitioBO.findById(id);
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
    public Response save(SitioTO sitio) {
        sitioBO = new SitioBO();
        SitioTO resultado = sitioBO.save(sitio);
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
    public Response update(@PathParam("id") int id, SitioTO sitio) {
        sitioBO = new SitioBO();
        sitio.setId(id);
        SitioTO resultado = sitioBO.update(sitio);
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
        sitioBO = new SitioBO();
        Response.ResponseBuilder response = null;
        if (sitioBO.delete(id)) {
            response = Response.status(204);
        } else {
            response = Response.status(404);
        }
        return response.build();
    }
}