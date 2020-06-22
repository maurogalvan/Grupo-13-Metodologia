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
    		String tipo, String ubicacion) {
        super(fechainicio, tipo, ubicacion);
        this.fechaLLegada = fechaLLegada;
        this.compania = compania;
        this.asiento = asiento;
        this.duracion = duracion;
    }
    public Traslado(String compania, String asiento, int duracion, Calendar fechainicio, 
    		String tipo, String ubicacion) {
        super(fechainicio, tipo, ubicacion);
        this.compania = compania;
        this.asiento = asiento;
        this.duracion = duracion;
    }
    
    public String toString () {
    	String retorno = super.toString()+
    			"\nFecha de llegada: "+
    			this.fechaLLegada.get(Calendar.DAY_OF_MONTH)+"/"+this.fechaLLegada.get(Calendar.MONTH)+"/"+this.fechaLLegada.get(Calendar.YEAR)+
    			"\nCompañia: "+this.compania+
    			"\nAsiento: "+this.asiento+
    			"\nDuracion: "+this.duracion+" hora";
    	
    	return retorno;
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
