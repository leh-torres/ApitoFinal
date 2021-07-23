/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telaCadUsuario;

import dao.DataSource;
import java.net.URL;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author RonaldoMatos
 */
public class TelaCadUsuario extends Application {
    
    private static Stage stage;

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/telaCadUsuario/TelaCadUsuario.fxml"));                
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        setStage(stage);
    }
    
    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        TelaCadUsuario.stage = stage;
    }   
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DataSource banco = new DataSource();
        launch(args);
        banco.closeDataSource();
    }
    
}
