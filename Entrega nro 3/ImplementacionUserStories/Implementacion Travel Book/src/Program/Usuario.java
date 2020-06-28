package Program;

import java.util.*;


public class Usuario {
	

	private String nombre;
	private String apellido;
	private String mail;
	private String pais;
	private Calendar nacimiento;
	private boolean notificacion;
	private ArrayList<String> paisesVisitados;
	private double kmRecorridos;
	private ArrayList<Viaje> misViajes;
	private boolean premium;
	private ArrayList<String> notificaciones = new ArrayList<String>();
	
	

	public Usuario(String nombre, String apellido, String mail, String pais,Calendar nacimiento,boolean notificacion,boolean premium) 
	{
		this.nombre=nombre;
		this.apellido=apellido;
		this.mail=mail;
		this.pais=pais;
		this.nacimiento=nacimiento;
		this.notificacion=notificacion;
		this.paisesVisitados= new ArrayList <String> ();
		this.kmRecorridos=0;
		this.misViajes= new ArrayList <Viaje>();
		this.premium= premium;
	}
	
	public Usuario() {
		
	}
	

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	

	public void setMail(String mail) {
		this.mail = mail;
	}
	

	public void setPais(String pais) {
		this.pais = pais;
	}
	

	public void setNacimiento(Calendar nacimiento) {
		this.nacimiento = nacimiento;
	}
	

	public void setNotificacion(boolean notificacion) {
		this.notificacion = notificacion;
	}
	

	public void setPremium(boolean premium) {
		this.premium = premium;
	}
	

	public String getNombre() {
		return nombre;
	}
	

	public String getApellido() {
		return apellido;
	}
	

	public String getMail() {
		return mail;
	}

	
	public String getPais() {
		return pais;
	}
	

	public Calendar getNacimiento() {
		return nacimiento;
	}

	
	public boolean isNotificacion() {
		return notificacion;
	}
	
	
	public void addNotificacion(String notificacion) {
		if(isNotificacion())
			notificaciones.add(notificacion);
	}
	

	public ArrayList<String> getPaisesVisitados() {
		return paisesVisitados;
	}


	public double getKmRecorridos() {
		return kmRecorridos;
	}
	

	public ArrayList<Viaje> getMisViajes() {
		return misViajes;
	}
	

	public boolean isPremium() {
		return premium;
	}
	

	public void addPaisesVisitados(String pais) {
		paisesVisitados.add(pais);
	}
	

	public void addKmRecorridos(double km) {
		this.kmRecorridos+=km;
	}
	

	public void addMisViajes(Viaje nuevoViaje) {
		misViajes.add(nuevoViaje);
	}
	
