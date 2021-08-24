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
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javax.swing.JFileChooser;
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
    private ImageView imagem_tela; 
    
    private boolean verifica;
    private File image;
    private FileChooser fc;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }   
   
    @FXML
    public void Button1Action(ActionEvent event) throws FileNotFoundException{
        FileChooser fc = new FileChooser();
        File seletedFile = fc.showOpenDialog(null);

        image = seletedFile;        
        
        if(image != null){
            System.out.println("Deu tudo certo");
        }else{
            System.out.println("Arquivo não é válido!");
        }
        System.out.println(image);
    }
    public void AcaoBotaoSalvar(ActionEvent event) throws FileNotFoundException{
        UsuarioDAO usuario = new UsuarioDAO();
        Usuario usu = new Usuario();
        verifica = usuario.adicionaImagemUsuario(image, 1);
        if(verifica){
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
        }
    }
    
}
