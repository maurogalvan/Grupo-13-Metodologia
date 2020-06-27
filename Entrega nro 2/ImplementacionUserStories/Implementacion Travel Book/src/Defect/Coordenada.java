/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodologia;

/**
 *
 * @author jerel
 */
public class Coordenada {
    
    private float x;
    private float y;
    
    
    
    public float CalcularDistancia(Coordenada p1)
    {
        
        return ( sqrt(pow(p1.getX() - x)2) + pow(p1.getY() - y)2)             )
        
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
    
    
    
}
