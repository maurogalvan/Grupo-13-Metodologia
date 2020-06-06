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
public class PlanBasico {
    
    private Date fechainicio;
    private String tipo;
    private Time comienzo;
    private GPS ubicacion;
 

    public PlanBasico(Date fechainicio, String tipo, GPS ubicacion,Time comienzo) {
        this.fechainicio = fechainicio;
        this.tipo = tipo;
        this.ubicacion = ubicacion;
        this.comienzo = comienzo;
    }
    public PlanBasico(){
        
    }
    
    
    
    
    //Getters y setters 
    public Date getFechainicio() {
        return fechainicio;
    }


    public String getTipo() {
        return tipo;
    }

    public GPS getUbicacion() {
        return ubicacion;
    }


    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
    
    
    
}
