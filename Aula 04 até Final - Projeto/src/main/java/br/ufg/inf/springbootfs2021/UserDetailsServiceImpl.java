package br.ufg.inf.springbootfs2021;

import br.ufg.inf.springbootfs2021.entities.Usuario;
import br.ufg.inf.springbootfs2021.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = repository.findByLogin(username);
        if(usuario == null) {
            throw new UsernameNotFoundException("Usuário não encontrado");
        }
        return new UserDetailsImpl(usuario);
    }

}

