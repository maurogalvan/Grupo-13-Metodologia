package Defect;

import java.util.*;

/**
 *
 * @author Jeremias manuel
 */
public class PlanHotel extends PlanBasico {
    
    private String habitacion;
    private Calendar fechaFin;

       // al constructor de PlanHotel le paso los atributos del padre tambien para usar el constructor con super()
    public PlanHotel(String habitacion, Calendar fechaFin, Calendar fechainicio, String tipo, String ubicacion) {
        super(fechainicio,tipo,ubicacion);
        this.habitacion = habitacion;
        this.fechaFin = fechaFin;
    }

    public PlanHotel(String habitacion, Calendar fechaFin) {
        super();
        this.habitacion = habitacion;
        this.fechaFin = fechaFin;
    }
    
    public String toString () {
    	String retorno = super.toString()+
    			"\nFecha de salida: "+this.fechaFin.get(Calendar.DAY_OF_MONTH)+"/"+
    			this.fechaFin.get(Calendar.MONTH)+"/"+this.fechaFin.get(Calendar.YEAR)+"\nHabitacion numero: "+this.habitacion;
    	return retorno;
    }

    public String getHabitacion() {
        return habitacion;
    }

    public Calendar getFechaFin() {
        return fechaFin;
    }
    
    public void reenviarEmail(){
        // reenviarEmail.
    	// Para el proximo sprint
    }
    
}