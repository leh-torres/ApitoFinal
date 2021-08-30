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
import classes.Competicao;
import classes.Usuario;
import java.util.ArrayList;

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
    private String nome;
    Usuario usuario = new Usuario();
    ArrayList<Competicao> listaComp = new ArrayList<>();
    
    public CompeticaoDAO(){
        conexao = data.getConnection();
    }

    public boolean verificaCampeonato(String email, String senha){
        
        String SQL = "SELECT * FROM competicao WHERE  EXISTS(SELECT id_user FROM usuario WHERE email_user=? and senha_user=?)=fk_usuario";
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
    
    public ArrayList verificaCampeonatoAberto(){
        conexao = data.getConnection();
        String SQL = "SELECT * FROM competicao WHERE fk_usuario=?";
        try {
            ps = (PreparedStatement)conexao.prepareStatement(SQL);
            ps.setInt(1, usuario.getId_user());
            rs = ps.executeQuery();
            
                while(rs.next()){
                    
                Competicao competicao = new Competicao();
                competicao.setId_competicao(rs.getInt("id_comp"));
                competicao.setNomeCompeticao(rs.getString("nome_comp"));
                competicao.setDescricao(rs.getString("descricao_comp"));
                competicao.setPremiacao(rs.getString("premiacao_comp"));
                competicao.setData_inicio(rs.getString("data_ini_comp"));
                competicao.setData_terminio(rs.getString("data_termi_comp"));
                competicao.setSituacao(rs.getString("situacao_comp"));
                competicao.setQtd_times(rs.getString("quantidade_times_comp"));
                competicao.setFk_user(rs.getInt("fk_usuario"));
                listaComp.add(competicao);
                }
                data.closeDataSource();
                return listaComp;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return null;
    }
    
    public String Nome(int id){
        Connection conn = null;
        DataSource data1 = new DataSource();
        conn = data1.getConnection();
        
        String SQL = "SELECT nome_comp FROM competicao WHERE id_comp=?";
        try {
            ps = (PreparedStatement)conn.prepareStatement(SQL);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            
            if(rs.next()){
                nome = rs.getString("nome_comp");
                data1.closeDataSource();
            }
                return nome;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return null;
    }

    public boolean excluirCompeticao(int id){
        conexao = data.getConnection();

        String SQL = "DELETE FROM competicao WHERE competicao.id_comp = ?";

        try {
            ps = (PreparedStatement)conexao.prepareStatement(SQL);
            ps.setInt(1, id);
            retUpdate = ps.executeUpdate();

            if(retUpdate == 1){
                data.closeDataSource();
            }
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        return false;
    }

    public Competicao gCompeticao(int idSelecaoCampeonato){
        Connection conn = null;
        DataSource data1 = new DataSource();
        conn = data1.getConnection();

        String SQL = "SELECT * FROM competicao WHERE id_comp = ?";
        try {
            ps = (PreparedStatement)conn.prepareStatement(SQL);
            ps.setInt(1, idSelecaoCampeonato);
            rs = ps.executeQuery();

            if(rs.next()){
                Competicao comp = new Competicao();
                comp.setId_competicao(rs.getInt("id_comp"));
                comp.setNomeCompeticao(rs.getString("nome_comp"));
                comp.setDescricao(rs.getString("descricao_comp"));
                comp.setPremiacao(rs.getString("premiacao_comp"));
                comp.setData_inicio(rs.getString("data_ini_comp"));
                comp.setData_terminio(rs.getString("data_termi_comp"));
                comp.setSituacao(rs.getString("situacao_comp"));
                comp.setQtd_times(rs.getString("quantidade_times_comp"));
                comp.setFk_user(rs.getInt("fk_usuario"));

                data1.closeDataSource();
                return comp;
            } else{
                System.out.println("Não foi possivel recuperar competicao");
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        return null;
    }
    
}
