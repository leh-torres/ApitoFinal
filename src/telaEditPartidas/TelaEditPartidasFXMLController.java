/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telaEditPartidas;

import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.mysql.cj.jdbc.Blob;

import classes.Competicao;
import classes.Partida;
import classes.Time;
import dao.BarraDeMenuDAO;
import dao.PartidaDAO;
import dao.TimeDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

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
    private ListView<String> lista_times;

    @FXML
    private ImageView imageTime1;

    @FXML
    private ImageView imageTime2;

    @FXML
    private Label nome_user;

    @FXML
    private ImageView imagem_user;

    private ArrayList<Partida> arrayPartidas = new ArrayList<>();
    private ArrayList<Time> arrayTimesAux = new ArrayList<>();
    private ArrayList<String> arrayAux = new ArrayList<>();
    private ArrayList<String> arrayAux1 = new ArrayList<>();
    private ObservableList<String> observableList;
    private ObservableList<String> observableList1;

    private Partida partida = new Partida();
    private Time time1 = new Time();
    private Time time2 = new Time();
    private Competicao comp = new Competicao();

    private TimeDAO timeDAO = new TimeDAO();
    private PartidaDAO partDAO = new PartidaDAO();

    private String auxNome;
    private String auxAbrv;
    private Blob auxImagem;
    private String nome;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        BarraDeMenuDAO barra = new BarraDeMenuDAO();
        BarraDeMenuDAO barra1 = new BarraDeMenuDAO();
        nome_user.setText(barra.Nome());
        imagem_user.setImage(barra1.Imagem());
        System.out.println("Entrou no initialize");
        CarregaTimesCadastrados();

        lista_times.setOnMouseClicked(new EventHandler<MouseEvent>(){
    
            @Override
            public void handle(MouseEvent arg0) {
                nome = lista_times.getSelectionModel().getSelectedItem();
                
                for(int i = 0; i < arrayPartidas.size(); i++){
                        Time time = new Time();
                        /*auxNome = arrayTimes.get(i).getNome_time();
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
                        }*/
                }
            }
  
        });
    } 
    
    private void CarregaTimesCadastrados(){
        String abrev1, abrev2;
        //arrayPartidas= partDAO.getListaPartidas(comp.getIdSelecionaCampeonato());
    
        //Para testes
        arrayPartidas = partDAO.getListaPartidas(109);

        for(int i = 0; i < arrayPartidas.size(); i++){
            abrev1 = timeDAO.getAbrev(arrayPartidas.get(i).getFk_time1(), 1);
            abrev2 =  timeDAO.getAbrev(arrayPartidas.get(i).getFk_time2(), 2);
            nome = abrev1 + " X " + abrev2;
            System.out.println(nome);
            arrayAux.add(nome);
            
        }
        
        observableList = FXCollections.observableArrayList(arrayAux);

        lista_times.setItems(observableList);

    }
    
}
