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
        Query query = em.createQuery("SELECT r FROM Empleado r WHERE r.contrasenia=:contraparam AND r.identificacion=:identiparam");
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

        }
        else{
                mensajes.setText("Inicio de sesión invalido para " + identificacion.getText()
                + ". Compruebe de nuevo los datos y vuelva a intentarlo.");
        }
    }
}
