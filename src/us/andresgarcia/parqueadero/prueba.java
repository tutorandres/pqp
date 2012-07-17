/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package us.andresgarcia.parqueadero;

/**
 *
 * @author andres
 */

import java.sql.*;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import us.andresgarcia.modelo.Todo;

public class prueba {
    
    private static final String PERSISTENCE_UNIT_NAME = "todos";
    private static EntityManagerFactory factory;
    
   	
    
    public static void main(String[] args) {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();
		// Read the existing entries and write to console
		Query q = em.createQuery("select t from Todo t");
		List<Todo> todoList = q.getResultList();
		for (Todo todo : todoList) {
			System.out.println(todo);
		}
		System.out.println("Size: " + todoList.size());

		// Create new todo
		em.getTransaction().begin();
		Todo todo = new Todo();
		todo.setSummary("This is a test");
		todo.setDescription("This is a test");
		em.persist(todo);
		em.getTransaction().commit();

		em.close();
	} 
   
 /*public static void main(String[] args) {
      
   try {//Por si ocurre algun error en la ejecucion
     //Carga el Driver de sqlite
     Class.forName("org.sqlite.JDBC");
     //Conecta a la base de datos prueba.db,si no existe la crea.
     Connection conn =DriverManager.getConnection("jdbc:sqlite:db/pqparqueo.sqlite");
     //Abre un estamento para la conexion anteriormente abierta
     Statement estamento = conn.createStatement(); 
     //Ejecuta sentencia sql estandar que Borra la tabla empleados si existe
     //estamento.executeUpdate("drop table if exists empleados;");
     //Ejecuta sentencia sql estandar que crea una tabla llamada empleados
     //estamento.executeUpdate("CREATE TABLE empleados (id INT, nombre varchar(80));");
     //Ejecuta sentencia sql estandar que un inserta un registro en la tabla empleados
     //estamento.executeUpdate("INSERT INTO empleados (id,nombre) VALUES(1,'Luis');");
     //Ejecuta sentencia sql que selecciona  los registros en la tabla empleados
     ResultSet rs=estamento.executeQuery("SELECT * FROM usuarios;");
     //Recorriendo el ResultSet 
     //while(rs.next()){
       //Extrae el campo id,nombre el repectivo orden 1,2
       //System.out.println("Codigo:"+rs.getInt(1)+"  Nombre:"+rs.getString(2));
     //}//Fin while            
    } catch (Exception ex) {
      System.out.println("--------Error--------"+ex.getMessage());
    }//Fin try
   
 }//fin Main
}//fin Clase*/
                
                
}
