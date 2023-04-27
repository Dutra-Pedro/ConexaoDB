package br.com.fiap.test;
import br.com.fiap.DAO.UsuarioDAO;
import br.com.fiap.connection.ConnectionFactory;
import br.com.fiap.model.Usuario;
import java.sql.SQLException;


public class Test {
    public static void main(String[] args) throws SQLException {
        new ConnectionFactory().conectar();
        UsuarioDAO DAO = new UsuarioDAO();
        Usuario user = new Usuario(1,"Pedro", "pedro@gmail.com","12345");

        DAO.insert(user);

    }
}
