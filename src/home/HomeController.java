/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package home;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import classes.Competicao;
import dao.CompeticaoDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import selecaocampeonato.SelecaoCampeonato;

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
    private Label labelDescricao;

    @FXML
    private Label labelNome;
    
    Competicao competicao = new Competicao();
    CompeticaoDAO competicaoDAO = new CompeticaoDAO();

    @FXML
    public void deletaComp(ActionEvent event) {
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        labelPremio.setText(competicao.getPremiacao());
        labelDescricao.setText(competicao.getDescricao());
    }    
    
    public void setComp(Competicao comp){
        competicao = comp;
    }

    private void fecha(){
        Home.getStage().close();
    }
}
