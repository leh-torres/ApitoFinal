/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telaCadAvatar;

import apitofinal.ApitoFinal;
import classes.Usuario;
import dao.UsuarioDAO;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
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
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author RonaldoMatos
 */
public class TelaCadAvatarController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private Button bt_inserir; 

    @FXML
    private ImageView ImageLogo;


    Image image1 = new Image(getClass().getResourceAsStream("/apitofinal/Logotype.jpg"));
    
    private static FileInputStream fis = null;
    private String path =  null;;
    private File image;
    private boolean verifica;
    private FileChooser fc; 
    @FXML
    private ImageView imgem_tela;
    @FXML
    private Button bt_avancar;
    @FXML
    private Label labelCaminho;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    @FXML
    public void displayImage(){
        ImageLogo.setImage(image1);
    }
   
    @FXML
    public void Button1Action(ActionEvent event) {
        FileChooser fc = new FileChooser();
        File seletedFile = fc.showOpenDialog(null);       
        
        if(seletedFile != null){
            System.out.println("Deu tudo certo");
        }else{
            System.out.println("Arquivo não é válido!");
        }
        System.out.println(image);
        
        path = seletedFile.getAbsolutePath();
        labelCaminho.setText(path);
    }
    
    @FXML
    public void AcaoBotaoSalvar(ActionEvent event) throws IOException{
        image = new File(path);
        fis = new FileInputStream(image);

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usu = new Usuario();
        usu.setId_user(usuarioDAO.getIdDoCadastro(usu.getNome_user(), usu.getSobrenome_user()));
        System.out.println("usuario_id:" + usu.getId_user());  
        verifica = usuarioDAO.adicionaImagemUsuario(fis, usu.getId_user());
        if(verifica){
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
            trocarTela();
        } else{
            JOptionPane.showMessageDialog(null, "ERRO: Cadastro não realizado!");
        }
    }
    
    private void fecha(){
        TelaCadAvatar.getStage().close();
    }
    
    private void trocarTela(){
        ApitoFinal a = new ApitoFinal();
        fecha();
        try {
            a.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(TelaCadAvatarController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
