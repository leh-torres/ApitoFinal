/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.Usuario;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.stage.FileChooser;
import javax.swing.JOptionPane;
/**
 *
 * @author raylander
 */
public class UsuarioDAO {
    
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet ps = null;
    DataSource data = new DataSource();
    private int result;

    public UsuarioDAO(){
        
    }
    
    public boolean login(String txtlogin, String pass_senha){
        DataSource data1 = new DataSource();
        conn = data1.getConnection();
        String SQL = "SELECT * FROM usuario WHERE email_user=? and senha_user=?";
        try {
            pst = (PreparedStatement)conn.prepareStatement(SQL);
            pst.setString(1, txtlogin);
            pst.setString(2, pass_senha);
            ps = pst.executeQuery();
            
            if(ps.next()){
                data.closeDataSource();
                return true;
            }
            else{
                JOptionPane.showMessageDialog(null,"Usuário ou senha inválidos");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return false;
    }


    public int getIdDoCadastro(String nome, String sobrenome){
        DataSource data1 = new DataSource();
        Connection conn1 = null;
        conn1 = data1.getConnection();

        int id = 0;
        String SQL = "SELECT id_user FROM usuario WHERE nome_user = ? AND sobrenome_user = ?";

        try {
            pst = (PreparedStatement)conn1.prepareStatement(SQL);
            pst.setString(1, nome);
            pst.setString(2, sobrenome);
            ps = pst.executeQuery();
            
            if(ps.next()){
                id = ps.getInt(1);
                data.closeDataSource();
            } else{
                JOptionPane.showMessageDialog(null, "Usuario não encontrado");
            }

            return id;
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        return 0;
    }

    public Usuario getUser(int id){
        conn = data.getConnection();

        String SQL = "SELECT * FROM usuario WHERE id_user = ?";

        try {
            pst = (PreparedStatement)conn.prepareStatement(SQL);
            pst.setInt(1, id);
            ps = pst.executeQuery();

            if(ps.next()){
                Usuario user = new Usuario();
                user.setId_user(ps.getInt("id_user"));
                user.setNome_user(ps.getString("nome_user"));
                user.setSobrenome_user(ps.getString("sobrenome_user"));
                user.setEmail_user(ps.getString("email_user"));
                user.setImagemPerfil(ps.getBlob("imagem_user"));

                data.closeDataSource();
                return user;

            }else {
                System.out.println("Não foi possível resgatar usuario");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        return null;
    }

    public boolean excluirCadastro(int id){
        DataSource data1 = new DataSource();
        conn = data1.getConnection();

        String SQL = "DELETE FROM usuario WHERE id_user = ?";

        try {
            pst = (PreparedStatement)conn.prepareStatement(SQL);
            pst.setInt(1, id);
            result = pst.executeUpdate();

            if(result == 1){
                data.closeDataSource();
            }
            return true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        return false;
    }

    public boolean atualizaNome(String nome, int id){
        DataSource data1 = new DataSource();
        conn = data1.getConnection();

        String SQL = "UPDATE usuario SET nome_user = ? WHERE id_user = ?";

        try {
            pst = (PreparedStatement)conn.prepareStatement(SQL);
            pst.setString(1, nome);
            pst.setInt(2, id);
            result = pst.executeUpdate();

            if(result == 1){
                data.closeDataSource();
                System.out.println("Nome atualizado com sucesso!");
            }
            return true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return false;
    }

    public boolean atualizaSobrenome(String sobrenome, int id){
        DataSource data1 = new DataSource();
        conn = data1.getConnection();

        String SQL = "UPDATE usuario SET sobrenome_user = ? WHERE id_user = ?";

        try {
            pst = (PreparedStatement)conn.prepareStatement(SQL);
            pst.setString(1, sobrenome);
            pst.setInt(2, id);
            result = pst.executeUpdate();

            if(result == 1){
                data.closeDataSource();
                System.out.println("Sobrenome atualizado com sucesso!");
            }
            return true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return false;
    }

    public boolean atualizaEmail(String email, int id){
        DataSource data1 = new DataSource();
        conn = data1.getConnection();

        String SQL = "UPDATE usuario SET email_user = ? WHERE id_user = ?";

        try {
            pst = (PreparedStatement)conn.prepareStatement(SQL);
            pst.setString(1, email);
            pst.setInt(2, id);
            result = pst.executeUpdate();

            if(result == 1){
                data.closeDataSource();
                System.out.println("Email atualizado com sucesso!");
            }
            return true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return false;
    }

    public boolean atualizaSenha(String senha, int id){
        DataSource data1 = new DataSource();
        conn = data1.getConnection();

        String SQL = "UPDATE usuario SET senha_user = ? WHERE id_user = ?";

        try {
            pst = (PreparedStatement)conn.prepareStatement(SQL);
            pst.setString(1, senha);
            pst.setInt(2, id);
            result = pst.executeUpdate();

            if(result == 1){
                data.closeDataSource();
                System.out.println("Senha atualizado com sucesso!");
            }
            return true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return false;
    }

    public boolean adicionaImagemUsuario(FileInputStream fis, int id) throws FileNotFoundException{
        DataSource data2 = new DataSource();
        conn = data2.getConnection();
        String SQL = "UPDATE usuario SET imagem_user=? WHERE id_user=?";
        try {
            pst = (PreparedStatement)conn.prepareStatement(SQL);
            pst.setBinaryStream(1, fis);
            pst.setInt(2,id);
            result = pst.executeUpdate();
            data.closeDataSource();
            
            if(result == 1){
                return true;
            }
            else{
                JOptionPane.showMessageDialog(null,"Imagem não cadastrada");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
        return false;
    }
}
