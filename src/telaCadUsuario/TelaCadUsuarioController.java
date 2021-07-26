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
    private TextField txt_email;
    @FXML
    private TextField txt_senha;
    @FXML
    private Button bt_avancar;
    @FXML
    private Button bt_conectar;
    
    private DataSource dataSource;
    
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
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
        
        conn = data.getConnection();
        
        String SQL = "INSERT INTO usuario VALUES (?,?,?,?,?,?)";
        try {
            pst = (PreparedStatement)conn.prepareStatement(SQL);
            pst.setString(1, txt_nome.getText());
            pst.setString(2, txt_email.getText());
            pst.setString(2, txt_senha.getText());
            rs = pst.executeQuery();
            
            if(rs.next()){
                System.out.println("Usuario cadastrado");
            }
            else{
                System.out.println("Erro");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    @FXML  
    public void acaoDOBotaoConectar(ActionEvent event){
        ApitoFinal a = new ApitoFinal();
        fecha();
        try {
            a.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
    
    public void fecha(){
        TelaCadUsuario.getStage().close();
    }
}
    

