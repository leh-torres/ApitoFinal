/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telaDefinirPartidas8;

import classes.Partida;
import classes.Time;
import dao.BarraDeMenuDAO;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import selecaocampeonato.SelecaoCampeonato;
import telaDefinirPartida.TelaDefinirPartida;

/**
 * FXML Controller class
 *
 * @author RonaldoMatos
 */
public class TelaDefinirPartidas8FXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private ImageView imagem_user;
    
    @FXML
    private Label nome_user;
    
    @FXML
    private ImageView time1;
    
    @FXML
    private ImageView time2;
    
    @FXML
    private ImageView time3;
    
    @FXML
    private ImageView time4;
    
    @FXML
    private ImageView time5;
    
    @FXML
    private ImageView time6;
    
    @FXML
    private ImageView time7;
    
    @FXML
    private ImageView time8;
    
    @FXML
    private Button part1;
    
    @FXML
    private Button part2;
    
    @FXML
    private Button part3;
    
    @FXML
    private Button part4;
    
    @FXML
    private Button part5;
    
    @FXML
    private Button part6;
    
    @FXML
    private Button part7;
    
    @FXML
    private ImageView concluir;
    
    private int[] id_sorteado = new int[9];
    ArrayList<Time> times = new ArrayList<>();
    Partida partida = new Partida();
    Time time = new Time();
    private int i;
    @FXML
    private Button bt_concluir;
    @FXML
    private Label nome_campeonato;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        times = time.getArrayTimes();
        id_sorteado = time.getId_sorteado();
        BarraDeMenuDAO barra = new BarraDeMenuDAO();
        BarraDeMenuDAO barra1 = new BarraDeMenuDAO();
        nome_user.setText(barra.Nome());
        imagem_user.setImage(barra1.Imagem());
        InputStream imageFile = null;
        
        for(i=0;i<8;i++){ 
            try {    
                imageFile = times.get(id_sorteado[i]).getImagem_time().getBinaryStream();
                Image image = new Image(imageFile);
                if(i == 0){
                    time1.setImage(image);
                }
                else if(i == 1){
                    time2.setImage(image);
                }
                else if(i == 2){
                    time3.setImage(image);
                }
                else if(i == 3){
                    time4.setImage(image);
                }
                else if(i == 4){
                    time5.setImage(image);
                }
                else if(i == 5){
                    time6.setImage(image);
                }
                else if(i == 6){
                    time7.setImage(image);
                }
                else if(i == 7){
                    time8.setImage(image);
                }
            } catch (SQLException ex) {
                Logger.getLogger(TelaDefinirPartidas8FXMLController.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    imageFile.close();
                } catch (IOException ex) {
                    Logger.getLogger(TelaDefinirPartidas8FXMLController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }  
    
    @FXML
    public void acaoPart1(ActionEvent event) throws IOException{
        TelaDefinirPartida tela = new TelaDefinirPartida();
        partida.setId_time1(times.get(id_sorteado[0]).getId_time());
        partida.setId_time2(times.get(id_sorteado[1]).getId_time());
        tela.start(new Stage());
        part1.setDisable(true);
    }
    
    @FXML
    public void acaoPart2(ActionEvent event) throws IOException{
        TelaDefinirPartida tela = new TelaDefinirPartida();
        partida.setId_time1(times.get(id_sorteado[2]).getId_time());
        partida.setId_time2(times.get(id_sorteado[3]).getId_time());
        tela.start(new Stage());
        part2.setDisable(true);    
    }
    
    @FXML
    public void acaoPart3(ActionEvent event) throws IOException{
        TelaDefinirPartida tela = new TelaDefinirPartida();
        partida.setId_time1(times.get(id_sorteado[4]).getId_time());
        partida.setId_time2(times.get(id_sorteado[5]).getId_time());
        tela.start(new Stage());
        part3.setDisable(true);  
    }
    
    @FXML
    public void acaoPart4(ActionEvent event) throws IOException{
        TelaDefinirPartida tela = new TelaDefinirPartida();
        partida.setId_time1(times.get(id_sorteado[6]).getId_time());
        partida.setId_time2(times.get(id_sorteado[7]).getId_time());
        tela.start(new Stage());
        part4.setDisable(true);  
    }
    
    @FXML
    public void acaoPart5(ActionEvent event) throws IOException{
        TelaDefinirPartida tela = new TelaDefinirPartida();
        partida.setId_time1(0);
        partida.setId_time2(0);
        tela.start(new Stage());
        part5.setDisable(true);
    }
    
    @FXML
    public void acaoPart6(ActionEvent event) throws IOException{
        TelaDefinirPartida tela = new TelaDefinirPartida();
        partida.setId_time1(0);
        partida.setId_time2(0);
        tela.start(new Stage());
        part6.setDisable(true);
    }
    
    @FXML
    public void acaoPart7(ActionEvent event) throws IOException{
        TelaDefinirPartida tela = new TelaDefinirPartida();
        partida.setId_time1(0);
        partida.setId_time2(0);
        tela.start(new Stage());
        part7.setDisable(true);
    }
    
    @FXML
    public void acaoConcluir(ActionEvent event) throws Exception{
        SelecaoCampeonato tela1 = new SelecaoCampeonato();
        fecha();
        tela1.start(new Stage());
        fecha();
        
    }
    
     public void fecha(){
        TelaDefinirPartidas8.getStage().close();
    }

    
}
