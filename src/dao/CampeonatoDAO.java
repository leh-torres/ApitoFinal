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
    
    public boolean verificaCampeonato(){
        conn = data.getConnection();
        
        String SQL = "SELECT * FROM competicao";
        try {
            pst = (PreparedStatement)conn.prepareStatement(SQL);
            ps = pst.executeQuery();
            
            if(ps.wasNull() == true){
                data.closeDataSource();
                return true;
            }
            else{
                System.out.println("Erro");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return false;
    }
   
    
}
