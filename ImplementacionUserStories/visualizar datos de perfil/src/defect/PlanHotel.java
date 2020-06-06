/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodologia;

import java.util.Date;

/**
 *
 * @author jerel
 */
public class PlanHotel extends PlanBasico {
    
    private String habitacion;
    private Date fechaFin;

       // al constructor de PlanHotel le paso los atributos del padre tambien para usar el constructor con super()
    public PlanHotel(String habitacion, Date fechaFin, Date fechainicio, String tipo, GPS ubicacion,Time comienzo) {
        super(fechainicio,tipo,ubicacion,comienzo);
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