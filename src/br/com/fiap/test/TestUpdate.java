package br.com.fiap.test;

import br.com.fiap.DAO.UsuarioDAO;
import br.com.fiap.connection.ConnectionFactory;
import br.com.fiap.model.Usuario;

import java.sql.SQLException;

public class TestUpdate {
    public static void main(String[] args) throws SQLException {
        UsuarioDAO dao = new UsuarioDAO();
        Usuario user = new Usuario(3,"Rafaela","rafinha@gmail.com","54321");

        dao.update(user);
    }
}
