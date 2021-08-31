/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package telacadcampeonato;

import dao.CompeticaoDAO;
import dao.UsuarioDAO;
import javax.swing.JOptionPane;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.net.URL;

import java.util.ResourceBundle;

import apitofinal.FXMLDocumentController;
import dao.BarraDeMenuDAO;
import classes.Competicao;
import classes.Partida;
import classes.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import telaSelecionarTimes.telaSelecionarTimes;

/**
 *
 * @author Zairo Bastos
 * @author Leticia Torres
 */
public class TelaCadCampeonatoController implements Initializable {

    @FXML
    private TextField txt_nome_camp;
    
    @FXML
    private Label nome_user;
    
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
    private ImageView imagem_user;

    @FXML
    private void acaoDoBotao(ActionEvent event){
        botaoAvancar();
        trocaDeTela();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        BarraDeMenuDAO barra = new BarraDeMenuDAO();
        BarraDeMenuDAO barra1 = new BarraDeMenuDAO();
        nome_user.setText(barra.Nome());
        imagem_user.setImage(barra1.Imagem());
    } 

    public void botaoAvancar(){
       Competicao competicao = new Competicao();
       CompeticaoDAO compDAO = new CompeticaoDAO();
       Partida partida = new Partida();
    
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
       
       partida.setId_comp(compDAO.recuperaId(txtNomeComp.getText(), usuario.getId_user()));
    }

    private void trocaDeTela(){
        telaSelecionarTimes tela = new telaSelecionarTimes();
        fecha();

        try {
            tela.start(new Stage());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    private void fecha(){
        TelaCadCampeonato.getStage().close();
    }
}
