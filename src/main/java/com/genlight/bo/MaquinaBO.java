package com.genlight.bo;

import com.genlight.dao.MaquinaDAO;
import com.genlight.dao.SitioDAO;
import com.genlight.to.MaquinaTO;
import com.genlight.to.SitioInvalidoException;

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
    

    public MaquinaTO save(MaquinaTO pecaTO) throws SitioInvalidoException {
        maquinaDAO = new MaquinaDAO();
        SitioDAO.isSitioTipoFonteCorrect(pecaTO.getIdSitio(), 0);
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
