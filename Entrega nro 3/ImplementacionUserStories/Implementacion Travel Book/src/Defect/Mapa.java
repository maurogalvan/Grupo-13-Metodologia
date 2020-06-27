/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Defect;

 
import java.util.HashMap;

/**
 *
 * @author jerel
 */
public class Mapa {
    
    
    private HashMap<String,Coordenada> puntos;

    public Mapa() {
      
    }
    
    public void setPunto (String nombre, Coordenada punto)
    {

        puntos.put(nombre, punto);
        
    }
    
    public Coordenada getPunto(String nombre)
    {
        
        return puntos.get(nombre);
        
    }
    
    
    
    
}
