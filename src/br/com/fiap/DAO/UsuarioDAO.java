package br.com.fiap.DAO;


import br.com.fiap.connection.ConnectionFactory;
import br.com.fiap.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioDAO {
    private Connection conexao;

    public UsuarioDAO(Connection conexao) {
        this.conexao = new ConnectionFactory().conectar();
    }

    public void insert(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO USUARIO (id_usuario, nome, email, senha, dt_registro) values (?,?,?,?,?)";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1,usuario.getId());
        stmt.setString(2, usuario.getNome());
        stmt.setString(3, usuario.getEmail());
        stmt.setString(4, usuario.getSenha());
        stmt.setDate(5,usuario.getData());

        stmt.execute();
        stmt.close();
    }
}
