package Defect;

import java.util.*;

/**
 *
 * @author Jeremias Manuel
 */
public class Traslado extends PlanBasico{
    
    private Calendar fechaLLegada;
    private String compania;
    private String asiento;
    private int duracion;

    public Traslado(Calendar fechaLLegada, String compania, String asiento, int duracion, Calendar fechainicio, 
    		String tipo, Coordenada ubicacion) {
        super(fechainicio, tipo, ubicacion);
        this.fechaLLegada = fechaLLegada;
        this.compania = compania;
        this.asiento = asiento;
        this.duracion = duracion;
        
    }

	public void setAsiento(String asiento) {
		this.asiento = asiento;
	}

	public Calendar getFechaLLegada() {
		return fechaLLegada;
	}

	public String getCompania() {
		return compania;
	}

	public String getAsiento() {
		return asiento;
	}

	public int getDuracion() {
		return duracion;
	}
    
	
    
    
        	
}
