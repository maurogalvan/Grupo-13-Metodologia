package Tests;

/**
 * Esta clase hace test de todos los servicios del paquete de Program
 * @author Mauro Galvan
 * @version 2.0
 *
 */

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;

import Program.*;

public class Test {

	public static void main(String[] args) {
		Calendar nacimiento = Calendar.getInstance();
		nacimiento.set(1998, 9, 28);
		
		//Creo un usuario
		boolean userPremium = true;
		boolean uNotificaciones = true;
		Usuario user1 = new Usuario("Mauro", "Galvan" , "maurogalvanbalca@gmail.com", "Argentina" ,nacimiento, userPremium, uNotificaciones);
		
		//Muestro los datos del usuario
		System.out.println("Datos del usuario: \n");
		System.out.println(user1.toString());
		if (user1.isPremium()) System.out.println("El usuario es Premium.");
		else System.out.println("El usuario no es Premium.");
		if (user1.isNotificacion()) System.out.println("El usuario tiene las notificaciones ACTIVADAS.");
		else System.out.println("El usuario tiene las notificaciones DESACTIVADAS.");
		
		System.out.println("\n---------------------------------------------------------------");
		
		
		Calendar fechaInicio1 = Calendar.getInstance();
		Calendar fechaRegreso1 = Calendar.getInstance();
		fechaInicio1.set(2020, 2, 11, 8, 45);
		fechaRegreso1.set(2020, 3, 11, 9, 50);
		
		//Aeropuerto de salida
		Coordenada coordenadaEzeiza = new Coordenada ((float)233.445,(float)889.08);
		Aeropuerto aeropuertoEzeiza = new Aeropuerto("Aeropuerto Ezeiza", coordenadaEzeiza);
		
		
		//Informacion del aerpuerto de si estan abierto o no los mostradores. Esto deberia darme la API del aeropuerto
		aeropuertoEzeiza.setMostradores(true);
		aeropuertoEzeiza.addInfoVuelo("221", "nro 5");
		
		//Aeropuerto de llegada
		Coordenada coordenadaBarcelona = new Coordenada ((float)1333.445,(float)4889.08);
		Aeropuerto aeropuertoBarcelona = new Aeropuerto ("Barcelona airport", coordenadaBarcelona);
		
		
		//Informacion del aerpuerto de si estan abierto o no los mostradores.
		aeropuertoBarcelona.setMostradores(false);
		aeropuertoBarcelona.addInfoVuelo("987", "nro 2");
		
		//Genero los vuelos de ida y vuelta del viaje
		TrasladoAereo vueloIda = new TrasladoAereo("221", "Latam", fechaInicio1,user1, aeropuertoEzeiza, aeropuertoBarcelona);
		TrasladoAereo vueloVuelta = new TrasladoAereo("987", "Aerolinea Argentina", fechaRegreso1,user1,aeropuertoBarcelona,aeropuertoEzeiza);
		
	
		
		vueloIda.notificarMostradores();
		vueloIda.notificarCinta();
		vueloVuelta.notificarMostradores();
		vueloVuelta.notificarCinta();
		
		
		//Plan Excursion 
		Calendar fechaInicioPB = Calendar.getInstance();
		fechaInicioPB.set(2019, 2, 18, 8, 45);
		Coordenada coordenadaPlan = new Coordenada(11.321,22.432);
		PlanBasico planBasico = new PlanBasico(fechaInicioPB, "Excursion", coordenadaPlan);
		
		//Plan hotel
		Calendar checkIn = Calendar.getInstance();
		Calendar checkOut = Calendar.getInstance();
		checkOut.set(2020, 3, 11);
		checkIn.set(2020, 2, 11);
		Coordenada coordenadaHotel = new Coordenada(21.321,32.432); //Se deberia seleccionar desde un mapa
		PlanHotel planHotel = new PlanHotel("23", checkOut, checkIn, "Hotel",coordenadaHotel);
		
		//Traslado colectivo
		Calendar salida = Calendar.getInstance();
		Calendar llegada = Calendar.getInstance();
		salida.set(2020, 2, 13,11,20);
		llegada.set(2020, 2, 13,12,20);
		Coordenada coordenadaColectivo = new Coordenada(31.321,42.432);
		Traslado colectivo = new Traslado(llegada, "tacvi", "12", 1, salida,"Colectivo",coordenadaColectivo);
		
		//Traslado tren
		Calendar salidaTren = Calendar.getInstance();
		Calendar llegadaTren = Calendar.getInstance();
		salidaTren.set(2020, 2, 17,11,20);
		llegadaTren.set(2020, 7, 01,12,20);
		Coordenada coordenadaTren = new Coordenada(41.321,52.432); //Se deberia seleccionar desde un mapa
		Traslado Tren = new Traslado(llegadaTren, "CSR Corporation", "40", 2, salidaTren,"Tren",coordenadaTren);
		
		//Creo un viaje
		Viaje viaje1 = new Viaje("Argentina", "Barcelona", vueloIda, vueloVuelta, "Viaje para conocer Barcelona");
		//Agrego todos los planes
		viaje1.addPlan(planBasico);
		viaje1.addPlan(planHotel);
		viaje1.addPlan(colectivo);
		viaje1.addPlan(Tren);
		//Agrego a la lista de mis viajes
		user1.addMisViajes(viaje1);
		
		
		//Simulacion que un usuario carga un plan basico.
		Coordenada ubicacionCntro = new Coordenada ( 432.5, 234.3);
		Calendar fechaPlan = Calendar.getInstance();
		fechaPlan.set(2020, 2,22);
		//La fecha plan debe ser entre medio de una fecha de un viaje, ya que no podes hacer dos viajes al mismo tiempo.
		user1.cargarPlanBasico(fechaPlan, "Colectivo centrico", ubicacionCntro);
		
		//Simulacion que un usuario carga un plan Hotel.
		Coordenada ubicacionHotel = new Coordenada (32.5, 2134.3);
		Calendar fechaHotelSalida = Calendar.getInstance();
		fechaHotelSalida.set(2020, 3,10);
		user1.cargarPlanHotel(fechaPlan, "Hotel Centro", ubicacionHotel, "16", fechaHotelSalida);
		
		//Simulacion que un usuario carga un plan Hotel via emai, hay muchos datos simulados, ya que depende de terceros.
		user1.cargarPlanHoteleMail(fechaPlan);
		
		
		
		
		
		//Muestro la lista de mis viajes y sus planes
		ArrayList<Viaje> misViajes = user1.getMisViajes();
		
		System.out.println("\n** Mis viajes: ");
		for (int i=0 ; i < misViajes.size();i++) {
			System.out.println("\n*** Viaje numero: "+i+"\n");
			System.out.println(misViajes.get(i).toString());
			Vector<PlanBasico> plan= misViajes.get(i).getPlanes();
			if (!plan.isEmpty()) {
				System.out.println("------------------------------");
				System.out.println("\nPlanes del viaje numero: "+i);
				System.out.println("------------------------------");
				for (int j=0 ; j < plan.size();j++) {
					System.out.println("\nPlan: "+j+"\n");
					System.out.println(plan.get(j).toString());
				}
			}
			
		}
		System.out.println("\n---------------------------------------------------------------");
		ArrayList<String> notificaciones = user1.getNotificaciones();
		System.out.print("\nNotificaciones: "+"\n");
		if(user1.isNotificacion()) {
			for (int i=0; i<notificaciones.size();i++) {
				System.out.println("\n"+i+": "+notificaciones.get(i)+"\n");
			}
		}
		else {
			System.out.print("El usuario no quiere recibir notificaciones.");
		}
		System.out.println("\n---------------------------------------------------------------");
		System.out.println("\nMapa de viaje: \n");
		user1.crearMapa(viaje1).mostrarMapa();
	
		
		System.out.println("\n---------------------------------------------------------------");
		
		//Simulacion posicion actual.
		Coordenada posicionActual = new Coordenada(31.321,42.432);
		if (user1.isPremium()) {
			//Da cero por que le doy como posicion actual exactamente la misma posicion de colectivo.
			System.out.println("\nDistancia desde: ");
			System.out.println ("   Posicion actual: "+posicionActual.toString()+
					"\n   Distancia a Colectivo: "+user1.crearMapaPremium(viaje1).calcularDistancia(posicionActual, "Colectivo"));
		}
		else {
			System.out.println("\nEl usuario no es premium, no puede calcular la distancia.");
		}
		
	}
}
