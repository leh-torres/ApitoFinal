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

/**
 *
 * @author rayla
 */
public class BarraDeMenu {
    
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet ps = null;
    DataSource data = new DataSource();
    private static int id;
    private static String nome;
    private static byte[] imagem;
    
    public void logoNomeUsuario(String txtlogin, String pass_senha){
        conn = data.getConnection();
        
        String SQL = "SELECT * FROM usuario WHERE email_user=? and senha_user=?";
        try {
            pst = (PreparedStatement)conn.prepareStatement(SQL);
            pst.setString(1, txtlogin);
            pst.setString(2, pass_senha);
            ps = pst.executeQuery();
            
            if(ps.next()){
                id = ps.getInt("id_user");
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
        
        conn = data.getConnection();
        
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
                imagem = ps.getBytes("imagem__user");
                data.closeDataSource();
                return imagem;
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
