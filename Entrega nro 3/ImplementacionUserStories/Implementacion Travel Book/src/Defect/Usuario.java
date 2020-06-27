package Defect;


import java.util.*;
import java.util.Calendar;

/**
 * Esta clase genera un Usuario
 * @author Mauro Galvan
 * @version 1.0
 *
 */

public class Usuario {
	
	//Campos de la clase
	private String nombre;
	private String apellido;
	private String mail;
	private String pais;
	private Calendar nacimiento;
	private boolean notificacion;
	private ArrayList<String> paisesVisitados;
	private double kmRecorridos;
	private ArrayList<Viaje> misViajes;
	private boolean premium;
	
	
	
	/**
	 * Constructor de la clase Usuario
	 * @param nombre El nombre del usuario
	 * @param apellido El apellido del usuario
	 * @param mail El email del usuario
	 * @param pais Pais de donde se encuentra el usuario
	 * @param nacimiento Fecha de nacimiento del usuario
	 * @param notificacion Decicion si el usuario quiere recibir notificaciones
	 * @param paisesVisitados Lista de los paises que el Usuario visito
	 * @param kmRecorridos Total de kilometros que recorrio
	 * @param misViajes Lista de todos los viajes hechos
	 * @param premium Decisor de si un Usuario es premium o no
	 */
	public Usuario(String nombre, String apellido, String mail, String pais,Calendar nacimiento,boolean notificacion,boolean premium) 
	{
		this.nombre=nombre;
		this.apellido=apellido;
		this.mail=mail;
		this.pais=pais;
		this.nacimiento=nacimiento;
		this.notificacion=notificacion;
		this.paisesVisitados= new ArrayList <String> ();
		this.kmRecorridos=0;
		this.misViajes= new ArrayList <Viaje>();
		this.premium= premium;
	}
	
	/**
	 * Setea el nombre del Usuario
	 * @param nombre El nombre del usuario
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Setea el apellido del usuario
	 * @param apellido El apellido del usuario
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	/**
	 * Setea el email del usuario
	 * @param mail El email del usuario
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	/**
	 * Setea el pais de donde se encuentra el usuario
	 * @param pais El pais de nacimiento del usuario
	 */
	public void setPais(String pais) {
		this.pais = pais;
	}
	
	/**
	 * Setea la fecha de nacimiento del usuario
	 * @param nacimiento Fecha de nacimiento del usuario
	 */
	public void setNacimiento(Calendar nacimiento) {
		this.nacimiento = nacimiento;
	}
	
	/**
	 * Setea si el usuario quiere recibir notificaciones
	 * @param notificacion Decicion si el usuario quiere recibir notificaciones
	 */
	public void setNotificacion(boolean notificacion) {
		this.notificacion = notificacion;
	}
	
	/**
	 * Setea si el usuario es premium o no
	 * @param premium Decisor de si un Usuario es premium o no
	 */
	public void setPremium(boolean premium) {
		this.premium = premium;
	}
	
	/**
	 * Metodo que devulve el nombre del usuario
	 * @return Nombre del usuario
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Metodo que devulve el apellido del usuario
	 * @return Apellido del usuario
	 */
	public String getApellido() {
		return apellido;
	}
	
	/**
	 * Metodo que devulve el mail del usuario
	 * @return Mail del usuario
	 */
	public String getMail() {
		return mail;
	}
	
	/**
	 * Metodo que devulve el pais del usuario
	 * @return pais del usuario
	 */
	public String getPais() {
		return pais;
	}
	
	/**
	 * Metodo que devulve la fecha de nacimiento del usuario
	 * @return Nacimiento del usuario del tipo Calendar
	 */
	public Calendar getNacimiento() {
		return nacimiento;
	}
	/**
	 * Metodo que devulve si el usuario quiere recibir notificaciones
	 * @return true or false depende que tenga notifiacion
	 */
	public boolean isNotificacion() {
		return notificacion;
	}
	
