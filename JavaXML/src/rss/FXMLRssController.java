/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rss;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.HostServices;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLRssController implements Initializable {

    public HostServices hostServices;
    
    
    @FXML
    private FlowPane fxFlowPane;
     Configuration c = null;
    

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        c = new Configuration();
        // TODO
        Button but = new Button("testing");
        but.setOnAction(click -> {
        this.hostServices.showDocument("http://www.marca.es");
        
        });
    }    
    
}
