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

    @FXML
    private Label label;

    @FXML
    private TextField txtNomeComp;

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

    @FXML
    private ComboBox<Situacao> status;

    private List<Situacao> situacoes = new ArrayList<>();

    private ObservableList<Situacao> obsSituacao;

    
    @FXML
    private void acaoDoBotao(ActionEvent event){
        botaoAvancar();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
