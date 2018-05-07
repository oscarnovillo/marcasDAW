/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.ejemplosjavafx;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author user
 */
public class MapsMain extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        //BorderPane root = FXMLLoader.load(getClass().getResource("/fxml/FXMLMenu.fxml"));
            FXMLLoader loaderMenu = new FXMLLoader(
              getClass().getResource("/fxml/FXMLMaps.fxml"));
            Parent root = loaderMenu.load();
           
            
            Scene scene = new Scene(root);
            
            primaryStage.setTitle("BUS");
            primaryStage.setScene(scene);
            primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
