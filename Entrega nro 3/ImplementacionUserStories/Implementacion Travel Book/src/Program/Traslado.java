package Program;

import java.util.*;


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

	public void setFechaLLegada(Calendar fechaLLegada) {
		this.fechaLLegada = fechaLLegada;
	}

	public void setCompania(String compania) {
		this.compania = compania;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	
	
	public String toString() {
		return super.toString() + "\nFecha de LLegada: " + this.fechaLLegada.get(Calendar.DAY_OF_MONTH)+
				"/"+this.fechaLLegada.get(Calendar.MONTH)+
				"/"+this.fechaLLegada.get(Calendar.YEAR)
				+ "\nCompania: " + this.compania+ "\nAsiento: " + this.asiento + "\nDuracion: " + this.duracion+" horas";
	}
      	
}
