/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package home16times;

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
 * @author Leticia Torres
 */
public class FXMLDocumentController implements Initializable {
    
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
    private ImageView image14;

    @FXML
    private ImageView image15;

    @FXML
    private ImageView image16;

    @FXML
    private ImageView image17;

    @FXML
    private ImageView image18;

    @FXML
    private ImageView image19;

    @FXML
    private ImageView image20;

    @FXML
    private ImageView image21;

    @FXML
    private ImageView image22;

    @FXML
    private ImageView image23;

    @FXML
    private ImageView image24;

    @FXML
    private ImageView image25;

    @FXML
    private ImageView image26;

    @FXML
    private ImageView image27;

    @FXML
    private ImageView image28;

    @FXML
    private ImageView image29;

    @FXML
    private ImageView image30;

    @FXML
    private ImageView image31;

    @FXML
    private ImageView imagePerfil;

    @FXML
    private Label descricaoLabel;

    @FXML
    private Label premioLabel;
    
    private Competicao competicao = new Competicao();
    private CompeticaoDAO competicaoDAO = new CompeticaoDAO();
    

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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        competicao = competicaoDAO.gCompeticao(competicao.getIdSelecionaCampeonato());
        JOptionPane.showMessageDialog(null,"Nome:" + competicao.getNomeCompeticao() + " Premiacao:" + competicao.getPremiacao() + " Descricao:" + competicao.getDescricao());
        
        premioLabel.setText(competicao.getPremiacao());
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

    private void fecha(){
        Home16Times.getStage().close();
    }  
    
    
}
