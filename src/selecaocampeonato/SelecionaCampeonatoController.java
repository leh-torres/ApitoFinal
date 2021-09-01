/*
 * 
 * 
 * @author Raylander Marques
 * @author Leticia Torres
 */
package selecaocampeonato;

import apitofinal.FXMLDocumentController;
import classes.Competicao;
import dao.BarraDeMenuDAO;
import dao.CompeticaoDAO;
import home.Home;

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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import telaUsuario.TelaUsuario;
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
    
    private ArrayList<Competicao> listaComp = new ArrayList<>();
    private CompeticaoDAO comp = new CompeticaoDAO();
    private Competicao comp1 = new Competicao();
    private Competicao comp2 = new Competicao();
    private Competicao comp3 = new Competicao();
    private Competicao comp4 = new Competicao();
    private Competicao comp5 = new Competicao();
    private Competicao comp6 = new Competicao();
    private Competicao comp7 = new Competicao();
    private Competicao comp8 = new Competicao();
    private Competicao comp9 = new Competicao();
    private Competicao comp10 = new Competicao();
    private Competicao comp11 = new Competicao();
    private Competicao comp12 = new Competicao();
    private Competicao comp13 = new Competicao();
    private Competicao comp14 = new Competicao();
    
    
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

        comp1.setIdSelecionaCampeonato(listaComp.get(0).getId_competicao());
        Home h = new Home();
        fecha();
        try {
            h.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    public void funcaoBtn2(ActionEvent event){
        comp2.setIdSelecionaCampeonato(listaComp.get(1).getId_competicao());
        Home h = new Home();
        fecha();
        try {
            h.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    }
    
    @FXML
    public void funcaoBtn3(ActionEvent event){

        Home h = new Home();
        comp3.setIdSelecionaCampeonato(listaComp.get(2).getId_competicao());
        fecha();
        try {
            h.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    @FXML
    public void funcaoBtn4(ActionEvent event){
        Home h = new Home();
        comp4.setIdSelecionaCampeonato(listaComp.get(3).getId_competicao());
        fecha();
        try {
            h.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    @FXML
    public void funcaoBtn5(ActionEvent event){
        
        Home h = new Home();
        comp5.setIdSelecionaCampeonato(listaComp.get(4).getId_competicao());
        fecha();
        try {
            h.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    @FXML
    public void funcaoBtn6(ActionEvent event){
        Home h = new Home();
        comp6.setIdSelecionaCampeonato(listaComp.get(5).getId_competicao());
        fecha();
        try {
            h.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    @FXML
    public void funcaoBtn7(ActionEvent event){
        Home h = new Home();
        comp7.setIdSelecionaCampeonato(listaComp.get(6).getId_competicao());
        fecha();
        try {
            h.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    @FXML
    public void funcaoBtn8(ActionEvent event){
        Home h = new Home();
        comp8.setIdSelecionaCampeonato(listaComp.get(7).getId_competicao());
        fecha();
        try {
            h.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    public void funcaoBtn9(ActionEvent event){
        Home h = new Home();
        comp9.setIdSelecionaCampeonato(listaComp.get(8).getId_competicao());
        fecha();
        try {
            h.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
    
    @FXML
    public void funcaoBtn10(ActionEvent event){
        Home h = new Home();
        comp10.setIdSelecionaCampeonato(listaComp.get(9).getId_competicao());
        fecha();
        try {
            h.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
    
    @FXML
    public void funcaoBtn11(ActionEvent event){
        
        Home h = new Home();
        comp11.setIdSelecionaCampeonato(listaComp.get(10).getId_competicao());
        fecha();
        try {
            h.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
         }
        
    }
    
    @FXML
    public void funcaoBtn12(ActionEvent event){
        Home h = new Home();
        comp12.setIdSelecionaCampeonato(listaComp.get(11).getId_competicao());
        fecha();
        try {
            h.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
         
    }
    
    @FXML
    public void funcaoBtn13(ActionEvent event){
        Home h = new Home();
        comp13.setIdSelecionaCampeonato(listaComp.get(12).getId_competicao());
        fecha();
        try {
            h.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
         
    }
    
    @FXML
    public void funcaoBtn14(ActionEvent event){
        Home h = new Home();
        comp14.setIdSelecionaCampeonato(listaComp.get(13).getId_competicao());
        fecha();
        try {
            h.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    @FXML
    public void funcaoBtn15(ActionEvent event){
    
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        BarraDeMenuDAO barra = new BarraDeMenuDAO();
        BarraDeMenuDAO barra1 = new BarraDeMenuDAO();
        nome_user.setText(barra.Nome());
        imagem_user.setImage(barra1.Imagem());
        listaComp = comp.verificaCampeonatoAberto();
        for(int i =0; i < listaComp.size(); i++){
            System.out.println(listaComp.get(i).getNomeCompeticao());
        } 
        
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

                comp1 = listaComp.get(0);
                comp2 = listaComp.get(1);
                comp3 = listaComp.get(2);
                comp4 = listaComp.get(3);
                comp5 = listaComp.get(4);
                comp6 = listaComp.get(5);
                comp7 = listaComp.get(6);
                comp8 = listaComp.get(7);
                comp9 = listaComp.get(8);
                comp10 = listaComp.get(9);
                comp11 = listaComp.get(10);
                comp12 = listaComp.get(11);
                comp13 = listaComp.get(12);
                comp14 = listaComp.get(13);
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

                comp1 = listaComp.get(0);
                comp2 = listaComp.get(1);
                comp3 = listaComp.get(2);
                comp4 = listaComp.get(3);
                comp5 = listaComp.get(4);
                comp6 = listaComp.get(5);
                comp7 = listaComp.get(6);
                comp8 = listaComp.get(7);
                comp9 = listaComp.get(8);
                comp10 = listaComp.get(9);
                comp11 = listaComp.get(10);
                comp12 = listaComp.get(11);
                comp13 = listaComp.get(12);
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

                comp1 = listaComp.get(0);
                comp2 = listaComp.get(1);
                comp3 = listaComp.get(2);
                comp4 = listaComp.get(3);
                comp5 = listaComp.get(4);
                comp6 = listaComp.get(5);
                comp7 = listaComp.get(6);
                comp8 = listaComp.get(7);
                comp9 = listaComp.get(8);
                comp10 = listaComp.get(9);
                comp11 = listaComp.get(10);
                comp12 = listaComp.get(11);
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

                comp1 = listaComp.get(0);
                comp2 = listaComp.get(1);
                comp3 = listaComp.get(2);
                comp4 = listaComp.get(3);
                comp5 = listaComp.get(4);
                comp6 = listaComp.get(5);
                comp7 = listaComp.get(6);
                comp8 = listaComp.get(7);
                comp9 = listaComp.get(8);
                comp10 = listaComp.get(9);
                comp11 = listaComp.get(10);
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

                comp1 = listaComp.get(0);
                comp2 = listaComp.get(1);
                comp3 = listaComp.get(2);
                comp4 = listaComp.get(3);
                comp5 = listaComp.get(4);
                comp6 = listaComp.get(5);
                comp7 = listaComp.get(6);
                comp8 = listaComp.get(7);
                comp9 = listaComp.get(8);
                comp10 = listaComp.get(9);
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

                comp1 = listaComp.get(0);
                comp2 = listaComp.get(1);
                comp3 = listaComp.get(2);
                comp4 = listaComp.get(3);
                comp5 = listaComp.get(4);
                comp6 = listaComp.get(5);
                comp7 = listaComp.get(6);
                comp8 = listaComp.get(7);
                comp9 = listaComp.get(8);
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

                comp1 = listaComp.get(0);
                comp2 = listaComp.get(1);
                comp3 = listaComp.get(2);
                comp4 = listaComp.get(3);
                comp5 = listaComp.get(4);
                comp6 = listaComp.get(5);
                comp7 = listaComp.get(6);
                comp8 = listaComp.get(7);
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

                comp1 = listaComp.get(0);
                comp2 = listaComp.get(1);
                comp3 = listaComp.get(2);
                comp4 = listaComp.get(3);
                comp5 = listaComp.get(4);
                comp6 = listaComp.get(5);
                comp7 = listaComp.get(6);
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

                comp1 = listaComp.get(0);
                comp2 = listaComp.get(1);
                comp3 = listaComp.get(2);
                comp4 = listaComp.get(3);
                comp5 = listaComp.get(4);
                comp6 = listaComp.get(5);
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

                comp1 = listaComp.get(0);
                comp2 = listaComp.get(1);
                comp3 = listaComp.get(2);
                comp4 = listaComp.get(3);
                comp5 = listaComp.get(4);
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

                comp1 = listaComp.get(0);
                comp2 = listaComp.get(1);
                comp3 = listaComp.get(2);
                comp4 = listaComp.get(3);
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

                comp1 = listaComp.get(0);
                comp2 = listaComp.get(1);
                comp3 = listaComp.get(2);
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

                comp1 = listaComp.get(0);
                comp2 = listaComp.get(1);
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

                comp1 = listaComp.get(0);
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
    
    public void fecha(){
        SelecaoCampeonato.getStage().close();
    }
    
    @FXML
    private void abreTelaUsuario(MouseEvent event){
        TelaUsuario telaUser = new TelaUsuario();
        
        try {
            telaUser.start(new Stage());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    
}
