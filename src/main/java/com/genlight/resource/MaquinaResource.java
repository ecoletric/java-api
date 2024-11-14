package com.genlight.resource;

import com.genlight.bo.MaquinaBO;
import com.genlight.to.MaquinaTO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/maquina")
public class MaquinaResource {

    MaquinaBO maquinaBO;
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(){
        maquinaBO = new MaquinaBO();
        ArrayList<MaquinaTO> resultado = maquinaBO.findAll();
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
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/sitio/{idSitio}")
    public Response findAllByIdSitio(@PathParam("idSitio") int idSitio){
        maquinaBO = new MaquinaBO();
        ArrayList<MaquinaTO> resultado = maquinaBO.findAllByIdSitio(idSitio);
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
        maquinaBO = new MaquinaBO();
        MaquinaTO resultado = maquinaBO.findById(id);
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
    public Response save(MaquinaTO maquina){
        maquinaBO = new MaquinaBO();
        MaquinaTO resultado = maquinaBO.save(maquina);
        Response.ResponseBuilder response = null;
        if (resultado != null){
            response = Response.ok();
        }
        else{
            response = Response.status(400);
        }
        response.entity(resultado);
        return response.build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response update(@PathParam("id") int id , MaquinaTO maquina){
        maquinaBO = new MaquinaBO();
        maquina.setId(id);
        MaquinaTO resultado = maquinaBO.update(maquina);
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
        maquinaBO = new MaquinaBO();
        Response.ResponseBuilder response = null;
        if (maquinaBO.delete(id)){
            response = Response.status(204);
        }
        else{
            response = Response.status(404);
        }
        return response.build();
    }
}

