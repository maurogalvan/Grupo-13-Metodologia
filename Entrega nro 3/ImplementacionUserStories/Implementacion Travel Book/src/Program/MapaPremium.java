package Program;

public class MapaPremium extends Mapa{

	public double calcularDistancia(Coordenada posicionActual, String lugar2)
    {
		Coordenada coordenada = puntos.get(lugar2);
		double valor = posicionActual.CalcularDistancia(coordenada);
        return valor;
    }
    
 
}
