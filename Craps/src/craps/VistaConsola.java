/*
 * Programación Interactiva
 * Autor: Alejandro Cardona Mosquera - 2022499
 * Caso 1: Juego Craps
 * Fecha: 19 de febrero de 2021 
 */

package craps;

//Para leer datos del teclado (también impresora, bases de datos, etc).
import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * The Class VistaConsola.
 * Encargada de hacer las operaciones de entrada/salida por lineas de comando, usando Scanner
 */
public class VistaConsola {
	
	/** The control craps. */
	private ControlCraps controlCraps;
	
	/** The pregunta. */
	private String pregunta;
	
	/** The lectura datos. */
	//Para lectura de datos
	private Scanner lecturaDatos;
	
	/**
	 * Instantiates a new vista consola.
	 * Constructor de la clase, inicia los objetos auxiliares (controlCraps y Scanner)
	 */
	public VistaConsola() {
		controlCraps = new ControlCraps();
		//System.in, es una clase que se encarga de leer lo que hay en consola.
		lecturaDatos = new Scanner(System.in);
	}
	
	/**
	 * Iniciar juego.
	 * Inicia el juego
	 */
	public void iniciarJuego( ) {
		//Enviar datos a consola (imprime), el "ln" genera un salto de línea automatico.
		System.out.println("¿Desea lanzar los datos? (Escribe y/n)");
		//Capturar los datos
		//nextLine, lee lo que se escribe como string
		pregunta = lecturaDatos.nextLine();
		
		// equalsIgnoreCase("y"), se usa para comparar strings ignorando las mayúsculas
		if(pregunta.equalsIgnoreCase("y")) {
			//Inicia juego
			controlCraps.calcularTiro();
			//Sirve para imorimir con formato
			//"%d" se cuencia de datos de salida, int en este caso
			System.out.printf("Dado 1 = %d Dado 2 = %d Tiro = %d \n",controlCraps.getCaraDado1(),
																	 controlCraps.getCaraDado2(),
																	 controlCraps.getTiro());
			controlCraps.determinarJuego();
			
			switch(controlCraps.getEstado()) {
				case 1: System.out.println("¡Has Ganado!");
						break;
				case 2: System.out.println("¡Has Perdido!");
						break;
				case 3: System.out.printf("¡Has establecido punto = %d, debes lanzar otra vez!",controlCraps.getPunto());
						while(controlCraps.getEstado()==3) {
							System.out.println("¿Deseas lanzar de nuevo? (Escribe y/n)");
							pregunta = lecturaDatos.nextLine();
							
							if(pregunta.equalsIgnoreCase("y")) {
								controlCraps.calcularTiro();
								System.out.printf("Dado 1 = %d Dado 2 = %d Tiro = %d \n",controlCraps.getCaraDado1(),
																						 controlCraps.getCaraDado2(),
																						 controlCraps.getTiro());
								controlCraps.determinarJuego();
							}
							else {
								System.out.println("Perdiste por abandono.");
								controlCraps.setAbandono();
							}
						}
						if(controlCraps.getEstado()==1) {
							System.out.println("¡Logras el punto y ganaste!");
						}
						else {
							System.out.println("¡Perdiste!");
						}
						break;
			}
			seguirJuego();
		}
		else {
			System.out.println("¡Bye!");
		}
	}
	
	/**
	 * Seguir juego.
	 * Inicia una nueva ronda de juedo; permite al juegador seguir jugando rondas
	 */
	private void seguirJuego() {
		System.out.println("¿Quieres volver a jugar otra ronda? (Escribe y/n)");
		pregunta = lecturaDatos.nextLine();
		if(pregunta.equalsIgnoreCase("y")) {
			iniciarJuego();
		}
		else {
			System.out.println("¡Bye!");
		}
	}
	
}