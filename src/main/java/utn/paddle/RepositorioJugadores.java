package utn.paddle;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Transient;

public class RepositorioJugadores {
	
	@Transient
	private List<Jugador> jugadores = new ArrayList<>();
	
}