	public void eliminarViaje(String origen, String destino, Calendar fechaInicioViaje) {
		if(this.misViajes != null)
			for(Viaje e : this.misViajes)
				if((e.getFechaInicioViaje().equals(fechaInicioViaje)) && (e.getOrigen().equals(origen)) && (e.getDestino().equals(destino)))
					misViajes.remove(e);
	}
	
	
	public void eliminarPlan(Calendar fechaPlan) {
		for(Viaje e : this.misViajes)
			if(e.getFechaInicioViaje().after(fechaPlan) && e.getFechaFinViaje().before(fechaPlan))
				e.eliminarPlan(fechaPlan);
	}
	
	
	public void cargarPlanBasico(String origen, String destino, Calendar fechaInicioViaje, Calendar fechainicioPlan, String tipo, Coordenada ubicacion) {
		if(this.misViajes != null)
			for(Viaje e : this.misViajes)
				if((e.getFechaInicioViaje().equals(fechaInicioViaje)) && (e.getOrigen().equals(origen)) && (e.getDestino().equals(destino))) {
					PlanBasico planB = new PlanBasico(fechainicioPlan, tipo, ubicacion);
					e.addPlan(planB);
				}
	
	}
	
	
	public void cargarPlanHotel(String origen, String destino, Calendar fechaInicioViaje, Calendar fechainicioPlan, String tipo, Coordenada ubicacion, String habitacion, Calendar fechaFin) {
		if(this.misViajes != null)
			for(Viaje e : this.misViajes)
				if((e.getFechaInicioViaje().equals(fechaInicioViaje)) && (e.getOrigen().equals(origen)) && (e.getDestino().equals(destino))) {
					PlanBasico planH = new PlanHotel(habitacion, fechaFin, fechainicioPlan, tipo, ubicacion);
					e.addPlan(planH);
				}
	}
	
	
	public void cargarPlanHoteleMail(String origen, String destino, Calendar fechaInicioViaje) {
		if(this.misViajes != null)
			for(Viaje e : this.misViajes)
				if((e.getFechaInicioViaje().equals(fechaInicioViaje)) && (e.getOrigen().equals(origen)) && (e.getDestino().equals(destino))) {
					PlanBasico planHe = new PlanHotel(this.getMail());
					e.addPlan(planHe);
				}
	
	}
	
	
	public void cargarTraslado(String origen, String destino, Calendar fechaInicioViaje, Calendar fechainicioPlan, String tipo, Coordenada ubicacion, Calendar fechaLLegada, String compania, String asiento, int duracion) {
		if(this.misViajes != null)
			for(Viaje e : this.misViajes)
				if((e.getFechaInicioViaje().equals(fechaInicioViaje)) && (e.getOrigen().equals(origen)) && (e.getDestino().equals(destino))) {
					PlanBasico traslado = new Traslado(fechaLLegada, compania, asiento, duracion, fechainicioPlan, tipo, ubicacion);
					e.addPlan(traslado);
				}
	
	}
	
	
	public void cargarTrasladoAereo(String origen, String destino, Calendar fechaInicioViaje, String nroVuelo, String compania, Calendar fechainicio) {
		if(this.misViajes != null)
			for(Viaje e : this.misViajes)
				if((e.getFechaInicioViaje().equals(fechaInicioViaje)) && (e.getOrigen().equals(origen)) && (e.getDestino().equals(destino))) {
					Traslado planAereo = new TrasladoAereo(nroVuelo, compania, fechainicio);
					e.addPlan(planAereo);
				}
	
	}
	
	public void cargarTrasladoAereoEmail(String origen, String destino, Calendar fechaInicioViaje) {
		if(this.misViajes != null)
			for(Viaje e : this.misViajes)
				if((e.getFechaInicioViaje().equals(fechaInicioViaje)) && (e.getOrigen().equals(origen)) && (e.getDestino().equals(destino))) {
					Traslado planAereo = new TrasladoAereo(this.getMail());
					e.addPlan(planAereo);
				}
	
	}
	

	
	public void cargarDatosViaje (Calendar diaIda, Calendar diaVuelta, String companiaIda, String companiaVuelta, 
			String numVueloIda, String numVueloVuelta, String ciudadOrigen, String ciudadDestino,String descripcion) {
		
		TrasladoAereo vueloIda= new TrasladoAereo(numVueloIda, companiaIda, diaIda);
		TrasladoAereo vueloVuelta= new TrasladoAereo(numVueloVuelta, companiaVuelta, diaVuelta); 
		String origen= ciudadOrigen;
		String destino= ciudadDestino;
		Viaje nuevoViaje= new Viaje (origen, destino, vueloIda, vueloVuelta, descripcion);
		misViajes.add(nuevoViaje);
	}
        
 
        public Mapa crearMapa(Viaje viaje) 
        {
      
            if(this.existeViaje(viaje))
            {
                Mapa m = viaje.crearMapaViaje();
                return m;
            }
          
           return null; 
            
        }
        

        public MapaPremium crearMapaPremium(Viaje viaje)
        {
            if(premium)
            {
                if(this.existeViaje(viaje))
                {
                    MapaPremium m = viaje.crearMapaPremium();
                    return m;
                }
            }
           
            return null;
        }
        
      
        
        private boolean existeViaje(Viaje viaje)
        {
            int i = 0;
            
            while(i < misViajes.size())
            {
                if(viaje.equals(misViajes.get(i)))
                {
                    return true;
                }
            }
            
            return false;
        }
	
	public String toString() {
		String retorno = "Nombre: "+this.nombre+"\nApellido: "+this.apellido+"\nMail: "+this.mail+"\nPais: "+this.pais+
				"\nFecha Nacimiento: "+this.nacimiento.get(Calendar.DAY_OF_MONTH)+"/"+this.nacimiento.get(Calendar.MONTH)+"/"+this.nacimiento.get(Calendar.YEAR);
		return retorno;
	}
	
} 
