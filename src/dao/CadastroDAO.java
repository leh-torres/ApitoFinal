/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author rayla
 */
public class CadastroDAO {
    
    private DataSource dataSource;
       
        public CadastroDAO(DataSource dataSource){
            this.dataSource = dataSource;
        }
    
     public void create(Usuario u) throws SQLException{
        
        Connection con = dataSource.getConnection();
        PreparedStatement stmt = null;
         
        try {  
            stmt = con.prepareStatement(" INSERT INTO usuario (nome_user,sobrenome_user,email_user,senha_user,imagem_user) values(?,?,?,?,?)");
            stmt.setString(1,u.getNome_user());
            stmt.setString(2,u.getSobrenome_user());
            stmt.setString(3,u.getEmail_user());
            stmt.setString(4,u.getSenha_user());
            stmt.setBlob(5,u.getImagem_user());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Usuário cadastrado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao cadastrar usuário");
        }finally{
            con.close();
            stmt.close();
        }
   
   
    } 
}
