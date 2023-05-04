package br.com.fiap.test;
import br.com.fiap.DAO.UsuarioDAO;
import br.com.fiap.connection.ConnectionFactory;
import br.com.fiap.model.Usuario;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class Test {
    public static void main(String[] args) throws SQLException {
        UsuarioDAO DAO = new UsuarioDAO();
//        Usuario user1 = new Usuario(5,"Rafaela", "rafaela@gmail.com","1235");
//        Usuario user2 = new Usuario(6,"Miguel", "miguelito@gmail.com","345");
//        Usuario user3 = new Usuario(7,"Luigi", "lulu@gmail.com","12565");
//        Usuario user4 = new Usuario(8,"Maria", "m4ria@gmail.com","4862");

//        List<Usuario> lista = new ArrayList<Usuario>();
//        lista.add(user1);
//        lista.add(user2);
//        lista.add(user3);
//        lista.add(user4);

//        for (Usuario usuario : lista){
//            DAO.insert(usuario);
//        }

//        List<Usuario> lista = DAO.select();
//        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
//        for (Usuario user : lista){
//            System.out.println("-------------------------");
//            System.out.println("ID: "+user.getId()+"\n" +
//                    "Nome: "+user.getNome()+"\n" +
//                    "Email: "+user.getEmail()+"\n" +
//                    "Senha: "+user.getSenha()+"\n" +
//                    "Data: "+sdf.format(user.getData()));
//        }

        Usuario user = DAO.selectById(5);
        System.out.println(user);
    }
}
