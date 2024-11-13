package com.genlight.dao;

import com.genlight.to.EnderecoTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EnderecoDAO extends Repository {
    public ArrayList<EnderecoTO> findAll() {
        ArrayList<EnderecoTO> resultado = new ArrayList<>();
        String sql = "SELECT * FROM T_GL_ENDERECO";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    EnderecoTO endereco = new EnderecoTO();
                    endereco.setId(rs.getInt("id_endereco"));
                    endereco.setCep(rs.getString("cep"));
                    endereco.setLogradouro(rs.getString("nm_logradouro"));
                    endereco.setComplemento(rs.getString("ds_complemento"));
                    endereco.setCidade(rs.getString("cidade"));
                    endereco.setBairro(rs.getString("bairro"));
                    endereco.setCep(rs.getString("cep"));
                    endereco.setUf(rs.getString("uf"));
                    resultado.add(endereco);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro de sql! " + e.getMessage());
        } finally {
            closeConnection();
        }
        return resultado;
    }

    public EnderecoTO findById(int id) {
        String sql = "SELECT * FROM T_GL_ENDERECO WHERE id_endereco = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                EnderecoTO endereco = new EnderecoTO();
                endereco.setId(rs.getInt("id_endereco"));
                endereco.setCep(rs.getString("cep"));
                endereco.setLogradouro(rs.getString("nm_logradouro"));
                endereco.setComplemento(rs.getString("ds_complemento"));
                endereco.setCidade(rs.getString("cidade"));
                endereco.setBairro(rs.getString("bairro"));
                endereco.setCep(rs.getString("cep"));
                endereco.setUf(rs.getString("uf"));
                return endereco;
            }
        } catch (SQLException e) {
            System.out.println("Erro de sql! " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public EnderecoTO save(EnderecoTO endereco) {
        String sql = "INSERT INTO T_GL_ENDERECO(CEP, NM_LOGRADOURO, CIDADE, BAIRRO, UF, NR_LOGRADOURO, " +
                "DS_COMPLEMENTO) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql, new String[]{"ID_ENDERECO"})) {
            ps.setString(1, endereco.getCep());
            ps.setString(2, endereco.getLogradouro());
            ps.setString(3, endereco.getCidade());
            ps.setString(4, endereco.getBairro());
            ps.setString(5, endereco.getUf());
            ps.setString(6, endereco.getNumeroLogradouro());
            ps.setString(7, endereco.getComplemento());

            if (ps.executeUpdate() > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        endereco.setId(rs.getInt(1));
                    }
                }
                return endereco;
            }
        } catch (SQLException e) {
            System.out.println("Erro de sql! " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM T_GL_ENDERECO WHERE ID_ENDERECO = ?";
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

    public EnderecoTO update(EnderecoTO endereco) {
        String sql = "UPDATE T_GL_ENDERECO SET CEP = ?, NM_LOGRADOURO = ?, DS_COMPLEMENTO = ?, BAIRRO = ?, CIDADE = " +
                "?, UF = ?, NR_LOGRADOURO = ?" +
                " WHERE " +
                "ID_ENDERECO = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, endereco.getCep());
            ps.setString(2, endereco.getLogradouro());
            ps.setString(3, endereco.getComplemento());
            ps.setString(4, endereco.getBairro());
            ps.setString(5, endereco.getCidade());
            ps.setString(6, endereco.getUf());
            ps.setString(7, endereco.getNumeroLogradouro());
            ps.setInt(8, endereco.getId());
            if (ps.executeUpdate() > 0) {
                return endereco;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao editar: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }
}