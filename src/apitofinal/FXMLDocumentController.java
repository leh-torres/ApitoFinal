/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apitofinal;

import dao.DataSource;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import telaCadUsuario.TelaCadUsuario;


/**
 *
 * @author RonaldoMatos
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private Button cadastrar;
    @FXML
    private ImageView logo;
    
    Image image = new Image(getClass().getResourceAsStream("Logotype.jpg"));
    @FXML
    private Button entrar;
    @FXML
    private TextField txtsenha;
    @FXML
    private Label labelResultado;
    @FXML
    private TextField txtlogin;
    private String[] args;
    
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
   
    DataSource data = new DataSource();
    
    @FXML
    public void displayImage(){
        logo.setImage(image);
    }
    
    @FXML
    public  void handleButtonAction(ActionEvent event) {
        
        String email;
        email = txtlogin.getText();
        
        conn = (Connection) data;
        
        String SQL = "SELECT * FROM usuario WHERE email_user=? and senh_user=?";
        
        try {
            
            
        } catch (Exception e) {
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    public void acaoBotaoCadastrar(ActionEvent event) {
        TelaCadUsuario cad = new TelaCadUsuario();
        fecha();
        try {
            cad.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void fecha(){
        ApitoFinal.getStage().close();
    }
    
}
