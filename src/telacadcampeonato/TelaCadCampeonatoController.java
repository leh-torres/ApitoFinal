/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package telacadcampeonato;

import dao.DataSource;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import com.mysql.cj.xdevapi.PreparableStatement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 *
 * @author Zairo Bastos
 */
public class TelaCadCampeonatoController implements Initializable {
    
    Connection conexao = null; //variável de conexão
    PreparedStatement ps = null; //variável que faz as consultas ao banco
    ResultSet rs = null; //variável que recebe o resultado da consulta
    DataSource data = new DataSource(); //objeto que abre a connection
    private int retUpdate; //recebe o retorno do update

    @FXML
    private Label label;

    @FXML
    private TextField txt_nome_camp;

    @FXML
    private TextField txt_premiacao;

    @FXML
    private RadioButton rad_qtd8;

    @FXML
    private RadioButton rad_qtd16;

    @FXML
    private TextField txt_desc;

    @FXML
    private Button btn_avancar;
    
    @FXML
    private void acaoDoBotao(ActionEvent event){
        cadastroCamp();
    }

    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void cadastroCamp(){
        conexao = data.getConnection();
        String SQL = "SELECT * FROM competicao WHERE nome_comp = ? AND descricao_comp = ? AND premiacao_comp =? AND quatidade_times_comp = ?";
        String SQL1 = "";
        
        try {
            ps = (PreparedStatement)conexao.prepareStatement(SQL);
            ps.setString(1, txt_nome_camp.getText());
            ps.setString(2, txt_desc.getText());
            ps.setString(3, txt_premiacao.getText());
            if(rad_qtd8.isSelected()){
                int qtd8 = 8;
                ps.setInt(4, qtd8); //Erro nessa linha, na hr de setar;
            } else if(rad_qtd16.isSelected()){
                int qtd16 = 16;
                ps.setInt(4, qtd16);
            }
            rs = ps.executeQuery();

            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Campeonato já cadastrado");
                data.closeDataSource();
                txt_nome_camp.clear();
                txt_desc.clear();
                txt_premiacao.clear();
            } else{
                SQL = "INSERT INTO competicao (nome_comp, descricao_comp, premiacao_comp, quatidade_times_comp) VALUES (?,?,?,?)";

                try {
                    ps = (PreparedStatement)conexao.prepareStatement(SQL);
                    ps.setString(1, txt_nome_camp.getText());
                    ps.setString(2, txt_desc.getText());
                    ps.setString(3, txt_premiacao.getText());
                    if(rad_qtd8.isSelected()){
                       int qtd8 = 8;
                        ps.setInt(4, qtd8);
                    } else if(rad_qtd16.isSelected()){
                        int qtd16 = 16;
                        ps.setInt(4, qtd16);
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
