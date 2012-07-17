/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package us.andresgarcia.modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Empleado implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private String nombresYapellidos;
	private String contrasenia;
        private String correo;
        private String identificacion;
        private String rol;

	public String getnombresYapellidos() {
		return nombresYapellidos;
	}
        
        public void setnombresYapellidos(String nombresYapellidos) {
		this.nombresYapellidos = nombresYapellidos;
	}
        
        
        public String getcontrasenia() {
		return contrasenia;
	}
        
	public void setcontrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
        
        
	public String getcorreo() {
		return correo;
	}
        
        public void setcorreo(String correo) {
		this.correo = correo;
	}
        
        
                
	public String getidentificacion() {
		return identificacion;
	}
        
        public void setidentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
        
        
        public String getrol() {
		return rol;
	}
        
        public void setrol(String rol) {
		this.rol = rol;
	}
        

	@Override
	public String toString() {
		return "Empleado [Nombres y apellidos=" + nombresYapellidos + ", rol=" + rol+ "]";
	}

} 