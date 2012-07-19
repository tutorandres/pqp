/*
 * Copyright (c) 2012, Oracle and/or its affiliates. All rights reserved.
 */
package us.andresgarcia.controladores;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.persistence.*;
import us.andresgarcia.modelo.Empleado;
import us.andresgarcia.parqueadero.Parqueadero;

/**
 * Login Controller.
 */
public class InicioController extends AnchorPane implements Initializable {

    @FXML
    TextField identificacion;
    @FXML
    PasswordField contrasenia;
    @FXML
    Button bvalidar;
    @FXML
    Label mensajes;
    private Parqueadero application;

    public void setApp(Parqueadero application) {
        this.application = application;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mensajes.setText("");
    }

    public void processIdentificar(ActionEvent event) {
        
        EntityManagerFactory factory;
        factory = Persistence.createEntityManagerFactory(Parqueadero.PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        // 1-Send query to database to see if that user exist
        Query query = em.createQuery("SELECT e FROM Empleado e WHERE e.contrasenia=:contraparam AND e.identificacion=:identiparam");
        query.setParameter("identiparam", identificacion.getText());
        query.setParameter("contraparam", contrasenia.getText());
        // 2-If the query returns the user(Role) object, store it somewhere in
        // the session
        Empleado empleado;
        
        try{ 
            empleado = (Empleado) query.getSingleResult();     
        } catch(NoResultException e) {
            empleado = null;
        }
        

        if (empleado != null && empleado.getidentificacion().equals(identificacion.getText())
                && empleado.getcontrasenia().equals(contrasenia.getText())) {
            //FacesContext.getCurrentInstance().getExternalContext()
            //    .getSessionMap().put("userRole", role);
            // 3-return true if the user state was saved
           //System.out.println("SESION CORRECTA.");
          mensajes.setText("Inicio de sesión CORRECTO para " + identificacion.getText());
          
          
          //stage.
          //try {
                
              //Parent root2 = this.getParent();
              //root2.setVisible(false);
              
              //Parent root = FXMLLoader.load(getClass().getResource("../vistas/Principal.fxml"));              
              //Stage stage = new Stage();
              //stage.setScene(new Scene(root));
              //stage.setTitle("PQParqueo v1.0");
              ///stage.show();

                
            //} catch (IOException ex) {
            //    Logger.getLogger(InicioController.class.getName()).log(Level.SEVERE, null, ex);
            
            //} catch (Throwable ex) {
            //    Logger.getLogger(InicioController.class.getName()).log(Level.SEVERE, null, ex);
           // }

        }
        else{
                mensajes.setText("Inicio de sesión invalido para " + identificacion.getText()
                + ". Compruebe de nuevo los datos y vuelva a intentarlo.");
        }
    }
}
