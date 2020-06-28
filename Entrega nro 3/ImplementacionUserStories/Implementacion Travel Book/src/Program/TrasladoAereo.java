package Program;

import java.util.Calendar;


public class TrasladoAereo extends Traslado{
	

	protected static Calendar calendar = Calendar.getInstance();
    private String nroVuelo;
    private AeroPuerto aeropuertoLLegada;
    private AeroPuerto aeropuertoSalida;
    private String infoAeronave;
    private Usuario user;
    
    protected static final float x = (float) 41.2891;
    protected static final float y = (float) 2.074;
    protected static final Coordenada coordenada = new Coordenada (x,y);
    
    
    public TrasladoAereo(String nroVuelo, String compania, Calendar fechainicio) {
        super(calendar, compania,"A4",12,fechainicio,"trasladoAereo", coordenada);
        
        this.nroVuelo = nroVuelo;
        //Supongo que FlightStats me da los siguientes datos:
        this.aeropuertoLLegada.setNombre("Barcelona");
        this.aeropuertoSalida.setNombre("Ezeiza");
        this.infoAeronave = "Boing 737";
    }
    
    public TrasladoAereo(String email) {
        super(calendar, "AerolineasArg", "A4", 12, calendar, "trasladoAereo", coordenada);
        this.nroVuelo = "365";
        //Supongo que FlightStats me da los siguientes datos:
        this.aeropuertoLLegada.setNombre("Barcelona");
        this.aeropuertoSalida.setNombre("Ezeiza");
        this.infoAeronave = "Boeing 737";
        email = "NroVuelo: 365, Aerolinea: AerolineasArg, Asiento: A4, Duracion: 12hs, fechaInicio: 20/03 a las 15hs, AeropuertoSalida: Ezeiza, AeropuertoLlegada: Barcelona";
        // Se retorna el email
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
	
	public void notificarMostradores() {
		if(this.aeropuertoLLegada.getMosradores())
			user.addNotificacion("Mostradores Abiertos");
	}
	
	public void notificarCinta() {
		String cinta = this.aeropuertoLLegada.getCinta(this.nroVuelo);
		if(user.isPremium() && user.isNotificacion())
			user.addNotificacion("Cinta para realizar BagDrop" + cinta);
	}
	

	public void setAeropuertoLLegada(AeroPuerto aeropuertoLLegada) {
		this.aeropuertoLLegada = aeropuertoLLegada;
		if(user.isPremium())
			user.addNotificacion("Nuevo AeroPuerto LLegada:" + aeropuertoLLegada);
	}

	public void setAeropuertoSalida(AeroPuerto aeropuertoSalida) {
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