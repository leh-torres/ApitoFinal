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
    private int id;
    private int result;

    public UsuarioDAO(){
        conn = data.getConnection();
    }
    
    public boolean login(String txtlogin, String pass_senha){
        
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

    public boolean adicionaImagemUsuario(File imagem, int id) throws FileNotFoundException{
        
        FileInputStream file = null;
        
        String SQL = "UPDATE usuario SET imagem_user=? WHERE id_user=?";
        try {
            file = new FileInputStream(imagem);
            pst = (PreparedStatement)conn.prepareStatement(SQL);
            pst.setBinaryStream(1,(InputStream)file,(int)(imagem.length()));
            pst.setString(2,Integer.toString(id));
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
