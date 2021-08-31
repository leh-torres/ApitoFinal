/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telaeditarcadastro;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import classes.Usuario;
import dao.UsuarioDAO;
import home.Home;
import home.HomeController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import selecaocampeonato.SelecaoCampeonato;

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

    private UsuarioDAO usuarioD = new UsuarioDAO();
    private Usuario user = new Usuario();
    private File image;
    private FileInputStream fis;

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

        if(checkNome.isSelected()){
            usuarioD.atualizaNome(txtNome.getText(), user.getId_user());
        } 
        if(checkSobrenome.isSelected()){
            usuarioD.atualizaSobrenome(txtSobrenome.getText(), user.getId_user());
        }
        if(checkEmail.isSelected()){
            usuarioD.atualizaEmail(txtEmail.getText(), user.getId_user());
        }
        if(checkSenha.isSelected()){
            usuarioD.atualizaSenha(passSenha.getText(), user.getId_user());
        }
        if(checkPerfil.isSelected()){
            try {
                usuarioD.adicionaImagemUsuario(fis, user.getId_user());
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
        JOptionPane.showMessageDialog(null, "Dado(os) atualizado(os) com sucesso!");
        SelecaoCampeonato selec = new SelecaoCampeonato();
        fecha();
        try {
            selec.start(new Stage());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    @FXML 
    private void getNewImage(ActionEvent event){
            FileChooser fc = new FileChooser();
            File selectedFile = fc.showOpenDialog(null);
            String path = selectedFile.getAbsolutePath();
            image = new File(path);

            try {
                fis = new FileInputStream(image);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
    }

    @FXML 
    private void voltar(ActionEvent event){
        SelecaoCampeonato selec = new SelecaoCampeonato();
        fecha();
        try {
            selec.start(new Stage());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void fecha(){
        TelaEditarCadastro.getStage().close();
    }
}
