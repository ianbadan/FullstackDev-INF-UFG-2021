package br.ufg.inf.springbootfs2021.repository;

import br.ufg.inf.springbootfs2021.entities.Hotel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {

    @Query("SELECT h from Hotel h WHERE h.nmHotel LIKE %:str%")
    public List<Hotel> findByNomeHotel(@Param("str")String str);

    @Query("SELECT h FROM Hotel h WHERE h.qtdEstrelas = :qtd")
    public List<Hotel> findByQtdEstrelas(@Param("qtd") Integer qtd);

    @Query("SELECT h FROM Hotel h WHERE h.enderecoHotel LIKE %:str%")
    public List<Hotel> findByEnderecoHotel(@Param("str") String str);

}
