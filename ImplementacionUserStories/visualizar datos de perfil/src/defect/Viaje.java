import java.util.Calendar;
import java.util.Vector;

public class Viaje {

    private String origen;
    private String destino;
    private Calendar fecha;
    private Calendar fechaInicioViaje;
    private Calendar fechaFinViaje;
    private float tiempoEscalas;
    private Vector<PlanBasico> planes = new Vector<PlanBasico>();
    private String descripcion;


    public Viaje(String origen, String destino, TrasladoAereo vuelo1, TrasladoAereo vuelo2) {

        this.origen = origen;
        this.destino = destino;
        this.fecha = Calendar.getInstance();
        this.fechaInicioViaje = vuelo1.getFechaInicio();
        this.fechaFinViaje = vuelo2.getFechaInicio();

    }


    public void crearMapa() {
        Vector<GPS> ocurrencias = new Vector<GPS>();
        for(PlanBasico plan : planes) {
            ocurrencias.add(plan.getUbicacion);
        }
    }

    public Vector<PlanBasico> getPlanes() {
        Vector<PlanBasico> salida = new Vector<PlanBasico>();
        salida.addAll(planes);

        return salida;
    }

    public addPlan(PlanBasico plan) {

        if(!planes.contains(plan))
            planes.add(plan);
    }


    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public Calendar getFechaInicioViaje() {
        return fechaInicioViaje;
    }

    public Calendar getFechaFinViaje() {
        return fechaFinViaje;
    }

    public float getTiempoEscalas() {
        return tiempoEscalas;
    }

    public String getDescripcion() {
        return descripcion;
    }


    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


}
