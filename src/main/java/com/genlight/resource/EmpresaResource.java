package com.genlight.resource;


import com.genlight.bo.EmpresaBO;
import com.genlight.to.EmpresaTO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/empresa")
public class EmpresaResource {
    EmpresaBO empresaBO;
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(){
        empresaBO = new EmpresaBO();
        ArrayList<EmpresaTO> resultado = empresaBO.findAll();
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
        empresaBO = new EmpresaBO();
        EmpresaTO resultado = empresaBO.findById(id);
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
    public Response save(EmpresaTO maquina){
        empresaBO = new EmpresaBO();
        EmpresaTO resultado = empresaBO.save(maquina);
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
    public Response update(@PathParam("id") int id , EmpresaTO maquina){
        empresaBO = new EmpresaBO();
        maquina.setId(id);
        EmpresaTO resultado = empresaBO.update(maquina);
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
        empresaBO = new EmpresaBO();
        Response.ResponseBuilder response = null;
        if (empresaBO.delete(id)){
            response = Response.status(204);
        }
        else{
            response = Response.status(404);
        }
        return response.build();
    }
}
