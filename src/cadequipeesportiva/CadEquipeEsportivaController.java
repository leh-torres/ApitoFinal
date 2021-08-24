/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadequipeesportiva;

import classes.Usuario;
import dao.BarraDeMenuDAO;
import dao.Time;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import telaSelecionarTimes.telaSelecionarTimes;

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
    private Label nome_user;
    
    @FXML
    private Label labelCaminho;
    
    @FXML
    private TextField abreviacao;
    
    private static FileInputStream fis = null;
    private String path =  null;;
    private File image;
    private boolean verifica;
    private FileChooser fc; 
    @FXML
    private Button avancar;
    @FXML
    private ImageView Imagem_user;
   
    @FXML
    public void Button1Action(ActionEvent event){
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
    public void AcaoDoBotaoAvancar(ActionEvent event) throws FileNotFoundException{
        Time time = new Time();
        Usuario usu = new Usuario();
        image = new File(path);
        fis = new FileInputStream(image);
        verifica = time.inserirTime(nome.getText(), fis, abreviacao.getText(),usu.getId_user());
        if(verifica){
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
            trocarTela();
        }
        else{
            JOptionPane.showMessageDialog(null, "ERRO: Cadastro não realizado!");
        }
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        BarraDeMenuDAO barra = new BarraDeMenuDAO();
        nome_user.setText(barra.Nome());
    }    
    
    private void fecha(){
        CadEquipeEsportiva.getStage().close();
    }
    
    private void trocarTela(){
        telaSelecionarTimes a = new telaSelecionarTimes();
        fecha();
        try {
            a.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(CadEquipeEsportivaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
