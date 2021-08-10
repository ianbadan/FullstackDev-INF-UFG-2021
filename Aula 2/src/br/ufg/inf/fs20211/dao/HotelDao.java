package br.ufg.inf.fs20211.dao;

import br.ufg.inf.fs20211.entities.Hotel;
import br.ufg.inf.fs20211.exceptions.HotelException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HotelDao {
    Connection conn;

    public HotelDao(Connection conn) {
        this.conn = conn;
    }

    public List<Hotel> findAll() throws HotelException{
        List<Hotel> retorno = new ArrayList<Hotel>();
        ResultSet rs = null;
        PreparedStatement st = null;
        try{
            String sql = "SELECT * FROM db_hotel.tb_hotel";
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()){
                Hotel hotel = new Hotel(
                        rs.getInt("id_hotel"),
                        rs.getString("nm_hotel"),
                        rs.getString("endereco"),
                        rs.getInt("qtd_estrelas"));
                retorno.add(hotel);
            }

        } catch (SQLException e){
            throw new HotelException("Erro no banco de dados" + e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
        return retorno;
    }

    public Hotel findById(Integer id) throws HotelException{
        Hotel retorno = new Hotel();
        ResultSet rs = null;
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement("SELECT * FROM db_hotel.tb_hotel WHERE id_hotel = ?");
            st.setInt(1, id);
            rs = st.executeQuery();
            if(rs.next()){
                retorno = new Hotel(
                        rs.getInt("id_hotel"),
                        rs.getString("nm_hotel"),
                        rs.getString("endereco"),
                        rs.getInt("qtd_estrelas"));
            }

        } catch (SQLException e){
            throw new HotelException("Erro no banco de dados" + e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
        return retorno;
    }

    public Hotel insert(Hotel hotel) throws HotelException{
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement(
                "INSERT INTO tb_hotel(nm_hotel, endereco, qtd_estrelas)"
                    + "VALUES(?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            st.setString(1, hotel.getNmHotel());
            st.setString(2, hotel.getEnderecoHotel());
            st.setInt(3, hotel.getQtdEstrelas());
            int rowsAffected = st.executeUpdate();
            if(rowsAffected > 0){
                ResultSet rs = st.getGeneratedKeys();
                if(rs.next()) hotel.setIdHotel(rs.getInt(1));
            }else{
             throw new HotelException("Ação inesperada! Nenhuma linha foi inserida");
            }
        } catch (SQLException e){
            throw new HotelException("Erro no banco de dados:" + e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
        return hotel;
    }

    public Hotel update(Hotel hotel) throws HotelException{
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement(" "
                    + "UPDATE tb_hotel "
                    +"SET nm_hotel = ?, endereco = ?, qtd_estrelas = ? "
                    + "WHERE id_hotel = ?");
            st.setString(1, hotel.getNmHotel());
            st.setString(2, hotel.getEnderecoHotel());
            st.setInt(3, hotel.getQtdEstrelas());
            st.setInt(4, hotel.getIdHotel());
            st.executeUpdate();
        } catch (SQLException e){
            throw new HotelException("Erro no banco de dados:" + e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
        return hotel;
    }

    public void delete(Integer id) throws HotelException{
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement("DELETE FROM tb_hotel WHERE id_hotel = ?");
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e){
            throw new HotelException("Erro no banco de dados" + e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

}
