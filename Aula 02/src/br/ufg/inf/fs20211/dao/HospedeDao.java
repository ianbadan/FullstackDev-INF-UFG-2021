package br.ufg.inf.fs20211.dao;

import br.ufg.inf.fs20211.entities.Hospede;

import br.ufg.inf.fs20211.exceptions.HospedeException;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class HospedeDao {
    Connection conn = null;

    public HospedeDao(Connection conn) {
        this.conn = conn;
    }

    public List<Hospede> findAll()  throws HospedeException{
        List<Hospede> retorno = new ArrayList<Hospede>();
        ResultSet rs = null;
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("" +
                    "SELECT * FROM tb_hospede");
            rs = st.executeQuery();
            while(rs.next()){

                Hospede hospede = new Hospede(
                        rs.getInt("id_hospede"),
                        rs.getString("nm_hospede"),
                        rs.getDate("dt_nascimento").toLocalDate(),
                        rs.getString("cpf"));
                retorno.add(hospede);
            }
        }catch (SQLException e){
            throw new HospedeException("Erro no banco de dados: " + e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }

        return retorno;
    }

    public Hospede findById(Integer id) throws HospedeException{
        Hospede retorno = new Hospede();
        ResultSet rs = null;
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement("" +
                    "Select * " +
                    "FROM tb_hospede " +
                    "WHERE id_hospede = ?");
            st.setInt(1, id);
            rs = st.executeQuery();
            if(rs.next()){
                retorno = new Hospede(
                        rs.getInt("id_hospede"),
                        rs.getString("nm_hospede"),
                        rs.getDate("dt_nascimento").toLocalDate(),
                        rs.getString("cpf"));
            }
        } catch (SQLException e){
            throw new HospedeException("Erro no banco de dados: " + e.getMessage());
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }
        return retorno;
    }

    public Hospede insert(Hospede hospede) throws  HospedeException{
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement("" +
                    "INSERT INTO tb_hospede " +
                    "(nm_hospede, dt_nascimento, cpf) " +
                    "VALUES ( ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            st.setString(1, hospede.getNomeHospede());
            st.setDate(2, java.sql.Date.valueOf(hospede.getDtNascimento()));
            st.setString(3, hospede.getCpf());
            int rowsAffected = st.executeUpdate();
            if(rowsAffected > 0){
                ResultSet rs = st.getGeneratedKeys();
                if(rs.next()){ hospede.setIdHospede(rs.getInt(1));}
                else{ throw new HospedeException("Ação inesperada! Nenhuma linha foi inserida");}
            }
        } catch (SQLException e){
            throw new HospedeException("Erro no banco de dados: " + e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
        return hospede;
    }

    public Hospede update(Hospede hospede) throws HospedeException{
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("" +
                    "UPDATE tb_hospede " +
                    "SET nm_hospede = ?, dt_nascimento = ?, cpf = ? " +
                    "WHERE id_hospede = ?");
            st.setString(1, hospede.getNomeHospede());
            st.setDate(2, java.sql.Date.valueOf(hospede.getDtNascimento()));
            st.setString(3, hospede.getCpf());
            st.setInt(4, hospede.getIdHospede());
            st.executeUpdate();
        } catch (SQLException e){
            throw new HospedeException("Erro no banco de dados: " + e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
        return hospede;
    }

    public void delete(Integer id) throws HospedeException{
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement("" +
                    "DELETE FROM tb_hospede where id_hospede = ?");
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e){
            throw new HospedeException("Erro no banco de dados: " + e.getMessage());
        }
    }
}
