package com.genlight.bo;

import com.genlight.dao.SitioDAO;
import com.genlight.to.SitioTO;

import java.util.ArrayList;

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

    public SitioTO save(SitioTO sitio) {
        sitioDAO = new SitioDAO();
        return sitioDAO.save(sitio);
    }

    public boolean delete(int id) {
        sitioDAO = new SitioDAO();
        return sitioDAO.delete(id);
    }

    public SitioTO update(SitioTO sitio) {
        sitioDAO = new SitioDAO();
        return sitioDAO.update(sitio);
    }
}