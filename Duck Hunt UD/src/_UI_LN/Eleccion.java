package _UI_LN;

import java.applet.AudioClip;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Eleccion extends JFrame {
	// VENTANA DE ELECCION DEL USUARIO
	// AUDIO DEL JUEGO
	AudioClip sonido_D;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws Exception {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Eleccion frame = new Eleccion();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws JavaLayerException
	 */
	public Eleccion() {
		// DEFINIMOS SONIDO DE FONDO
		sonido_D = java.applet.Applet.newAudioClip(getClass().getResource(
				"/imagenes/Pantera.wav"));
		sonido_D.play();

		// CARACTERISTICAS DE LA VENTANA
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 791, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(0);
		this.setResizable(false);

		// BONTON QUE NOS REDIRECCIONO A LA VENTANA DE CREDITOS
		JButton Creditos = new JButton("");
		Creditos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Creditos das = new Creditos();
				das.setVisible(true);
				dispose();
			}
		});
		Creditos.setIcon(new ImageIcon(Eleccion.class
				.getResource("/imagenes/CREDITOS2.png")));
		Creditos.setSelectedIcon(new ImageIcon(Eleccion.class
				.getResource("/imagenes/CREDITOS2.png")));
		Creditos.setRolloverIcon(new ImageIcon(Eleccion.class
				.getResource("/imagenes/CREDITOS1.png")));
		Creditos.setContentAreaFilled(false);
		Creditos.setBorderPainted(false);
		Creditos.setBorder(null);
		Creditos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Creditos.setBounds(288, 157, 230, 46);
		contentPane.add(Creditos);

		// BOTON QUE NOS REDIRECCIONA A LA VENTANA DEL JUEGO PARANDO EL SONIDO
		JButton Jugar = new JButton("");
		Jugar.setIcon(new ImageIcon(Eleccion.class
				.getResource("/imagenes/JUGAR2.png")));
		Jugar.setRolloverIcon(new ImageIcon(Eleccion.class
				.getResource("/imagenes/JUGAR1.png")));
		Jugar.setPressedIcon(new ImageIcon(Eleccion.class
				.getResource("/imagenes/JUGAR2.png")));
		Jugar.setContentAreaFilled(false);
		Jugar.setBorderPainted(false);
		Jugar.setBorder(null);
		Jugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sonido_D.stop();
				Juego sed = new Juego();
				sed.setVisible(true);
				dispose();
			}
		});
		Jugar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Jugar.setBounds(288, 26, 230, 46);
		contentPane.add(Jugar);

		// BOTON QUE TERMINA EL PROGRAMA
		JButton Salir = new JButton("");
		Salir.setIcon(new ImageIcon(Eleccion.class
				.getResource("/imagenes/botonSalir.png")));
		Salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		Salir.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Salir.setBounds(10, 365, 151, 50);
		contentPane.add(Salir);

		// BOTON QUE NOS REDIRECCIONA A LA VENTANA DE PUNTAJES MAXIMOS
		JButton PuntajeMaximo = new JButton("");
		PuntajeMaximo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PuntajeMaximo des = new PuntajeMaximo();
				des.setVisible(true);
				dispose();
			}
		});
		PuntajeMaximo.setSelectedIcon(new ImageIcon(Eleccion.class
				.getResource("/imagenes/JUGAR2.png")));
		PuntajeMaximo.setRolloverIcon(new ImageIcon(Eleccion.class
				.getResource("/imagenes/PUNTAJE1.png")));
		PuntajeMaximo.setIcon(new ImageIcon(Eleccion.class
				.getResource("/imagenes/PUNTAJE2.png")));
		PuntajeMaximo.setContentAreaFilled(false);
		PuntajeMaximo.setBorderPainted(false);
		PuntajeMaximo.setBorder(null);
		PuntajeMaximo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PuntajeMaximo.setBounds(288, 92, 230, 46);
		contentPane.add(PuntajeMaximo);

		// JLABELS DE DECORACION
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Eleccion.class
				.getResource("/imagenes/patosss.gif")));
		label.setBounds(322, 214, 158, 176);
		contentPane.add(label);

		JLabel Fondo = new JLabel("");
		Fondo.setHorizontalAlignment(SwingConstants.CENTER);
		Fondo.setIcon(new ImageIcon(Eleccion.class
				.getResource("/imagenes/patosvolando.png")));
		Fondo.setBounds(-13, -11, 827, 455);
		contentPane.add(Fondo);
	}
}
