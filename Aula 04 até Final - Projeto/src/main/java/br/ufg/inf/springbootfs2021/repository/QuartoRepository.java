package br.ufg.inf.springbootfs2021.repository;

import br.ufg.inf.springbootfs2021.entities.Hotel;
import br.ufg.inf.springbootfs2021.entities.Quarto;
import br.ufg.inf.springbootfs2021.enums.CategoriaQuarto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuartoRepository extends JpaRepository<Quarto, Integer> {

    @Query("SELECT q FROM Quarto q Where q.categoriaQuarto = :categoria")
    public List<Quarto> findByCategoriaQuarto(@Param("categoria")CategoriaQuarto categoria);

    @Query("SELECT q FROM Quarto q WHERE q.qtdLeito = :qtd")
    public List<Quarto> findByQtdLeito(@Param("qtd") Integer qtd);

    @Query("SELECT q FROM Quarto q WHERE q.nrQuarto = :numeroQuarto")
    public List<Quarto> findByNumeroQuarto(@Param("numeroQuarto") Integer numeroQuarto);

    @Query("SELECT q FROM Quarto q WHERE q.prDiaria = :precoDiaria")
    public List<Quarto> findByPrecoDiaria(@Param("precoDiaria") Double precoDiaria);

    @Query("SELECT q FROM Quarto q WHERE q.prDiaria >= :precoMinimo AND q.prDiaria <= :precoMaximo")
    public List<Quarto> findByIntervaloPrecoDiaria(@Param("precoMinimo") Double precoMinimo, @Param("precoMaximo") Double precoMaximo);

    @Query("SELECT q FROM Quarto q WHERE q.hotel = :hotel")
    public List<Quarto> findByIdHotel(@Param("hotel") Hotel hotel);
}
