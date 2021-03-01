/*
 * Programación Interactiva
 * Autor: Alejandro Cardona Mosquera - 2022499
 * Caso 1: Juego Craps
 * Fecha: 19 de febrero de 2021 
 */

package craps;

/*
 *Importar una clase, en este caso Random. Si se poner * importa toda la libreria
 *lo cual es innesario. 
 */

import java.util.Random;

// TODO: Auto-generated Javadoc
/**
 * The Class Dado. Simulacipon de un dado y permite ver valor de su cara cisible
 */
public class Dado {
	
	/** The cara visible. Valor (1 - 6) sacado por el usuario*/
	private int caraVisible;

	/**
	 * Gets the cara visible. Determina el valor de la cara visible del dado.
	 *
	 * @return the cara visible valor entre 1 a 6.
	 */
	public int getCaraVisible() {
		Random aleatorio = new Random();
		caraVisible = aleatorio.nextInt(6) + 1;
		return caraVisible;
	}
}