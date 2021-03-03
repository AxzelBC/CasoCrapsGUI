/*
 * Programación Interactiva
 * Autor: Alejandro Cardona Mosquera - 2022499
 * Caso 1: Juego Craps
 * Fecha: 19 de febrero de 2021 
 */

package craps;

// TODO: Auto-generated Javadoc
/**
 * The Class ControlCraps. Valor del tiro, estado del juego, valor del punto, lanzamiento, caras del dado, etc.
 */
public class ControlCraps {

	/** The dado 2. */
	private Dado  dado1, dado2;
	
	/** The estado. */
	private int tiro, punto, estado;
	
	/** The lanzamiento. */
	private int lanzamiento;
	
	/** The caras dados. */
	//Ejemplo de sintaxis de un arreglo
	private int[] carasDados;
	
	/**
	 * Instantiates a new control craps.
	 * Constructor que carga los objetos a usar
	 */
	public ControlCraps() {
		dado1 = new Dado();
		dado2 = new Dado();
		lanzamiento = 0; //Ronda de tiro
		carasDados = new int[2];
	}
	
	/**
	 * Calcular tiro.
	 * Simula el lazamiento de los dados y saca el valor del tiro inicial
	 */
	public void calcularTiro() {
		carasDados[0] = dado1.getCaraVisible();
		carasDados[1] = dado2.getCaraVisible();
		tiro = carasDados[0]+carasDados[1];
		//Otra forma -> tiro = dado1.getCaraVisible() + dado2.getCaraVisible();
	}
	
	/**
	 * Determinar juego.
	 * Determina el estado del juego: 1 = ganar, 2 = perder, 3 = punto
	 */
	public void determinarJuego() {
		if(lanzamiento==0) {
			//Ronda de tiro
			if(tiro==7 || tiro == 11) {
				estado = 1; // Ganó
			}
			else if(tiro==2 || tiro==3 || tiro==12) {
				estado = 2; // Perdió
			}
			else {
				estado = 3; // Ronda de punto
				punto = tiro;
				lanzamiento = 1;
			}
		}
		else {
			rondaPunto();
		}
	}
	
	/**
	 * Ronda punto.
	 * Establece el estado del juego cuando se está en la ronda punto
	 */
	//Definición de metodo privado, se usan cuando un metodo no será llamado por una clase externa
	private void rondaPunto() {
		if(tiro==punto) {
			estado = 1; // Ganó
			lanzamiento = 0;
		}
		if(tiro==7) {
			estado = 2; //Perdió
			lanzamiento = 0;
		}
	}

	/**
	 * Sets the abandono.
	 * Establece el esatado del juego si el usuario abandona en la ronda punto
	 */
	public void setAbandono() {
		estado = 2;
		lanzamiento = 0;
	}
	
	/**
	 * Gets the tiro.
	 *
	 * @return the tiro
	 */
	public int getTiro() {
		return tiro;
	}

	/**
	 * Gets the punto.
	 *
	 * @return the punto
	 */
	public int getPunto() {
		return punto;
	}

	/**
	 * Gets the estado.
	 *
	 * @return the estado
	 */
	public int getEstado() {
		return estado;
	}

	/**
	 * Gets the caras dados.
	 *
	 * @return the caras dados
	 */
	public int[] getCarasDados() {
		return carasDados;
	}
	
	/**
	 * Gets the cara dado 1.
	 *
	 * @return the cara dado 1
	 */
	public int getCaraDado1() {
		return carasDados[0];
	}
	
	/**
	 * Gets the cara dado 2.
	 *
	 * @return the cara dado 2
	 */
	public int getCaraDado2() {
		return carasDados[1];
	}
	
}