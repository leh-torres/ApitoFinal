/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telaCadAvatar;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author RonaldoMatos
 */
public class TelaCadAvatarController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    @FXML
    private Button bt_inserir; 
    
    private boolean verifica;
    //private byte[] image;
   
    @FXML
    public void Button1Action(ActionEvent event){
        FileChooser fc = new FileChooser();
        File seletedFile = fc.showOpenDialog(null);
        
        if(seletedFile != null){
            System.out.println("Deu tudo certo");
        }else{
            System.out.println("Arquivo não é válido!");
        }
        //image = new byte[(int) seletedFile.length()];
    }
    public void AcaoBotaoSalvar(ActionEvent event){
        
    }
    
    
    
}
