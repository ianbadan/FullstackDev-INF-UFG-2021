package br.ufg.inf.springbootfs2021.repository;

import br.ufg.inf.springbootfs2021.entities.Hospede;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface HospedeRepository extends JpaRepository<Hospede, Integer> {

    @Query("SELECT h from Hospede h WHERE h.nomeHospede LIKE %:str%")
    public List<Hospede> findByNomeHospede(@Param("str") String str);

    @Query("SELECT h from Hospede h WHERE h.dtNascimento = :date")
    public List<Hospede> findByDtNascimento(@Param("date")LocalDate date);

    @Query("SELECT h FROM Hospede h WHERE h.cpf LIKE %:str%")
    public List<Hospede> findByCPF(@Param("str") String str);
}
