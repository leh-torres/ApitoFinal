/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author rayla
 */
public class UsuarioDAO {

    private DataSource dataSource;
    
    public UsuarioDAO(DataSource dataSource){
        this.dataSource = dataSource;
    }
        
    public void login(Usuario u) throws SQLException{
      /*  Connection con = dataSource.getConnection();
        PreparedStatement stmt = null;
        
        private String email;
        private String senha;
         
        try {  
            stmt = con.prepareStatement("SELECT email_user,senha_user FROM usuario");
            
            if(stmt != null){
                if()
            }
            JOptionPane.showMessageDialog(null,"Usuário cadastrado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao cadastrar usuário");
        }finally{
            con.close();
            stmt.close();
        }
   
   */
    }
}
