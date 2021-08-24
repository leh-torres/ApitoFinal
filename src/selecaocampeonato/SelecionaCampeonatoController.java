/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selecaocampeonato;

import apitofinal.FXMLDocumentController;
import classes.Competicao;
import dao.BarraDeMenuDAO;
import dao.CompeticaoDAO;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import telacadcampeonato.TelaCadCampeonato;

/**
 *
 * @author Zairo Bastos
 */
public class SelecionaCampeonatoController implements Initializable {
    
    byte[] imgByte = null;
    
    @FXML
    private ImageView imagem_user;
    
    @FXML 
    private Label nome_user;
    
    @FXML
    private Button btn1;
    
    @FXML
    private Button btn2;
    
    @FXML
    private Button btn3;
    
    @FXML
    private Button btn4;
    
    @FXML
    private Button btn5;
    
    @FXML
    private Button btn6;
    
    @FXML
    private Button btn7;
    
    @FXML
    private Button btn8;
    
    @FXML
    private Button btn9;
    
    @FXML
    private Button btn10;
    
    @FXML
    private Button btn11;
    
    @FXML
    private Button btn12;
    
    @FXML
    private Button btn13;
    
    @FXML
    private Button btn14;
    
    @FXML
    private Button btn15;
    
    @FXML
    private Button btn_cad;
    
    ArrayList<Competicao> listaComp = new ArrayList<>();
    CompeticaoDAO comp = new CompeticaoDAO();
    
