package br.ufg.inf.fs20211.dao;

import br.ufg.inf.fs20211.entities.Hotel;
import br.ufg.inf.fs20211.entities.Quarto;
import br.ufg.inf.fs20211.enums.CategoriaQuarto;
import br.ufg.inf.fs20211.exceptions.QuartoException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuartoDao {
    Connection conn = null;

    public QuartoDao(Connection conn){
        this.conn = conn;
    }

    public List<Quarto> findAll() throws QuartoException{
        List<Quarto> retorno = new ArrayList<Quarto>();
        ResultSet rs = null;
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement("" +
                    "SELECT * " +
                    "FROM tb_quarto");
            rs = st.executeQuery();
            while(rs.next()){
                Quarto quarto = new Quarto(
                        rs.getInt("id_quarto"),
                        new Hotel(rs.getInt("id_hotel"), null, null, null),
                        CategoriaQuarto.get(rs.getInt("categoria_quarto")),
                        rs.getInt("qtd_leito"),
                        rs.getInt("nr_quarto"),
                        rs.getDouble("preco_diaria"));
                retorno.add(quarto);
            }
        } catch (SQLException e){
            throw new QuartoException("Erro no banco de dados: " + e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
        return retorno;
    }

    public Quarto findById( Integer id) throws QuartoException{
        Quarto retorno = new Quarto();
        ResultSet rs = null;
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement("" +
                    "SELECT * " +
                    "FROM tb_quarto " +
                    "WHERE id_quarto = ?");
            st.setInt(1, id);
            rs = st.executeQuery();
            if(rs.next()){
                retorno = new Quarto(
                        rs.getInt("id_quarto"),
                        new Hotel(rs.getInt("id_hotel"), null, null, null),
                        CategoriaQuarto.get(rs.getInt("categoria_quarto")),
                        rs.getInt("qtd_leito"),
                        rs.getInt("nr_quarto"),
                        rs.getDouble("preco_diaria")
                );
            } else{
                System.out.println("*** NÃO ENCONTROU O ID ***");
            }
        } catch (SQLException e){
            throw new QuartoException("Erro no banco de dados: " + e.getMessage());
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }
        return retorno;
    }

    public Quarto insert(Quarto quarto) throws QuartoException{
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement("" +
                    "INSERT INTO tb_quarto " +
                    "(id_hotel, categoria_quarto, qtd_leito, nr_quarto, preco_diaria) " +
                    "VALUES (?, ?, ? ,?, ?)", Statement.RETURN_GENERATED_KEYS);
            st.setInt(1, quarto.getHotel().getIdHotel());
            st.setInt(2, quarto.getCategoriaQuarto().getId());
            st.setInt(3, quarto.getQtdLeito());
            st.setInt(4, quarto.getNrQuarto());
            st.setDouble(5,quarto.getPrDiaria());
            int rows_affected = st.executeUpdate();
            if(rows_affected > 0){
                ResultSet rs = st.getGeneratedKeys();
                if(rs.next()){ quarto.setIdQuarto(rs.getInt(1));}
                else{ throw new QuartoException("Ação inesperada!! Nenhuma linha foi adicionada");}
            }
        } catch (SQLException e){
            throw new QuartoException("Erro no banco de dados: " + e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
        return quarto;
    }

    public  Quarto update(Quarto quarto) throws  QuartoException{
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement("" +
                    "UPDATE tb_quarto " +
                    "SET id_hotel = ?, categoria_quarto = ?, qtd_leito = ?, nr_quarto = ?, preco_diaria = ? " +
                    "WHERE id_quarto = ? ");
            st.setInt(1, quarto.getHotel().getIdHotel());
            st.setInt(2, quarto.getCategoriaQuarto().getId());
            st.setInt(3, quarto.getQtdLeito());
            st.setInt(4, quarto.getNrQuarto());
            st.setDouble(5, quarto.getPrDiaria());
            st.setInt(6, quarto.getIdQuarto());
            st.executeUpdate();
        } catch (SQLException e){
            throw new QuartoException("Erro no banco de dados: " + e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
        return quarto;
    }

    public void delete(Integer id) throws QuartoException{
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("" +
                    "DELETE FROM tb_quarto WHERE id_quarto = ? ");
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e){
            throw new QuartoException("Erro no banco de dados: " + e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }


}
