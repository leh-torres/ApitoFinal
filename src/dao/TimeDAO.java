/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import classes.Time;

/**
 *
 * @author rayla
 */
public class TimeDAO {
    
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet ps = null;
    DataSource data = new DataSource();
    int rs;

    public TimeDAO(){

    }
    
    public boolean inserirTime(String nome_time,FileInputStream fis,String abreviacao_time,int fk_usuario){
        conn = data.getConnection();
        
        String SQL = "INSERT INTO times (nome_time,imagem_time,abreviacao_time,fk_usuario) VALUES (?,?,?,?)";
        
        try {
            pst = (PreparedStatement)conn.prepareStatement(SQL);
            pst.setString(1, nome_time);
            pst.setBinaryStream(2, fis);
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


    public ArrayList getTimes(int id_usuario){
        conn = data.getConnection();

        ArrayList<Time> arrayTimes = new ArrayList<>();

        String SQL = "select * from times where fk_usuario = ?";

        try{
            pst = (PreparedStatement)conn.prepareStatement(SQL);
            pst.setInt(1, id_usuario);
            ps = pst.executeQuery();

            while(ps.next()){
                Time time = new Time();
                time.setId_time(ps.getInt("id_time"));
                time.setNome_time(ps.getString("nome_time"));
                time.setImagem_time(ps.getBlob("imagem_time"));
                time.setAbreviacao_time(ps.getNString("abreviacao_time"));
                time.setFk_usuario(ps.getInt("fk_usuario"));
                arrayTimes.add(time);
            }
            data.closeDataSource();
            return arrayTimes;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        return null;
    }
}
