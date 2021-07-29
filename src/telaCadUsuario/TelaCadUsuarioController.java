/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telaCadUsuario;

import apitofinal.ApitoFinal;
import apitofinal.FXMLDocumentController;
import dao.DataSource;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
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
    private TextField txt_sobrenome;
    @FXML
    private TextField txt_email;
    @FXML
    private TextField pass_senha;
    @FXML
    private Button bt_avancar;
    @FXML
    private Button bt_conectar;
  
    
    Connection conn = null;
    PreparedStatement pst = null;
    PreparedStatement pstl = null;
    ResultSet ps = null;
    private int rs;
    DataSource data = new DataSource();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  

    @FXML    
    public void acaoDOBotaoAvancar(ActionEvent event){
           cadastrar(); 
    }
    
    @FXML  
    public void acaoDOBotaoConectar(ActionEvent event){
        trocarTela();
    }  
    
    public void fecha(){
        TelaCadUsuario.getStage().close();
    }
    
    private void trocarTela(){
        ApitoFinal a = new ApitoFinal();
        fecha();
        try {
            a.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void cadastrar(){
        conn = data.getConnection();
        
        String SQL = "SELECT * FROM usuario WHERE nome_user=? and sobrenome_user=? and email_user=? and senha_user=?";
        try {
            pst = (PreparedStatement)conn.prepareStatement(SQL);
            pst.setString(1, txt_nome.getText());
            pst.setString(2, txt_sobrenome.getText());
            pst.setString(3, txt_email.getText());
            pst.setString(4, pass_senha.getText());
            ps = pst.executeQuery();
            
            if(ps.next()){
                JOptionPane.showMessageDialog(null,"Este usuário já está cadastrado");
                data.closeDataSource();
                txt_nome.clear();
                txt_sobrenome.clear();
                txt_email.clear();
                pass_senha.clear();
            }
            else{
             SQL = "INSERT INTO usuario VALUES(null,?,?,?,?,?)";
            try {
            pstl = (PreparedStatement)conn.prepareStatement(SQL);
            pstl.setString(1, txt_nome.getText());
            pstl.setString(2, txt_sobrenome.getText());
            pstl.setString(3, txt_email.getText());
            pstl.setString(4, pass_senha.getText());
            pstl.setString(5, null);
            rs = pstl.executeUpdate();
            
            if(rs == 1){
                JOptionPane.showMessageDialog(null,"Usuario cadastrado");
                data.closeDataSource();
                trocarTela();
            }
            else{
                System.out.println("Erro");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
}
    

