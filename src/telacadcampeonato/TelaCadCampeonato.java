/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package telacadcampeonato;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Zairo Bastos
 */
public class TelaCadCampeonato extends Application {
    
    private static Stage stage;
    //public static Stage stage;
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/telacadcampeonato/TelaCadCampeonato.fxml"));
        
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
        setStage(stage);
    }
    
    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        TelaCadCampeonato.stage = stage;
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}