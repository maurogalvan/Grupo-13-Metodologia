package Tests;

import java.util.ArrayList;
import java.util.Calendar;

import Defect.*;

public class Test {

	public static void main(String[] args) {
		Calendar nacimiento = Calendar.getInstance();
		nacimiento.set(1998, 9, 28);
		
		//Creo un usuario
		Usuario user1 = new Usuario("Mauro", "Galvan" , "maurogalvanbalca@gmail.com", "Argentina" ,nacimiento, true);
		
		//Muestro los datos del usuario
		System.out.println("Datos del usuario: ");
		System.out.println(user1.toString()); //Podria cambiarle el nombre a mostrarDatosUsuario
		
		//Genero fechas de inicio del viaje y fin del viaje
		Calendar fechaInicio = Calendar.getInstance();
		Calendar fechaRegreso = Calendar.getInstance();
		fechaInicio.set(2020, 7, 20, 21, 30);
		fechaRegreso.set(2020, 8, 15, 15, 00);
		//formato: fechaRegreso.set(año,mes,fecha,hora,minutos)
		
		//Cargo loss datos de un viaje
		user1.cargarDatosViaje(fechaInicio, fechaRegreso, "Latam", "Aerolineas Argentinas", "221AG", "987OP", "Buenos aires", "Barcelona");
		
		//Genero los vuelos de ida y vuelta
		TrasladoAereo vueloIda = new TrasladoAereo("221", "Latam", fechaInicio);
		TrasladoAereo vueloVuelta = new TrasladoAereo("987", "Aerolinea Argentina", fechaRegreso);
		
		//Creo un viaje
		Viaje viaje1 = new Viaje("Argentina", "Mexico", vueloIda, vueloVuelta);
		//Agrego a la lista de mis viajes
		user1.addMisViajes(viaje1);
		
		
		ArrayList<Viaje> misViajes = user1.getMisViajes();
		
		//Muestro la lista de mis viajes
		System.out.println("\nMis viajes: ");
		for (int i=0 ; i < misViajes.size();i++) {
			System.out.println("\nViaje: "+i+"\n");
			System.out.println(misViajes.get(i).toString());
		}
		
		
	}

}
