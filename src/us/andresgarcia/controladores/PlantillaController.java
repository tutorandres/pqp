/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package us.andresgarcia.controladores;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 *
 * @author andres
 */
public class PlantillaController implements Initializable{
    
    
    @FXML
    private void nuevoError(ActionEvent event) {
        System.out.println("You clicked me!");
    }
    
    @FXML
    private void guardarError(ActionEvent event) {
        System.out.println("You clicked me!");
    }
          
    @FXML
    private void eliminarError(ActionEvent event) {
        System.out.println("You clicked me!");
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    
    
}
