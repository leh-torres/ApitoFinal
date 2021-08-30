/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TelaSorteio16;

import classes.Time;
import dao.BarraDeMenuDAO;
import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
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
import telaDefinirPartidas16.TelaDefinirPartidas16Main;

/**
 * FXML Controller class
 *
 * @author RonaldoMatos
 */
public class TelaSorteio16FXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private Label nome_user;
    
    @FXML
    private Label abrev1;
    
    @FXML
    private Label abrev2;
    
    @FXML
    private Label abrev3;
    
    @FXML
    private Label abrev4;
    
    @FXML
    private Label abrev5;
    
    @FXML
    private Label abrev6;
    
    @FXML
    private Label abrev7;
    
    @FXML
    private Label abrev8;
    
    @FXML
    private Label abrev9;
    
    @FXML
    private Label abrev10;
    
    @FXML
    private Label abrev11;
    
    @FXML
    private Label abrev12;
    
    @FXML
    private Label abrev13;
    
    @FXML
    private Label abrev14;
    
    @FXML
    private Label abrev15;
    
    @FXML
    private Label abrev16;
    
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
    private ImageView time9;
    
    @FXML
    private ImageView time10;
    
    @FXML
    private ImageView time11;
    
    @FXML
    private ImageView time12;
    
    @FXML
    private ImageView time13;
    
    @FXML
    private ImageView time14;
    
    @FXML
    private ImageView time15;
    
    @FXML
    private ImageView time16;
    
    @FXML
    private ImageView time_sorteado;
    
    private ImageView imagem_fundo;
    
    private int i = 0;
    private int j = 0;
    private int id = 0;
    private boolean testa;
    private int count = 0;
    private int[] id_sorteado = new int[17];
    ArrayList<Time> times = new ArrayList<>();
    @FXML
    private ImageView imagem_user;
    @FXML
    private Button bt_sortear;
    
    Time time = new Time(); 
    @FXML
    private Label nome_campeonato;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        times = time.getArrayTimes();
        sortear();
        BarraDeMenuDAO barra = new BarraDeMenuDAO();
        BarraDeMenuDAO barra1 = new BarraDeMenuDAO();
        Image image = new Image(getClass().getResourceAsStream("/resources/Árvore 16.png"));
        
        nome_user.setText(barra.Nome());
        imagem_user.setImage(barra1.Imagem());
        //imagem_fundo.setImage(image);
        
        
        abrev1.setText(times.get(0).getAbreviacao_time());
        abrev2.setText(times.get(1).getAbreviacao_time());
        abrev3.setText(times.get(2).getAbreviacao_time());
        abrev4.setText(times.get(3).getAbreviacao_time());
        abrev5.setText(times.get(4).getAbreviacao_time());
        abrev6.setText(times.get(5).getAbreviacao_time());
        abrev7.setText(times.get(6).getAbreviacao_time());
        abrev8.setText(times.get(7).getAbreviacao_time());
        abrev9.setText(times.get(8).getAbreviacao_time());
        abrev10.setText(times.get(9).getAbreviacao_time());
        abrev11.setText(times.get(10).getAbreviacao_time());
        abrev12.setText(times.get(11).getAbreviacao_time());
        abrev13.setText(times.get(12).getAbreviacao_time());
        abrev14.setText(times.get(13).getAbreviacao_time());
        abrev15.setText(times.get(14).getAbreviacao_time());
        abrev16.setText(times.get(15).getAbreviacao_time());
    }    
    
    public void acaoBotaoSortear(ActionEvent event) throws SQLException{
        InputStream imageFile = times.get(id_sorteado[count]).getImagem_time().getBinaryStream();
        Image image = new Image(imageFile);
        time_sorteado.setImage(image);
        
        if(count == 0){
            time1.setImage(image);
        }
        else if(count == 1){
            time2.setImage(image);
        }
        else if(count == 2){
            time3.setImage(image);
        }
        else if(count == 3){
            time4.setImage(image);
        }
        else if(count == 4){
            time5.setImage(image);
        }
        else if(count == 5){
            time6.setImage(image);
        }
        else if(count == 6){
            time7.setImage(image);
        }
        else if(count == 7){
            time8.setImage(image);
        }
        else if(count == 8){
            time9.setImage(image);
        }
        else if(count == 9){
            time10.setImage(image);
        }
        else if(count == 10){
            time11.setImage(image);
        }
        else if(count == 11){
            time12.setImage(image);
        }
        else if(count == 12){
            time13.setImage(image);
        }
        else if(count == 13){
            time14.setImage(image);
        }
        else if(count == 14){
            time15.setImage(image);
        }
        else if(count == 15){
            time16.setImage(image);
        }
        count ++ ;
    }
    
    private void sortear(){
        System.out.println("Antes do Random");
        Random random = new Random();
        System.out.println("Depois do Random");
        
        for( i=0; i<times.size(); i++){
            System.out.println("Entrou no for");
             id = random.nextInt(30);
             System.out.println(id);
             for( j=0;j<i;j++){
                 System.out.println("Entrou no segundo for");
                   if(id == id_sorteado[j] ){
                         sortear();   
                   }else{
                        id_sorteado[i] = id;                        
                   }
             }
        }
    }
    
    public void acaoBotaoProximo(ActionEvent event){
        time.setId_sorteado(id_sorteado);
        trocarTela();
    }
    
    private void trocarTela(){
        TelaDefinirPartidas16Main tela1 = new TelaDefinirPartidas16Main();
            fecha();

            try {
            tela1.start(new Stage());
            } catch (Exception ex) {
            Logger.getLogger(TelaSorteio16FXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    private void fecha(){
        TelaSorteio16.getStage().close();
    }
    
}
