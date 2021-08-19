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
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;


import classes.Competicao;

/**
 *
 * @author raylander
 * @author Leticia Torres
 */
public class CompeticaoDAO {
    
    Connection conexao = null; 
    PreparedStatement ps = null; 
    ResultSet rs = null; 
    DataSource data = new DataSource(); 
    private int retUpdate;

    public CompeticaoDAO(){
        conexao = data.getConnection();
    }

    public boolean verificaCampeonato(String email, String senha){
        
        String SQL = "SELECT * FROM competicao WHERE EXISTS(SELECT id_user FROM usuario WHERE email_user=? and senha_user=?)=fk_usuario";
        try {
            ps = (PreparedStatement)conexao.prepareStatement(SQL);
            ps.setString(1, email);
            ps.setString(2, senha);
            rs = ps.executeQuery();
            
            if(rs.next()){
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
    
    public boolean cadastrarComp(Competicao competicao){

        String SQL = "SELECT * FROM competicao WHERE nome_comp = ? ";
        try {
            ps = (PreparedStatement)conexao.prepareStatement(SQL);
            ps.setString(1, competicao.getNomeCompeticao());
            rs = ps.executeQuery();

            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Campeonato já cadastrado");
                data.closeDataSource();

                return true;
            } else{
                SQL = "INSERT INTO competicao (nome_comp, descricao_comp, premiacao_comp, data_ini_comp, data_termi_comp, situacao_comp, quantidade_times_comp, fk_usuario) VALUES (?,?,?,?,?,?,?,?)";

                try {
                    ps = (PreparedStatement)conexao.prepareStatement(SQL);
                    ps.setString(1, competicao.getNomeCompeticao());
                    ps.setString(2, competicao.getDescricao());
                    ps.setString(3, competicao.getPremiacao());
                    ps.setString(4, competicao.getData_inicio());
                    ps.setString(5, competicao.getData_terminio());
                    ps.setString(6, competicao.getSituacao());
                    ps.setString(7, competicao.getQtd_times());
                    ps.setInt(8, competicao.getFk_user());
                    retUpdate = ps.executeUpdate();


                    if(retUpdate == 1){
                        JOptionPane.showMessageDialog(null, "Cadastro Realizado com sucesso!");
                        data.closeDataSource();
    
                        return true;
                    } else{
                        JOptionPane.showMessageDialog(null, "----ERRO!----");
                    }
                    
                } catch (SQLException exSQL) {
                    System.out.println("------------ERRO: INSERT INTO----------");
                    JOptionPane.showMessageDialog(null, exSQL);
                }
            }

        } catch (SQLException exSQL) {
            System.out.println("-----------ERRO: SELECT FROM----------");
            JOptionPane.showMessageDialog(null, exSQL);
        }

        return false;
        
    }
    
}
