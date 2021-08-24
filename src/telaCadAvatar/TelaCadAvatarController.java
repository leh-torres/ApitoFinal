/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telaCadAvatar;

import classes.Usuario;
import dao.UsuarioDAO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
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

    @FXML
    private Label LabelCaminho;

    Image image1 = new Image(getClass().getResourceAsStream("/apitofinal/Logotype.jpg"));
    
    private static FileInputStream fis = null;
    private String path =  null;;
    private File image;

    private boolean verifica;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    @FXML
    public void displayImage(){
        ImageLogo.setImage(image1);
    }
   
    @FXML
    public void Button1Action(ActionEvent event) throws IOException{
        FileChooser fc = new FileChooser();
        File seletedFile = fc.showOpenDialog(null);
        
        if(seletedFile != null){
            System.out.println("Deu tudo certo");
        }else{
            System.out.println("Arquivo não é válido!");
        }
        
        path = seletedFile.getAbsolutePath();
    }
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
        } else{
            JOptionPane.showMessageDialog(null, "ERRO: Cadastro não realizado!");
        }
    }
    
}
