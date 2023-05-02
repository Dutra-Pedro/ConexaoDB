package br.com.fiap.DAO;
import br.com.fiap.connection.ConnectionFactory;
import br.com.fiap.model.Usuario;

import javax.management.StringValueExp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioDAO {
    private Connection conexao;

    public UsuarioDAO() {
        this.conexao = new ConnectionFactory().conectar();
    }

    public void insert(Usuario usuario) throws SQLException {
        try {
            String sql = "INSERT INTO USUARIO(id_usuario, nome, email, senha, dt_registro) VALUES (?,?,?,?,?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, usuario.getId());
            stmt.setString(2, usuario.getNome());
            stmt.setString(3, usuario.getEmail());
            stmt.setString(4, usuario.getSenha());
            stmt.setDate(5, usuario.getData());

            stmt.execute();
            stmt.close();
        } catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    public void update(Usuario usuario) throws SQLException {
        String sql = "UPDATE USUARIO SET nome=?, email=?, senha=? WHERE id_usuario=?";
        try{
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());
            stmt.setInt(4,usuario.getId());

            stmt.execute();
            stmt.close();
        } catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    public void delete(int id) throws SQLException{
        String sql = "DELETE FROM USUARIO WHERE id_usuario=?";
        try{
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, String.valueOf(id));

            stmt.execute();
            stmt.close();
        } catch (SQLException ex){
            throw new RuntimeException(ex);
        }
    }
}
