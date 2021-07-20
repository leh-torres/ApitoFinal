/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telaCadUsuario;

import classes.Usuario;
import dao.CadastroDAO;
import dao.DataSource;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author RonaldoMatos
 */
public class TelaCadUsuarioController implements Initializable {

    @FXML
    private TextField txt_nome;
    @FXML
    private TextField txt_email;
    @FXML
    private TextField txt_senha;
    @FXML
    private Button bt_avancar;
    @FXML
    private Button bt_conectar;
    
    private DataSource dataSource;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void acaoDOBotaoAvancar(ActionEvent event){
        
        try {
            Usuario usu = new Usuario();
            CadastroDAO ca = new CadastroDAO(dataSource);
            
            usu.setNome_user(txt_nome.getText());
            usu.setEmail_user(txt_email.getText());
            usu.setSenha_user(txt_senha.getText());
            ca.create(usu);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao cadastrar usuário");
        }
    }
    
    public void acaoDOBotaoConectar(ActionEvent event){
        
    }
    
}
