/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package telacadcampeonato;

import dao.CompeticaoDAO;
import dao.UsuarioDAO;

import java.net.URL;

import java.util.ResourceBundle;

import apitofinal.FXMLDocumentController;
import dao.BarraDeMenuDAO;
import classes.Competicao;
import classes.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
    private Label nome_user;


    @FXML
    private void acaoDoBotao(ActionEvent event){
        botaoAvancar();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        BarraDeMenuDAO barra = new BarraDeMenuDAO();
        nome_user.setText(barra.Nome());
    } 

    public void botaoAvancar(){
       Competicao competicao = new Competicao();
       CompeticaoDAO compDAO = new CompeticaoDAO();
    
       Usuario usuario = new Usuario();

       competicao.setNomeCompeticao(txtNomeComp.getText());
       competicao.setPremiacao(txtPremiacao.getText());
       competicao.setDescricao(txtDesc.getText());
       competicao.setData_inicio(txtDataInicio.getText());
       competicao.setData_terminio(txtDataTerminio.getText());
       competicao.setSituacao("iniciada");
       if(radQtd16.isSelected()){
           competicao.setQtd_times("16");
       }
       if(radQtd8.isSelected()){
           competicao.setQtd_times("8");
       }
       competicao.setFk_user(usuario.getId_user());
      
       compDAO.cadastrarComp(competicao);
    }

}
