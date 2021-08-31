/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telaUsuario;

import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import com.mysql.cj.jdbc.Blob;

import classes.Competicao;
import classes.Usuario;
import dao.UsuarioDAO;
import home.HomeController;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import selecaocampeonato.SelecaoCampeonato;
import selecaocampeonato.SelecionaCampeonatoController;
import telaeditarcadastro.TelaEditarCadastro;

/**
 * FXML Controller class
 *
 * @author RonaldoMatos
 */
public class TelaUsuarioFXMLController implements Initializable {

    @FXML
    private ImageView avatar_user;

    @FXML
    private Label nome_usuario;

    @FXML 
    private Label email_usuario;

    @FXML 
    private Label sobrenomeUsuario;

    private Usuario usuario = new Usuario();
    private UsuarioDAO usuarioD = new UsuarioDAO();
    private Competicao competicao = new Competicao();
    private Blob imagem;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        usuario = usuarioD.getUser(competicao.getFk_user());

        imagem = (Blob) usuario.getImagemPerfil();
        try {
            InputStream is = imagem.getBinaryStream();
            Image image = new Image(is);
            avatar_user.setImage(image);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        nome_usuario.setText(usuario.getNome_user());
        email_usuario.setText(usuario.getEmail_user());
        sobrenomeUsuario.setText(usuario.getSobrenome_user());
    } 
    
    @FXML
    private void editarPerfil(){
        SelecionaCampeonatoController selecao = new SelecionaCampeonatoController();
        TelaEditarCadastro edit = new TelaEditarCadastro();
        fecha();
        selecao.fecha();
        try {
            edit.start(new Stage());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * Método para o botão
     * @param event
     */
    @FXML
    private void voltar(ActionEvent event){
        fecha();
    }

    /**
     * Método para o imageView
     * @param event
     */
    @FXML
    private void voltar(MouseEvent event){
        fecha();
    }

    @FXML
    private void excluirCadastro(ActionEvent event){
        Boolean retornoExcluir = usuarioD.excluirCadastro(usuario.getId_user());
        
        if(retornoExcluir == true){
            JOptionPane.showMessageDialog(null, "Usuario Excluido com sucesso!");
            fecha();
            Platform.exit();
            System.exit(0);
        } else{
            JOptionPane.showMessageDialog(null, "Usuario não excluido. Tente Novamente");
        }
    }

    @FXML
    private void sair(ActionEvent event){
        fecha();
        Platform.exit();
        System.exit(0);
    }

    private void fecha(){
        TelaUsuario.getStage().close();
    }
    
}
