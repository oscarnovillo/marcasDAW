package rss;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author user
 */
public class MainRss extends Application {
    
    @Override
    public void start(Stage stage) throws IOException {
       FXMLLoader loaderMenu = new FXMLLoader(
          getClass().getResource("/rss/FXMLRss.fxml"));
        AnchorPane root = loaderMenu.load();
        FXMLRssController menuController = loaderMenu.getController();   

        menuController.hostServices =  this.getHostServices();
     
        Scene scene = new Scene(root);

        
        stage.setTitle("JavaFX and Maven");
        stage.setScene(scene);
        stage.getProperties().put("hostServices", this.getHostServices());
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
