/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telaSelecionarTimes;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;
import javax.swing.event.ListDataEvent;

import com.mysql.cj.jdbc.Blob;

import cadequipeesportiva.CadEquipeEsportiva;
import classes.Competicao;
import classes.Time;
import dao.CompeticaoDAO;
import dao.TimeDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import telaDefinirPartidas16.TelaDefinirPartidas16Main;
import telaDefinirPartidas8.TelaDefinirPartidas8;

/**
 * FXML Controller class
 *
 * @author RonaldoMatos
 * @author Leticia Torres
 */
public class TelaSelecionarTImesFXMLController implements Initializable {

    @FXML
    private ImageView imageTime;

    @FXML
    private TextField txtNomeTime;

    @FXML
    private TextField txtAbrev;

    @FXML
    private Button btnSelecionarTime;

    @FXML
    private Button btnConcluir;

    @FXML
    private Button btnCadastrarTime;

    @FXML
    private ListView<String> listaTimesSelecionados;

    @FXML
    private ListView<String> lista_times;

    @FXML
    private TextField txtBusca;

    private ArrayList<Time> arrayTimes = new ArrayList<>();
    private ArrayList<Time> arrayTimesAux = new ArrayList<>();
    private ArrayList<String> arrayAux = new ArrayList<>();
    private ArrayList<String> arrayAux1 = new ArrayList<>();
    private ObservableList<String> observableList;
    private ObservableList<String> observableList1;
    private Time timeAux = new Time();
    private TimeDAO timeDAO = new TimeDAO();
    private Competicao comp = new Competicao();
    private String auxNome;
    private String auxAbrv;
    private Blob auxImagem;
    String nome;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Entrou no initialize");
        CarregaTimesCadastrados();

        //TODO implementar barra de tarefa

        lista_times.setOnMouseClicked(new EventHandler<MouseEvent>(){
    
            @Override
            public void handle(MouseEvent arg0) {
                nome = lista_times.getSelectionModel().getSelectedItem();
                
                for(int i = 0; i < arrayTimes.size(); i++){
                    if(nome == arrayTimes.get(i).getNome_time()){
                        Time time = new Time();
                        auxNome = arrayTimes.get(i).getNome_time();
                        auxAbrv = arrayTimes.get(i).getAbreviacao_time();
                        auxImagem = (Blob) arrayTimes.get(i).getImagem_time();

                        time.setId_time(arrayTimes.get(i).getId_time());
                        time.setNome_time(auxNome);
                        time.setAbreviacao_time(auxAbrv);
                        time.setImagem_time(auxImagem);
                        time.setFk_usuario(arrayTimes.get(i).getFk_usuario());
                        time.setFk_comp(comp.getId_competicao());

                        arrayTimesAux.add(time);
                        arrayAux1.add(auxNome);

                        txtNomeTime.setText(auxNome);
                        txtAbrev.setText(auxAbrv);
                        try {
                            InputStream is = auxImagem.getBinaryStream();
                            Image image = new Image(is);
                            imageTime.setImage(image);
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        
                    }
                }
            }
  
        });
    }
    
    private void CarregaTimesCadastrados(){
        arrayTimes = timeDAO.getTimes(comp.getFk_user());
        System.out.println(comp.getFk_user());
        //Para testes
        //arrayTimes = timeDAO.getTimes(8);

        for(int i = 0; i < arrayTimes.size(); i++){
            nome = arrayTimes.get(i).getNome_time();
            arrayAux.add(nome);
            System.out.println(arrayTimes.get(i).getNome_time());
        }
        
        observableList = FXCollections.observableArrayList(arrayAux);

        lista_times.setItems(observableList);

    }

    @FXML
    public void acaoBotaoSelecionar(ActionEvent event) {
        observableList1 = FXCollections.observableArrayList(arrayAux1);
        listaTimesSelecionados.setItems(observableList1);
    }

    @FXML
    public void acaoDoBotaoConcluir(ActionEvent event){
        timeAux.setArrayTimes(arrayTimesAux);
        for(int i = 0; i<timeAux.getArrayTimes().size();i++){
            System.out.println(timeAux.getArrayTimes().get(i).getNome_time());
        }
        if(timeAux.getArrayTimes().size() == 8){
            TelaDefinirPartidas8 tela8 = new TelaDefinirPartidas8();
            close();

            try {
                tela8.start(new Stage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if(timeAux.getArrayTimes().size() == 16){
            TelaDefinirPartidas16Main tela16 = new TelaDefinirPartidas16Main();
            close();

            try {
                tela16.start(new Stage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else{
            JOptionPane.showMessageDialog(null, "8 ou 16 times precisam ser selecionados!");
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

    private void close(){
        telaSelecionarTimes.getStage().close();
    }

    @FXML
    public void acaoDoCadastrar(ActionEvent event) throws Exception{
        CadEquipeEsportiva cadEquipe = new CadEquipeEsportiva();
        close();

        try {
            cadEquipe.start(new Stage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
