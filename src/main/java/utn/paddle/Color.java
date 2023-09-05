package utn.paddle;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Color {
@Id
	public long codigo;
	public String descripcion;
	@Transient
	private Cancha cancha;
	
public long getCodigo() {return codigo;}
public String getDescripcion() {return descripcion;}
	
}
