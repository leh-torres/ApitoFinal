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
import java.io.InputStream;
import javafx.scene.image.Image;

/**
 *
 * @author rayla
 */
public class TimeDAO {
    
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet ps = null;
    DataSource data = new DataSource();
    private String resultado;
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
        System.out.println("ArrayList DAO");
        conn = data.getConnection();

        ArrayList<Time> arrayTimes = new ArrayList<>();

        String SQL = "select * from times where fk_usuario = ?";

        try{
            System.out.println("try");
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
        System.out.println("fora");
        return null;
    }
    
    public Image getImagem(int id_time, int variancia){
        DataSource data1 = new DataSource();
        conn = data1.getConnection();
        
        if(variancia == 1){
        String SQL = "select * from times where id_time = ?";

        try{
            pst = (PreparedStatement)conn.prepareStatement(SQL);
            pst.setInt(1, id_time);
            ps = pst.executeQuery();

            if(ps.next()){
                if(ps.getBinaryStream("imagem_time") != null){
                InputStream imageFile = ps.getBinaryStream("imagem_time");
                Image image = new Image(imageFile);
                return image;
                }
                return null;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        System.out.println("fora");
        }
        else if(variancia == 2){
            String SQL = "select * from times where id_time = ?";

        try{
            pst = (PreparedStatement)conn.prepareStatement(SQL);
            pst.setInt(1, id_time);
            ps = pst.executeQuery();

            if(ps.next()){
                if(ps.getBinaryStream("imagem_time") != null){
                InputStream imageFile = ps.getBinaryStream("imagem_time");
                Image image = new Image(imageFile);
                return image;
                }
                return null;
            }
            data.closeDataSource();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        System.out.println("fora");
        }
        return null;
    }
    
    public String getAbrev(int id_time, int variancia){
        DataSource data1 = new DataSource();
        conn = data1.getConnection();
        
        if(variancia == 1){
        String SQL = "select * from times where id_time = ?";

        try{
            pst = (PreparedStatement)conn.prepareStatement(SQL);
            pst.setInt(1, id_time);
            ps = pst.executeQuery();

            if(ps.next()){
                resultado = ps.getString("abreviacao_time");
                return resultado;
                }
                return null;
            }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
            System.out.println("fora");
        }
        else if(variancia == 2){
            String SQL = "select * from times where id_time = ?";

        try{
            pst = (PreparedStatement)conn.prepareStatement(SQL);
            pst.setInt(1, id_time);
            ps = pst.executeQuery();

            if(ps.next()){
                resultado = ps.getString("abreviacao_time");
                return resultado;
            }
            data.closeDataSource();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        System.out.println("fora");
        
        }
    return null;
    }
    
    public Image buscaImagem(int id_time){
        DataSource data1 = new DataSource();
        conn = data1.getConnection();
        
        String SQL = "select * from times where id_time = ?";

        try{
            pst = (PreparedStatement)conn.prepareStatement(SQL);
            pst.setInt(1, id_time);
            ps = pst.executeQuery();

            if(ps.next()){
                if(ps.getBinaryStream("imagem_time") != null){
                InputStream imageFile = ps.getBinaryStream("imagem_time");
                Image image = new Image(imageFile);
                return image;
                }
                return null;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        System.out.println("fora");
        return null;
    }
        
}
