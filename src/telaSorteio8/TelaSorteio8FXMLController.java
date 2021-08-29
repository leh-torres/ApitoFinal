/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telaSorteio8;

import classes.Time;
import dao.BarraDeMenuDAO;
import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author RonaldoMatos
 */
public class TelaSorteio8FXMLController implements Initializable {
    
    
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
    private ImageView time_sorteado;
    
    @FXML
    private ImageView imagem_fundo;
    
    private int i = 0;
    private int count = 0;
    private int[] id_sorteado;
    ArrayList<Time> times = new ArrayList<>();
    @FXML
    private ImageView imagem_user;
    @FXML
    private Button bt_sortear;
    @FXML
    private Label txt_nomecamp;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        BarraDeMenuDAO barra = new BarraDeMenuDAO();
        BarraDeMenuDAO barra1 = new BarraDeMenuDAO();
        Image image = new Image(getClass().getResourceAsStream("/resources/Árvore 8.png"));
        Time time = new Time();
        times = time.getArrayTimes();
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
    }    
    
    public void acaoBotaoSortear(ActionEvent event) throws SQLException{
        sortear();
        InputStream imageFile = times.get(id_sorteado[i-1]).getImagem_time().getBinaryStream();
        Image image = new Image(imageFile);
        time_sorteado.setImage(image);
        
        if(count == 0){
            time1.setImage(image);
        }
        else if(count ==1){
            time2.setImage(image);
        }
        else if(count ==2){
            time3.setImage(image);
        }
        else if(count ==3){
            time4.setImage(image);
        }
        else if(count ==4){
            time5.setImage(image);
        }
        else if(count ==5){
            time6.setImage(image);
        }
        else if(count ==6){
            time7.setImage(image);
        }
        else if(count ==7){
            time8.setImage(image);
        }
    }
    
    private void sortear(){
        Random random = new Random();
        id_sorteado[i] = random.nextInt(7);
        i++;
        for(int j=0; j<i;j++){
            if(id_sorteado[i] == id_sorteado[j]){
                i--;
                sortear();
            }
        }
    }
    
}
