package com.genlight.bo;

import com.genlight.dao.SitioDAO;
import com.genlight.to.SitioTO;

import java.util.ArrayList;
import java.util.List;

public class SitioBO {
    SitioDAO sitioDAO;

    public ArrayList<SitioTO> findAll() {
        sitioDAO = new SitioDAO();
        return sitioDAO.findAll();
    }

    public SitioTO findById(int id) {
        sitioDAO = new SitioDAO();
        return sitioDAO.findById(id);
    }

    public ArrayList<SitioTO> findAllByIdIndustria(int id) {
        sitioDAO = new SitioDAO();
        return sitioDAO.findAllByIdIndustria(id);
    }

    public SitioTO save(SitioTO sitio) {
        sitioDAO = new SitioDAO();
        return sitioDAO.save(sitio);
    }

    public boolean delete(int id) {
        sitioDAO = new SitioDAO();
        ArrayList<List<Integer>> equipamentsToDelete = sitioDAO.equipamentsToDelete(id);
        if (!equipamentsToDelete.isEmpty()){
            for (List<Integer> integers : equipamentsToDelete) {
                Integer idToDelete = integers.get(0);
                Integer typeOfObject = integers.get(1);
                switch (typeOfObject) {
                    case 1:
                        MaquinaBO maquinaBO = new MaquinaBO();
                        maquinaBO.delete(idToDelete);
                        break;
                    case 2:
                        AparelhoGeradorBO aparelhoGeradorBO = new AparelhoGeradorBO();
                        aparelhoGeradorBO.delete(idToDelete);
                        break;
                    default:
                        System.out.println("Sem item para apagar!");
                }
            }
        }
        return sitioDAO.delete(id);
    }

    public SitioTO update(SitioTO sitio) {
        sitioDAO = new SitioDAO();
        return sitioDAO.update(sitio);
    }
}