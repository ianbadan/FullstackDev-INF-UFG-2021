package br.ufg.inf.springbootfs2021.repository;

import br.ufg.inf.springbootfs2021.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface HotelRepository extends JpaRepository<Hotel, Integer> {
}
