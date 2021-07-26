/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apitofinal;

import dao.DataSource;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import telaCadUsuario.TelaCadUsuario;


/**
 *
 * @author RonaldoMatos
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private Button cadastrar;
    @FXML
    private ImageView logo;
    
    Image image = new Image(getClass().getResourceAsStream("Logotype.jpg"));
    @FXML
    private Button entrar;
    @FXML
    private TextField pass_senha;
    @FXML
    private Label labelResultado;
    @FXML
    private TextField txtlogin;

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    DataSource data = new DataSource();
    
    @FXML
    public void displayImage(){
        logo.setImage(image);
    }
    
    @FXML
    public  void handleButtonAction(ActionEvent event) {
        
        conn = data.getConnection();
        
        String SQL = "SELECT * FROM usuario WHERE email_user=? and senha_user=?";
        try {
            pst = (PreparedStatement)conn.prepareStatement(SQL);
            pst.setString(1, txtlogin.getText());
            pst.setString(2, pass_senha.getText());
            rs = pst.executeQuery();
            
            if(rs.next()){
                JOptionPane.showMessageDialog(null,"Bem vindo ao sistema");
                data.closeDataSource();
            }
            else{
                System.out.println("Erro");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    public void acaoBotaoCadastrar(ActionEvent event) {
        TelaCadUsuario cad = new TelaCadUsuario();
        fecha();
        try {
            cad.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void fecha(){
        ApitoFinal.getStage().close();
    }
    
}
