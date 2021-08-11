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
public class CampeonatoDAO {
    
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet ps = null;
    DataSource data = new DataSource();
    
    public boolean verificaCampeonato(String email, String senha){
        conn = data.getConnection();
        
        String SQL = "SELECT * FROM competicao WHERE EXISTS(SELECT id_user FROM usuario WHERE email_user=? and senha_user=?)=fk_usuario";
        try {
            pst = (PreparedStatement)conn.prepareStatement(SQL);
            pst.setString(1, email);
            pst.setString(2, senha);
            ps = pst.executeQuery();
            
            if(ps.next()){
                data.closeDataSource();
                return true;
            }
            else{
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return false;
    }    
    
}
