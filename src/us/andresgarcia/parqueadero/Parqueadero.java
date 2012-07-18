/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package us.andresgarcia.parqueadero;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.persistence.EntityManagerFactory;


/**
 *
 * @author andres
 */
public class Parqueadero extends Application {

    /**
     * @param args the command line arguments
     */
    public static final String PERSISTENCE_UNIT_NAME = "todos";
    private static EntityManagerFactory factory;
     
    
    public static void main(String[] args) {
        Application.launch(Parqueadero.class, args);
    }
    
    
    
    @Override
    public void start(Stage stage) throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("../vistas/Inicio.fxml"));
        
        System.setProperty("derby.system.home", System.getProperty("user.dir")
        + System.getProperty("file.separator") + "bd");
        
        
        //agregamso el usuario de prueba
        
           
    
        
        
        
        stage.setScene(new Scene(root));
        stage.setTitle("Parqueadero v1.0");
        stage.show();
    }
    
}
