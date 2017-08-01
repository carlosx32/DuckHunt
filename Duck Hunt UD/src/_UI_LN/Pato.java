package _UI_LN;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

//CLASE QUE USA POLIMORFISMO PARA SELECCIONAR EL TIPO DE PATO QUE APARECE EN LA CLASE JUEGO
public class Pato {
	private JLabel pato1;

	public Pato(JLabel pato12) {
		// ESTA CLASE SELECCIONA EL PATO NEGRO COMO INICIAL
		this.pato1 = pato12;
		pato1 = new JLabel("");
		pato1.addComponentListener(new ComponentAdapter() {
			public void componentMoved(ComponentEvent arg0) {
				pato1.setIcon(new ImageIcon(Juego.class
						.getResource("/imagenes/pato negro.gif")));
			}
		});
		pato1.setVisible(false);
	}

	// polimorfismo con el metodo color jaja :v
	// CON ESTOS METODOS SE CAMBIA EL COLOR DE LOS PATOS
	public void color(int negro) {
		pato1.setVisible(true);
		pato1.setIcon(new ImageIcon(Juego.class
				.getResource("/imagenes/pato negro.gif")));
	}

	public void color(String amarillo) {
		pato1.setVisible(true);
		pato1.setIcon(new ImageIcon(Juego.class
				.getResource("/imagenes/pato amarillo.gif")));

	}

	public void color(double verde) {

		pato1.setVisible(true);
		pato1.setIcon(new ImageIcon(Juego.class
				.getResource("/imagenes/pato verde.gif")));

	}

}
