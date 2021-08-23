/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author rayla
 */
public class Time {
    
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet ps = null;
    DataSource data = new DataSource();
    int rs;
    
    public boolean inserirTime(String nome_time,File imagem_time,String abreviacao_time,int fk_usuario){
        conn = data.getConnection();
        
        String SQL = "INSERT INTO times (nome_time,imagem_time,abreviacao_time,fk_usuario) VALUES (?,?,?,?)";
        
        try {
            pst = (PreparedStatement)conn.prepareStatement(SQL);
            pst.setString(1, nome_time);
            //pst.setBytes(2, imagem_time);
            pst.setString(3, abreviacao_time);
            pst.setInt(4, fk_usuario);
            rs = pst.executeUpdate();
            
            if(rs == 1){
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
}
