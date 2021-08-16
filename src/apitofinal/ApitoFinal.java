/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apitofinal;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author RonaldoMatos
 */
public class ApitoFinal extends Application {
    
    private static Stage stage; 
    
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/apitofinal/FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        Image image = new Image(getClass().getResourceAsStream("/apitofinal/Logotype.jpg"));
        ImageView imageView = new ImageView(image);
        
        imageView.setImage(image);
        imageView.setVisible(true);
        imageView.setCache(true);
        
        stage.setScene(scene);
        stage.show();
        setStage(stage);
    }
    
    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        ApitoFinal.stage = stage;
    }    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
 
}
