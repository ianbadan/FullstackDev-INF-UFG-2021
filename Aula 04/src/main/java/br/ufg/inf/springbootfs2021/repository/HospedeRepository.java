package br.ufg.inf.springbootfs2021.repository;

import br.ufg.inf.springbootfs2021.entities.Hospede;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospedeRepository extends JpaRepository<Hospede, Integer> {
}
