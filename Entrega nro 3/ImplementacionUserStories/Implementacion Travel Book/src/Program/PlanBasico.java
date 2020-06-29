package Program;

import java.util.*;


public class PlanBasico {
    
    private Calendar fechainicio;
    private String tipo;
    private Coordenada ubicacion;
 

    public PlanBasico(Calendar fechainicio, String tipo, Coordenada ubicacion) {
        this.fechainicio = fechainicio;
        this.tipo = tipo;
        this.ubicacion = ubicacion;
    }
    
    
    public Calendar getFechainicio() {
        return fechainicio;
    }


    public String getTipo() {
        return tipo;
    }

    public Coordenada getUbicacion() {
        return ubicacion;
    }
    
    
    public String toString() {
    	return "Fecha de Inicio:" + this.fechainicio.get(Calendar.DAY_OF_MONTH)+"/"+this.fechainicio.get(Calendar.MONTH)+"/"+this.fechainicio.get(Calendar.YEAR) 
    + "\nTipo: " + this.tipo + "\nUbicacion: " + this.ubicacion.toString();
    }
    
    
    
}