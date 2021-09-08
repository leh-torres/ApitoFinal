/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela.estatisticas;

import java.net.URL;
import java.util.ResourceBundle;

import classes.Partida;
import classes.Time;
import dao.BarraDeMenuDAO;
import dao.PartidaDAO;
import dao.TimeDAO;
import home.Home;
import java.util.Random;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

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
    private ImageView imagem_user;
    
    @FXML
    private Label nome_user;
    
    @FXML
    private Label abrev1;
    
    @FXML
    private Label abrev2;
    
    @FXML
    private ImageView logo1;
    
    @FXML
    private ImageView logo2;
    
    @FXML
    private void acaoDoBotaoSalvar(ActionEvent event) throws Exception {
        salvarGols();
    }
    
    Partida partida = new Partida();
    TimeDAO time = new TimeDAO();
    private int id;
    private static int[] id_ganhador = new int[8];
    private static int cont;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        BarraDeMenuDAO barra = new BarraDeMenuDAO();
        BarraDeMenuDAO barra1 = new BarraDeMenuDAO();
        nome_user.setText(barra.Nome());
        imagem_user.setImage(barra1.Imagem());
        
        abrev1.setText(time.getAbrev(partida.getId_part(), 1));
        abrev2.setText(time.getAbrev(partida.getId_part1(), 2));
        
        logo1.setImage(time.getImagem(partida.getId_part(),1));
        logo2.setImage(time.getImagem(partida.getId_part1(),2));
             
        
    }    
    
    private void salvarGols() throws Exception{
        
        PartidaDAO partDAO = new PartidaDAO();
        String placar;

        placar = time_1.getText() + "x" + time_2.getText();

        
        partida.setId_part(partida.getId_part());
        partida.setPlacar_part(placar);
        
        partDAO.setPlacar(partida);
        cont ++;
        
        if(time_1.getText().compareTo(time_2.getText()) < 0){
            Time time = new Time();
            id_ganhador[cont-1] = partida.getId_part();
            time.setId_ganhador(id_ganhador);
        }
        else if(time_1.getText().compareTo(time_2.getText()) > 0){
            Time time = new Time();
            id_ganhador[cont-1] = partida.getId_part1();
            time.setId_ganhador(id_ganhador);
        }
        else{
            Random random = new Random();
            id = random.nextInt(2);
            if(id == 1){
             Time time = new Time();
            id_ganhador[cont-1] = partida.getId_part();
            time.setId_ganhador(id_ganhador);
            }
            else {
            Time time = new Time();
            id_ganhador[cont-1] = partida.getId_part1();
            time.setId_ganhador(id_ganhador);
            }
        }
        
        telaHome();
        fecha();
    }
    
    private void telaHome() throws Exception{
        Home tela = new Home();
        
        tela.start(new Stage());
        fecha();
    }
    
    private void fecha(){
        TelaEstatisticas.getStage().close();
    }
}