    @FXML
    public void funcaoBtnCad(ActionEvent event) {
        TelaCadCampeonato tela = new TelaCadCampeonato();
                fecha();

                try {
                tela.start(new Stage());
            } catch (Exception ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    @FXML
    public void funcaoBtn1(ActionEvent event){
        
    }
    
    @FXML
    public void funcaoBtn2(ActionEvent event){
    
    }
    
    @FXML
    public void funcaoBtn3(ActionEvent event){
    
    }
    
    @FXML
    public void funcaoBtn4(ActionEvent event){
    
    }
    
    @FXML
    public void funcaoBtn5(ActionEvent event){
    
    }
    
    @FXML
    public void funcaoBtn6(ActionEvent event){
    
    }
    
    @FXML
    public void funcaoBtn7(ActionEvent event){
    
    }
    
    @FXML
    public void funcaoBtn8(ActionEvent event){
    
    }
    
    @FXML
    public void funcaoBtn9(ActionEvent event){
    
    }
    
    @FXML
    public void funcaoBtn10(ActionEvent event){
    
    }
    
    @FXML
    public void funcaoBtn11(ActionEvent event){
    
    }
    
    @FXML
    public void funcaoBtn12(ActionEvent event){
    
    }
    
    @FXML
    public void funcaoBtn13(ActionEvent event){
    
    }
    
    @FXML
    public void funcaoBtn14(ActionEvent event){
    
    }
    
    @FXML
    public void funcaoBtn15(ActionEvent event){
    
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        BarraDeMenuDAO barra = new BarraDeMenuDAO();
        BarraDeMenuDAO barra1 = new BarraDeMenuDAO();
        nome_user.setText(barra.Nome());
        listaComp = comp.verificaCampeonatoAberto(); 
        imagem_user.setImage(barra1.Imagem());

        switch (listaComp.size()) {
            case 14:
                btn15.setDisable(true);
                
                btn14.setText(comp.Nome(listaComp.get(13).getId_competicao()));
                btn13.setText(comp.Nome(listaComp.get(12).getId_competicao()));
                btn12.setText(comp.Nome(listaComp.get(11).getId_competicao()));
                btn11.setText(comp.Nome(listaComp.get(10).getId_competicao()));
                btn10.setText(comp.Nome(listaComp.get(9).getId_competicao()));
                btn9.setText(comp.Nome(listaComp.get(8).getId_competicao()));
                btn8.setText(comp.Nome(listaComp.get(7).getId_competicao()));
                btn7.setText(comp.Nome(listaComp.get(6).getId_competicao()));
                btn6.setText(comp.Nome(listaComp.get(5).getId_competicao()));
                btn5.setText(comp.Nome(listaComp.get(4).getId_competicao()));
                btn4.setText(comp.Nome(listaComp.get(3).getId_competicao()));
                btn3.setText(comp.Nome(listaComp.get(2).getId_competicao()));
                btn2.setText(comp.Nome(listaComp.get(1).getId_competicao()));
                btn1.setText(comp.Nome(listaComp.get(0).getId_competicao()));
                break;
            case 13:
                btn15.setDisable(true);
                btn14.setDisable(true);
                
                btn13.setText(comp.Nome(listaComp.get(12).getId_competicao()));
                btn12.setText(comp.Nome(listaComp.get(11).getId_competicao()));
                btn11.setText(comp.Nome(listaComp.get(10).getId_competicao()));
                btn10.setText(comp.Nome(listaComp.get(9).getId_competicao()));
                btn9.setText(comp.Nome(listaComp.get(8).getId_competicao()));
                btn8.setText(comp.Nome(listaComp.get(7).getId_competicao()));
                btn7.setText(comp.Nome(listaComp.get(6).getId_competicao()));
                btn6.setText(comp.Nome(listaComp.get(5).getId_competicao()));
                btn5.setText(comp.Nome(listaComp.get(4).getId_competicao()));
                btn4.setText(comp.Nome(listaComp.get(3).getId_competicao()));
                btn3.setText(comp.Nome(listaComp.get(2).getId_competicao()));
                btn2.setText(comp.Nome(listaComp.get(1).getId_competicao()));
                btn1.setText(comp.Nome(listaComp.get(0).getId_competicao()));
                break;
            case 12:
                btn15.setDisable(true);
                btn14.setDisable(true);
                btn13.setDisable(true);
                
                btn12.setText(comp.Nome(listaComp.get(11).getId_competicao()));
                btn11.setText(comp.Nome(listaComp.get(10).getId_competicao()));
                btn10.setText(comp.Nome(listaComp.get(9).getId_competicao()));
                btn9.setText(comp.Nome(listaComp.get(8).getId_competicao()));
                btn8.setText(comp.Nome(listaComp.get(7).getId_competicao()));
                btn7.setText(comp.Nome(listaComp.get(6).getId_competicao()));
                btn6.setText(comp.Nome(listaComp.get(5).getId_competicao()));
                btn5.setText(comp.Nome(listaComp.get(4).getId_competicao()));
                btn4.setText(comp.Nome(listaComp.get(3).getId_competicao()));
                btn3.setText(comp.Nome(listaComp.get(2).getId_competicao()));
                btn2.setText(comp.Nome(listaComp.get(1).getId_competicao()));
                btn1.setText(comp.Nome(listaComp.get(0).getId_competicao()));
                break;
            case 11:
                btn15.setDisable(true);
                btn14.setDisable(true);
                btn13.setDisable(true);
                btn12.setDisable(true);
                
                btn11.setText(comp.Nome(listaComp.get(10).getId_competicao()));
                btn10.setText(comp.Nome(listaComp.get(9).getId_competicao()));
                btn9.setText(comp.Nome(listaComp.get(8).getId_competicao()));
                btn8.setText(comp.Nome(listaComp.get(7).getId_competicao()));
                btn7.setText(comp.Nome(listaComp.get(6).getId_competicao()));
                btn6.setText(comp.Nome(listaComp.get(5).getId_competicao()));
                btn5.setText(comp.Nome(listaComp.get(4).getId_competicao()));
                btn4.setText(comp.Nome(listaComp.get(3).getId_competicao()));
                btn3.setText(comp.Nome(listaComp.get(2).getId_competicao()));
                btn2.setText(comp.Nome(listaComp.get(1).getId_competicao()));
                btn1.setText(comp.Nome(listaComp.get(0).getId_competicao()));
                break;
            case 10:
                btn15.setDisable(true);
                btn14.setDisable(true);
                btn13.setDisable(true);
                btn12.setDisable(true);
                btn11.setDisable(true);
                
                btn10.setText(comp.Nome(listaComp.get(9).getId_competicao()));
                btn9.setText(comp.Nome(listaComp.get(8).getId_competicao()));
                btn8.setText(comp.Nome(listaComp.get(7).getId_competicao()));
                btn7.setText(comp.Nome(listaComp.get(6).getId_competicao()));
                btn6.setText(comp.Nome(listaComp.get(5).getId_competicao()));
                btn5.setText(comp.Nome(listaComp.get(4).getId_competicao()));
                btn4.setText(comp.Nome(listaComp.get(3).getId_competicao()));
                btn3.setText(comp.Nome(listaComp.get(2).getId_competicao()));
                btn2.setText(comp.Nome(listaComp.get(1).getId_competicao()));
                btn1.setText(comp.Nome(listaComp.get(0).getId_competicao()));
                break;
            case 9:
                btn15.setDisable(true);
                btn14.setDisable(true);
                btn13.setDisable(true);
                btn12.setDisable(true);
                btn11.setDisable(true);
                btn10.setDisable(true);
                
                btn9.setText(comp.Nome(listaComp.get(8).getId_competicao()));
                btn8.setText(comp.Nome(listaComp.get(7).getId_competicao()));
                btn7.setText(comp.Nome(listaComp.get(6).getId_competicao()));
                btn6.setText(comp.Nome(listaComp.get(5).getId_competicao()));
                btn5.setText(comp.Nome(listaComp.get(4).getId_competicao()));
                btn4.setText(comp.Nome(listaComp.get(3).getId_competicao()));
                btn3.setText(comp.Nome(listaComp.get(2).getId_competicao()));
                btn2.setText(comp.Nome(listaComp.get(1).getId_competicao()));
                btn1.setText(comp.Nome(listaComp.get(0).getId_competicao()));
                break;
            case 8:
                btn15.setDisable(true);
                btn14.setDisable(true);
                btn13.setDisable(true);
                btn12.setDisable(true);
                btn11.setDisable(true);
                btn10.setDisable(true);
                btn9.setDisable(true);
                
                btn8.setText(comp.Nome(listaComp.get(7).getId_competicao()));
                btn7.setText(comp.Nome(listaComp.get(6).getId_competicao()));
                btn6.setText(comp.Nome(listaComp.get(5).getId_competicao()));
                btn5.setText(comp.Nome(listaComp.get(4).getId_competicao()));
                btn4.setText(comp.Nome(listaComp.get(3).getId_competicao()));
                btn3.setText(comp.Nome(listaComp.get(2).getId_competicao()));
                btn2.setText(comp.Nome(listaComp.get(1).getId_competicao()));
                btn1.setText(comp.Nome(listaComp.get(0).getId_competicao()));
                break;
            case 7:
                btn15.setDisable(true);
                btn14.setDisable(true);
                btn13.setDisable(true);
                btn12.setDisable(true);
                btn11.setDisable(true);
                btn10.setDisable(true);
                btn9.setDisable(true);
                btn8.setDisable(true);
                
                btn7.setText(comp.Nome(listaComp.get(6).getId_competicao()));
                btn6.setText(comp.Nome(listaComp.get(5).getId_competicao()));
                btn5.setText(comp.Nome(listaComp.get(4).getId_competicao()));
                btn4.setText(comp.Nome(listaComp.get(3).getId_competicao()));
                btn3.setText(comp.Nome(listaComp.get(2).getId_competicao()));
                btn2.setText(comp.Nome(listaComp.get(1).getId_competicao()));
                btn1.setText(comp.Nome(listaComp.get(0).getId_competicao()));
                break;
            case 6:
                btn15.setDisable(true);
                btn14.setDisable(true);
                btn13.setDisable(true);
                btn12.setDisable(true);
                btn11.setDisable(true);
                btn10.setDisable(true);
                btn9.setDisable(true);
                btn8.setDisable(true);
                btn7.setDisable(true);
                
                btn6.setText(comp.Nome(listaComp.get(5).getId_competicao()));
                btn5.setText(comp.Nome(listaComp.get(4).getId_competicao()));
                btn4.setText(comp.Nome(listaComp.get(3).getId_competicao()));
                btn3.setText(comp.Nome(listaComp.get(2).getId_competicao()));
                btn2.setText(comp.Nome(listaComp.get(1).getId_competicao()));
                btn1.setText(comp.Nome(listaComp.get(0).getId_competicao()));
                break;
            case 5:
                btn15.setDisable(true);
                btn14.setDisable(true);
                btn13.setDisable(true);
                btn12.setDisable(true);
                btn11.setDisable(true);
                btn10.setDisable(true);
                btn9.setDisable(true);
                btn8.setDisable(true);
                btn7.setDisable(true);
                btn6.setDisable(true);
                
                btn5.setText(comp.Nome(listaComp.get(4).getId_competicao()));
                btn4.setText(comp.Nome(listaComp.get(3).getId_competicao()));
                btn3.setText(comp.Nome(listaComp.get(2).getId_competicao()));
                btn2.setText(comp.Nome(listaComp.get(1).getId_competicao()));
                btn1.setText(comp.Nome(listaComp.get(0).getId_competicao()));
                break;
            case 4:
                btn15.setDisable(true);
                btn14.setDisable(true);
                btn13.setDisable(true);
                btn12.setDisable(true);
                btn11.setDisable(true);
                btn10.setDisable(true);
                btn9.setDisable(true);
                btn8.setDisable(true);
                btn7.setDisable(true);
                btn6.setDisable(true);
                btn5.setDisable(true);
                
                btn4.setText(comp.Nome(listaComp.get(3).getId_competicao()));
                btn3.setText(comp.Nome(listaComp.get(2).getId_competicao()));
                btn2.setText(comp.Nome(listaComp.get(1).getId_competicao()));
                btn1.setText(comp.Nome(listaComp.get(0).getId_competicao()));
                break;
            case 3:
                btn15.setDisable(true);
                btn14.setDisable(true);
                btn13.setDisable(true);
                btn12.setDisable(true);
                btn11.setDisable(true);
                btn10.setDisable(true);
                btn9.setDisable(true);
                btn8.setDisable(true);
                btn7.setDisable(true);
                btn6.setDisable(true);
                btn5.setDisable(true);
                btn4.setDisable(true);
                
                btn3.setText(comp.Nome(listaComp.get(2).getId_competicao()));
                btn2.setText(comp.Nome(listaComp.get(1).getId_competicao()));
                btn1.setText(comp.Nome(listaComp.get(0).getId_competicao()));
                break;
            case 2:
                btn15.setDisable(true);
                btn14.setDisable(true);
                btn13.setDisable(true);
                btn12.setDisable(true);
                btn11.setDisable(true);
                btn10.setDisable(true);
                btn9.setDisable(true);
                btn8.setDisable(true);
                btn7.setDisable(true);
                btn6.setDisable(true);
                btn5.setDisable(true);
                btn4.setDisable(true);
                btn3.setDisable(true);
               
                btn2.setText(comp.Nome(listaComp.get(1).getId_competicao()));
                btn1.setText(comp.Nome(listaComp.get(0).getId_competicao()));
                break;
            case 1:
                btn15.setDisable(true);
                btn14.setDisable(true);
                btn13.setDisable(true);
                btn12.setDisable(true);
                btn11.setDisable(true);
                btn10.setDisable(true);
                btn9.setDisable(true);
                btn8.setDisable(true);
                btn7.setDisable(true);
                btn6.setDisable(true);
                btn5.setDisable(true);
                btn4.setDisable(true);
                btn3.setDisable(true);
                btn2.setDisable(true);
                
                btn1.setText(comp.Nome(listaComp.get(0).getId_competicao()));
                break;
            default:
                btn15.setText(comp.Nome(listaComp.get(14).getId_competicao()));
                btn14.setText(comp.Nome(listaComp.get(13).getId_competicao()));
                btn13.setText(comp.Nome(listaComp.get(12).getId_competicao()));
                btn12.setText(comp.Nome(listaComp.get(11).getId_competicao()));
                btn11.setText(comp.Nome(listaComp.get(10).getId_competicao()));
                btn10.setText(comp.Nome(listaComp.get(9).getId_competicao()));
                btn9.setText(comp.Nome(listaComp.get(8).getId_competicao()));
                btn8.setText(comp.Nome(listaComp.get(7).getId_competicao()));
                btn7.setText(comp.Nome(listaComp.get(6).getId_competicao()));
                btn6.setText(comp.Nome(listaComp.get(5).getId_competicao()));
                btn5.setText(comp.Nome(listaComp.get(4).getId_competicao()));
                btn4.setText(comp.Nome(listaComp.get(3).getId_competicao()));
                btn3.setText(comp.Nome(listaComp.get(2).getId_competicao()));
                btn2.setText(comp.Nome(listaComp.get(1).getId_competicao()));
                btn1.setText(comp.Nome(listaComp.get(0).getId_competicao()));
                break;
        }
    }    
    
    private void fecha(){
        SelecaoCampeonato.getStage().close();
    }
    
}
