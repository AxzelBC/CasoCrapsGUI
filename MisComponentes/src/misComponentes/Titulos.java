package misComponentes;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class Titulos extends JLabel {
	//Atributos
	
	//Metodos
	public Titulos(String texto, int tamano, Color colorfondo) {
		this.setText(texto);
		Font font = new Font(Font.SANS_SERIF, Font.ITALIC+Font.BOLD,tamano);
		this.setFont(font);
		this.setBackground(colorfondo);
		this.setForeground(Color.white);
		this.setHorizontalAlignment(JLabel.CENTER);
		this.setOpaque(true);
	}
}
