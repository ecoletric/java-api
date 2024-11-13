package com.genlight.dao;

import com.genlight.to.IndustriaTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class IndustriaDAO extends Repository{
    public ArrayList<IndustriaTO> findAll(){
        ArrayList<IndustriaTO> resultado = new ArrayList<>();
        String sql = "SELECT * FROM T_GL_INDUSTRIA";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            if (rs!=null){
                while(rs.next()){
                    IndustriaTO industria = new IndustriaTO();
                    industria.setId(rs.getInt("id_industria"));
                    industria.setNome(rs.getString("ds_industria"));
                    industria.setIdEmpresa(rs.getInt("id_empresa"));
                    resultado.add(industria);
                }
            }
        }catch (SQLException e){
            System.out.println("Erro de sql! " + e.getMessage());
        }finally {
            closeConnection();
        }
        return resultado;
    }

    public IndustriaTO findById(int id){
        String sql = "SELECT * FROM T_GL_INDUSTRIA where id_industria = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                IndustriaTO industria = new IndustriaTO();
                industria.setId(rs.getInt("id_industria"));
                industria.setNome(rs.getString("ds_industria"));
                industria.setIdEmpresa(rs.getInt("id_empresa"));
                return industria;
            }
        } catch (SQLException e) {
            System.out.println("Erro de sql! " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }


    public IndustriaTO save(IndustriaTO industriaTO){
        String sql = "INSERT INTO T_GL_INDUSTRIA(NM_INDUSTRIA, ID_EMPRESA) values (?, ?)";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setString(2, industriaTO.getNome());
            if (ps.executeUpdate() > 0){
                return industriaTO;
            }
        } catch (SQLException e) {
            System.out.println("Erro de sql! " + e.getMessage());
        }finally {
            closeConnection();
        }
        return null;
    }

    public boolean delete (int codigo){
        String sql = "delete T_GL_INDUSTRIA where ID_INDUSTRIA = ?";
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

    public IndustriaTO update(IndustriaTO industria){
        String sql = "update T_GL_INDUSTRIA set NM_INDUSTRIA = ? where ID_INDUSTRIA = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){

            if (ps.executeUpdate() > 0){
                return industria;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao editar: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }
}
