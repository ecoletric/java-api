package com.genlight.dao;

import com.genlight.to.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public ArrayList<SitioTO> findAllByIdIndustria(int idIndustria) {
        ArrayList<SitioTO> resultado = new ArrayList<>();
        String sql = "SELECT * FROM T_GL_SITIO where ID_INDUSTRIA = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setInt(1, idIndustria);
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
                sitio.setConsumo(findConsumption(sitio.getId()));
                sitio.setEnergiaProduzida(findSumEnergy(sitio.getId()));
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

    private Double findConsumption(int id){
        String sql = "select sum(m.CONSUMO) as consumo_total from T_GL_MAQUINA m inner join T_GL_SITIO s on m" +
                ".ID_SITIO = s.ID_SITIO " +
                "where m.ID_SITIO = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                return rs.getDouble("consumo_total");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar valor total de consumo: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }
    private Double findSumEnergy(int id){
        String sql = "select sum(ag.POTENCIA) as consumo_total from T_GL_APARELHO_GERADOR ag inner join T_GL_SITIO s " +
                "on ag" +
                ".ID_SITIO = s.ID_SITIO " +
                "where ag.ID_SITIO = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                return rs.getDouble("consumo_total");
            }
        }catch (SQLException e){
            System.out.println("Erro ao consultar valor total de potência energética: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }


    public ArrayList<List<Integer>> equipamentsToDelete(int idSitio){
        ArrayList<List<Integer>> equipaments = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            String sql;
            if (i == 0){
                sql = "select ID_MAQUINA from T_GL_MAQUINA where ID_SITIO = ?";
                try(PreparedStatement ps = getConnection().prepareStatement(sql)){
                    ps.setInt(1, idSitio);
                    ResultSet rs = ps.executeQuery();
                    if (rs != null){
                        while (rs.next()){
                            List<Integer> result = new ArrayList<>();
                            result.add(rs.getInt(1));
                            result.add(1);
                            equipaments.add(result);
                        }
                    }
                } catch (SQLException e){
                    System.out.println("Erro ao selecionar ids de maquina: " + e.getMessage());
                } finally {
                    closeConnection();
                }
            }
            else{
                sql = "select ID_FONTE from T_GL_APARELHO_GERADOR where ID_SITIO = ?";
                try(PreparedStatement ps = getConnection().prepareStatement(sql)){
                    ps.setInt(1, idSitio);
                    ResultSet rs = ps.executeQuery();
                    if (rs != null){
                        while (rs.next()){
                            List<Integer> result = new ArrayList<>();
                            result.add(rs.getInt(1));
                            result.add(2);
                            equipaments.add(result);
                        }
                    }
                } catch (SQLException e){
                    System.out.println("Erro ao selecionar ids de aparelho-gerador: " + e.getMessage());
                } finally {
                    closeConnection();
                }
            }

        }
        return equipaments;

    }

//    public void isSitioTipoFonteCorrect(int idSitio) throws SitioInvalidoException {
//        String sql = "select TP_FONTE from T_GL_SITIO where ID_SITIO = ?";
//        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
//            ps.setInt(1, idSitio);
//            ResultSet rs = ps.executeQuery();
//            int tipo = rs.getInt(1);
//            if (tipo != 0){
//                throw new SitioInvalidoException("Sitio requisitado é de :" + TipoEnergia.fromValor(tipo));
//            }
//        } catch (SQLException e){
//            System.out.println("Erro de sql: " + e.getMessage());
//        } finally {
//            closeConnection();
//        }
//    }
    public static void isSitioTipoFonteCorrect(int idSitio, int tipoAparelho) throws SitioInvalidoException {
        SitioTO sitio = new SitioDAO().findById(idSitio);
        int tipoSitio = sitio.getTipoFonte();
        if (tipoAparelho != tipoSitio){
            throw new SitioInvalidoException("Aparelho do tipo " + TipoEnergia.fromValor(tipoAparelho) + " não pode " +
                    "ser cadastrado no sítio de: " + TipoEnergia.fromValor(tipoSitio));
        }
    }
}