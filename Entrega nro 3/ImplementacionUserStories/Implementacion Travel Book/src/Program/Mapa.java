package Program;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * La clase Mapa genera a traves de un HashMap una sucesion de puntos.
 *
 */

public class Mapa {
    
    
    protected HashMap<String,Coordenada> puntos = new HashMap<>();
    

    
    public void setPunto (String nombre, Coordenada punto)
    {

        puntos.put(nombre, punto);
        
    }
    
    public Coordenada getPunto(String nombre)
    {
    	Coordenada salida = null;
        if (puntos.containsKey(nombre)) {
        	salida=puntos.get(nombre);
        	return salida;
        }
        return salida;
        
    }
    
    //No es una buena practica mostrar en una clase, pero me facilitaba en el Test.
    public void mostrarMapa () {
    	for (Map.Entry<String, Coordenada> e : puntos.entrySet()) 
            System.out.println(e.getKey() + " | Coordenada: " + e.getValue()); 	
    }
   
    
}