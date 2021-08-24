/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telaCadAvatar;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 *
 * @author RonaldoMatos
 */
public class TelaCadAvatar extends Application{
    
    private static Stage stage;

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/telaCadAvatar/telaCadAvatar.fxml"));                
        
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
        TelaCadAvatar.stage = stage;
    }   
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
