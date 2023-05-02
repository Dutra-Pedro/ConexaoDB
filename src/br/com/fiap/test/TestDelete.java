package br.com.fiap.test;

import br.com.fiap.DAO.UsuarioDAO;
import br.com.fiap.model.Usuario;

import java.sql.SQLException;

public class TestDelete {
    public static void main(String[] args) throws SQLException {
        UsuarioDAO DAO = new UsuarioDAO();
        Usuario user = new Usuario(4,"Rafael", "rafa@gmail.com","12345");

        DAO.delete(3);
    }
}
