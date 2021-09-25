package br.ufg.inf.springbootfs2021.repository;

import br.ufg.inf.springbootfs2021.entities.Hospedagem;
import br.ufg.inf.springbootfs2021.entities.Hospede;
import br.ufg.inf.springbootfs2021.entities.Quarto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface HospedagemRepository extends JpaRepository<Hospedagem, Integer> {

    @Query("SELECT h from Hospedagem h WHERE h.quarto = :quarto")
    public List<Hospedagem> findByIdQuarto(@Param("quarto")Quarto quarto);

    @Query("SELECT h from Hospedagem h WHERE h.hospede = :hospede")
    public List<Hospedagem> findByIdHospede(@Param("hospede")Hospede hospede);

    @Query("SELECT h from Hospedagem h WHERE h.dtCheckin = :date")
    public List<Hospedagem> findByDataCheckin(@Param("date")LocalDate date);

    @Query("SELECT h from Hospedagem h WHERE h.dtCheckout = :date")
    public List<Hospedagem> findByDataCheckout(@Param("date") LocalDate date);
}
