/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadequipeesportiva;

import dao.Time;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Zairo Bastos
 */
public class CadEquipeEsportivaController implements Initializable {
    
    
    @FXML
    private Button btnFile;
    
    @FXML
    private ListView view;
    
    @FXML
    private TextField nome;
    
    @FXML
    private TextField abreviacao;
    
    private boolean verifica;
    private byte[] image;
    @FXML
    private Button avancar;
   
    @FXML
    public void Button1Action(ActionEvent event){
        FileChooser fc = new FileChooser();
        File seletedFile = fc.showOpenDialog(null);
        
        if(seletedFile != null){
            view.getItems().add(seletedFile.getAbsolutePath());
        }else{
            System.out.println("Arquivo não é válido!");
        }
        image = new byte[(int) seletedFile.length()];
    }
    
    @FXML
    public void AcaoDoBotaoAvancar(ActionEvent event){
        Time time = new Time();
        verifica = time.inserirTime(nome.getText(), image, abreviacao.getText(), 0);
        if(verifica){
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
        }
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
