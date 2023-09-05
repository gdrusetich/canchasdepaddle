package utn.paddle;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Jugador {
	
	@Id
	@GeneratedValue
	public Long id;

	private String nombre;
	private String apellido;
	public String domicilio;
	public Long cod_paleta;

	public void setId(long id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public void setCod_Paleta(long cod_paleta) {
		this.cod_paleta = cod_paleta;
	}

	public Long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public Long getCod_Paleta() {
		return cod_paleta;
	}

}