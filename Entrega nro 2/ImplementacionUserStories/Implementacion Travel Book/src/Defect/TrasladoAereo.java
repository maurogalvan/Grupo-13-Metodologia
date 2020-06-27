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
    
    
    
    public TrasladoAereo(String nroVuelo, String compania, Calendar fechainicio) {
        super(calendar, compania,"A4",12,fechainicio,"trasladoAereo", "41.2891 , 2.074");
        
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
