/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telaCadAvatar;

import classes.Usuario;
import dao.UsuarioDAO;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
    
    private boolean verifica;
    private File image;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
   
    @FXML
    public void Button1Action(ActionEvent event){
        FileChooser fc = new FileChooser();
        File seletedFile = fc.showOpenDialog(null);
        
        if(seletedFile != null){
            System.out.println("Deu tudo certo");
        }else{
            System.out.println("Arquivo não é válido!");
        }
        image = seletedFile;
        System.out.println(image);
    }
    public void AcaoBotaoSalvar(ActionEvent event) throws FileNotFoundException{
        UsuarioDAO usuario = new UsuarioDAO();
        Usuario usu = new Usuario();
        verifica = usuario.adicionaImagemUsuario(image, usu.getId_user());
        if(verifica){
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
        }
    }
    
}
