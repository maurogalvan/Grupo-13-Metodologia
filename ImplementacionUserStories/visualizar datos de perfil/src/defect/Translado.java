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
public class Translado extends PlanBasico{
    
    private Date fechaLLegada;
    private String compania;
    private String asiento;
    private Date duracion;

    public Translado(Date fechaLLegada, String compania, String asiento, Date duracion, Date fechainicio, String tipo, GPS ubicacion, Time comienzo) {
        super(fechainicio, tipo, ubicacion, comienzo);
        this.fechaLLegada = fechaLLegada;
        this.compania = compania;
        this.asiento = asiento;
        this.duracion = duracion;
    }

    public Translado(Date fechaLLegada, String compania, String asiento, Date duracion) {
        super();
        this.fechaLLegada = fechaLLegada;
        this.compania = compania;
        this.asiento = asiento;
        this.duracion = duracion;
    }
    
    
    
}
