package Defect;


import java.util.Calendar;
import java.util.Vector;


public class Viaje {

    private String origen;
    private String destino;
    private Calendar fechaInicioViaje;
    private Calendar fechaFinViaje;
    private float tiempoEscalas;
    private Vector<PlanBasico> planes = new Vector<PlanBasico>();
    private String descripcion;


    public Viaje(String origen, String destino, TrasladoAereo vueloIda, TrasladoAereo vueloVuelta) {

        this.origen = origen;
        this.destino = destino;
        this.fechaInicioViaje = vueloIda.getFechainicio();
        this.fechaFinViaje = vueloVuelta.getFechaLLegada();
    }


    public void crearMapa() {
        Vector<String> ocurrencias = new Vector<String>(); //Es clase gps pero por ahora ponemos Strings
        for(PlanBasico plan : planes) {
            ocurrencias.add(plan.getUbicacion());
        }
    }

    public Vector<PlanBasico> getPlanes() {
        Vector<PlanBasico> salida = new Vector<PlanBasico>();
        salida.addAll(planes);

        return salida;
    }

    public void addPlan(PlanBasico plan) {

        if(!planes.contains(plan))
            planes.add(plan);
    }


    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
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