/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela.estatisticas;

import java.net.URL;
import java.util.ResourceBundle;

import classes.Partida;
import dao.PartidaDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author Zairo Bastos
 * @author Leticia Torres
 */
public class TelaEstatisticaController implements Initializable {
    
    @FXML
    private Label label;

    @FXML
    private TextField time_1;

    @FXML
    private TextField time_2;

    @FXML
    private Button btn_salvar;
    
    @FXML
    private void acaoDoBotaoSalvar(ActionEvent event) {
        salvarGols();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    private void salvarGols(){
        Partida partida = new Partida();
        PartidaDAO partDAO = new PartidaDAO();
        String placar;

        placar = time_1.getText() + "x" + time_2.getText();

        partida.setId_part(1);
        partida.setPlacar_part(placar);
        
        partDAO.setPlacar(partida);
    }
}
