package com.genlight.bo;

import com.genlight.dao.AparelhoGeradorDAO;
import com.genlight.to.AparelhoGeradorTO;

import java.util.ArrayList;

public class AparelhoGeradorBO {
    AparelhoGeradorDAO aparelhoGeradorDAO;

    public ArrayList<AparelhoGeradorTO> findAll() {
        aparelhoGeradorDAO = new AparelhoGeradorDAO();
        return aparelhoGeradorDAO.findAll();
    }

    public AparelhoGeradorTO findById(int id) {
        aparelhoGeradorDAO = new AparelhoGeradorDAO();
        return aparelhoGeradorDAO.findById(id);
    }

    public AparelhoGeradorTO save(AparelhoGeradorTO aparelho) {
        aparelhoGeradorDAO = new AparelhoGeradorDAO();
        return aparelhoGeradorDAO.save(aparelho);
    }

    public boolean delete(int id) {
        aparelhoGeradorDAO = new AparelhoGeradorDAO();
        return aparelhoGeradorDAO.delete(id);
    }

    public AparelhoGeradorTO update(AparelhoGeradorTO aparelho) {
        aparelhoGeradorDAO = new AparelhoGeradorDAO();
        return aparelhoGeradorDAO.update(aparelho);
    }
}