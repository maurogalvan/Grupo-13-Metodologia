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

import Defect.*;

public class Test {

	public static void main(String[] args) {
		Calendar nacimiento = Calendar.getInstance();
		nacimiento.set(1998, 9, 28);
		
		//Creo un usuario
		Usuario user1 = new Usuario("Mauro", "Galvan" , "maurogalvanbalca@gmail.com", "Argentina" ,nacimiento, true);
		
		//Muestro los datos del usuario
		System.out.println("Datos del usuario: \n");
		System.out.println(user1.toString());
		
		System.out.println("\n---------------------------------------------------------------");
		
		/*
		 * Esta bloque de codico comentado es para probar cargarDatosViajes pero como seteamos en forma manual los datos de flightStats entra en conflicto
		 * 
		//Genero fechas de inicio del viaje y fin del viaje
		Calendar fechaInicio = Calendar.getInstance();
		Calendar fechaRegreso = Calendar.getInstance();
		fechaInicio.set(2020, 7, 20, 9, 30);
		fechaRegreso.set(2020, 8, 15, 3, 10);
		//formato: fechaRegreso.set(año,mes,fecha,hora,minutos)
		
		//Cargo loss datos de un viaje
		user1.cargarDatosViaje(fechaInicio, fechaRegreso, "Latam", "Aerolineas Argentinas", "221AG", "987OP", "Buenos aires", "Barcelona","viaje de vacaciones");
		
		*/
		
		Calendar fechaInicio1 = Calendar.getInstance();
		Calendar fechaRegreso1 = Calendar.getInstance();
		fechaInicio1.set(2020, 2, 11, 8, 45);
		fechaRegreso1.set(2020, 3, 11, 9, 50);
		
		//Genero los vuelos de ida y vuelta del viaje
		TrasladoAereo vueloIda = new TrasladoAereo("221", "Latam", fechaInicio1);
		TrasladoAereo vueloVuelta = new TrasladoAereo("987", "Aerolinea Argentina", fechaRegreso1);
		
		//Plan Excursion 
		Calendar fechaInicioPB = Calendar.getInstance();
		fechaInicioPB.set(2019, 2, 18, 8, 45);
		PlanBasico planBasico = new PlanBasico(fechaInicioPB, "Excursion", "Zoologico Matrute");
		
		//Plan hotel
		Calendar checkIn = Calendar.getInstance();
		Calendar checkOut = Calendar.getInstance();
		checkOut.set(2020, 3, 11);
		checkIn.set(2020, 2, 11);
		PlanHotel planHotel = new PlanHotel("23", checkOut, checkIn, "Hotel", "av.centanario 334");
		
		//Traslado colectivo
		Calendar salida = Calendar.getInstance();
		Calendar llegada = Calendar.getInstance();
		salida.set(2020, 2, 13,11,20);
		llegada.set(2020, 2, 13,12,20);
		Traslado colectivo = new Traslado(llegada, "tacvi", "12", 1, salida,"Colectivo","Terminal centro");
		
		//Traslado tren
		Calendar salidaTren = Calendar.getInstance();
		Calendar llegadaTren = Calendar.getInstance();
		salida.set(2020, 2, 17,11,20);
		llegada.set(2020, 2, 17,12,20);
		Traslado Tren = new Traslado(llegadaTren, "Tren Bala", "40", 2, salidaTren,"Tren","Terminal tranvia centro");
		
		//Creo un viaje
		Viaje viaje1 = new Viaje("Argentina", "China", vueloIda, vueloVuelta, "Viaje para conocer China");
		//Agrego todos los planes
		viaje1.addPlan(planBasico);
		viaje1.addPlan(planHotel);
		viaje1.addPlan(colectivo);
		viaje1.addPlan(Tren);
		//Agrego a la lista de mis viajes
		user1.addMisViajes(viaje1);
		
		
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
	}
}
