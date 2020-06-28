import java.util.Calendar;



public class PlanHotel extends PlanBasico {
    
    private String habitacion;
    private Calendar fechaFin;

   
    public PlanHotel(String habitacion, Calendar fechaFin, Calendar fechainicio, String tipo, Coordenada ubicacion) {
        super(fechainicio, tipo, ubicacion);
        this.habitacion = habitacion;
        this.fechaFin = fechaFin;
    }

    
    public PlanHotel(String email){ // Se pretende que se mande un email y el mismo vuelve cargado.
    	super(Calendar.getInstance(), "Hotel", new Coordenada(1,2));
    	this.habitacion = "Habitacion 113";
    	this.fechaFin = Calendar.getInstance();
    	email = "Hotel, ubicacion, FechaInicio, FechaFin, Habitacion";
    	//Se retorna el email
    }
    
    

    public String getHabitacion() {
        return habitacion;
    }

    public Calendar getFechaFin() {
        return fechaFin;
    }
    
}