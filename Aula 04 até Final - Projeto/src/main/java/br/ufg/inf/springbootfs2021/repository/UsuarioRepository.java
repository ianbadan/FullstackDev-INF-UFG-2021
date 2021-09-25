package br.ufg.inf.springbootfs2021.repository;

import br.ufg.inf.springbootfs2021.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

    public Usuario findByLogin(String login);
}
