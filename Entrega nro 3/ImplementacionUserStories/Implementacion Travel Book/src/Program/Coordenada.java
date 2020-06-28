package Program;

public class Coordenada {
    
    private float x;
    private float y;
    
    
    /**
     * 
     * @param x Coordenada x del mapa
     * @param y Coordenada y del mapa
     */
    public Coordenada(float x, float y) {
		this.x=x;
		this.y=y;
    }

	public float CalcularDistancia(Coordenada p1)
    {
        
        return (float) ( Math.sqrt(Math.pow(p1.getX() - x,2) + Math.pow(p1.getY() - y,2)));
        
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