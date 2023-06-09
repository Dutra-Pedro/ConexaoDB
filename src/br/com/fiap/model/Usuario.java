package br.com.fiap.model;
import br.com.fiap.util.CriptografiaUtils;

import java.sql.Date;

/* JAVABEAN
* classe com apenas atributos construtores e getters/setters (serve de objeto para persistir no db) */
public class Usuario {
    private int id;
    private String nome;
    private String email;
    private String senha;
    private Date data = new Date(System.currentTimeMillis());

    public Usuario(){}

    public Usuario(String nome, String email, String senha) {
        setNome(nome);
        setEmail(email);
        setSenha(senha);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
        try {
            this.senha = CriptografiaUtils.criptografar(senha);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
