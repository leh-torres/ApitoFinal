/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.image.ImageView;
import javax.swing.JOptionPane;

import classes.Usuario;

/**
 *
 * @author rayla
 */
public class BarraDeMenuDAO {
    
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet ps = null;
    DataSource data = new DataSource();
    private static int id;
    private static String nome;
<<<<<<< HEAD:src/dao/BarraDeMenu.java
    private static byte[] imagem;
=======

    public BarraDeMenuDAO(){
        conn = data.getConnection();
    }
>>>>>>> e59c81ebe57c9b971f7513a262b6bc5fd645271d:src/dao/BarraDeMenuDAO.java
    
    public void logoNomeUsuario(String txtlogin, String pass_senha){
        Usuario usuario = new Usuario();
        String SQL = "SELECT * FROM usuario WHERE email_user=? and senha_user=?";
        try {
            pst = (PreparedStatement)conn.prepareStatement(SQL);
            pst.setString(1, txtlogin);
            pst.setString(2, pass_senha);
            ps = pst.executeQuery();
            
            if(ps.next()){
                id = ps.getInt("id_user");
                usuario.setId_user(id);
                data.closeDataSource();
            }
            else{
                JOptionPane.showMessageDialog(null,"Usuário ou senha inválidos");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public String Nome(){
        
        String SQL = "SELECT * FROM usuario WHERE id_user=?";
        try {
            pst = (PreparedStatement)conn.prepareStatement(SQL);
            pst.setString(1, Integer.toString(id));
            ps = pst.executeQuery();
            
            if(ps.next()){
                nome = ps.getString("nome_user");
                data.closeDataSource();
                return nome;
            }
            else{
                JOptionPane.showMessageDialog(null,"Usuário ou senha inválidos");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return null;
    }
    
    public byte[] Imagem(){
        
        conn = data.getConnection();
        
        String SQL = "SELECT * FROM usuario WHERE id_user=?";
        try {
            pst = (PreparedStatement)conn.prepareStatement(SQL);
            pst.setString(1, Integer.toString(id));
            ps = pst.executeQuery();
            
            if(ps.next()){
<<<<<<< HEAD:src/dao/BarraDeMenu.java
                imagem = ps.getBytes("imagem__user");
=======
                //imagem = (ImageView) ps.getBlob("imagem_user");
>>>>>>> e59c81ebe57c9b971f7513a262b6bc5fd645271d:src/dao/BarraDeMenuDAO.java
                data.closeDataSource();
                //return imagem;
            }
            else{
                JOptionPane.showMessageDialog(null,"Usuário ou senha inválidos");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return null;

    }
}
