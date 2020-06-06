/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodologia;

import java.util.Date;

/**
 *
 * @author jerel
 */
public class TransladoAereo extends Translado{
    private String nroVuelo;
    private Aeropuerto aeropuertoLLegada;
    private Aeropuerto aeropuertoSalida;
    private String infoAeronave;

    public TransladoAereo(String nroVuelo, Aeropuerto aeropuertoLLegada, Aeropuerto aeropuertoSalida, String infoAeronave, Date fechaLLegada, String compania, String asiento, Date duracion, Date fechainicio, String tipo, GPS ubicacion, Time comienzo) {
        super(fechaLLegada, compania, asiento, duracion, fechainicio, tipo, ubicacion, comienzo);
        this.nroVuelo = nroVuelo;
        this.aeropuertoLLegada = aeropuertoLLegada;
        this.aeropuertoSalida = aeropuertoSalida;
        this.infoAeronave = infoAeronave;
    }

    public String getNroVuelo() {
        return nroVuelo;
    }

    public Aeropuerto getAeropuertoLLegada() {
        return aeropuertoLLegada;
    }

    public Aeropuerto getAeropuertoSalida() {
        return aeropuertoSalida;
    }

    public String getInfoAeronave() {
        return infoAeronave;
    }

        
  
    
    
    
}
