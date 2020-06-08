package Defect;

import java.util.Calendar;

/**
 *
 * @author Jeremias Manuel
 */
public class TrasladoAereo extends Traslado{
	

	private static Calendar fechaRegreso = Calendar.getInstance();
    private String aeropuertoLLegada; //Proximamente sera la clase aeropuerto
    private String aeropuertoSalida; //Proximamente sera la clase aeropuerto
    private String infoAeronave;
    private String nroVuelo;
    
    
    
    public TrasladoAereo(String nroVuelo, String compania, Calendar fechainicio) {
    	
    	 //Supongo que FlightStats da los valores seteados:
    	
        super(setFechaRegresoFlighStats(), compania,"A4",24,fechainicio,"Traslado Aereo", "41.2891 , 2.074");
        
        this.nroVuelo = nroVuelo;
       
        this.aeropuertoLLegada = "China";
        this.aeropuertoSalida = "Ezeiza";
        this.infoAeronave = "Boing 737";
    }
    
    public String toString () {
    	String retorno = super.toString()+ "\nNumero de vuelo: "+this.nroVuelo+"\nAeropuerto de salida: "+this.aeropuertoSalida+"\nAeropuerto de llegada: "+
    			this.aeropuertoLLegada+"\nInformacion de aeronave: "+this.infoAeronave;
    	return retorno;
    }
    
    //Simula la entrada de flightstats para poder pasarle al super el tipo Calendar
    private static Calendar setFechaRegresoFlighStats () {
    	fechaRegreso.set(2020, 2, 12,8,30);
    	return fechaRegreso;
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
