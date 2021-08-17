/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package telacadcampeonato;

import dao.CompeticaoDAO;
import dao.DataSource;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;


import javax.swing.JOptionPane;

import com.mysql.cj.xdevapi.PreparableStatement;
import dao.BarraDeMenu;

import classes.Competicao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

/**
 *
 * @author Zairo Bastos
 * @author Leticia Torres
 */
public class TelaCadCampeonatoController implements Initializable {

    private Label label;

    @FXML
<<<<<<< HEAD
    private TextField txtNomeComp;
=======
    private TextField txt_nome_camp;
    
    @FXML
    private TextField nome_user;
>>>>>>> bb580e6b3fee51333fb0248cb399373a1c83c045

    @FXML
    private TextField txtPremiacao;

    @FXML
    private TextField txtDesc;

    @FXML
    private TextField txtDataInicio;

    @FXML
    private TextField txtDataTerminio;

    @FXML
    private RadioButton radQtd8;

    @FXML
    private RadioButton radQtd16;

    @FXML
    private Button btnAvancar;

<<<<<<< HEAD
    @FXML
    private ComboBox<Situacao> status;
=======
    private DatePicker data_terminio;
>>>>>>> bb580e6b3fee51333fb0248cb399373a1c83c045

    private List<Situacao> situacoes = new ArrayList<>();

    private ObservableList<Situacao> obsSituacao;
<<<<<<< HEAD

    
    @FXML
    private void acaoDoBotao(ActionEvent event){
        botaoAvancar();
=======
    @FXML
    private DatePicker data_temino;
    
    @FXML
    private void acaoDoBotao(ActionEvent event){
        cadastroCamp();
    }

    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
>>>>>>> bb580e6b3fee51333fb0248cb399373a1c83c045
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        BarraDeMenu barra = new BarraDeMenu();
        nome_user.setText(barra.Nome());
        
        carregaSituacao();
    } 
    
    public void carregaSituacao(){
        Situacao sit1 = new Situacao(1, "A iniciar");
        Situacao sit2 = new Situacao(2, "Em andamento");

        situacoes.add(sit1);
        situacoes.add(sit2);

        obsSituacao = FXCollections.observableArrayList(situacoes);

        status.setItems(obsSituacao);

    }

    public void botaoAvancar(){
       Competicao competicao = new Competicao();
       CompeticaoDAO compDAO = new CompeticaoDAO();

       Situacao situation = status.getSelectionModel().getSelectedItem();
       String sit = situation.getNome();
        
       competicao.setNomeCompeticao(txtNomeComp.getText());
       competicao.setPremiacao(txtPremiacao.getText());
       competicao.setDescricao(txtDesc.getText());
       competicao.setData_inicio(txtDataInicio.getText());
       competicao.setData_terminio(txtDataTerminio.getText());
       competicao.setSituacao(sit);
       if(radQtd16.isSelected()){
           competicao.setQtd_times("16");
       }
       if(radQtd8.isSelected()){
           competicao.setSituacao("8");
       }

       compDAO.cadastrarComp(competicao);
    }

}
