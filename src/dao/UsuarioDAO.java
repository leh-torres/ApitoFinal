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
    private int result;

    public UsuarioDAO(){
        
    }
    
    public boolean login(String txtlogin, String pass_senha){
        conn = data.getConnection();
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

    public boolean adicionaImagemUsuario(FileInputStream fis, int id) throws FileNotFoundException{
        DataSource data2 = new DataSource();
        conn = data2.getConnection();
        String SQL = "UPDATE usuario SET imagem_user=? WHERE id_user=?";
        try {
            pst = (PreparedStatement)conn.prepareStatement(SQL);
<<<<<<< HEAD
            pst.setBinaryStream(1,(InputStream)file,(int)(imagem.length()));
            pst.setString(2,Integer.toString(id));
=======
            pst.setBinaryStream(1, fis);
            pst.setInt(2,id);
>>>>>>> refs/remotes/origin/master
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
   
}
