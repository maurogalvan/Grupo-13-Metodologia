package Program;

import java.util.Calendar;
import java.util.Vector;


public class TrasladoAereo extends Traslado{
	

	protected static Calendar calendar = Calendar.getInstance();
    private String nroVuelo;
    private Aeropuerto aeropuertoLLegada;
    private Aeropuerto aeropuertoSalida;
    private String infoAeronave;
    private Usuario user;
    private Vector<TrasladoAereo> escalas = new Vector<TrasladoAereo>();
    
    //Datos para simular FlightStats
    protected static final Coordenada coordenada = new Coordenada (41.2891,2.013);
    protected static final Coordenada coordenadaLlegada = new Coordenada (12.31,345.65);
    protected static final Coordenada coordenadaSalida = new Coordenada (876.31,453.65);
    
    
    public TrasladoAereo(String nroVuelo, String compania, Calendar fechainicio, Usuario user, Aeropuerto aeroLlegadaTEST,
    		Aeropuerto aeroSalidaTEST) {
        super(calendar, compania,"A4",12,fechainicio,"trasladoAereo", coordenada);
        
        this.nroVuelo = nroVuelo;
        //Supongo que FlightStats me da los siguientes datos:
        this.aeropuertoLLegada = aeroLlegadaTEST;
        this.aeropuertoSalida = aeroSalidaTEST;
        this.infoAeronave = "Boing 737";
        this.user=user;
        //Supongo que FlightStats carga la lista de escalas
    }
    
    public TrasladoAereo(String nroVuelo, String compania, Calendar fechainicio, Usuario user) {
        super(calendar, compania,"A4",12,fechainicio,"trasladoAereo", coordenada);
        
        this.nroVuelo = nroVuelo;
        //Supongo que FlightStats me da los siguientes datos:
        this.aeropuertoLLegada = new Aeropuerto ("Ezeiza", coordenadaLlegada);
        this.aeropuertoSalida = new Aeropuerto ("Barcelona", coordenadaSalida);
        this.infoAeronave = "Boing 737";
        this.user=user;
        //Supongo que FlightStats carga la lista de escalas
    }
    
    public TrasladoAereo(String email) {
        super(calendar, "AerolineasArg", "A4", 12, calendar, "trasladoAereo", coordenada);
        this.nroVuelo = "365";
        //Supongo que FlightStats me da los siguientes datos:
        this.aeropuertoLLegada = new Aeropuerto("Barcelona", coordenadaLlegada);
        this.aeropuertoSalida = new Aeropuerto ("Ezeiza", coordenadaSalida);
        this.infoAeronave = "Boing 737";
        email = "NroVuelo: 365, Aerolinea: AerolineasArg, Asiento: A4, Duracion: 12hs, fechaInicio: 20/03 a las 15hs, AeropuertoSalida: Ezeiza, AeropuertoLlegada: Barcelona";
        // Se retorna el email
    }
    
    public String toString() {
    	return super.toString() + "\nNroVuelo: " + this.nroVuelo + "\nAeropuertoLLegada: " + this.aeropuertoLLegada.toString() 
    		+ "\nAeropuertaSalida: " + this.aeropuertoSalida.toString() + "\nInformacino de Nave: " + this.infoAeronave;
    }

    public String getNroVuelo() {
        return nroVuelo;
    }

    public String getAeropuertoLLegada() {
        return aeropuertoLLegada.getNombre();
    }

    public String getAeropuertoSalida() {
        return aeropuertoSalida.getNombre();
    }

    public String getInfoAeronave() {
        return infoAeronave;
    }
    

	public void setNroVuelo(String nroVuelo) {
		this.nroVuelo = nroVuelo;
	}
	
	public Vector<TrasladoAereo> getEscalas(){
		Vector<TrasladoAereo> salida = new Vector<TrasladoAereo>(this.escalas);
		return salida;
	}
	
	public Vector<Integer> getDuracionEscalas() {
		Vector<Integer> salida = new Vector<Integer>(null);
		if(getEscalas() != null)
			for(int i=0 ; i < this.escalas.size(); i++) {
				TrasladoAereo ta = this.escalas.get(i);
				TrasladoAereo tasig = null;
				if(this.escalas.get(i+1) != null)
					tasig = this.escalas.get(i+1);
				@SuppressWarnings("static-access")
				float diferenciaDia = tasig.getFechainicio().DAY_OF_MONTH - ta.getFechainicio().DAY_OF_MONTH;
				@SuppressWarnings("static-access")
				float tiempo = tasig.getFechainicio().HOUR - (ta.getFechainicio().HOUR + ta.getDuracion());
				float tiempoReal = tiempo + diferenciaDia* 24;
				salida.add((int) tiempoReal);
			}
		return salida;
	}
	
	public void notificarMostradores() {
		if(user.isPremium() && user.isNotificacion()) {
			if(this.aeropuertoSalida.getMostradores())
				user.addNotificacion("Mostradores Abiertos del aeropuerto de salida "+aeropuertoSalida.getNombre());
		}
	}
	
	public void notificarCinta() {
		String cinta = this.aeropuertoLLegada.getCinta(this.nroVuelo);
		
		if(user.isPremium() && user.isNotificacion())
			user.addNotificacion("Para vuelo nro: "+this.nroVuelo+" Cinta para realizar BagDrop: " + cinta);
	}
	

	public void setAeropuertoLLegada(Aeropuerto aeropuertoLLegada) {
		this.aeropuertoLLegada = aeropuertoLLegada;
		if(user.isPremium())
			user.addNotificacion("Nuevo AeroPuerto LLegada: " + aeropuertoLLegada);
	}

	public void setAeropuertoSalida(Aeropuerto aeropuertoSalida) {
		this.aeropuertoSalida = aeropuertoSalida;
		if(user.isPremium())
			user.addNotificacion("Nuevo AeroPuerto Salida:" + aeropuertoSalida);
	}

	public void setInfoAeronave(String infoAeronave) {
		this.infoAeronave = infoAeronave;
		if(user.isPremium())
			user.addNotificacion("Nuevo infoAeronave:" + infoAeronave);
	}


	public void setAsiento(String asiento) {
		super.setAsiento(asiento);
		if(user.isPremium())
			user.addNotificacion("Nuevo Asiento:" + asiento);
	}


	public void setFechaLLegada(Calendar fechaLLegada) {
		super.setFechaLLegada(fechaLLegada);
		if(user.isPremium())
			user.addNotificacion("Nuevo FechaLLegada:" + fechaLLegada.toString());
	}


	public void setCompania(String compania) {
		super.setCompania(compania);
		if(user.isPremium())
			user.addNotificacion("Nuevo Compania:" + compania);
	}


	public void setDuracion(int duracion) {
		super.setDuracion(duracion);
		if(user.isPremium())
			user.addNotificacion("Nuevo Duracion:" + duracion);
	}
	

    
}