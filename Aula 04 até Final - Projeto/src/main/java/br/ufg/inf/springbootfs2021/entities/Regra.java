/*
ackage br.ufg.inf.springbootfs2021.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Regra implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    private String regra;

    @ManyToMany(mappedBy = "regras", fetch = FetchType.EAGER)
    private List<Usuario> usuarios;

    public Regra() {
        super();
    }

    public Regra(String regra) {
        super();
        this.regra = regra;
    }

    public String getRegra() {
        return regra;
    }

    public void setRegra(String regra) {
        this.regra = regra;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

}
 */