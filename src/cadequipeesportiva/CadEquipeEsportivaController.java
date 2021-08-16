/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadequipeesportiva;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.FileChooser;

/**
 *
 * @author Zairo Bastos
 */
public class CadEquipeEsportivaController implements Initializable {
    
    
    @FXML
    private Button btnFile;
    
    @FXML
    private ListView view;
   
    public void Button1Action(ActionEvent event){
        FileChooser fc = new FileChooser();
        File seletedFile = fc.showOpenDialog(null);
        
        if(seletedFile != null){
            view.getItems().add(seletedFile.getAbsolutePath());
        }else{
            System.out.println("Arquivo não é válido!");
        }
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
