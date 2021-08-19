/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telaprincipal;

import dao.BarraDeMenu;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.swing.ImageIcon;
import telacadcampeonato.TelaCadCampeonato;


/**
 *
 * @author Zairo Bastos
 */
public class TelaPrincipalController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private Label nome_user;
    @FXML
    private ImageView imagem_user;
    @FXML
    private Button criar_camp;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        BarraDeMenu barra = new BarraDeMenu();
        nome_user.setText(barra.Nome());
        
    }  
    
    public void inicioCampeonato(ActionEvent event) {
        trocarTela();        
    }
    
    public void logoUsuario(ActionEvent event){
        
    }
    
    private void fecha(){
        TelaPrincipal.getStage().close();
    }
    
    private void trocarTela(){
        TelaCadCampeonato a = new TelaCadCampeonato();
        fecha();
        try {
            a.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(TelaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
