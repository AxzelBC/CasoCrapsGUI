/*
 * Programación Interactiva
 * Autor: Alejandro Cardona Mosquera - 2022499
 * Caso 1: Juego Craps
 * Fecha: 19 de febrero de 2021 
 */

package craps;

import java.awt.EventQueue;

// TODO: Auto-generated Javadoc
/**
 * The Class PrincipalCrasp.
 * Contiene el metodo Main() e inicia el programa
 */
public class PrincipalCrasp {

	/**
	 * The main method.
	 *Metodo principal de Java
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*VistaConsola consola = new VistaConsola();
		consola.iniciarJuego();*/
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				VistaGUICraps miVentana = new VistaGUICraps();
			}
		});
	}

}
