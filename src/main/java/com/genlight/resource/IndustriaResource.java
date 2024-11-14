package com.genlight.resource;

import com.genlight.bo.IndustriaBO;
import com.genlight.to.IndustriaTO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/industria")
public class IndustriaResource {
    IndustriaBO industriaBO;
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(){
        industriaBO = new IndustriaBO();
        ArrayList<IndustriaTO> resultado = industriaBO.findAll();
        Response.ResponseBuilder response = null;
        if (resultado != null){
            response = Response.ok();
        }
        else{
            response = Response.status(404);
        }
        response.entity(resultado);
        return response.build();
    }

    @GET
    @Path("/empresa/{idEmpresa}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllByIdEmpresa(@PathParam("idEmpresa") int idEmpresa){
        industriaBO = new IndustriaBO();
        ArrayList<IndustriaTO> resultado = industriaBO.findByIdEmpresa(idEmpresa);
        Response.ResponseBuilder response = null;
        if (resultado != null){
            response = Response.ok();
        }
        else{
            response = Response.status(404);
        }
        response.entity(resultado);
        return response.build();
    }


    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") int id){
        industriaBO = new IndustriaBO();
        IndustriaTO resultado = industriaBO.findById(id);
        Response.ResponseBuilder response = null;
        if (resultado != null){
            response = Response.ok();
        }
        else{
            response = Response.status(404);
        }
        response.entity(resultado);
        return response.build();
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(IndustriaTO industria){
        industriaBO = new IndustriaBO();
        IndustriaTO resultado = industriaBO.save(industria);
        Response.ResponseBuilder response = null;
        if (resultado != null){
            response = Response.ok();
        }
        else{
            response = Response.status(404);
        }
        response.entity(resultado);
        return response.build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response update(@PathParam("id") int id , IndustriaTO industria){
        industriaBO = new IndustriaBO();
        industria.setId(id);
        IndustriaTO resultado = industriaBO.update(industria);
        Response.ResponseBuilder response = null;
        if (resultado != null){
            response = Response.ok();
        }
        else{
            response = Response.status(404);
        }
        response.entity(resultado);
        return response.build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete (@PathParam("id") int id){
        industriaBO = new IndustriaBO();
        Response.ResponseBuilder response = null;
        if (industriaBO.delete(id)){
            response = Response.status(204);
        }
        else{
            response = Response.status(404);
        }
        return response.build();
    }
}
