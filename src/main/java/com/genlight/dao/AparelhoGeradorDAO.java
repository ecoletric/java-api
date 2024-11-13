package com.genlight.dao;

import com.genlight.to.AparelhoGeradorTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AparelhoGeradorDAO extends Repository {
    public ArrayList<AparelhoGeradorTO> findAll() {
        ArrayList<AparelhoGeradorTO> resultado = new ArrayList<>();
        String sql = "SELECT * FROM T_GL_APARELHO_GERADOR";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    AparelhoGeradorTO aparelho = new AparelhoGeradorTO();
                    aparelho.setId(rs.getInt("id_fonte"));
                    aparelho.setPotencia(rs.getInt("potencia"));
                    aparelho.setSitio(rs.getInt("id_sitio"));
                    aparelho.setTipo(rs.getInt("tipo"));
                    resultado.add(aparelho);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro de sql! " + e.getMessage());
        } finally {
            closeConnection();
        }
        return resultado;
    }

    public AparelhoGeradorTO findById(int id) {
        String sql = "SELECT * FROM T_GL_APARELHO_GERADOR WHERE ID_FONTE = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                AparelhoGeradorTO aparelho = new AparelhoGeradorTO();
                aparelho.setId(rs.getInt("id_fonte"));
                aparelho.setPotencia(rs.getInt("potencia"));
                aparelho.setSitio(rs.getInt("id_sitio"));
                aparelho.setTipo(rs.getInt("tipo"));
                return aparelho;
            }
        } catch (SQLException e) {
            System.out.println("Erro de sql! " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public AparelhoGeradorTO save(AparelhoGeradorTO aparelho) {
        String sql = "INSERT INTO T_GL_APARELHO_GERADOR(POTENCIA, TIPO, ID_SITIO) VALUES (?, ?, ?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setInt(1, aparelho.getPotencia());
            ps.setInt(2, aparelho.getTipo());
            ps.setInt(3, aparelho.getSitio());
            if (ps.executeUpdate() > 0) {
                return aparelho;
            }
        } catch (SQLException e) {
            System.out.println("Erro de sql! " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM T_GL_APARELHO_GERADOR WHERE ID_FONTE = ?";
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

    public AparelhoGeradorTO update(AparelhoGeradorTO aparelho) {
        String sql = "UPDATE T_GL_APARELHO_GERADOR SET POTENCIA = ?, ID_SITIO = ?, TIPO = ? WHERE ID_FONTE = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setInt(1, aparelho.getPotencia());
            ps.setInt(2, aparelho.getSitio());
            ps.setInt(3, aparelho.getTipo());
            ps.setInt(4, aparelho.getId());
            if (ps.executeUpdate() > 0) {
                return aparelho;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao editar: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }
}