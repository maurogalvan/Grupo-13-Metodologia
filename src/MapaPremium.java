public class MapaPremium extends Mapa{


    
    public float calcularDistancia(Coordenada posicionActual, String lugar2)
    {
        return posicionActual.CalcularDistancia(super.getPunto(lugar2));
    }
    
 
}
