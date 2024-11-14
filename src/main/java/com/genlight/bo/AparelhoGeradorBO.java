package com.genlight.bo;

import com.genlight.dao.AparelhoGeradorDAO;
import com.genlight.dao.SitioDAO;
import com.genlight.to.AparelhoGeradorTO;
import com.genlight.to.SitioInvalidoException;
import com.genlight.to.TipoEnergia;

import java.util.ArrayList;

public class AparelhoGeradorBO {
    AparelhoGeradorDAO aparelhoGeradorDAO;

    public ArrayList<AparelhoGeradorTO> findAll() {
        aparelhoGeradorDAO = new AparelhoGeradorDAO();
        return aparelhoGeradorDAO.findAll();
    }

    public ArrayList<AparelhoGeradorTO> findAllByIdSitio(int idSitio) {
        aparelhoGeradorDAO = new AparelhoGeradorDAO();
        return aparelhoGeradorDAO.findAllByIdSitio(idSitio);
    }

    public AparelhoGeradorTO findById(int id) {
        aparelhoGeradorDAO = new AparelhoGeradorDAO();
        return aparelhoGeradorDAO.findById(id);
    }

    public AparelhoGeradorTO save(AparelhoGeradorTO aparelho) {
        aparelhoGeradorDAO = new AparelhoGeradorDAO();
        try {
            SitioDAO.isSitioTipoFonteCorrect(aparelho.getSitio(), aparelho.getTipo());
        } catch (SitioInvalidoException e) {
            System.out.println("Salvar aparelho gerador de "+ TipoEnergia.fromValor(aparelho.getTipo()) + " não " +
                    "foi possível! " + e.getMessage());
            return null;
        }
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