package classes;

import java.sql.Blob;

public class Usuario {
    private static int id_user;
    private String nome_user;
    private String sobrenome_user;
    private String email_user;
    private String senha_user;
    private Blob imagem_user;

    public Usuario(){
    
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getNome_user() {
        return nome_user;
    }

    public void setNome_user(String nome_user) {
        this.nome_user = nome_user;
    }

    public String getSobrenome_user() {
        return sobrenome_user;
    }

    public void setSobrenome_user(String sobrenome_user) {
        this.sobrenome_user = sobrenome_user;
    }

    public String getEmail_user() {
        return email_user;
    }

    public void setEmail_user(String email_user) {
        this.email_user = email_user;
    }

    public String getSenha_user() {
        return senha_user;
    }

    public void setSenha_user(String senha_user) {
        this.senha_user = senha_user;
    }

    public Blob getImagem_user() {
        return imagem_user;
    }

    public void setImagem_user(Blob imagem_user) {
        this.imagem_user = imagem_user;
    }
    
    
}
