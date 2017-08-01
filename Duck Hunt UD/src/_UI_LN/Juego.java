package _UI_LN;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
// VENTANA EN DONDE SE EJECUA TEL JUEGO
// USAMOS ILOS PARA HACER QUE LOS PATOS SE MOVIERAN CONTROLANDO SU VELOCIDAD
public class Juego extends JFrame implements Runnable {
	// OBJETO DE LA CLASE SONIDO
	public Sonido sonar = new Sonido();
	// HILO QUE SUAREMOS MAS ABAJO
	private Thread hilo = new Thread();
	private boolean enEjecucion;
	// UN JLABEL PARA USARLO CON LOS HILOS
	private JLabel pato1;
	// Instanciamos la clase Pato que nos permite modificar el label pato1
	private Pato cambiopato = new Pato(pato1);

	// contador para la velocidad del nivel
	public int velocidad = 3;
	// contador para disparos, cambios de fondos, pasar nivel, contador de hits,
	// de niveles y de puntos
	private int confondo = 0;
	private boolean pasar = false;
	private int conlvl = 1;
	private int conhit = 0;
	private int conimagen = 0;
	private int conivel = 0;
	private int puntos = 0;
	private int conshot = 0;
	private boolean tes = false;
	private JPanel contentPane;
	// AQUI CAMBIAMOS LA IMAGEN DEL CURSOR POR UNA MIRA DE ESCOPETA
	Cursor cursor;
	ImageIcon ImgCursor = new ImageIcon(
			Juego.class.getResource("/imagenes/mira1.png"));
	Toolkit TK = Toolkit.getDefaultToolkit();
	// DEFINIMOS TODOS LOS ELEMENTOS DE LA INTERFAZ PARA NO OCUPAR TANTA MEMORIA
	private JPanel shot[] = new JPanel[3];
	private JPanel hit[] = new JPanel[10];
	private JLabel game;
	private JLabel record;
	private JLabel puntmost;
	private JLabel scormost;
	private JLabel texshot;
	private JLabel fallar;
	private JLabel Nivel;
	private JLabel PASAR;
	private JButton Empezar;
	private JLabel next;
	private JLabel LVL;
	private JButton Continuar;
	private JLabel Raya;
	private JLabel Puntaje;
	private JLabel lblNewLabel_1;
	private JButton Inicio;
	private JLabel fondo3;
	private JButton Reiniciar;
	private JLabel label_1;
	private JButton Siguiente;
	private JLabel label;
	private JLabel lblNewLabel;
	private JButton Salir;
	private JLabel Marco1;
	private JLabel Fondo;
	private JLabel Fondotras;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { Juego frame = new Juego();
	 * frame.setVisible(true); // hacemos que se mueva } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */
	/**
	 * Create the frame.
	 */
	public Juego() {
		cambiopato.color(0);
		// MEDIDAS Y OPCIONES AJUSTADAS DEL RECUADRO DE LA INTERFAZ
		setBounds(new Rectangle(0, 0, 1200, 700));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 700);
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(0);
		this.setResizable(false);

		// JLABELS PARA EL FONDO, SE USARON DOS FONDOS
		Fondo = new JLabel("");
		Fondotras = new JLabel("");

		contentPane = new JPanel();
		contentPane.setBounds(new Rectangle(0, 0, 1200, 700));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		// SE CUENTAN LOS DISPAROS, CADA VES QUE SE LE DE EN EL FONDO UN DISPARO
		// DESAPARECE
		shot[1] = new JPanel();
		shot[1].setBackground(Color.BLUE);
		shot[1].setBounds(120, 561, 23, 43);
		contentPane.add(shot[1]);
		// SE USAN VECTORES PARA LOS HITS Y LOS SHOTS CON EL OBJETIVO DE USAR
		// MENOS MEMORIA
		shot[2] = new JPanel();
		shot[2].setBackground(Color.BLUE);
		shot[2].setBounds(170, 561, 23, 43);
		contentPane.add(shot[2]);

		shot[0] = new JPanel();
		shot[0].setBackground(Color.BLUE);
		shot[0].setBounds(71, 561, 23, 43);
		contentPane.add(shot[0]);

		hit[0] = new JPanel();
		hit[0].setBounds(461, 578, 23, 43);
		contentPane.add(hit[0]);

		hit[1] = new JPanel();
		hit[1].setBounds(494, 578, 23, 43);
		contentPane.add(hit[1]);

		hit[2] = new JPanel();
		hit[2].setBounds(527, 578, 23, 43);
		contentPane.add(hit[2]);

		hit[3] = new JPanel();
		hit[3].setBounds(560, 578, 23, 43);
		contentPane.add(hit[3]);

		hit[5] = new JPanel();
		hit[5].setBounds(625, 578, 23, 43);
		contentPane.add(hit[5]);

		hit[4] = new JPanel();
		hit[4].setBounds(592, 578, 23, 43);
		contentPane.add(hit[4]);

		hit[6] = new JPanel();
		hit[6].setBounds(658, 578, 23, 43);
		contentPane.add(hit[6]);

		hit[7] = new JPanel();
		hit[7].setBounds(691, 578, 23, 43);
		contentPane.add(hit[7]);

		hit[8] = new JPanel();
		hit[8].setBounds(724, 578, 23, 43);
		contentPane.add(hit[8]);

		hit[9] = new JPanel();
		hit[9].setBounds(757, 578, 23, 43);
		contentPane.add(hit[9]);
		// IMAGEN GAMEOVER QUE APARECE CUANDO SE PIERDE
		game = new JLabel("");
		game.setIcon(new ImageIcon(Juego.class
				.getResource("/imagenes/gameover.png")));
		game.setBounds(352, -17, 454, 224);
		contentPane.add(game);
		game.setVisible(false);
		// SE DEFINEN ALGUNOS JLABEL QUE MUESTRAN EL PUNTAJE Y SI MARCO RECORD
		record = new JLabel("");
		record.setForeground(new Color(255, 0, 0));
		record.setFont(new Font("Tahoma", Font.PLAIN, 35));
		record.setBounds(140, 315, 330, 58);
		contentPane.add(record);
		record.setVisible(false);

		puntmost = new JLabel("00000");
		puntmost.setForeground(new Color(255, 0, 51));
		puntmost.setFont(new Font("Tahoma", Font.PLAIN, 70));
		puntmost.setBounds(477, 315, 195, 58);
		contentPane.add(puntmost);
		puntmost.setVisible(false);

		scormost = new JLabel("SCORE");
		scormost.setForeground(new Color(255, 0, 0));
		scormost.setFont(new Font("Tahoma", Font.PLAIN, 70));
		scormost.setBounds(461, 220, 237, 71);
		contentPane.add(scormost);
		scormost.setVisible(false);

		texshot = new JLabel("SHOT");
		texshot.setFont(new Font("Arial", Font.PLAIN, 34));
		texshot.setBounds(85, 615, 100, 30);
		contentPane.add(texshot);

		fallar = new JLabel("HAS FALLADO");
		fallar.setForeground(Color.RED);
		fallar.setFont(new Font("Tahoma", Font.PLAIN, 50));
		fallar.setBounds(426, 57, 321, 68);
		contentPane.add(fallar);
		fallar.setVisible(false);

		pato1 = new JLabel("");

		pato1.setVisible(false);

		// SE DICE QUE EL CURSOR DE ESTA INTEFAZ CAMBIARA A CIERTAS MEDIDAS DE
		// CIERTA IMAGEN
		this.cursor = TK.createCustomCursor(ImgCursor.getImage(), new Point(1,
				1), "Cursor");
		this.setCursor(cursor);

		// SE DEFINEN ALGUNOS JLABELS PARA CONTROLAR LOS ANUNCIOS
		Nivel = new JLabel("R=");
		Nivel.setForeground(new Color(0, 0, 255));
		Nivel.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 65));
		Nivel.setBounds(24, 465, 221, 58);
		contentPane.add(Nivel);

		PASAR = new JLabel("HAS CONSEGUIDO PASAR AL SIGUIENTE NIVEL");
		PASAR.setForeground(new Color(255, 0, 51));
		PASAR.setFont(new Font("Tahoma", Font.PLAIN, 34));
		PASAR.setBounds(255, 72, 745, 50);
		contentPane.add(PASAR);
		PASAR.setVisible(false);

		Raya = new JLabel("");

		// BOTON QUE EMPIEZA EL JUEGO Y TAMBIEN LOS NIVELES QUE SE VAN SUPERANDO
		// TAMBIEN CONTROLA LOS ANUNCIOS PARA QUE SEAN VISIBLES O NO
		Empezar = new JButton("");
		Empezar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sonar.sonido_pato();
				Raya.setVisible(false);
				Empezar.setVisible(false);
				Nivel.setText("R= 1");
				pato1.setVisible(true);
				Fondo.setVisible(true);
				pato1.addComponentListener(new ComponentAdapter() {
					// SE DEFINE UN COMPONENTMOVED QUE ARA QUE LOS PATOS SE
					// EMPIESEN A MOVER
					public void componentMoved(ComponentEvent arg0) {
						if (conimagen == 0) {
							cambiopato.color(0);
							pato1.setIcon(new ImageIcon(Juego.class
									.getResource("/imagenes/pato negro.gif")));

						} else if (conimagen == 1) {
							cambiopato.color(1);
							pato1.setIcon(new ImageIcon(Juego.class
									.getResource("/imagenes/pato amarillo.gif")));

						} else if (conimagen == 2) {
							cambiopato.color(2);
							pato1.setIcon(new ImageIcon(Juego.class
									.getResource("/imagenes/pato verde.gif")));
						}
					}
				});
				Empezar.setEnabled(false);
				// LLAMARA UN HILO QUE ARA QUE EL PATO SE EMPIESE A MOVER
				iniciar();
			}
		});
		// ATRIBUTOS DEL BOTON EMPEZAR
		Empezar.setRolloverIcon(new ImageIcon(Juego.class
				.getResource("/imagenes/EMPEZAR2.png")));
		Empezar.setSelectedIcon(new ImageIcon(Juego.class
				.getResource("/imagenes/EMPEZAR11.png")));
		Empezar.setIcon(new ImageIcon(Juego.class
				.getResource("/imagenes/EMPEZAR11.png")));
		Empezar.setContentAreaFilled(false);
		Empezar.setBorderPainted(false);
		Empezar.setBorder(null);
		Empezar.setBounds(447, 235, 267, 68);
		contentPane.add(Empezar);

		// JLABELS PARA SIGUIENTE NIVEL Y NUMERO DE NIVEL
		next = new JLabel("");
		next.setIcon(new ImageIcon(Juego.class
				.getResource("/imagenes/next.png")));
		next.setBounds(71, 45, 1050, 250);
		contentPane.add(next);
		next.setVisible(false);

		LVL = new JLabel("1");
		LVL.setForeground(new Color(255, 0, 0));
		LVL.setFont(new Font("Tahoma", Font.PLAIN, 99));
		LVL.setBounds(1107, 552, 75, 102);
		contentPane.add(LVL);

		// BOTON PARA PAZAR AL SIGUIENTE NIVEL
		Continuar = new JButton("CONTINUAR");
		Continuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// agrega mas velocidad
				velocidad = velocidad + 3;
				// CONTADOR QUE CAMBIA EL FONDO
				confondo++;
				// SEGUN EL CONTADOR, SE SELECCIONA EL FONDO PARA CADA NIVEL
				if (confondo == 1) {
					Fondotras.setIcon(new ImageIcon(Juego.class
							.getResource("/imagenes/pisisoto.png")));
					Fondo.setIcon(new ImageIcon(Juego.class
							.getResource("/imagenes/pisisoto.png")));
				} else if (confondo == 2) {
					Fondotras.setIcon(new ImageIcon(Juego.class
							.getResource("/imagenes/pisiscara.png")));
					Fondo.setIcon(new ImageIcon(Juego.class
							.getResource("/imagenes/pisiscara.png")));
				} else if (confondo == 3) {
					Fondotras.setIcon(new ImageIcon(Juego.class
							.getResource("/imagenes/pisisnieve.png")));
					Fondo.setIcon(new ImageIcon(Juego.class
							.getResource("/imagenes/pisisnieve.png")));
				} else if (confondo == 4) {
					Fondotras.setIcon(new ImageIcon(Juego.class
							.getResource("/imagenes/pisisselva.png")));
					Fondo.setIcon(new ImageIcon(Juego.class
							.getResource("/imagenes/pisisselva.png")));
				} else if (confondo == 5) {
					Fondotras.setIcon(new ImageIcon(Juego.class
							.getResource("/imagenes/paisa1.png")));
					Fondo.setIcon(new ImageIcon(Juego.class
							.getResource("/imagenes/paisa1.png")));
				} else if (confondo == 6) {
					Fondotras.setIcon(new ImageIcon(Juego.class
							.getResource("/imagenes/pisisoto.png")));
					Fondo.setIcon(new ImageIcon(Juego.class
							.getResource("/imagenes/pisisoto.png")));
				} else if (confondo == 7) {
					Fondotras.setIcon(new ImageIcon(Juego.class
							.getResource("/imagenes/pisiscara.png")));
					Fondo.setIcon(new ImageIcon(Juego.class
							.getResource("/imagenes/pisiscara.png")));
				} else if (confondo == 8) {
					Fondotras.setIcon(new ImageIcon(Juego.class
							.getResource("/imagenes/pisisnieve.png")));
					Fondo.setIcon(new ImageIcon(Juego.class
							.getResource("/imagenes/pisisnieve.png")));
				} else if (confondo == 9) {
					Fondotras.setIcon(new ImageIcon(Juego.class
							.getResource("/imagenes/pisisselva.png")));
					Fondo.setIcon(new ImageIcon(Juego.class
							.getResource("/imagenes/pisisselva.png")));
				}
				// SE REINICIAN TODOS LOS JLABELS Y CONTADORS EXCEPTUANDO LA
				// PUNTUACION
				conlvl++;
				LVL.setText(Integer.toString(conlvl));
				Nivel.setText("R=");
				hit[0].setBackground(Color.WHITE);
				hit[1].setBackground(Color.WHITE);
				hit[2].setBackground(Color.WHITE);
				hit[3].setBackground(Color.WHITE);
				hit[4].setBackground(Color.WHITE);
				hit[5].setBackground(Color.WHITE);
				hit[6].setBackground(Color.WHITE);
				hit[7].setBackground(Color.WHITE);
				hit[8].setBackground(Color.WHITE);
				hit[9].setBackground(Color.WHITE);
				pasar = false;
				conhit = 0;
				conimagen = 0;
				conivel = 0;
				conshot = 0;
				tes = false;
				next.setVisible(false);
				Raya.setVisible(true);
				Empezar.setVisible(true);
				Empezar.setEnabled(true);
				Continuar.setVisible(false);
				Continuar.setEnabled(false);
			}
		});
		// ATRIBUTOS DEL BOTON
		Continuar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		Continuar.setBackground(new Color(0, 0, 0));
		Continuar.setForeground(new Color(255, 69, 0));
		Continuar.setBounds(480, 330, 204, 43);
		contentPane.add(Continuar);
		Continuar.setVisible(false);
		Continuar.setEnabled(false);

		// ALGUNOS JLABELS PARA
		Raya.setIcon(new ImageIcon(Juego.class
				.getResource("/imagenes/raya2.png")));
		Raya.setBounds(0, 260, 1194, 17);
		contentPane.add(Raya);

		Puntaje = new JLabel("00000");
		Puntaje.setFont(new Font("Tahoma", Font.PLAIN, 50));
		Puntaje.setBounds(897, 561, 135, 43);
		contentPane.add(Puntaje);

		lblNewLabel_1 = new JLabel("HIT");
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setBackground(new Color(240, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblNewLabel_1.setBounds(341, 578, 89, 43);
		contentPane.add(lblNewLabel_1);

		// BOTON PARA VOLVER A LA VENTANA DE INICIO
		Inicio = new JButton("VENTANA DE INICIO");
		Inicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// SE LLAMA UN OBJETO DE LA CLASE INICIAL Y SE CIERRA LA ACUAL
				Eleccion sed = new Eleccion();
				sed.setVisible(true);
				dispose();
			}
		});
		Inicio.setForeground(new Color(255, 0, 0));
		Inicio.setBackground(new Color(0, 0, 0));
		Inicio.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		Inicio.setBounds(479, 465, 202, 43);
		contentPane.add(Inicio);
		Inicio.setVisible(false);
		Inicio.setEnabled(false);

		// ESTE BOTON REINICIA TODA LA CLASE
		Reiniciar = new JButton("REINICIAR");
		Reiniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// SE REINICIA TODO INCLUYENDO LA PUNTUACION
				hit[0].setBackground(Color.WHITE);
				hit[1].setBackground(Color.WHITE);
				hit[2].setBackground(Color.WHITE);
				hit[3].setBackground(Color.WHITE);
				hit[4].setBackground(Color.WHITE);
				hit[5].setBackground(Color.WHITE);
				hit[6].setBackground(Color.WHITE);
				hit[7].setBackground(Color.WHITE);
				hit[8].setBackground(Color.WHITE);
				hit[9].setBackground(Color.WHITE);
				pasar = false;
				conhit = 0;
				conimagen = 0;
				conivel = 0;
				puntos = 0;
				conshot = 0;
				Nivel.setText("R=");
				Puntaje.setText("00000");
				tes = false;
				PASAR.setVisible(false);
				record.setVisible(false);
				scormost.setVisible(false);
				puntmost.setVisible(false);
				game.setVisible(false);

				Inicio.setVisible(false);
				Inicio.setEnabled(false);
				Raya.setVisible(true);
				// SE MUESTRA DE NUEVO EL BOTON EMPEZAR
				Empezar.setVisible(true);
				Empezar.setEnabled(true);
				Reiniciar.setVisible(false);
				Reiniciar.setEnabled(false);

			}
		});

		Reiniciar.setBackground(new Color(0, 0, 0));
		Reiniciar.setForeground(new Color(220, 20, 60));
		Reiniciar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		Reiniciar.setBounds(477, 404, 204, 44);
		contentPane.add(Reiniciar);
		Reiniciar.setVisible(false);
		Reiniciar.setEnabled(false);

		// SE DAN LAS CARACTERISTICAS PARA EL FONDO
		fondo3 = new JLabel("");
		fondo3.setIcon(new ImageIcon(Juego.class
				.getResource("/imagenes/lvl.png")));
		fondo3.setBounds(1085, 534, 99, 136);
		contentPane.add(fondo3);

		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Juego.class
				.getResource("/imagenes/MARCO2.png")));
		label_1.setBounds(255, 534, 589, 136);
		contentPane.add(label_1);

		// ESTE BOTON HACE QUE APARESCA UN PATO NUEVO PARA MATAR
		Siguiente = new JButton("SIGUIENTE PATO");
		Siguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// SE TERMIAN EL SICLO DE MOVIMIENTO DEL PATO ACTUAL
				terminar();
				// SE LE AGREGA SONIDO DE PATOS
				sonar.sonido_pato();
				tes = false;
				// SE REINICIAN LOS SHOTS
				shot[0].setBackground(Color.BLUE);
				shot[1].setBackground(Color.BLUE);
				shot[2].setBackground(Color.BLUE);
				texshot.setText("SHOT");
				// SE REINICIA CONTADOR DE SHOTS
				conshot = 0;
				conivel++;
				// UN IF QUE EVALUA SI MATO LOS PATOS SUFICIENTES PARA PASAR AL
				// SIGUIENTE NIVEL O NO
				if (conivel > 9) {
					pato1.setVisible(false);
					Siguiente.setVisible(false);
					Siguiente.setEnabled(false);
					fallar.setVisible(false);
					conshot = 3;
					// SI PASO ENTONCES SE HACE VISIBLE EL BOTON CONTINUAR
					if (pasar == true) {
						next.setVisible(true);
						Continuar.setVisible(true);
						Continuar.setEnabled(true);
					} else {
						// SI NO PASO SE MUESTRA EL PUNTAJE ALCANZADO Y LOS
						// BOTONES REINICIAR E INICIO
						ConduccionDatos punt = new ConduccionDatos();
						game.setVisible(true);
						puntmost.setText(Integer.toString(puntos));
						puntmost.setVisible(true);
						scormost.setVisible(true);
						int can = punt.puntos(puntos);
						if (can != 0) {
							record.setText("NUEVO RECORD " + can + ". ");
							record.setVisible(true);
						}
						Reiniciar.setVisible(true);
						Reiniciar.setEnabled(true);
						Inicio.setVisible(true);
						Inicio.setEnabled(true);
					}
				} else {
					// SI TODAVIA NO VAN LOS 10 PATOS ENTONCES SE REINICIA EL
					// SICLO PARA CADA CASO DE PATOS
					switch (conivel) {
					case 1:
						sonar.sonido_pato();
						Nivel.setText("R= 2");
						conimagen = 1;
						break;
					case 2:
						sonar.sonido_pato();
						Nivel.setText("R= 3");
						conimagen = 2;
						break;
					case 3:
						sonar.sonido_pato();
						Nivel.setText("R= 4");
						conimagen = 0;
						break;
					case 4:
						sonar.sonido_pato();
						Nivel.setText("R= 5");
						conimagen = 1;
						break;
					case 5:
						sonar.sonido_pato();
						Nivel.setText("R= 6");
						conimagen = 2;
						break;
					case 6:
						sonar.sonido_pato();
						Nivel.setText("R= 7");
						conimagen = 0;
						break;
					case 7:
						sonar.sonido_pato();
						Nivel.setText("R= 8");
						conimagen = 1;
						break;
					case 8:
						sonar.sonido_pato();
						Nivel.setText("R= 9");
						conimagen = 2;
						break;
					case 9:
						sonar.sonido_pato();
						Nivel.setText("R= 10");
						conimagen = 0;
						break;
					}
					// SE TERMINA EL SICLO DE MOVIMIENTO Y SE VUELVE A INICIAR
					// PARA EL SIGUIENTE PATO
					terminar();
					sonar.sonido_pato();
					iniciar();
					fallar.setVisible(false);
					Siguiente.setVisible(false);
					Siguiente.setEnabled(false);
				}
			}
		});
		Siguiente.setBackground(new Color(178, 34, 34));
		Siguiente.setForeground(Color.WHITE);
		Siguiente.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Siguiente.setBounds(477, 136, 204, 43);
		contentPane.add(Siguiente);
		Siguiente.setVisible(false);
		Siguiente.setEnabled(false);

		// JLABELS DE DECORACION
		label = new JLabel("");
		label.setIcon(new ImageIcon(Juego.class
				.getResource("/imagenes/recuad.png")));
		label.setBounds(24, 534, 221, 136);
		contentPane.add(label);

		lblNewLabel = new JLabel("SCORE");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblNewLabel.setBounds(888, 601, 159, 50);
		contentPane.add(lblNewLabel);

		contentPane.add(pato1);
		// SE AGREGA UN EVENTO PARA CUANDO SE LE DE A EL PATO
		pato1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				// EVALUA SI NO SE HAN GASTADO TODOS LOS DISPAROS
				if (conshot != 3) {
					// SE TERMINA EL SICLO DE MOVIMIENTO
					terminar();
					conhit++;
					// SE MUESTRA LA IMAGEN DE UN PATO MUERTO DEPENDIENDO DEL
					// COLOR DEL PATO
					if (conimagen == 0) {
						sonar.explosion();

						pato1.setIcon(new ImageIcon(Juego.class
								.getResource("/imagenes/pato  nm.png")));
						puntos = puntos + 500;
					} else if (conimagen == 1) {
						sonar.explosion();
						pato1.setIcon(new ImageIcon(Juego.class
								.getResource("/imagenes/pato  am.png")));
						puntos = puntos + 1000;
					} else {
						sonar.explosion();
						pato1.setIcon(new ImageIcon(Juego.class
								.getResource("/imagenes/pato  vm.png")));
						puntos = puntos + 2000;
					}
					// SE MARCA UN HIT DEPENDIENDO DE EN CUAL SE VALLA
					switch (conhit) {
					case 1:
						hit[0].setBackground(Color.RED);
						break;
					case 2:
						hit[1].setBackground(Color.RED);
						break;
					case 3:
						hit[2].setBackground(Color.RED);
						break;
					case 4:
						hit[3].setBackground(Color.RED);
						break;
					case 5:
						hit[4].setBackground(Color.RED);
						break;
					case 6:
						hit[5].setBackground(Color.RED);
						break;
					case 7:
						hit[6].setBackground(Color.RED);
						pasar = true;
						break;
					case 8:
						hit[7].setBackground(Color.RED);
						break;
					case 9:
						hit[8].setBackground(Color.RED);
						break;
					case 10:
						hit[9].setBackground(Color.RED);
						break;
					}
					// SE CALCULA Y MUESTRA PUNTAJE EN INTERFAZ
					Puntaje.setText(Integer.toString(puntos));
					conshot = 3;
					tes = false;
					Siguiente.setVisible(true);
					Siguiente.setEnabled(true);
					fallar.setText("BIEN HECHO");
					fallar.setVisible(true);
				}
			}
		});
		// BOTON QUE REDIRECCIONA INMEDIATAMENTE A LA VENTANA DE INICIO
		Salir = new JButton("SALIR");
		Salir.setBackground(Color.DARK_GRAY);
		Salir.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Salir.setForeground(Color.RED);
		Salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Eleccion sed = new Eleccion();
				sed.setVisible(true);
				dispose();
			}
		});
		Salir.setBounds(1085, 11, 89, 23);
		contentPane.add(Salir);

		Marco1 = new JLabel("");
		Marco1.setIcon(new ImageIcon(Juego.class
				.getResource("/imagenes/recuad.png")));
		Marco1.setBounds(854, 534, 221, 136);
		contentPane.add(Marco1);
		// UN MOUSELISTENER PARA REALIZAR LA ACCION CUANDO SE FALLEN LOS
		// DISPAROS
		Fondo.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent arg0) {
				// SE PREGUNTA SI YA A FALLADO TODOS LOS DISPAROS O SI NO SE
				// UBICA EN EL DISPARO EN QUE SE VALLA
				if (tes == true) {
					conshot = 3;
				} else if (conshot == 0) {
					shot[2].setBackground(Color.WHITE);
					sonar.shotgun1();
					conshot = 1;
				} else if (conshot == 1) {
					shot[1].setBackground(Color.WHITE);
					sonar.shotgun1();
					conshot = 2;
				} else if (conshot == 2) {
					// SE PINTA EL ULTIMO SHOT Y SE TERMINA EL SICLO DE
					// MOVIMIENTO DEL PATO
					shot[0].setBackground(Color.WHITE);
					terminar();
					sonar.shotgun1();
					texshot.setText("");
					texshot.setIcon(new ImageIcon(Juego.class
							.getResource("/imagenes/shot.gif")));
					fallar.setText("HAS FALLADO");
					fallar.setVisible(true);
					Siguiente.setVisible(true);
					Siguiente.setEnabled(true);
					conshot = 3;
				}
			}
		});
		// SE CAMBIAN Y MODIFICAN LOS FONDOS
		Fondo.setVisible(false);
		Fondo.setForeground(new Color(0, 0, 255));
		Fondo.setIcon(new ImageIcon(Juego.class
				.getResource("/imagenes/paisa1.png")));
		Fondo.setBounds(0, 0, 1194, 700);
		contentPane.add(Fondo);

		Fondotras.setIcon(new ImageIcon(Juego.class
				.getResource("/imagenes/paisa1.png")));
		Fondotras.setBounds(0, 0, 1194, 681);
		contentPane.add(Fondotras);
	}

	// methodos que implemantamos de la clase
	public void iniciar() {
		// EMPIEZA EL MOVIMIENTO DEL PATO POR MEDIO DE HILOS
		enEjecucion = true;
		hilo = new Thread(this, "Hilo");
		hilo.start();
	}

	public void terminar() {
		// TERMINA EL MOVIMIENTO DE LOS PATOS CON UN METODO DE LA CLASE THREAD
		enEjecucion = false;
		try {
			hilo.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// REALIZA EL MOVIMIENTO DE LOS PATOS
	public void run() {

		// posision inicial de los patos
		int x = (int) (Math.random() * 1050 + 1);
		int y = (int) (Math.random() * 350 + 1);
		// VELOCIDAD DE LOS PATOS
		int vx = (int) (velocidad * Math.pow(-1,
				(int) (Math.random() * 1050 + 1)));
		int vy = (int) (velocidad * Math.pow(-1,
				(int) (Math.random() * 1050 + 1)));
		// SE CONTROLA QUE EL METODO SE ACTUALIZE PARA QUE SE MUEVAN LOS PATOS
		// CABIANDO DE POSICIONES
		final int NS_POR_SEGUNDO = 10000000;
		final byte APS_OBJETIVO = 60;
		final double NS_POR_ACTUALIZACION = NS_POR_SEGUNDO / APS_OBJETIVO;

		long referenciaActualizacion = System.nanoTime();
		long referenciaContador = System.nanoTime();

		double tiempoTranscurrido;
		double delta = 0;
		requestFocus();
		// EMPLEA EL SICLO Y LAS POSICIONES DE MOVIMIENTOS DE LOS PATOS
		while (enEjecucion) {

			final long inicioBucle = System.nanoTime();
			tiempoTranscurrido = inicioBucle - referenciaActualizacion;
			referenciaActualizacion = inicioBucle;
			delta += tiempoTranscurrido / NS_POR_ACTUALIZACION;
			while (delta >= 1) {
				delta--;
			}
			if ((System.nanoTime() - referenciaContador) > NS_POR_SEGUNDO) {

				pato1.setBounds(x, y, 150, 150);
				// SE CONTROLA QUE EL PATO NO SALGA DEL RECUADRO
				if (x < 0) {
					vx *= -1;
				}
				if (y < 0) {
					vy *= -1;
				}
				if (x > 1050) {
					vx *= -1;
				}
				if (y > 400) {
					vy *= -1;
				}
				x = x - vx;
				y = y + vy;

				referenciaContador = System.nanoTime();
			}

		}

	}
}
