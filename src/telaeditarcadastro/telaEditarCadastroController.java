/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telaeditarcadastro;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

/**
 *
 * @author Zairo Bastos
 */
public class telaEditarCadastroController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private Button selecionaImagem;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtSobrenome;

    @FXML
    private TextField txtEmail;

    @FXML
    private PasswordField passSenha;

    @FXML
    private CheckBox checkNome;

    @FXML
    private CheckBox checkSobrenome;

    @FXML
    private CheckBox checkEmail;

    @FXML
    private CheckBox checkSenha;

    @FXML
    private CheckBox checkPerfil;

    private ArrayList<Boolean> arrayDeChecks = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        

        
    }  
    
    @FXML
    private void acaoDoCheck(ActionEvent event){
        if(checkNome.isSelected()){
            txtNome.setEditable(true);
        } else{
            txtNome.setEditable(false);
        }

        if(checkSobrenome.isSelected()){
            txtSobrenome.setEditable(true);
        } else{
            txtSobrenome.setEditable(false);
        }

        if(checkEmail.isSelected()){
            txtEmail.setEditable(true);
        } else{
            txtEmail.setEditable(false);
        }

        if(checkSenha.isSelected()){
            passSenha.setEditable(true);
        } else{
            passSenha.setEditable(false);;
        }

        if(checkPerfil.isSelected()){
            selecionaImagem.setDisable(false);
        } else{
            selecionaImagem.setDisable(true);
        }
    }

    
    @FXML
    private void BotaoAtualizar(ActionEvent event){
        
        
        
        FileChooser fc = new FileChooser();
        File selectedFile = fc.showOpenDialog(null);
        
        if(selectedFile != null){
        //Aqui ia um código para mostrar a localização
        //
        }else{
            System.out.println("Arquivo inválido!");
        }
    }

}
