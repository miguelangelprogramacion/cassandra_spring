/**
 * 
 */
package world.we.deserve.dao;

import java.util.UUID;

import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

/**
 * @author Miguel Ángel Dev (miguelangelprogramacion@gmail.com)
 *
 */
@Table
public class usuario {
	
	@PrimaryKey
	private UUID id;
	private String email;
	private String nombre;
	
	
	
	
	/**
	 * @param id
	 * @param email
	 * @param nombre
	 */
	public usuario(UUID id, String email, String nombre) {
		super();
		this.id = id;
		this.email = email;
		this.nombre = nombre;
	}
	/**
	 * @return the id
	 */
	public UUID getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(UUID id) {
		this.id = id;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	 @Override 
	 public String toString() { 
	  return "Person [id=" + id + ", name=" + nombre + ", email=" + email + "]"; 
	 } 

}
