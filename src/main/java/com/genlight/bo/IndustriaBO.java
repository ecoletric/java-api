package com.genlight.bo;

import com.genlight.dao.IndustriaDAO;
import com.genlight.to.IndustriaTO;

import java.util.ArrayList;

public class IndustriaBO {
    IndustriaDAO industriaDAO;

    public ArrayList<IndustriaTO> findAll(){
        industriaDAO = new IndustriaDAO();
        return industriaDAO.findAll();
    }
    public IndustriaTO findById(int id){
        industriaDAO = new IndustriaDAO();
        return industriaDAO.findById(id);
    }

    public IndustriaTO save(IndustriaTO pecaTO){
        industriaDAO = new IndustriaDAO();
        return industriaDAO.save(pecaTO);
    }

    public boolean delete(int codigo){
        industriaDAO = new IndustriaDAO();
        return industriaDAO.delete(codigo);
    }

    public IndustriaTO update (IndustriaTO email){
        industriaDAO = new IndustriaDAO();
        return industriaDAO.update(email);
    }
}
