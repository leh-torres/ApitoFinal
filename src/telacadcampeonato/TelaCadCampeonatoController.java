/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package telacadcampeonato;

import dao.DataSource;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;


import javax.swing.JOptionPane;
import dao.BarraDeMenu;
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
import javafx.scene.image.ImageView;

/**
 *
 * @author Zairo Bastos
 * @author Leticia Torres
 */
public class TelaCadCampeonatoController implements Initializable {
    
    Connection conexao = null; //variável de conexão
    PreparedStatement ps = null; //variável que faz as consultas ao banco
    ResultSet rs = null; //variável que recebe o resultado da consulta
    DataSource data = new DataSource(); //objeto que abre a connection
    private int retUpdate; //recebe o retorno do update

    @FXML
    private TextField txt_nome_camp;
    
    @FXML
    private Label nome_user;

    @FXML
    private TextField txt_premiacao;

    @FXML
    private TextField txt_desc;

    @FXML
    private RadioButton rad_qtd8;

    @FXML
    private RadioButton rad_qtd16;

    @FXML
    private Button btn_avancar;

    @FXML
    private ComboBox<Situacao> status;

    @FXML
    private DatePicker data_inicio;

    private DatePicker data_terminio;

    private List<Situacao> situacoes = new ArrayList<>();

    private ObservableList<Situacao> obsSituacao;
    @FXML
    private DatePicker data_temino;
    @FXML
    private ImageView imagem_user;
    
    @FXML
    private void acaoDoBotao(ActionEvent event){
        cadastroCamp();
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

    public void cadastroCamp(){

        /**Recebendo data_inicio */
        LocalDate data1 = data_inicio.getValue();
        Calendar calendario1 = Calendar.getInstance();

        java.util.Date uData = Date.from(data1.atStartOfDay(ZoneId.systemDefault()).toInstant());
        calendario1.setTime(uData);
        uData = calendario1.getTime();
        Date sqlData1 = (Date) uData;

        /**Recebendo data_fim */
        LocalDate data2 = data_terminio.getValue();
        Calendar calendario2 = Calendar.getInstance();

        java.util.Date uData2 = Date.from(data2.atStartOfDay(ZoneId.systemDefault()).toInstant());
        calendario1.setTime(uData2);
        uData2 = calendario1.getTime();
        Date sqlData2 = (Date) uData2;

        /**Recebendo valor do ComboBox */
        Situacao situation = status.getSelectionModel().getSelectedItem();
        String sit = situation.getNome();

        conexao = data.getConnection();
        String SQL = "SELECT * FROM competicao WHERE nome_comp = ? ";
        
        try {
            ps = (PreparedStatement)conexao.prepareStatement(SQL);
            ps.setString(1, txt_nome_camp.getText());
            rs = ps.executeQuery();

            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Campeonato já cadastrado");
                data.closeDataSource();
                txt_nome_camp.clear();
            } else{
                SQL = "INSERT INTO competicao (nome_comp, descricao_comp, premiacao_comp, data_ini_comp, data_term_com, situacao_comp, quatidade_times_comp) VALUES (?,?,?,?,?,?,?)";

                try {
                    ps = (PreparedStatement)conexao.prepareStatement(SQL);
                    ps.setString(1, txt_nome_camp.getText());
                    ps.setString(2, txt_desc.getText());
                    ps.setString(3, txt_premiacao.getText());
                    ps.setDate(4, sqlData1);
                    ps.setDate(5, sqlData2);
                    ps.setString(6, sit);
                    if(rad_qtd8.isSelected()){
                        int qtd8 = 8;
                         ps.setInt(7, qtd8);
                     } else if(rad_qtd16.isSelected()){
                         int qtd16 = 16;
                         ps.setInt(7, qtd16);
                     }
                    retUpdate = ps.executeUpdate();

                    if(retUpdate == 1){
                        JOptionPane.showMessageDialog(null, "Cadastro Realizado com sucesso!");
                        data.closeDataSource();
                    } else{
                        JOptionPane.showMessageDialog(null, "----ERRO!----");
                    }
                    
                } catch (SQLException exSQL) {
                    System.out.println("------------Primeira exceção----------");
                    JOptionPane.showMessageDialog(null, exSQL);
                }
            }

        } catch (SQLException exSQL) {
            System.out.println("-----------Segunda exceção----------");
            JOptionPane.showMessageDialog(null, exSQL);
        }
    }

}
