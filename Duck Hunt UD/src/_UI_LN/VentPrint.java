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
import javax.swing.border.EmptyBorder;

/**
 * Duck Hunt UD
 * 
 * @Version 1.0
 * 
 * @author Norbey Danilo Muñoz Cañon
 * @author Carlos David Camacho Pance
 * @author Brayan Leonardo Sierra Forero
 * 
 *         Universidad Distrital Francisco Jose de Caldas Proyecto curricular de
 *         Ingenieria de Sistemas
 *
 */
@SuppressWarnings("serial")
public class VentPrint extends JFrame {
	// CLASE DE PRECENTACION DEL JUEGO
	AudioClip sonido;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentPrint frame = new VentPrint();
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
	 * @throws InterruptedException
	 */
	public VentPrint() throws InterruptedException {

		// SONIDO Y CARACTERISTICAS DE LA VENTANA
		sonido = java.applet.Applet.newAudioClip(getClass().getResource(
				"/imagenes/The game.wav"));
		sonido.play();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 742, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(0);
		this.setResizable(false);

		// BOTON QUE REDIRECCIONA A LA VENTANA DE INICIO
		JButton Continuar = new JButton("");
		Continuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sonido.stop();
				Eleccion ten = new Eleccion();
				ten.setVisible(true);
				dispose();
			}
		});
		Continuar.setRolloverIcon(new ImageIcon(VentPrint.class
				.getResource("/imagenes/cont.png")));
		Continuar.setPressedIcon(new ImageIcon(VentPrint.class
				.getResource("/imagenes/contm.png")));
		Continuar.setIcon(new ImageIcon(VentPrint.class
				.getResource("/imagenes/contm.png")));
		Continuar.setContentAreaFilled(false);
		Continuar.setBorderPainted(false);
		Continuar.setBorder(null);
		Continuar.setBounds(232, 139, 280, 65);
		contentPane.add(Continuar);

		// BOTON QUE TERMINA EL PROGRAMA
		JButton Salir = new JButton("");
		Salir.setIcon(new ImageIcon(VentPrint.class
				.getResource("/imagenes/botonSalir.png")));
		Salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		// JLABELS PARA DECORAR LA VENTANA
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VentPrint.class
				.getResource("/imagenes/Fondo_duck.png")));
		lblNewLabel.setBounds(115, 11, 495, 120);
		contentPane.add(lblNewLabel);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(VentPrint.class
				.getResource("/imagenes/jgpkjc.jpg")));
		label.setBounds(208, 197, 351, 278);
		contentPane.add(label);

		JLabel RayaRoja = new JLabel("");
		RayaRoja.setIcon(new ImageIcon(VentPrint.class
				.getResource("/imagenes/raya.png")));
		RayaRoja.setBounds(0, 161, 736, 25);
		contentPane.add(RayaRoja);
		Salir.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Salir.setBounds(10, 362, 151, 50);
		contentPane.add(Salir);

		JLabel ImagenFondo = new JLabel("");
		ImagenFondo.setIcon(new ImageIcon(VentPrint.class
				.getResource("/imagenes/pisis.png")));
		ImagenFondo.setBounds(0, -11, 747, 446);
		contentPane.add(ImagenFondo);

	}
}
