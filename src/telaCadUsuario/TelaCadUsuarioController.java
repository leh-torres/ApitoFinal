/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telaCadUsuario;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
