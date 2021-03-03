package craps;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import misComponentes.Titulos;

// TODO: Auto-generated Javadoc
/**
 * The Class VistaGUIGridBagLayout.
 */
public class VistaGUIGridBagLayout extends JFrame {
	
	/** The zona resultados. */
	//Atributos
	private JPanel zonaJuego, zonaResultados;
	
	/** The punto. */
	private JLabel dado1, dado2, tiro, punto;
	
	/** The valor punto. */
	private JTextField valorTiro, valorPunto;
	
	/** The lanzar. */
	private JButton salir, lanzar;
	
	/** The imagen. */
	private ImageIcon imagen;
	
	/** The mensajes. */
	private JTextArea mensajes;
	
	/** The control. */
	private ControlCraps control;
	
	/** The escucha. */
	private Escucha escucha;
	
	/** The resultados. */
	private Titulos titulo, resultados;
	
	/** The vista grid bag layout. */
	private JFrame vistaGridBagLayout;
	
	/**
	 * Instantiates a new vista GUI grid bag layout.
	 */
	//Metodos
	public VistaGUIGridBagLayout() {
		initGUI();
		
		//Set default window configuration
		//this.setTitle("Juego Craps");
		this.setUndecorated(true);
		this.pack();
		this.setBackground(new Color(255,255,255,100));
		//this.setSize(320, 180);
		this.setLocation(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * Inits the GUI.
	 */
	private void initGUI() {
		//Set up container - layout
		this.getContentPane().setLayout(new GridBagLayout());
		GridBagConstraints contraints = new GridBagConstraints();
		
		//Create objets Escucha, control, and others.
		escucha = new Escucha();
		control = new ControlCraps();
		vistaGridBagLayout=this;
		
		//Set up GUIComponents
		titulo = new Titulos("Juego Craps",30,new Color(0,0,0));
		titulo.addMouseListener(escucha);
		titulo.addMouseMotionListener(escucha);
		titulo.setCursor(new Cursor(Cursor.MOVE_CURSOR));
		contraints.gridx=0;
		contraints.gridy=0;
		contraints.gridwidth=2;
		contraints.gridheight=0;
		contraints.fill=GridBagConstraints.HORIZONTAL;
		add(titulo,contraints);
		
		//zonaJuego
		zonaJuego = new JPanel();//Panel
		//Componentes gráficos del panel
		imagen = new ImageIcon("src/imagenes/dado.png");
		dado1 = new JLabel(imagen);
		dado2 = new JLabel(imagen);
		lanzar = new JButton("Lanzar");
		lanzar.addActionListener(escucha);
		//Adición de componentes al panel
		zonaJuego.add(dado1);
		zonaJuego.add(dado2);
		zonaJuego.add(lanzar);
		zonaJuego.setPreferredSize(new Dimension(310,180));
		zonaJuego.setBorder(new TitledBorder("Zona Juego"));
		contraints.gridx=0;
		contraints.gridy=1;
		contraints.gridwidth=1;
		contraints.gridheight=2;
		contraints.fill=GridBagConstraints.NONE;
		add(zonaJuego,contraints);
		
		//Salir
		salir = new JButton("Salir");
		salir.addActionListener(escucha);
		salir.setCursor(new Cursor(Cursor.HAND_CURSOR));
		salir.add(salir);
		contraints.gridx=0;
		contraints.gridy=4;
		contraints.gridwidth=1;
		contraints.gridheight=1;
		contraints.fill=GridBagConstraints.NONE;
		contraints.anchor=GridBagConstraints.LAST_LINE_END;
		add(salir,contraints);
		
		//Titulo resultados
		resultados = new Titulos("Resultados", 24, new Color(255,20,155));
		contraints.gridx=1;
		contraints.gridy=1;
		contraints.gridwidth=1;
		contraints.gridheight=1;
		contraints.fill=GridBagConstraints.HORIZONTAL;
		contraints.anchor=GridBagConstraints.CENTER;
		add(resultados,contraints);
		
		//zonaResultados
		zonaResultados = new JPanel();//Panel
		//Componentes gráficos del panel
		zonaResultados.setLayout(new GridLayout(2,2));
		tiro = new JLabel("Tiro");
		punto = new JLabel("Punto");
		valorTiro = new JTextField(2);
		valorTiro.setEditable(false);
		valorPunto = new JTextField(2);
		valorPunto.setEditable(false);
		//Adición de componentes al panel
		zonaResultados.add(tiro);
		zonaResultados.add(valorTiro);
		zonaResultados.add(punto);
		zonaResultados.add(valorPunto);
		zonaResultados.setBackground(Color.WHITE);
		contraints.gridx=1;
		contraints.gridy=2;
		contraints.gridwidth=1;
		contraints.gridheight=1;
		contraints.fill=GridBagConstraints.NONE;
		contraints.anchor=GridBagConstraints.CENTER;
		add(zonaResultados,contraints);
		
		mensajes = new JTextArea(10,20);
		mensajes.setText("Lanza los dados para iniciar el juego. \n");
		mensajes.setEditable(false);
		JScrollPane scroll = new JScrollPane(mensajes);
		contraints.gridx=1;
		contraints.gridy=3;
		contraints.gridwidth=1;
		contraints.gridheight=2;
		contraints.anchor=GridBagConstraints.CENTER;
		contraints.fill=GridBagConstraints.VERTICAL ;
		add(scroll,contraints);
	}
	
	/**
	 * The Class Escucha.
	 */
	private class Escucha implements ActionListener, MouseListener, MouseMotionListener{

		/** The y. */
		private int x,y;
		
		/**
		 * Action performed.
		 *
		 * @param eventAction the event action
		 */
		@Override
		public void actionPerformed(ActionEvent eventAction) {
			if(eventAction.getSource() == salir) {
				//EXIT_ON_CLOSE == 0
				System.exit(EXIT_ON_CLOSE);
			}
			else if(eventAction.getSource() == lanzar) {
				control.calcularTiro();
				imagen = new ImageIcon("src/Imagenes/"+control.getCaraDado1()+".png");
				dado1.setIcon(imagen);
				imagen = new ImageIcon("src/Imagenes/"+control.getCaraDado2()+".png");
				dado2.setIcon(imagen);
				
				control.determinarJuego();
				valorTiro.setText(String.valueOf(control.getTiro()));
				
				switch(control.getEstado()) {
					case 1://Ganó		
						mensajes.append("¡Has Ganado!\n");
						break;
					case 2://Perdió
						mensajes.append("¡Has Ganado!\n");
						break;
					case 3://Punto
						valorPunto.setText(String.valueOf(control.getPunto()));
						String mensaje = "Has establecido un punto en: "+control.getPunto()+
									   ".\nDebes volver a sacar el valor del puntop para ganar.\n"+
									   "Pero si obtienes 7 antes perderas.\n";
						mensajes.append(mensaje);
						break;
				}
			}
		}

		/**
		 * Mouse clicked.
		 *
		 * @param eventMouse the event mouse
		 */
		@Override
		public void mouseClicked(MouseEvent eventMouse) {
			//zonaResultados.setBackground(Color.CYAN);
		}

		/**
		 * Mouse entered.
		 *
		 * @param eventMouse the event mouse
		 */
		@Override
		public void mouseEntered(MouseEvent eventMouse) {
			//salir.setBackground(Color.BLUE);
			
		}

		/**
		 * Mouse exited.
		 *
		 * @param eventMouse the event mouse
		 */
		@Override
		public void mouseExited(MouseEvent eventMouse) {
			//salir.setBackground(Color.GREEN);
			
		}

		/**
		 * Mouse pressed.
		 *
		 * @param eventMouse the event mouse
		 */
		@Override
		public void mousePressed(MouseEvent eventMouse) {
			//lanzar.setBackground(Color.RED);
			x = eventMouse.getX();
			y = eventMouse.getY();
		}

		/**
		 * Mouse released.
		 *
		 * @param eventMouse the event mouse
		 */
		@Override
		public void mouseReleased(MouseEvent eventMouse) {
			//salir.setBackground(Color.ORANGE);
		}

		/**
		 * Mouse dragged.
		 *
		 * @param eventMouseMotion the event mouse motion
		 */
		@Override
		public void mouseDragged(MouseEvent eventMouseMotion) {
			//System.out.println("Mouse Motion Dragged"+eventMouseMotion.getX());
			setLocation(vistaGridBagLayout.getLocation().x+eventMouseMotion.getX()-x,
						vistaGridBagLayout.getLocation().y+eventMouseMotion.getY()-y);
		}

		/**
		 * Mouse moved.
		 *
		 * @param eventMouseMotion the event mouse motion
		 */
		@Override
		public void mouseMoved(MouseEvent eventMouseMotion) {
			//System.out.println("Mouse Motion Moved"+eventMouseMotion.getX());
			
		}
		
	}
}
