package Defect;

import java.util.Calendar;

/**
 *
 * @author Jeremias Manuel
 */
public class TrasladoAereo extends Traslado{
	

	protected static Calendar calendar = Calendar.getInstance();
    private String nroVuelo;
    private String aeropuertoLLegada;
    private String aeropuertoSalida;
    private String infoAeronave;
    
    protected static final float x = (float) 41.2891;
    protected static final float y = (float) 2.074;
    protected static final Coordenada coordenada = new Coordenada (x,y);
    
    public TrasladoAereo(String nroVuelo, String compania, Calendar fechainicio) {
        super(calendar, compania,"A4",12,fechainicio,"trasladoAereo", coordenada);
        
        this.nroVuelo = nroVuelo;
        //Supongo que FlightStats me da los siguientes datos:
        this.aeropuertoLLegada = "Barcelona";
        this.aeropuertoSalida = "Ezeiza";
        this.infoAeronave = "Boing 737";
    }

    public String getNroVuelo() {
        return nroVuelo;
    }

    public String getAeropuertoLLegada() {
        return aeropuertoLLegada;
    }

    public String getAeropuertoSalida() {
        return aeropuertoSalida;
    }

    public String getInfoAeronave() {
        return infoAeronave;
    }
    
}
