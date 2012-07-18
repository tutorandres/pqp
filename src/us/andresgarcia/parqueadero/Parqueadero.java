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
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import us.andresgarcia.modelo.Empleado;


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
        	factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();

                //objeto que agregaremos a la bd
                Empleado nuevoEmpleado = new Empleado();
                
		// Create nuevo usuario Administrador
		em.getTransaction().begin();
		nuevoEmpleado.setcorreo("usuarioadmin@pqsoft.com");
		nuevoEmpleado.setcontrasenia("12345");
                nuevoEmpleado.setidentificacion("admin");
                nuevoEmpleado.setnombresYapellidos("Usuario admin de prueba");
                nuevoEmpleado.setrol("Administrador");
		em.persist(nuevoEmpleado);
		em.getTransaction().commit();
		em.close();
           
    
        	// Create nuevo usuario Administrador
		em.getTransaction().begin();
		nuevoEmpleado.setcorreo("usuarionormal@pqsoft.com");
		nuevoEmpleado.setcontrasenia("12345");
                nuevoEmpleado.setidentificacion("usuario");
                nuevoEmpleado.setnombresYapellidos("Usuario admin de prueba");
                nuevoEmpleado.setrol("Administrador");
		em.persist(nuevoEmpleado);
		em.getTransaction().commit();
		em.close();
        
        
        stage.setScene(new Scene(root));
        stage.setTitle("Parqueadero v1.0");
        stage.show();
    }
    
}
