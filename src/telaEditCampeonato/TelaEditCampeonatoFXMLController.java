/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telaEditCampeonato;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import classes.Competicao;
import dao.CompeticaoDAO;
import home.Home;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author RonaldoMatos
 * @author Leticia Torres
 */
public class TelaEditCampeonatoFXMLController implements Initializable {
    
    @FXML
    private Label label;

    @FXML
    private TextField txtNomeComp;

    @FXML
    private TextField txtPremiacao;

    @FXML
    private TextField txtDesc;

    @FXML
    private CheckBox checkNome;

    @FXML
    private CheckBox checkSituacao;

    @FXML
    private CheckBox checkDescricao;

    @FXML
    private CheckBox checkPremiacao;

    @FXML
    private ChoiceBox<String> choiceSituacao;

    private Competicao comp = new Competicao();
    private CompeticaoDAO compDao = new CompeticaoDAO();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        choiceSituacao.getItems().add("Cancelado");
        choiceSituacao.getItems().add("Finalizado");
    }    

    @FXML
    private void acaoDoCheck(ActionEvent event){
        if(checkNome.isSelected()){
            txtNomeComp.setEditable(true);
        } else{
            txtNomeComp.setEditable(false);
        }

        if(checkDescricao.isSelected()){
            txtDesc.setEditable(true);
        } else{
            txtDesc.setEditable(false);
        }

        if(checkPremiacao.isSelected()){
            txtPremiacao.setEditable(true);
        } else{
            txtPremiacao.setEditable(false);
        }

        if(checkSituacao.isSelected()){
            choiceSituacao.setDisable(false);
        } else{
            choiceSituacao.setDisable(true);
        }

    }

    @FXML
    private void BotaoAtualizar(ActionEvent event){

        if(checkNome.isSelected()){
            compDao.atualizaNome(txtNomeComp.getText(), comp.getIdSelecionaCampeonato());
        } 
        if(checkDescricao.isSelected()){
            compDao.atualizaDescricao(txtDesc.getText(), comp.getIdSelecionaCampeonato());
        }
        if(checkPremiacao.isSelected()){
            compDao.atualizaPremiacao(txtPremiacao.getText(), comp.getIdSelecionaCampeonato());
        }
        if(checkSituacao.isSelected()){
            compDao.atualizaSituacao(choiceSituacao.getSelectionModel().getSelectedItem(), comp.getIdSelecionaCampeonato());
        }
        
        
        JOptionPane.showMessageDialog(null, "Dado(os) atualizado(os) com sucesso!");
        Home h = new Home();
        fecha();
        try {
            h.start(new Stage());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    

    @FXML 
    private void voltar(ActionEvent event){
        Home h = new Home();
        fecha();
        try {
            h.start(new Stage());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void fecha(){
        TelaEditCampeonato.getStage().close();
    }
}
