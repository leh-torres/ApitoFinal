/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package telacadcampeonato;

import dao.CompeticaoDAO;
import dao.UsuarioDAO;

<<<<<<< HEAD
import javax.swing.JOptionPane;
import dao.BarraDeMenu;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
=======
import java.net.URL;

import java.util.ResourceBundle;

import apitofinal.FXMLDocumentController;
import dao.BarraDeMenuDAO;
import classes.Competicao;
import classes.Usuario;
>>>>>>> e59c81ebe57c9b971f7513a262b6bc5fd645271d
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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

<<<<<<< HEAD
    @FXML
    private TextField txt_nome_camp;
    
    @FXML
    private Label nome_user;
=======

    @FXML
    private TextField txtNomeComp;
>>>>>>> e59c81ebe57c9b971f7513a262b6bc5fd645271d

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


<<<<<<< HEAD
    private ObservableList<Situacao> obsSituacao;
    @FXML
    private DatePicker data_temino;
    @FXML
    private ImageView imagem_user;
    
    @FXML
    private void acaoDoBotao(ActionEvent event){
        cadastroCamp();
=======
    @FXML
    private void acaoDoBotao(ActionEvent event){
        botaoAvancar();
>>>>>>> e59c81ebe57c9b971f7513a262b6bc5fd645271d
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        BarraDeMenuDAO barra = new BarraDeMenuDAO();
        nome_user.setText(barra.Nome());
<<<<<<< HEAD
        carregaSituacao();
=======
>>>>>>> e59c81ebe57c9b971f7513a262b6bc5fd645271d
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
