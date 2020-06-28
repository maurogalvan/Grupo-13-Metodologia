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
    
    
    
}