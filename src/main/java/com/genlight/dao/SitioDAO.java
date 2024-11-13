package com.genlight.dao;

import com.genlight.to.SitioTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SitioDAO extends Repository {
    public ArrayList<SitioTO> findAll() {
        ArrayList<SitioTO> resultado = new ArrayList<>();
        String sql = "SELECT * FROM T_GL_SITIO";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    SitioTO sitio = new SitioTO();
                    sitio.setId(rs.getInt("id_sitio"));
                    sitio.setTipoFonte(rs.getInt("tp_fonte"));
                    sitio.setIdIndustria(rs.getInt("id_industria"));
                    sitio.setIdEndereco(rs.getInt("id_endereco"));
                    resultado.add(sitio);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro de sql! " + e.getMessage());
        } finally {
            closeConnection();
        }
        return resultado;
    }

    public SitioTO findById(int id) {
        String sql = "SELECT * FROM T_GL_SITIO WHERE id_sitio = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                SitioTO sitio = new SitioTO();
                sitio.setId(rs.getInt("id_sitio"));
                sitio.setTipoFonte(rs.getInt("tp_fonte"));
                sitio.setIdIndustria(rs.getInt("id_industria"));
                sitio.setIdEndereco(rs.getInt("id_endereco"));
                return sitio;
            }
        } catch (SQLException e) {
            System.out.println("Erro de sql! " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public SitioTO save(SitioTO sitio) {
        String sql = "INSERT INTO T_GL_SITIO(TP_FONTE, ID_INDUSTRIA, ID_ENDERECO) VALUES (?, ?, ?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setInt(1, sitio.getTipoFonte());
            ps.setInt(2, sitio.getIdIndustria());
            ps.setInt(3, sitio.getIdEndereco());
            if (ps.executeUpdate() > 0) {
                return sitio;
            }
        } catch (SQLException e) {
            System.out.println("Erro de sql! " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM T_GL_SITIO WHERE ID_SITIO = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao deletar: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }

    public SitioTO update(SitioTO sitio) {
        String sql = "UPDATE T_GL_SITIO SET TP_FONTE = ?, ID_INDUSTRIA = ?, ID_ENDERECO = ? WHERE ID_SITIO = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setInt(1, sitio.getTipoFonte());
            ps.setInt(2, sitio.getIdIndustria());
            ps.setInt(3, sitio.getIdEndereco());
            ps.setInt(4, sitio.getId());
            if (ps.executeUpdate() > 0) {
                return sitio;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao editar: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }
}