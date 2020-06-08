package Defect;

import java.util.*;

/**
 *
 * @author Jeremias Manuel
 */
public class PlanBasico {
    
    private Calendar fechainicio;
    private String tipo;
    private String ubicacion;
 

    public PlanBasico(Calendar fechainicio, String tipo, String ubicacion) {
        this.fechainicio = fechainicio;
        this.tipo = tipo;
        this.ubicacion = ubicacion;
    }
    public PlanBasico(){
        
    }
    
    public String toString () {
    	String retorno = "Tipo: "+this.tipo+"\nCoordenadas: "+this.ubicacion+"\nFecha de inicio: "+this.fechainicio.get(Calendar.DAY_OF_MONTH)+"/"+
    			this.fechainicio.get(Calendar.MONTH)+"/"+this.fechainicio.get(Calendar.YEAR);
    	return retorno;
    }
    
    //Getters y setters 
    public Calendar getFechainicio() {
        return fechainicio;
    }


    public String getTipo() {
        return tipo;
    }

    public String getUbicacion() {
        return ubicacion;
    }
    
}
