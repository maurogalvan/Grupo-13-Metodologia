package Program;

public class Coordenada {
    
    private double x;
    private double y;
    
    
    
    public Coordenada(double x, double y) {
		this.x=x;
		this.y=y;
    }

	public double CalcularDistancia(Coordenada p1)
    {
		double p1X = p1.getX() - this.getX();
		double p1Y = p1.getY() - this.y;
		double a = Math.pow(p1X, 2);
		double b = Math.pow(p1Y, 2);
        double result = Math.sqrt(a + b);
        return result;
        
    }

    public double getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
    
    public String toString() {
    	return " "+ this.x + "," + this.y + " " ;
    }
    
    
    
}