/*
 * Copyright (c) 2012, Oracle and/or its affiliates. All rights reserved.
 */
package us.andresgarcia.controladores;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import us.andresgarcia.parqueadero.Parqueadero;

/**
 * Login Controller.
 */
public class InicioController extends AnchorPane implements Initializable {

    @FXML
    TextField userId;
    @FXML
    PasswordField password;
    @FXML
    Button login;
    @FXML
    Label errorMessage;

    private Parqueadero application;
    
    
    public void setApp(Parqueadero application){
        this.application = application;
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        errorMessage.setText("");
    }

    public void processLogin(ActionEvent event) 
    {
        
        
       System.out.println("Hola apreto el boton"); 
       /* if (application == null){
            // We are running in isolated FXML, possibly in Scene Builder.
            // NO-OP.
            errorMessage.setText("Hello " + userId.getText());
        } else {
            if (!application.userLogging(userId.getText(), password.getText())){
                errorMessage.setText("Unknown user " + userId.getText());
            }
        }*/
    }
}
