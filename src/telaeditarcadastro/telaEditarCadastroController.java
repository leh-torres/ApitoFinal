/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telaeditarcadastro;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;

/**
 *
 * @author Zairo Bastos
 */
public class telaEditarCadastroController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private Button btn1;
    
    public void Button1Action(ActionEvent event){
        FileChooser fc = new FileChooser();
        File selectedFile = fc.showOpenDialog(null);
        
        if(selectedFile != null){
        //Aqui ia um código para mostrar a localização
        //
        }else{
            System.out.println("Arquivo inválido!");
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
