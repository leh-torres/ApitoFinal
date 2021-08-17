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

    public BarraDeMenuDAO(){
        conn = data.getConnection();
    }
    
    public void logoNomeUsuario(String txtlogin, String pass_senha){
        
        String SQL = "SELECT * FROM usuario WHERE email_user=? and senha_user=?";
        try {
            pst = (PreparedStatement)conn.prepareStatement(SQL);
            pst.setString(1, txtlogin);
            pst.setString(2, pass_senha);
            ps = pst.executeQuery();
            
            if(ps.next()){
                data.closeDataSource();
                id = ps.getInt("id_user");
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
                data.closeDataSource();
                nome = ps.getString("nome_user");
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
