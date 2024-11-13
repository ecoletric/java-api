package com.genlight.bo;

import com.genlight.dao.EnderecoDAO;
import com.genlight.to.EnderecoTO;

import java.util.ArrayList;

public class EnderecoBO {
    EnderecoDAO enderecoDAO;

    public ArrayList<EnderecoTO> findAll() {
        enderecoDAO = new EnderecoDAO();
        return enderecoDAO.findAll();
    }

    public EnderecoTO findById(int id) {
        enderecoDAO = new EnderecoDAO();
        return enderecoDAO.findById(id);
    }

    public EnderecoTO save(EnderecoTO endereco) {
        enderecoDAO = new EnderecoDAO();
        return enderecoDAO.save(endereco);
    }

    public boolean delete(int id) {
        enderecoDAO = new EnderecoDAO();
        return enderecoDAO.delete(id);
    }

    public EnderecoTO update(EnderecoTO endereco) {
        enderecoDAO = new EnderecoDAO();
        return enderecoDAO.update(endereco);
    }
}