/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telaDefinirPartida;

import classes.Partida;
import classes.Time;
import dao.PartidaDAO;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author RonaldoMatos
 */
public class TelaDefinirPartidaFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private TextField local_partida;
    
    @FXML
    private TextField data_partida;
    
    @FXML
    private TextField horario_partida;
    
    private int id_time1;
    private int id_time2;
    private int id_comp;
    
    Partida partida = new Partida();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        id_time1 = partida.getId_time1();
        id_time2 = partida.getId_time2();
        id_comp = partida.getId_comp();
    }    
    
    public void acaoBotaoSalvar(ActionEvent event){
        PartidaDAO part = new PartidaDAO();
        part.cadastrarPart(data_partida.getText(), horario_partida.getText(), local_partida.getText(), id_comp, id_time1, id_time2);
        fecha();
    }
    
    private void fecha(){
        TelaDefinirPartida.getStage().close();
    }
    
}
