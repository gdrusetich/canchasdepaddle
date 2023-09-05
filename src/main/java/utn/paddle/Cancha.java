package utn.paddle;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Cancha {
@Id
private long id;
public String nombre;
private boolean iluminacion;
public long cod_color;

@Transient
private List<Partido> partidos = new ArrayList<>();
@Transient
private Color color;


public Long getId() {return id;}
public String getNombre() {return nombre;}
public boolean getIlumunacion() {return iluminacion;}
public long getCod_color() {return cod_color;}


}
