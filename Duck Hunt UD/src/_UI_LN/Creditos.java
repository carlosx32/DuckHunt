package _UI_LN;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Creditos extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Creditos frame = new Creditos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Creditos() {
		// CARACTERISTICAS DE LA VENTANA
		setTitle("CREDITOS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 742, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(0);
		this.setResizable(false);

		// sEDEFINE UN PANEL Y UN JTEXT AREA PARA ESCRIBIR LOS CREDITOS
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(79, 66, 567, 281);
		contentPane.add(scrollPane);

		JTextArea txtrDuckHuntUd = new JTextArea();
		txtrDuckHuntUd.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		txtrDuckHuntUd
				.setText("                                                      \r\n                                                 DUCK HUNT UD 1.0\r\n\r\n                                                   REALIZADO POR\r\n \r\n\r\n\t     -BRAYAN LEONARDO SIERRA FORERO                20151020059\r\n\t\r\n                            -CARLOS DAVID CAMACHO PANCHE                20151020034\r\n\r\n                            -NORBEY DANILO MU\u00D1OZ CA\u00D1ON                    20151020050\r\n\r\n       \t           ESTUDIANTES DE INGENIERIA DE SISTEMAS DE LA \r\n                             UNIVERSIDAD  DISTRITAL FRANCISCO JOSE DE CALDAS\r\n\r\n             SEGUNDO SEMESTRE DEL AREA DE PROGRAMACION ORIENTA A OBJETOS\r\n\r\nEN EL ACTUAL VIDEOJUEGO SE TUVIERON  EN CUENTA LAS PRINCIPALES CARACTERISTICAS \r\nDEL PARADIGMA DE LA PROGRAMACION ORIENTADA A OBJETOS, ADEMAS DEL DISE\u00D1O \r\nGRAFICO, SONIDOS, CONDUCCION DE DATOS CON MANEJO DE ARCHIVOS Y \r\nUSO DE HILOS PARA FINES DE LA ADAPTABILIDAD DEL JUEGO.\r\n                                        \r\n\r\nEN CUANTO A LAS IMAGENES, SE SELECCIONARON ALGUNAS ESPECIFICAS PARA CADA  \r\n       PARTE DEL VIDEOJUEGO CON EL OBJETIVO DE LOGRAR UNA MEJORA PARA LA  \r\n                                                  APRECIACION DEL USUARIO.");
		scrollPane.setViewportView(txtrDuckHuntUd);

		JLabel lblCreditos = new JLabel("CREDITOS");
		lblCreditos.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblCreditos.setBounds(236, 11, 253, 44);
		contentPane.add(lblCreditos);
		// BOTON PARA CERRAR EL PROGRAMA
		JButton Salir = new JButton("");
		Salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		Salir.setIcon(new ImageIcon(Creditos.class
				.getResource("/imagenes/botonSalir.png")));
		Salir.setBounds(10, 358, 151, 50);
		contentPane.add(Salir);

		// BOTON PARA VOLVER A LA VENTANA INICIAL
		JButton Volver = new JButton("");
		Volver.setRolloverIcon(new ImageIcon(Creditos.class
				.getResource("/imagenes/devolver2.png")));
		Volver.setSelectedIcon(new ImageIcon(Creditos.class
				.getResource("/imagenes/devolver1.png")));
		Volver.setIcon(new ImageIcon(Creditos.class
				.getResource("/imagenes/devolver1.png")));
		Volver.setContentAreaFilled(false);
		Volver.setBorderPainted(false);
		Volver.setBorder(null);
		Volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Eleccion des = new Eleccion();
				des.setVisible(true);
				dispose();
			}
		});
		Volver.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Volver.setBounds(10, 11, 128, 42);
		contentPane.add(Volver);

		JLabel Fondo = new JLabel("");
		Fondo.setIcon(new ImageIcon(Creditos.class
				.getResource("/imagenes/azules.png")));
		Fondo.setBounds(0, 0, 736, 423);
		contentPane.add(Fondo);
	}
}
