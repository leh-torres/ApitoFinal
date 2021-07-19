/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apitofinal;

import classes.Usuario;
import dao.DataSource;
import dao.UsuarioDAO;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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
    
    
    
    @FXML
    public void displayImage(){
        logo.setImage(image);
    }
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
