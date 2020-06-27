package Defect;

import java.util.Date;
import java.util.*;

/**
 *
 * @author jerel
 */
public class PlanHotel extends PlanBasico {
    
    private String habitacion;
    private Date fechaFin;

       // al constructor de PlanHotel le paso los atributos del padre tambien para usar el constructor con super()
    public PlanHotel(String habitacion, Date fechaFin, Calendar fechainicio, String tipo, Coordenada ubicacion) {
        super(fechainicio,tipo,ubicacion);
        this.habitacion = habitacion;
        this.fechaFin = fechaFin;
    }

    public PlanHotel(String habitacion, Date fechaFin) {
        super();
        this.habitacion = habitacion;
        this.fechaFin = fechaFin;
    }
    

    public String getHabitacion() {
        return habitacion;
    }

    public Date getFechaFin() {
        return fechaFin;
    }
    
    public void reenviarEmail(){
        // reenviarEmail.
    }
    
}