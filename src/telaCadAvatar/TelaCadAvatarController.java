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
<<<<<<< HEAD
import java.io.FileOutputStream;
import java.io.InputStream;
=======
import java.io.IOException;
>>>>>>> refs/remotes/origin/master
import java.net.URL;
import java.nio.file.Files;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
<<<<<<< HEAD
=======
import javafx.scene.control.Label;
>>>>>>> refs/remotes/origin/master
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
<<<<<<< HEAD
    @FXML
    private ImageView imagem_tela; 
=======

    @FXML
    private ImageView ImageLogo;

    @FXML
    private Label LabelCaminho;

    Image image1 = new Image(getClass().getResourceAsStream("/apitofinal/Logotype.jpg"));
>>>>>>> refs/remotes/origin/master
    
    private static FileInputStream fis = null;
    private String path =  null;;
    private File image;
<<<<<<< HEAD
    private FileChooser fc;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }   
   
    @FXML
    public void Button1Action(ActionEvent event) throws FileNotFoundException{
=======

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
>>>>>>> refs/remotes/origin/master
        FileChooser fc = new FileChooser();
        File seletedFile = fc.showOpenDialog(null);

        image = seletedFile;        
        
        if(image != null){
            System.out.println("Deu tudo certo");
        }else{
            System.out.println("Arquivo não é válido!");
        }
<<<<<<< HEAD
        System.out.println(image);
=======
        
        path = seletedFile.getAbsolutePath();
>>>>>>> refs/remotes/origin/master
    }
    public void AcaoBotaoSalvar(ActionEvent event) throws IOException{
        image = new File(path);
        fis = new FileInputStream(image);

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usu = new Usuario();
<<<<<<< HEAD
        verifica = usuario.adicionaImagemUsuario(image, 1);
=======
        usu.setId_user(usuarioDAO.getIdDoCadastro(usu.getNome_user(), usu.getSobrenome_user()));
        System.out.println("usuario_id:" + usu.getId_user());
        
        verifica = usuarioDAO.adicionaImagemUsuario(fis, usu.getId_user());
>>>>>>> refs/remotes/origin/master
        if(verifica){
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
        } else{
            JOptionPane.showMessageDialog(null, "ERRO: Cadastro não realizado!");
        }
    }
    
}
