package br.com.fiap.DAO;
import br.com.fiap.connection.ConnectionFactory;
import br.com.fiap.model.Usuario;

import javax.management.StringValueExp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    private Connection conexao;

    public UsuarioDAO() {
        this.conexao = new ConnectionFactory().conectar();
    }

    public void insert(Usuario usuario) throws SQLException {
        try {
            String sql = "INSERT INTO USUARIOS(nome, email, senha, dt_registro) VALUES (?,?,?,?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());
            stmt.setDate(4, usuario.getData());

            stmt.execute();
            stmt.close();
        } catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    public void update(Usuario usuario) throws SQLException {
        String sql = "UPDATE USUARIOS SET nome=?, email=?, senha=? WHERE id_usuario=?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, usuario.getNome());
        stmt.setString(2, usuario.getEmail());
        stmt.setString(3, usuario.getSenha());
        stmt.setInt(4, usuario.getId());

        stmt.execute();
        stmt.close();
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM USUARIOS WHERE id_usuario=?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, String.valueOf(id));

        stmt.execute();
        stmt.close();
    }

    public List<Usuario> select() throws SQLException {
        List<Usuario> usuarios = new ArrayList<Usuario>();
        String sql = "SELECT * FROM USUARIOS";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Usuario user = new Usuario();
            user.setId(rs.getInt("id_usuario"));
            user.setNome(rs.getString("nome"));
            user.setEmail(rs.getString("email"));
            user.setSenha(rs.getString("senha"));
            user.setData(rs.getDate("dt_registro"));

            usuarios.add(user);
        }

        rs.close();
        stmt.close();
        return usuarios;
    }

    public Usuario selectById(int id) throws SQLException {
        Usuario user = null;
        String sql = "SELECT * FROM USUARIOS WHERE id_usuario=?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        while(rs.next()) {
            user = new Usuario();
            user.setId(rs.getInt("id_usuario"));
            user.setNome(rs.getString("nome"));
            user.setEmail(rs.getString("email"));
            user.setSenha(rs.getString("senha"));
            user.setData(rs.getDate("dt_registro"));
        }
        rs.close();
        stmt.close();
        return user;
    }
}
