/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telaEditPartidas;


import java.io.IOException;
import java.net.URL;

import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;


import classes.Competicao;
import classes.Partida;
import classes.Time;
import dao.BarraDeMenuDAO;
import dao.PartidaDAO;
import dao.TimeDAO;
import home.Home;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author RonaldoMatos
 */
public class TelaEditPartidasFXMLController implements Initializable {

    @FXML
    private TextField txtLocalPartida;

    @FXML
    private TextField txtDataPartida;

    @FXML
    private TextField txtHorarioPartida;

    @FXML
    private TextField txtBusca;

    @FXML
    private CheckBox checkLocalPartida;

    @FXML
    private CheckBox checkData;

    @FXML
    private CheckBox checkHorario;

    @FXML
    private ListView<String> lista_partidas;

    @FXML
    private ImageView imageTime1;

    @FXML
    private ImageView imageTime2;

    @FXML
    private Label nome_user;

    @FXML
    private ImageView imagem_user;

    private ArrayList<Partida> arrayPartidas = new ArrayList<>();
    private ArrayList<String> arrayAux = new ArrayList<>();
    private ObservableList<String> observableList;

    private Partida partida = new Partida();
    private Time time = new Time();
    private Competicao comp = new Competicao();

    private TimeDAO timeDAO = new TimeDAO();
    private PartidaDAO partDAO = new PartidaDAO();


    private String nome;
    private int idPartidaSelecionada;
    private int idPartListView;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        BarraDeMenuDAO barra = new BarraDeMenuDAO();
        BarraDeMenuDAO barra1 = new BarraDeMenuDAO();
        nome_user.setText(barra.Nome());
        imagem_user.setImage(barra1.Imagem());
        
        CarregaPartidasCadastrados();

        lista_partidas.setOnMouseClicked(new EventHandler<MouseEvent>(){
    
            @Override
            public void handle(MouseEvent arg0) {
                idPartListView = lista_partidas.getSelectionModel().getSelectedIndex();
                idPartidaSelecionada = partDAO.getMinIdPart(comp.getIdSelecionaCampeonato(), idPartListView);
                
                for(int i = 0; i < arrayPartidas.size(); i++){
                    if(idPartidaSelecionada == arrayPartidas.get(i).getIdPartidaArray()){
                        imageTime1.setImage(timeDAO.buscaImagem(arrayPartidas.get(i).getFk_time1()));
                        imageTime2.setImage(timeDAO.buscaImagem(arrayPartidas.get(i).getFk_time2()));
                    }
                }
            }
  
        });
    } 
    
    private void CarregaPartidasCadastrados(){
        String abrev1, abrev2;
        arrayPartidas= partDAO.getListaPartidas(comp.getIdSelecionaCampeonato());
    
        //Para testes
        //arrayPartidas = partDAO.getListaPartidas(109);

        for(int i = 0; i < arrayPartidas.size(); i++){
            abrev1 = timeDAO.getAbrev(arrayPartidas.get(i).getFk_time1(), 1);
            abrev2 =  timeDAO.getAbrev(arrayPartidas.get(i).getFk_time2(), 2);
            nome = abrev1 + " X " + abrev2;
            System.out.println(nome);
            arrayAux.add(nome);
            
        }
        
        observableList = FXCollections.observableArrayList(arrayAux);

        lista_partidas.setItems(observableList);

    }

    @FXML
    private void acaoDoCheck(ActionEvent event){
        if(checkLocalPartida.isSelected()){
            txtLocalPartida.setEditable(true);
        } else{
            txtLocalPartida.setEditable(false);
        }

        if(checkHorario.isSelected()){
            txtHorarioPartida.setEditable(true);
        } else{
            txtHorarioPartida.setEditable(false);
        }

        if(checkData.isSelected()){
            txtDataPartida.setEditable(true);
        } else{
            txtDataPartida.setEditable(false);
        }

    }

    @FXML
    private void BotaoSalvar(ActionEvent event){

        if(checkLocalPartida.isSelected()){
            partDAO.atualizaLocal(txtLocalPartida.getText(), idPartidaSelecionada);
        } 
        if(checkHorario.isSelected()){
            partDAO.atualizaHorario(txtHorarioPartida.getText(), idPartidaSelecionada);
        }
        if(checkData.isSelected()){
            partDAO.atualizaData(txtDataPartida.getText(), idPartidaSelecionada);
        }
        
        
        JOptionPane.showMessageDialog(null, "Dado(os) atualizado(os) com sucesso!");
        
        refreshScreen();
    }

    @FXML
    public void acaoDeBusca(ActionEvent event){
        String busca = txtBusca.getText();

        Boolean ifContains = lista_partidas.getItems().contains(busca);
        if(ifContains == true){
            lista_partidas.getItems().add(0, busca);
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
        TelaEditPartidas.getStage().close();
    }

    private void refreshScreen(){
        TelaEditPartidas tela2 = new TelaEditPartidas() ;
        fecha();

        
            try {
                tela2.start(new Stage());
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        
    }
}
