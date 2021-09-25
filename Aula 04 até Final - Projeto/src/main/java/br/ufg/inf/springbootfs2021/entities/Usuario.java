package br.ufg.inf.springbootfs2021.entities;

import javax.persistence.*;

import java.util.List;

@Entity
public class Usuario {
    private static final long serialVersionUID = 1L;

    @Id
    private String login;

    private String nome;

    private String senha;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="usuario_regra",
            joinColumns =  @JoinColumn(name="login", referencedColumnName = "login"),
            inverseJoinColumns = @JoinColumn(name="regra", referencedColumnName = "regra")
    )
    private List<Regra> regras;


    public Usuario() {
        super();
    }
    public Usuario(String login, String nome, String senha,List<Regra> regras) {
        super();
        this.login = login;
        this.nome = nome;
        this.senha = senha;
        this.regras = regras;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Regra> getRegras() {
        return regras;
    }

    public void setRegras(List<Regra> regras) {
        this.regras = regras;
    }

    @Override
    public String toString() {
        return "Nome: " + this.nome + " Login: " + this.login + " Senha: " + this.senha + " Regras: " + regras.get(0);
    }
}
