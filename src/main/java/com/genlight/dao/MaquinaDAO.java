package com.genlight.dao;

import com.genlight.to.MaquinaTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MaquinaDAO extends Repository{
    public ArrayList<MaquinaTO> findAll(){
        ArrayList<MaquinaTO> resultado = new ArrayList<>();
        String sql = "SELECT * FROM T_GL_MAQUINA";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            if (rs!=null){
                while(rs.next()){
                    MaquinaTO maquina = new MaquinaTO();
                    maquina.setId(rs.getInt("id_maquina"));
                    maquina.setConsumo(rs.getInt("consumo"));
                    maquina.setNome(rs.getString("ds_maquina"));
                    maquina.setIdSitio(rs.getInt("id_sitio"));
                    resultado.add(maquina);
                }
            }
        }catch (SQLException e){
            System.out.println("Erro de sql! " + e.getMessage());
        }finally {
            closeConnection();
        }
        return resultado;
    }

    public ArrayList<MaquinaTO> findAllByIdSitio(int idSitio){
        ArrayList<MaquinaTO> resultado = new ArrayList<>();
        String sql = "SELECT * FROM T_GL_MAQUINA where ID_SITIO = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setInt(1, idSitio);
            ResultSet rs = ps.executeQuery();
            if (rs!=null){
                while(rs.next()){
                    MaquinaTO maquina = new MaquinaTO();
                    maquina.setId(rs.getInt("id_maquina"));
                    maquina.setConsumo(rs.getInt("consumo"));
                    maquina.setNome(rs.getString("ds_maquina"));
                    maquina.setIdSitio(rs.getInt("id_sitio"));
                    resultado.add(maquina);
                }
            }
        }catch (SQLException e){
            System.out.println("Erro de sql! " + e.getMessage());
        }finally {
            closeConnection();
        }
        return resultado;
    }

    public MaquinaTO findById(int id){
        String sql = "SELECT * FROM T_GL_MAQUINA where id_maquina = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                MaquinaTO maquina = new MaquinaTO();
                maquina.setId(rs.getInt("id_maquina"));
                maquina.setConsumo(rs.getInt("consumo"));
                maquina.setNome(rs.getString("ds_maquina"));
                maquina.setIdSitio(rs.getInt("id_sitio"));
                return maquina;
            }
        } catch (SQLException e) {
            System.out.println("Erro de sql! " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }


    public MaquinaTO save(MaquinaTO maquinaTO){
        String sql = "INSERT INTO T_GL_MAQUINA(CONSUMO, DS_MAQUINA, ID_SITIO) values (?, ?, ?)";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setInt(1, maquinaTO.getConsumo());
            ps.setString(2, maquinaTO.getNome());
            ps.setInt(3, maquinaTO.getIdSitio());
            if (ps.executeUpdate() > 0){
                return maquinaTO;
            }
        } catch (SQLException e) {
            System.out.println("Erro de sql! " + e.getMessage());
        }finally {
            closeConnection();
        }
        return null;
    }

    public boolean delete (int codigo){
        String sql = "delete T_GL_MAQUINA where ID_MAQUINA = ?";
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

    public MaquinaTO update(MaquinaTO maquina){
        String sql = "update T_GL_MAQUINA set CONSUMO = ?, DS_MAQUINA = ?, ID_SITIO = ? where ID_MAQUINA = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setInt(1, maquina.getConsumo());
            ps.setString(2, maquina.getNome());
            ps.setInt(3, maquina.getIdSitio());
            ps.setInt(4, maquina.getId());
            if (ps.executeUpdate() > 0){
                return maquina;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao editar: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }
}
