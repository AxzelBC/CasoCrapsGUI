package craps;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

// TODO: Auto-generated Javadoc
/**
 * The Class VistaGUICraps.
 * Se encarga de hacer intercambios de entrada/salida visual para el usuario.
 */
public class VistaGUICraps extends JFrame {
	
	/** The dado 2. */
	//Atributos
	private JLabel dado1, dado2;
	
	/** The lanzar. */
	private JButton lanzar;
	
	/** The imagen. */
	private ImageIcon imagen;
	
	/** The escucha. */
	private Escucha escucha;
	
	/** The control. */
	private ControlCraps control;
	
	//Metodos
	/**
	 * Instantiates a new vista GUI craps.
	 * Constructor de la clase inicializa los objetos, escucha, imagenes y la GUI.
	 */
	public VistaGUICraps() {
		//Window tiene un container y un layout.
		Container contenedor= this.getContentPane();
		contenedor.setLayout(new FlowLayout());
		
		//Crear objeto escucha
		escucha = new Escucha();
		control = new ControlCraps();
		
		//agregar los componentes gráficos
		imagen = new ImageIcon ("src/imagenes/dado.png");
		dado1 = new JLabel(imagen);
		dado2 = new JLabel(imagen);
		lanzar = new JButton("Lanzar");
		lanzar.addActionListener(escucha);
		
		//Agregar componentes al container
		contenedor.add(dado1);
		contenedor.add(dado2);
		contenedor.add(lanzar);
		
		//Titulo de la ventana
		this.setTitle("Juego Craps");
		//Tamaño de ventana	
		this.setSize(370, 200);
		//Parte de la pantalla donde se ejecuta
		this.setLocationRelativeTo(null);
		//Cambio de tamaño por el usuario
		this.setResizable(false);
		//Boton de cerrar
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Visibilidad de la ventana
		this.setVisible(true);
	}

	/**
	 * The Class Escucha.
	 * Se implementan los metodos de la clase ActionListener para usar escuchas.
	 */
	//Inner class
	private class Escucha implements ActionListener{

		/**
		 * Action performed.
		 *
		 * @param event the event
		 * Escucha del boton "lanzar" que permite detectar el evento de presionarle. 
		 */
		@Override
		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == lanzar) {
				visualizarCaras();
				control.determinarJuego();
				String tiro = "El tiro fue "+control.getTiro()+".\n ";
				Icon icon;
				
				switch(control.getEstado()) {
					case 1:
						icon = new ImageIcon ("src/Imagenes/ganaste.png");
						JOptionPane.showMessageDialog(lanzar, tiro + "\n¡Ganaste!", "Resultado", JOptionPane.DEFAULT_OPTION, icon);
						break;
					case 2:
						icon = new ImageIcon ("src/Imagenes/perdiste.png");
						JOptionPane.showMessageDialog(lanzar, tiro + "\n¡Perdiste!", "Resultado", JOptionPane.DEFAULT_OPTION, icon);
						break;
					case 3:
						String punto = "Has establecido un punto en: "+control.getPunto()+
									   ".\n Debes volver a sacar el valor del puntop para ganar, "+
									   "pero si obtienes 7 antes perderas.";
						icon = new ImageIcon ("src/Imagenes/punto.png");
						JOptionPane.showMessageDialog(lanzar, tiro+" - " +punto, "Resultado", JOptionPane.DEFAULT_OPTION, icon);
						break;
				}
			}
		}

		/**
		 * Visualizar caras.
		 * Permite al usuario ver las caras de los dados en imagen. 
		 */
		private void visualizarCaras() {
			control.calcularTiro();
			imagen = new ImageIcon("src/Imagenes/"+control.getCaraDado1()+".png");
			dado1.setIcon(imagen);
			imagen = new ImageIcon("src/Imagenes/"+control.getCaraDado2()+".png");
			dado2.setIcon(imagen);
		}
	}
}