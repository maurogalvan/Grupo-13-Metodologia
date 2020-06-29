package Program;

import java.util.Calendar;
import java.util.Vector;


public class Viaje {

    private String origen;
    private String destino;
    private Calendar fechaInicioViaje;
    private Calendar fechaFinViaje;
    private Vector<PlanBasico> planes = new Vector<PlanBasico>();
    private String descripcion;
    private Traslado trasladoIda; 
    private Traslado trasladoVuelta;
    
    
    
    public Viaje(String origen, String destino, TrasladoAereo vueloIda, TrasladoAereo vueloVuelta) {

        this.origen = origen;
        this.destino = destino;
        this.fechaInicioViaje = vueloIda.getFechainicio();
        this.fechaFinViaje = vueloVuelta.getFechainicio();
        this.trasladoIda= vueloIda;
        this.trasladoVuelta = vueloVuelta;
    }
    
    public Viaje(String origen, String destino, TrasladoAereo vueloIda, TrasladoAereo vueloVuelta, String descripcion) {

        this.origen = origen;
        this.destino = destino;
        this.fechaInicioViaje = vueloIda.getFechainicio();
        this.fechaFinViaje = vueloVuelta.getFechainicio();
        this.trasladoIda= vueloIda;
        this.trasladoVuelta = vueloVuelta;
        this.descripcion=descripcion;
    }
    
    public String toString () {
    	String retorno = "Origen: "+ this.origen + 
    			"\nDestino: "+this.destino+
    			"\nFecha inicio: "+this.fechaInicioViaje.get(Calendar.DAY_OF_MONTH)+"/"+this.fechaInicioViaje.get(Calendar.MONTH)+"/"+this.fechaInicioViaje.get(Calendar.YEAR)+
    			" A las: "+this.fechaInicioViaje.get(Calendar.HOUR)+":"+this.fechaInicioViaje.get(Calendar.MINUTE)+
    			"\nFecha fin: "+this.fechaFinViaje.get(Calendar.DAY_OF_MONTH)+"/"+this.fechaFinViaje.get(Calendar.MONTH)+"/"+this.fechaFinViaje.get(Calendar.YEAR)+
    			" A las: "+this.fechaFinViaje.get(Calendar.HOUR)+":"+this.fechaFinViaje.get(Calendar.MINUTE)+
    			"\nDescripcion: "+this.descripcion+
    			"\n"+
    			"\n* Traslado ida: \n"+this.trasladoIda.toString()+
    			"\n"+
    			"\n* Traslado vuelta: \n"+ this.trasladoVuelta.toString();
    	return retorno;
    }

    public Mapa crearMapaViaje() {
        Mapa m = new Mapa();
        
        for(int i =0; i < planes.size(); i++)
        {
        	m.setPunto(planes.get(i).getTipo(), planes.get(i).getUbicacion());
        }
        
        return m;
    }
    
    public MapaPremium crearMapaPremium (){
        MapaPremium m = new MapaPremium();
        for(int i =0; i< planes.size(); i++)
        	if(planes.get(i) instanceof PlanBasico)
        		m.setPunto(planes.get(i).getTipo(), planes.get(i).getUbicacion());
        return m;   
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
    
    public void eliminarPlan(Calendar fechaPlan) {
    	for(PlanBasico e : planes)
    		if(e.getFechainicio().equals(fechaPlan))
    			planes.remove(e);
    }
    
    public PlanBasico getPlan(Calendar fechaPlan) {
    	if(this.planes != null)
    		for(PlanBasico e : this.planes)
    			if(e.getFechainicio().equals(fechaPlan))
    				return e;
		return null;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public boolean equals (Viaje v){
        try {
        	return (v.origen.equals(this.origen) && v.destino.equals(this.destino) && v.descripcion.equals(this.descripcion));
        } catch (Exception e) {
        	return false;
        }
    }

}