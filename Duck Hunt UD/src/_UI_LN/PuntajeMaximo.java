package _UI_LN;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class PuntajeMaximo extends JFrame {
	// SE USA UN OBJETO DE LA CLASE CONDUCCION DATOS PARA MANEJAR LAS
	// PUNTUACIONES
	ConduccionDatos ser = new ConduccionDatos();
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PuntajeMaximo frame = new PuntajeMaximo();
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
	public static void mostrar() {

	}

	public PuntajeMaximo() {
		// CARACTERISTICAS DE LA VENTANA
		setTitle("PUNTAJE MAXIMO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 742, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(0);
		this.setResizable(false);

		// ALGUNOS JLABELS PARA LA DECORACION DE LA VENTANA
		JLabel lblPuntuacionesMaximas = new JLabel("PUNTUACIONES MAXIMAS");
		lblPuntuacionesMaximas.setForeground(Color.DARK_GRAY);
		lblPuntuacionesMaximas.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblPuntuacionesMaximas.setBounds(174, 13, 412, 66);
		contentPane.add(lblPuntuacionesMaximas);

		JLabel lblPosicion = new JLabel("POSICI\u00D3N 1 :");
		lblPosicion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPosicion.setBounds(232, 90, 123, 24);
		contentPane.add(lblPosicion);

		JLabel Pos1 = new JLabel("");
		Pos1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		Pos1.setBounds(393, 90, 160, 24);
		contentPane.add(Pos1);

		// JLABELS PARA GUARDAR LOS PUNTAJES Y MOSTRARLOS EN LA INTERFAZ
		JLabel lblPosicin = new JLabel("POSICI\u00D3N 2 :");
		lblPosicin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPosicin.setBounds(232, 137, 123, 24);
		contentPane.add(lblPosicin);

		JLabel lblPosicin_1 = new JLabel("POSICI\u00D3N 3 :");
		lblPosicin_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPosicin_1.setBounds(232, 182, 123, 24);
		contentPane.add(lblPosicin_1);

		JLabel lblPosicin_2 = new JLabel("POSICI\u00D3N 4 :");
		lblPosicin_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPosicin_2.setBounds(232, 226, 123, 24);
		contentPane.add(lblPosicin_2);

		JLabel lblPosicin_3 = new JLabel("POSICI\u00D3N 5 :");
		lblPosicin_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPosicin_3.setBounds(232, 272, 123, 24);
		contentPane.add(lblPosicin_3);

		JLabel lblPosicin_4 = new JLabel("POSICI\u00D3N 6 :");
		lblPosicin_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPosicin_4.setBounds(232, 320, 123, 24);
		contentPane.add(lblPosicin_4);

		JLabel Pos2 = new JLabel("");
		Pos2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		Pos2.setBounds(393, 137, 160, 24);
		contentPane.add(Pos2);

		JLabel Pos3 = new JLabel("");
		Pos3.setFont(new Font("Tahoma", Font.PLAIN, 24));
		Pos3.setBounds(393, 182, 160, 24);
		contentPane.add(Pos3);

		JLabel Pos4 = new JLabel("");
		Pos4.setFont(new Font("Tahoma", Font.PLAIN, 24));
		Pos4.setBounds(393, 226, 160, 24);
		contentPane.add(Pos4);

		JLabel Pos5 = new JLabel("");
		Pos5.setFont(new Font("Tahoma", Font.PLAIN, 24));
		Pos5.setBounds(393, 272, 160, 24);
		contentPane.add(Pos5);

		JLabel Pos6 = new JLabel("");
		Pos6.setFont(new Font("Tahoma", Font.PLAIN, 24));
		Pos6.setBounds(393, 320, 160, 24);
		contentPane.add(Pos6);

		// BOTON PARA VOLVER A LA CLASE DE INICIO
		JButton Volver = new JButton("");
		Volver.setRolloverIcon(new ImageIcon(PuntajeMaximo.class
				.getResource("/imagenes/devolver2.png")));
		Volver.setSelectedIcon(new ImageIcon(PuntajeMaximo.class
				.getResource("/imagenes/devolver1.png")));
		Volver.setIcon(new ImageIcon(PuntajeMaximo.class
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
		Volver.setFont(new Font("Tahoma", Font.PLAIN, 24));
		Volver.setBounds(10, 11, 128, 42);
		contentPane.add(Volver);

		// BOTON PARA SALIR DEL PROGRAMA
		JButton Salir = new JButton("");
		Salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		Salir.setIcon(new ImageIcon(PuntajeMaximo.class
				.getResource("/imagenes/botonSalir.png")));
		Salir.setBounds(10, 347, 151, 50);
		contentPane.add(Salir);

		// BOTON PARA REINICIAR PUNTAJES Y DEJARLOS EN 0
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(PuntajeMaximo.class
				.getResource("/imagenes/REINI.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// SE REINICIAN PUNTAJES CON UN METODO DE LA CLASE CONDUCCION
				// DATOS
				ser.Reiniciar();
				// UN JOPTIONPANE PARA VOTAR UN LETRERO DE QUE LOS PUNTAJES SE
				// REINICIARON
				JOptionPane.showMessageDialog(null, "PUNTAJE REINICIADO");
				// USAMOS CONDUCCION DE ARCHIVOS PARA EXTRAER LOS PUNTAJES Y
				// MOSTRARLOS
				File red = new File("puntajes.txt");
				String lineaTexto = null;
				FileReader cas = null;
				try {
					cas = new FileReader(red);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				BufferedReader si = new BufferedReader(cas);
				try {
					lineaTexto = si.readLine();
				} catch (IOException err) {
					JOptionPane.showMessageDialog(null, err.getMessage());
				}

				String[] Valores;
				Valores = lineaTexto.split(";");
				Pos1.setText(Valores[0]);
				Pos2.setText(Valores[1]);
				Pos3.setText(Valores[2]);
				Pos4.setText(Valores[3]);
				Pos5.setText(Valores[4]);
				Pos6.setText(Valores[5]);
				try {
					cas.close();
					si.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(525, 347, 201, 50);
		contentPane.add(btnNewButton);

		// LLAMAMOS EL ARCHIVO , EXTRAEMOS LOS PUNTAJES Y LOS ASIGNAMOS A LOS
		// CORRESPONDIENTES JLABELS
		File red = new File("puntajes.txt");
		String lineaTexto = null;
		FileReader cas = null;
		try {
			cas = new FileReader(red);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		BufferedReader si = new BufferedReader(cas);
		try {
			lineaTexto = si.readLine();
		} catch (IOException err) {
			JOptionPane.showMessageDialog(null, err.getMessage());
		}

		String[] Valores;
		Valores = lineaTexto.split(";");
		Pos1.setText(Valores[0]);
		Pos2.setText(Valores[1]);
		Pos3.setText(Valores[2]);
		Pos4.setText(Valores[3]);
		Pos5.setText(Valores[4]);
		Pos6.setText(Valores[5]);

		JLabel Fondo = new JLabel("");
		Fondo.setIcon(new ImageIcon(PuntajeMaximo.class
				.getResource("/imagenes/naranja.png")));
		Fondo.setBounds(0, 0, 736, 423);
		contentPane.add(Fondo);
		try {
			cas.close();
			si.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
