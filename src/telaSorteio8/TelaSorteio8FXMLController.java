/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telaSorteio8;

import dao.BarraDeMenu;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author RonaldoMatos
 */
public class TelaSorteio8FXMLController implements Initializable {
    
    
    @FXML
    private TextField nome_user;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        BarraDeMenu barra = new BarraDeMenu();
        nome_user.setText(barra.Nome());
    }    
    
}
