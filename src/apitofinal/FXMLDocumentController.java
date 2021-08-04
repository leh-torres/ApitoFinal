/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apitofinal;

import dao.CampeonatoDAO;
import dao.UsuarioDAO;
import java.net.URL;
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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import telaCadUsuario.TelaCadUsuario;
import telaprincipal.TelaPrincipal;


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
    private TextField pass_senha;
    @FXML
    private Label labelResultado;
    @FXML
    private TextField txtlogin;
    
    private boolean verificaLogin;
    private boolean verificaCampeonato;
    
    UsuarioDAO usu = new UsuarioDAO();
    CampeonatoDAO cam = new CampeonatoDAO();
    
    @FXML
    public void displayImage(){
        logo.setImage(image);
    }
    
    @FXML
    public  void handleButtonAction(ActionEvent event) {
        verificaLogin = usu.login(txtlogin.getText(), pass_senha.getText());
        verificaCampeonato = cam.verificaCampeonato();
        
        if(verificaLogin == true){
            if(verificaCampeonato == true){
                TelaPrincipal tela = new TelaPrincipal();
                fecha();

                try {
                tela.start(new Stage());
            } catch (Exception ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pass_senha.addEventHandler(KeyEvent.KEY_PRESSED, (KeyEvent event) -> {
            try {
                if (event.getCode() == KeyCode.ENTER) {
                    verificaLogin = usu.login(txtlogin.getText(), pass_senha.getText());
            if(verificaLogin == true){
                TelaPrincipal tela = new TelaPrincipal();
                fecha();
                try {
                tela.start(new Stage());
            } catch (Exception ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
                }
            } catch (Exception ex) {
            }
        });
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
    
    private void fecha(){
        ApitoFinal.getStage().close();
    }
    
}
