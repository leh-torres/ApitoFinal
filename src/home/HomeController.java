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
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import selecaocampeonato.SelecaoCampeonato;
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
    
    private Competicao competicao = new Competicao();
    private CompeticaoDAO competicaoDAO = new CompeticaoDAO();
    private BarraDeMenuDAO barra = new BarraDeMenuDAO();
    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        competicao = competicaoDAO.gCompeticao(competicao.getIdSelecionaCampeonato());
        JOptionPane.showMessageDialog(null,"Nome:" + competicao.getNomeCompeticao() + " Premiacao:" + competicao.getPremiacao() + " Descricao:" + competicao.getDescricao());


        labelPremio.setText(competicao.getPremiacao());
        descricaoLabel.setText(competicao.getDescricao());   
 
        
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
    private void abreTelaUsuario(MouseEvent event){
        TelaUsuario telaUser = new TelaUsuario();

        try {
            telaUser.start(new Stage());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void fecha(){
        Home.getStage().close();
    }
}
