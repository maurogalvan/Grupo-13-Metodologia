package Program;

import java.util.Vector;

public class AeroPuerto {
	
	private String nombre;
	private Coordenada ubicacion;
	private boolean mostradores;
	private Vector<String> infoVuelos = new Vector<String>();
	private Vector<String> cinta = new Vector<String>();
	
	public AeroPuerto(String nombre, Coordenada ubicacion) {
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.mostradores = false;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Coordenada getUbicacion() {
		return ubicacion;
	}
	
	public boolean getMosradores() {
		return this.mostradores;
	}
	
	public String getCinta(String nroVuelo) {
		int indice = 0;
		if(infoVuelos.contains(nroVuelo)) {
			indice = infoVuelos.indexOf(nroVuelo);
			 return cinta.get(indice);
		}
		else return null;
	}
	
	
	public void setMostradores(boolean cambiar) {
		this.mostradores = cambiar;
	}
	
	
	public void addInfoVuelo(String nroVuelo, String cinta) {
		this.infoVuelos.add(nroVuelo);
		this.cinta.add(cinta);
		
	}


}
