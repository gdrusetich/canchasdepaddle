package utn.paddle;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Partido {

	@Id
	@GeneratedValue
	private Long id;
	private Long cancha_id;
	private Long color_id;
	
	@Transient
	private List<Jugador> jugadores = new ArrayList<>();
	
}