	/**
	 * Metodo que devulve la lista de los paises visitados del usuario
	 * @return Lista de los paises visitados
	 */
	public ArrayList<String> getPaisesVisitados() {
		return paisesVisitados;
	}
	
	/**
	 * Metodo que devulve la cantidad de km recorridos por el usuario
	 * @return double con la cantidad de km
	 */
	public double getKmRecorridos() {
		return kmRecorridos;
	}
	
	/**
	 * Metodo que devulve la lista de viajes del usuario
	 * @return la lista que contiene los viajes llamada misViajes
	 */
	public ArrayList<Viaje> getMisViajes() {
		return misViajes;
	}
	
	/**
	 * Metodo que devulve si el usuario es premium
	 * @return true or false depende si el usuario es premium o no
	 */
	public boolean isPremium() {
		return premium;
	}
	
	/**
	 * Agregar un pais visitado a la lista
	 * @param pais Pais visitado
	 */
	public void addPaisesVisitados(String pais) {
		paisesVisitados.add(pais);
	}
	
	/**
	 * Agregar mas kilometros a los ya recorridos
	 * @param km Nuevos kilometros generados que se suman a los recorridos
	 */
	public void addKmRecorridos(double km) {
		this.kmRecorridos+=km;
	}
	
	/**
	 * Agrega un nuevo viaje a la lista de misViajes
	 * @param nuevoViaje Contiene un nuevo viaje
	 */
	public void addMisViajes(Viaje nuevoViaje) {
		misViajes.add(nuevoViaje);
	}
	
	/**
	 * Carga los datos de un viaje
	 * @param vueloIda contiene un Vuelo de ida
	 * @param vueloVuelta contiene un vuelo de vuelta
	 */
	public void cargarDatosViaje (Calendar diaIda, Calendar diaVuelta, String companiaIda, String companiaVuelta, 
			String numVueloIda, String numVueloVuelta, String ciudadOrigen, String ciudadDestino,String descripcion) {
		
		TrasladoAereo vueloIda= new TrasladoAereo(numVueloIda, companiaIda, diaIda);
		TrasladoAereo vueloVuelta= new TrasladoAereo(numVueloVuelta, companiaVuelta, diaVuelta); 
		String origen= ciudadOrigen;
		String destino= ciudadDestino;
		Viaje nuevoViaje= new Viaje (origen, destino, vueloIda, vueloVuelta, descripcion);
		misViajes.add(nuevoViaje);
	}
        
        /**
         * 
         * @param viaje
         * @return Mapa, si return Null controlar error.
         */
        
        public Mapa crearMapa(Viaje viaje) 
        {
      
            if(this.existeViaje(viaje))
            {
                Mapa m = viaje.crearMapaViaje();
                return m;
            }
          
           return null; 
            
        }
        
         /**
         * 
         * @param viaje
         * @return Mapa, si return Null controlar error.
         */
        
        public MapaPremium crearMapaPremium(Viaje viaje)
        {
            if(premium)
            {
                if(this.existeViaje(viaje))
                {
                    MapaPremium m = viaje.crearMapaPremium();
                    return m;
                }
            }
           
            return null;
        }
        
      
        
        private boolean existeViaje(Viaje viaje)
        {
            int i = 0;
            
            while(i < misViajes.size())
            {
                if(viaje.equals(misViajes.get(i)))
                {
                    return true;
                }
            }
            
            return false;
        }
	
	public String toString() {
		String retorno = "Nombre: "+this.nombre+"\nApellido: "+this.apellido+"\nMail: "+this.mail+"\nPais: "+this.pais+
				"\nFecha Nacimiento: "+this.nacimiento.get(Calendar.DAY_OF_MONTH)+"/"+this.nacimiento.get(Calendar.MONTH)+"/"+this.nacimiento.get(Calendar.YEAR);
		return retorno;
	}
	
} //Cierre de clase
