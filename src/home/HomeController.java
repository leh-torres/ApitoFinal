/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package home;

import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import classes.Competicao;
import classes.Usuario;
import dao.BarraDeMenuDAO;
import dao.CompeticaoDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import selecaocampeonato.SelecaoCampeonato;
import telaEditCampeonato.TelaEditCampeonato;
import telaUsuario.TelaUsuario;

/**
 *
 * @author Zairo Bastos
 */
public class HomeController implements Initializable {
    
    @FXML
    private Label label;

    @FXML
    private ImageView image1;

    @FXML
    private ImageView image2;

    @FXML
    private ImageView image3;

    @FXML
    private ImageView image4;

    @FXML
    private ImageView image5;

    @FXML
    private ImageView image6;

    @FXML
    private ImageView image7;

    @FXML
    private ImageView image8;

    @FXML
    private ImageView image9;

    @FXML
    private ImageView image10;

    @FXML
    private ImageView image11;

    @FXML
    private ImageView image12;

    @FXML
    private ImageView image13;

    @FXML
    private ImageView imagePerfil;

    @FXML
    private Label labelPremio;

    @FXML
    private Label descricaoLabel;

    @FXML
    private Label labelNome;

    @FXML
    private Label labelDataInicio;

    @FXML
    private Label labelDataTerm;

    @FXML
    private Label labelSituacao;

    @FXML
    private Button btnEditarCamp;

    @FXML
    private Button btnPlacarPartidas;

    
    private Competicao competicao = new Competicao();
    private CompeticaoDAO competicaoDAO = new CompeticaoDAO();
    private BarraDeMenuDAO barra = new BarraDeMenuDAO();
    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        competicao = competicaoDAO.gCompeticao(competicao.getIdSelecionaCampeonato());

        labelPremio.setText(competicao.getPremiacao());
        descricaoLabel.setText(competicao.getDescricao());   
        labelDataInicio.setText(competicao.getData_inicio());
        labelDataTerm.setText(competicao.getData_terminio());
        labelSituacao.setText(competicao.getSituacao());
        
    }    

    @FXML
    private void voltar(ActionEvent event){
        SelecaoCampeonato selecao = new SelecaoCampeonato();
        fecha();

        try {
            selecao.start(new Stage());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @FXML
    private void deletaComp(ActionEvent event) {
        boolean retorno = competicaoDAO.excluirCompeticao(competicao.getId_competicao());
        if(retorno == true){
            JOptionPane.showMessageDialog(null, "Campeonato excluido com sucesso!");
            SelecaoCampeonato selecao = new SelecaoCampeonato();
            fecha();
            try {
                selecao.start(new Stage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @FXML
    private void telaEditCamp(ActionEvent event){
        TelaEditCampeonato edit = new TelaEditCampeonato();
        fecha();
        try {
            edit.start(new Stage());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void fecha(){
        Home.getStage().close();
    }

}
