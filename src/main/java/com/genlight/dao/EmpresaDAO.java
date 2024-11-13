package com.genlight.dao;

import com.genlight.to.EmpresaTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmpresaDAO extends Repository{
    public ArrayList<EmpresaTO> findAll(){
        ArrayList<EmpresaTO> resultado = new ArrayList<>();
        String sql = "SELECT * FROM T_GL_EMPRESA";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            if (rs!=null){
                while(rs.next()){
                    EmpresaTO empresa = new EmpresaTO();
                    empresa.setNome(rs.getString("nm_empresa"));
                    empresa.setEmaill(rs.getString("email"));
                    empresa.setSenha(rs.getString("senha"));
                    empresa.setCnpj(rs.getString("cnpj"));
                    empresa.setIdEndereco(rs.getInt("id_endereco"));
                    empresa.setId(rs.getInt("id_empresa"));
                    resultado.add(empresa);
                }
            }
        }catch (SQLException e){
            System.out.println("Erro de sql! " + e.getMessage());
        }finally {
            closeConnection();
        }
        return resultado;
    }

    public EmpresaTO findById(int id){
        String sql = "SELECT * FROM T_GL_EMPRESA where id_empresa = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                EmpresaTO empresa = new EmpresaTO();
                empresa.setNome(rs.getString("nm_empresa"));
                empresa.setEmaill(rs.getString("email"));
                empresa.setSenha(rs.getString("senha"));
                empresa.setCnpj(rs.getString("cnpj"));
                empresa.setIdEndereco(rs.getInt("id_endereco"));
                empresa.setId(rs.getInt("id_empresa"));
                return empresa;
            }
        } catch (SQLException e) {
            System.out.println("Erro de sql! " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public EmpresaTO save(EmpresaTO empresaTO){
        String sql = "INSERT INTO T_GL_EMPRESA(NM_EMPRESA, NR_CNPJ, EMAIL, SENHA, ID_ENDERECO) values (?," +
                " ?, ?, ?, ?)";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setString(1, empresaTO.getNome());
            ps.setString(2, empresaTO.getCnpj());
            ps.setString(3, empresaTO.getEmaill());
            ps.setString(4, empresaTO.getSenha());
            ps.setInt(5, empresaTO.getIdEndereco());
            if (ps.executeUpdate() > 0){
                return empresaTO;
            }
        } catch (SQLException e) {
            System.out.println("Erro de sql! " + e.getMessage());
        }finally {
            closeConnection();
        }
        return null;
    }

    public boolean delete (int codigo){
        String sql = "delete T_GL_EMPRESA where ID_EMPRESA = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setInt(1,codigo);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao editar: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }

    public EmpresaTO update(EmpresaTO empresa){
        String sql = "update T_GL_EMPRESA set EMAIL = ?, NR_CNPJ = ?, SENHA = ?, NM_EMPRESA = ? where ID_EMPRESA = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            if (ps.executeUpdate() > 0){
                return empresa;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao editar: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }
}
