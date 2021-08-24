package br.ufg.inf.springbootfs2021.repository;

import br.ufg.inf.springbootfs2021.entities.Hospedagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospedagemRepository extends JpaRepository<Hospedagem, Integer> {
}
