import java.util.HashMap;


public class Mapa {
    
    
    private HashMap<String,Coordenada> puntos;

    
    public void setPunto (String nombre, Coordenada punto)
    {

        puntos.put(nombre, punto);
        
    }
    
    public Coordenada getPunto(String nombre)
    {
        
        return puntos.get(nombre);
        
    }
    
    
    
    
}