/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package us.andresgarcia.parqueadero;

import java.util.List;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import us.andresgarcia.modelo.Empleado;


/**
 *
 * @author andres
 */
public class Parqueadero extends Application {

    /**
     * @param args the command line arguments
     */
    public static final String PERSISTENCE_UNIT_NAME = "pqpersistencia";
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

                /*Empleado nuevoEmpleado = new Empleado();
		em.getTransaction().begin();
		nuevoEmpleado.setcorreo("administrador@pqsoft.com");
		nuevoEmpleado.setcontrasenia("12345");
                nuevoEmpleado.setidentificacion("admin");
                nuevoEmpleado.setnombresYapellidos("Administrador de prueba");
                nuevoEmpleado.setrol("Administrador");
		em.persist(nuevoEmpleado);
		em.getTransaction().commit();
               
                nuevoEmpleado = new Empleado();
		em.getTransaction().begin();
		nuevoEmpleado.setcorreo("administrador2@pqsoft.com");
		nuevoEmpleado.setcontrasenia("12345");
                nuevoEmpleado.setidentificacion("admin2");
                nuevoEmpleado.setnombresYapellidos("Administrador2 de prueba");
                nuevoEmpleado.setrol("Administrador");
		em.persist(nuevoEmpleado);
		em.getTransaction().commit();
           
                nuevoEmpleado = new Empleado();
		em.getTransaction().begin();
		nuevoEmpleado.setcorreo("usuario@pqsoft.com");
		nuevoEmpleado.setcontrasenia("12345");
                nuevoEmpleado.setidentificacion("usuario");
                nuevoEmpleado.setnombresYapellidos("Usuario de prueba");
                nuevoEmpleado.setrol("Usuario");
		em.persist(nuevoEmpleado);
		em.getTransaction().commit();
                
                nuevoEmpleado = new Empleado();
                em.getTransaction().begin();
		nuevoEmpleado.setcorreo("usuario2@pqsoft.com");
		nuevoEmpleado.setcontrasenia("12345");
                nuevoEmpleado.setidentificacion("usuario2");
                nuevoEmpleado.setnombresYapellidos("Usuario2 de prueba");
                nuevoEmpleado.setrol("Usuario");
		em.persist(nuevoEmpleado);
		em.getTransaction().commit();*/

                
                Query q = em.createQuery("select t from Empleado t");
		List<Empleado> empleadosList = q.getResultList();
		for (Empleado empleado : empleadosList) {
			System.out.println(empleado);
		}
		System.out.println("Size: " + empleadosList.size());
                
                
                em.close();
                
        
        stage.setScene(new Scene(root));
        stage.setTitle("Parqueadero v1.0");
        stage.show();
    }
    
}
