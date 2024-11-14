package com.genlight.bo;

import com.genlight.dao.MaquinaDAO;
import com.genlight.to.MaquinaTO;

import java.util.ArrayList;

public class MaquinaBO {
    MaquinaDAO maquinaDAO;

    public ArrayList<MaquinaTO> findAll(){
        maquinaDAO = new MaquinaDAO();
        return maquinaDAO.findAll();
    }

    public ArrayList<MaquinaTO> findAllByIdSitio(int idSitio){
        maquinaDAO = new MaquinaDAO();
        return maquinaDAO.findAllByIdSitio(idSitio);
    }
    public MaquinaTO findById(int id){
        maquinaDAO = new MaquinaDAO();
        return maquinaDAO.findById(id);
    }
    

    public MaquinaTO save(MaquinaTO pecaTO){
        maquinaDAO = new MaquinaDAO();
        return maquinaDAO.save(pecaTO);
    }

    public boolean delete(int codigo){
        maquinaDAO = new MaquinaDAO();
        return maquinaDAO.delete(codigo);
    }

    public MaquinaTO update (MaquinaTO email){
        maquinaDAO = new MaquinaDAO();
        return maquinaDAO.update(email);
    }
}
