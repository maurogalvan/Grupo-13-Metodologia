package Tests;

/**
 * Esta clase hace test de todos los servicios del paquete Defect
 * @author Mauro Galvan
 * @version 1.0
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
		Usuario user1 = new Usuario("Mauro", "Galvan" , "maurogalvanbalca@gmail.com", "Argentina" ,nacimiento, true, true);
		
		//Muestro los datos del usuario
		System.out.println("Datos del usuario: \n");
		System.out.println(user1.toString());
		
		System.out.println("\n---------------------------------------------------------------");
		
		
		Calendar fechaInicio1 = Calendar.getInstance();
		Calendar fechaRegreso1 = Calendar.getInstance();
		fechaInicio1.set(2020, 2, 11, 8, 45);
		fechaRegreso1.set(2020, 3, 11, 9, 50);
		
		//Aeropuerto de salida
		Coordenada coordenadaEzeiza = new Coordenada ((float)233.445,(float)889.08);
		Aeropuerto aeropuertoEzeiza = new Aeropuerto("Aeropuerto Ezeiza", coordenadaEzeiza);
		
		
		//Informacion del aerpuerto de si estan abierto o no los mostradores.
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
		Coordenada coordenadaPlan = new Coordenada((float)11.321,(float)22.432);
		PlanBasico planBasico = new PlanBasico(fechaInicioPB, "Excursion", coordenadaPlan);
		
		//Plan hotel
		Calendar checkIn = Calendar.getInstance();
		Calendar checkOut = Calendar.getInstance();
		checkOut.set(2020, 3, 11);
		checkIn.set(2020, 2, 11);
		Coordenada coordenadaHotel = new Coordenada((float)21.321,(float)32.432);
		PlanHotel planHotel = new PlanHotel("23", checkOut, checkIn, "Hotel",coordenadaHotel);
		
		//Traslado colectivo
		Calendar salida = Calendar.getInstance();
		Calendar llegada = Calendar.getInstance();
		salida.set(2020, 2, 13,11,20);
		llegada.set(2020, 2, 13,12,20);
		Coordenada coordenadaColectivo = new Coordenada((float)31.321,(float)42.432);
		Traslado colectivo = new Traslado(llegada, "tacvi", "12", 1, salida,"Colectivo",coordenadaColectivo);
		
		//Traslado tren
		Calendar salidaTren = Calendar.getInstance();
		Calendar llegadaTren = Calendar.getInstance();
		salidaTren.set(2020, 2, 17,11,20);
		llegadaTren.set(2020, 7, 01,12,20);
		Coordenada coordenadaTren = new Coordenada((float)41.321,(float)52.432);
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
		
		
		
		Coordenada ubicacionCntro = new Coordenada ((float) 432.5,(float) 234.3);
		Calendar fechaPlan = Calendar.getInstance();
		fechaPlan.set(2020, 2,22);
		
		user1.cargarPlanBasico(fechaPlan, "Colectivo", ubicacionCntro);
		
		
		//Muestro la lista de mis viajes y sus planes
		ArrayList<Viaje> misViajes = user1.getMisViajes();
		
		System.out.println("\n** Mis viajes: ");
		for (int i=0 ; i < misViajes.size();i++) {
			System.out.println("\n*** Viaje numero: "+i+"\n");
			System.out.println(misViajes.get(i).toString());
			Vector<PlanBasico> plan= misViajes.get(i).getPlanes();
			if (!plan.isEmpty()) {
				System.out.println("\nPlanes del viaje numero: "+i);
				for (int j=0 ; j < plan.size();j++) {
					System.out.println("\nPlan: "+j+"\n");
					System.out.println(plan.get(j).toString());
				}
			}
			
		}
		ArrayList<String> notificaciones = user1.getNotificaciones();
		System.out.print("\nNotificaciones: "+"\n");
		
		for (int i=0; i<notificaciones.size();i++) {
			System.out.println("\n"+i+": "+notificaciones.get(i));
		}
		
	}
}
