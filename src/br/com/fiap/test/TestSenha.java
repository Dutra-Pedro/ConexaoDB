package br.com.fiap.test;

import br.com.fiap.model.Usuario;
import br.com.fiap.util.CriptografiaUtils;

public class TestSenha {
    public static void main(String[] args) throws Exception {
        try{
            Usuario a = new Usuario("a", "a@a.a","123456Pedro");
            System.out.println("Senha sem: "+a.getSenha());
            System.out.println(CriptografiaUtils.criptografar(a.getSenha()));
        } catch (Exception ex){
            ex.printStackTrace();
        }

    }
}