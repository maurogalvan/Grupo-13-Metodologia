/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Defect;

/**
 *
 * @author jerel
 */
public class MapaPremium extends Mapa{

    public MapaPremium() {
        super();
    }
    
    
    public float calcularDistancia(Coordenada posicionActual, String lugar2)
    {
        return posicionActual.CalcularDistancia(super.getPunto(lugar2));
    }
    
    
    
}
