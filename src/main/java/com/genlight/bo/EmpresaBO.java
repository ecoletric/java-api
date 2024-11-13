package com.genlight.bo;

import com.genlight.dao.EmpresaDAO;
import com.genlight.dao.EmpresaDAO;
import com.genlight.to.EmpresaTO;

import java.util.ArrayList;

public class EmpresaBO {
    EmpresaDAO empresaDAO;

    public ArrayList<EmpresaTO> findAll(){
        empresaDAO = new EmpresaDAO();
        return empresaDAO.findAll();
    }
    public EmpresaTO findById(int id){
        empresaDAO = new EmpresaDAO();
        return empresaDAO.findById(id);
    }

    public EmpresaTO save(EmpresaTO pecaTO){
        empresaDAO = new EmpresaDAO();
        return empresaDAO.save(pecaTO);
    }

    public boolean delete(int codigo){
        empresaDAO = new EmpresaDAO();
        return empresaDAO.delete(codigo);
    }

    public EmpresaTO update (EmpresaTO email){
        empresaDAO = new EmpresaDAO();
        return empresaDAO.update(email);
    }
}
