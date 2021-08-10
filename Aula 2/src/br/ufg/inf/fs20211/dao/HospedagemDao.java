package br.ufg.inf.fs20211.dao;

import br.ufg.inf.fs20211.entities.Hospedagem;
import br.ufg.inf.fs20211.entities.Hospede;
import br.ufg.inf.fs20211.entities.Quarto;
import br.ufg.inf.fs20211.exceptions.HospedagemException;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HospedagemDao {
    Connection conn = null;

    public HospedagemDao(Connection conn) {
        this.conn = conn;
    }

    public List<Hospedagem> findAll()  throws HospedagemException {
        List<Hospedagem> retorno = new ArrayList<Hospedagem>();
        ResultSet rs = null;
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("" +
                    "SELECT * FROM tb_Hospedagem");
            rs = st.executeQuery();
            while(rs.next()){
                Hospedagem hospedagem = new Hospedagem(
                        rs.getInt("id_hospedagem"),
                        new Quarto(rs.getInt("id_quarto"), null, null, null, null, null),
                        new Hospede(rs.getInt("id_hospede"), null, null, null),
                        rs.getDate("dt_checkin").toLocalDate(),
                        rs.getDate("dt_checkout").toLocalDate());
                retorno.add(hospedagem);
            }
        }catch (SQLException e){
            throw new HospedagemException("Erro no banco de dados: " + e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }

        return retorno;
    }

    public Hospedagem findById(Integer id) throws HospedagemException{
        Hospedagem retorno = new Hospedagem();
        ResultSet rs = null;
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement("" +
                    "Select * " +
                    "FROM tb_hospedagem " +
                    "WHERE id_hospedagem = ? ");
            st.setInt(1, id);
            rs = st.executeQuery();
            if(rs.next()){
                retorno = new Hospedagem(
                        rs.getInt("id_hospedagem"),
                        new Quarto(rs.getInt("id_quarto"), null, null, null, null, null),
                        new Hospede(rs.getInt("id_hospede"), null, null, null),
                        rs.getDate("dt_checkin").toLocalDate(),
                        rs.getDate("dt_checkout").toLocalDate());
            }
        } catch (SQLException e){
            throw new HospedagemException("Erro no banco de dados: " + e.getMessage());
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }
        return retorno;
    }

    public Hospedagem insert(Hospedagem hospedagem) throws  HospedagemException{
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement("" +
                    "INSERT INTO tb_hospedagem " +
                    "(id_quarto, id_hospede, dt_checkin, dt_checkout) " +
                    "VALUES ( ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            st.setInt(1, hospedagem.getQuarto().getIdQuarto());
            st.setInt(2, hospedagem.getHospede().getIdHospede());
            st.setDate(3, java.sql.Date.valueOf(hospedagem.getDtCheckin()));
            st.setDate(4, java.sql.Date.valueOf(hospedagem.getDtCheckout()));
            int rowsAffected = st.executeUpdate();
            if(rowsAffected > 0){
                ResultSet rs = st.getGeneratedKeys();
                if(rs.next()){ hospedagem.setIdHospedagem(rs.getInt(1));}
                else{ throw new HospedagemException("Ação inesperada! Nenhuma linha foi inserida");}
            }
        } catch (SQLException e){
            throw new HospedagemException("Erro no banco de dados: " + e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
        return hospedagem;
    }

    public Hospedagem update(Hospedagem hospedagem) throws HospedagemException{
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("" +
                    "UPDATE tb_hospedagem " +
                    "SET id_quarto = ?, id_hospede = ?, dt_checkin = ?, dt_checkout = ?" +
                    "WHERE id_hospedagem = ?");
            st.setInt(1, hospedagem.getQuarto().getIdQuarto());
            st.setInt(2, hospedagem.getHospede().getIdHospede());
            st.setDate(3, java.sql.Date.valueOf(hospedagem.getDtCheckin()));
            st.setDate(4, java.sql.Date.valueOf(hospedagem.getDtCheckout()));
            st.setInt(5, hospedagem.getIdHospedagem());
            st.executeUpdate();
        } catch (SQLException e){
            throw new HospedagemException("Erro no banco de dados: " + e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
        return hospedagem;
    }

    public void delete(Integer id) throws HospedagemException{
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement("" +
                    "DELETE FROM tb_hospedagem where id_hospedagem = ?");
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e){
            throw new HospedagemException("Erro no banco de dados: " + e.getMessage());
        }
    }
}

