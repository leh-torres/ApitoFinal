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
import javax.swing.JOptionPane;

import classes.Competicao;
import classes.Usuario;
import java.io.InputStream;
import java.sql.Blob;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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
    private Blob image = null;
    private byte[] imgByte = null;

    public BarraDeMenuDAO(){
        conn = data.getConnection();
    }
    
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
    
    public Image Imagem(){
        Usuario  usu = new Usuario();
        conn = data.getConnection();
        id = usu.getId_user();
        
        String SQL = "SELECT * FROM usuario WHERE id_user=?";
        try {
            pst = (PreparedStatement)conn.prepareStatement(SQL);
            pst.setString(1, Integer.toString(id));
            ps = pst.executeQuery();
            
            if(ps.next()){
                if(ps.getBinaryStream("imagem_user") != null){
                InputStream imageFile = ps.getBinaryStream("imagem_user");
                Image image = new Image(imageFile);
                return image;
                }
                return null;
            }
            else{
                JOptionPane.showMessageDialog(null,"Não existe imagem salva");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return null;

    }
}
