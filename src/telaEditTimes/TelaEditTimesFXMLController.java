/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telaEditTimes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import com.mysql.cj.jdbc.Blob;

import classes.Competicao;
import classes.Time;
import dao.BarraDeMenuDAO;
import dao.TimeDAO;
import home.Home;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author RonaldoMatos
 */
public class TelaEditTimesFXMLController implements Initializable {

    @FXML
    private Label nome_user;

    @FXML
    private Label labelImagem;

    @FXML
    private TextField txtBusca;

    @FXML
    private TextField txtNomeTime;

    @FXML
    private TextField txtAbrev;

    @FXML
    private ImageView imagem_user;

    @FXML
    private CheckBox checkNomeTime;

    @FXML
    private CheckBox checkAbrevTime;

    @FXML
    private CheckBox checkEscudoTime;

    @FXML
    private Button btnInserir;

    @FXML
    private ListView<String> lista_times;

    private ArrayList<Time> arrayTimes = new ArrayList<>();
    private ArrayList<String> arrayAux = new ArrayList<>();
    private ObservableList<String> observableList;
    private TimeDAO timeDAO = new TimeDAO();
    private Competicao comp = new Competicao();
    private String nome;
    private int    idTimeSelecionado;

    private String path =  null;;
    private File image;
    private static FileInputStream fis = null;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        BarraDeMenuDAO barra = new BarraDeMenuDAO();
        BarraDeMenuDAO barra1 = new BarraDeMenuDAO();
        nome_user.setText(barra.Nome());
        imagem_user.setImage(barra1.Imagem());
    
        CarregaTimesCadastrados();

        lista_times.setOnMouseClicked(new EventHandler<MouseEvent>(){
    
            @Override
            public void handle(MouseEvent arg0) {
                nome = lista_times.getSelectionModel().getSelectedItem();
                
                for(int i = 0; i < arrayTimes.size(); i++){
                    if(nome == arrayTimes.get(i).getNome_time()){
                        idTimeSelecionado = arrayTimes.get(i).getId_time();
                    }
                }
            }
  
        });
    } 
    
    private void CarregaTimesCadastrados(){
        arrayTimes = timeDAO.getTimes(comp.getFk_user());
        //System.out.println(comp.getFk_user());
        //Para testes
        //arrayTimes = timeDAO.getTimes(1);

        for(int i = 0; i < arrayTimes.size(); i++){
            nome = arrayTimes.get(i).getNome_time();
            arrayAux.add(nome);
            System.out.println(arrayTimes.get(i).getNome_time());
        }
        
        observableList = FXCollections.observableArrayList(arrayAux);

        lista_times.setItems(observableList);

    }

    @FXML
    private void getNovaImagem(ActionEvent event){
        FileChooser fc = new FileChooser();
        File seletedFile = fc.showOpenDialog(null);       
        
        if(seletedFile != null){
            System.out.println("Deu tudo certo");
        }else{
            System.out.println("Arquivo não é válido!");
        }
        System.out.println(image);
        
        path = seletedFile.getAbsolutePath();
        labelImagem.setText(path);

        image = new File(path);
        try {
            fis = new FileInputStream(image);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @FXML
    private void acaoDoCheck(ActionEvent event){
        if(checkNomeTime.isSelected()){
            txtNomeTime.setEditable(true);
        } else{
            txtNomeTime.setEditable(false);
        }

        if(checkAbrevTime.isSelected()){
            txtAbrev.setEditable(true);
        } else{
            txtAbrev.setEditable(false);
        }

        if(checkEscudoTime.isSelected()){
            btnInserir.setDisable(false);
        } else{
            btnInserir.setDisable(true);
        }

    }

    @FXML
    private void salvar(ActionEvent event){
        if(checkNomeTime.isSelected()){
            timeDAO.atualizaNomeTime(txtNomeTime.getText(), idTimeSelecionado);
        } 
        if(checkAbrevTime.isSelected()){
            timeDAO.atualizaAbrev(txtAbrev.getText(), idTimeSelecionado);
        }
        if(checkEscudoTime.isSelected()){
            timeDAO.atualizaImagem(fis, idTimeSelecionado);
        }
        
        
        JOptionPane.showMessageDialog(null, "Dado(os) atualizado(os) com sucesso!");
        refreshScreen();
        
    }

    @FXML
    private void excluirTime(ActionEvent event){
        boolean ret = timeDAO.deletaTime(idTimeSelecionado);
        if(ret == true){
            JOptionPane.showMessageDialog(null, "Time excluido com sucesso");
            refreshScreen();
        } else{
            JOptionPane.showMessageDialog(null, "Erro ao excluir");
            refreshScreen();
        }
    }

    @FXML
    public void acaoDeBusca(ActionEvent event){
        String busca = txtBusca.getText();

        Boolean ifContains = lista_times.getItems().contains(busca);
        if(ifContains == true){
            lista_times.getItems().add(0, busca);
        }
    }

    @FXML
    public void acaoDeBuscaTeclado(KeyEvent event){
        String busca = txtBusca.getText();

        Boolean ifContains = lista_times.getItems().contains(busca);
        if(ifContains == true){
            lista_times.getItems().add(0, busca);
        }
    }

    @FXML 
    private void voltar(ActionEvent event){
        Home h = new Home();
        fecha();
        try {
            h.start(new Stage());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void fecha(){
        TelaEditTimes.getStage().close();
    }

    private void refreshScreen(){
        TelaEditTimes tela2 = new TelaEditTimes();
        fecha();

        try {
            tela2.start(new Stage());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
