package br.com.fiap.model;

import java.sql.Date;

public class Usuario {
    private long id;
    private String nome;
    private String email;
    private String senha;
    private Date data;

    public Usuario(long id, String nome, String email, String senha, Date data) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.data = data;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
