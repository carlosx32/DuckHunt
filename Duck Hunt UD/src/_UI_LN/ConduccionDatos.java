package _UI_LN;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class ConduccionDatos {
	// ESTA CLASE CONDUCE LA INFORMACION DE LA PUNTUACION DE LOS JUGADORES
	public int puntos(int punt) {
		// CREAMOS UN OBJETO DE LA CLASE FILE PARA CONDUCIR ARCHIVOS
		File red = new File("puntajes.txt");
		// LLAMAMOS EL FILEREADER PARA LEER LA INFORMACION DEL ARCHIVO
		String lineaTexto = null;
		FileReader cas = null;
		// UN BUFFEREDREADER CONTROLANDO ERRORES PARA PODER PASAR A UN STRING LA
		// INDFORMACION DEL ARCHIVO
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

		// CONTADORES PARA LAS POSICIONES DE LOS PUNTAJES
		int nos;
		int num1 = 0;
		int num2 = 0;
		int num3 = 0;
		int num4 = 0;
		int num5 = 0;
		int num6 = 0;
		String[] Valores;
		// USAMOS UN VECTOR PARA ROMPER LA LINEA DEL STRING Y PONERLO ENCADA
		// POSICION DEL VECOR
		Valores = lineaTexto.split(";");
		num1 = Integer.parseInt(Valores[0]);
		num2 = Integer.parseInt(Valores[1]);
		num3 = Integer.parseInt(Valores[2]);
		num4 = Integer.parseInt(Valores[3]);
		num5 = Integer.parseInt(Valores[4]);
		num6 = Integer.parseInt(Valores[5]);
		try {
			// CERRAMOS EL FILEREADER Y EL BUFF
			cas.close();
			si.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// SI EL PUNTAJE ES SUFICIENTE PARA CLASIFICAR EN LA TABLA SE HACE EL
		// REMPLAZO CORRESPONDIENTE
		if (punt >= num1) {
			num6 = num5;
			num5 = num4;
			num4 = num3;
			num3 = num2;
			num2 = num1;
			num1 = punt;
			nos = 1;
		} else if (punt < num1 && punt >= num2) {
			num6 = num5;
			num5 = num4;
			num4 = num3;
			num3 = num2;
			num2 = punt;
			nos = 2;
		} else if (punt < num2 && punt >= num3) {
			num6 = num5;
			num5 = num4;
			num4 = num3;
			num3 = punt;
			nos = 3;
		} else if (punt < num3 && punt >= num4) {
			num6 = num5;
			num5 = num4;
			num4 = punt;
			nos = 4;
		} else if (punt < num4 && punt >= num5) {
			num6 = num5;
			num5 = punt;
			nos = 5;
		} else if (punt < num5 && punt >= num6) {
			num6 = punt;
			nos = 6;
		} else {
			nos = 0;
		}
		// SE PONEN LAS PUNTUACIONES EN UN STRING PARA PONERLAS EN EL ARCHIVO DE
		// NUEVO
		String guarda = num1 + ";" + num2 + ";" + num3 + ";" + num4 + ";"
				+ num5 + ";" + num6 + ";";
		try {
			// SE ABREN UN FILEWRITE Y UN BUFF PARA ESCRIVIR EN EL ARCHIVO LOS
			// NUEVOS PUNTAJES
			FileWriter fw = new FileWriter("puntajes.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(guarda);
			bw.close();
			fw.close();
		} catch (Exception s) {
			JOptionPane.showMessageDialog(null, "Error");
		}
		return nos;
	}

	// ESTE METODO REINICIA LOS PUNTAJES EN EL ARCHIVO DEJANDOLOS TODOS EN 0
	public void Reiniciar() {
		try {
			FileWriter fw = new FileWriter("puntajes.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(0 + ";" + 0 + ";" + 0 + ";" + 0 + ";" + 0 + ";" + 0);
			bw.close();
			fw.close();
		} catch (Exception s) {
			JOptionPane.showMessageDialog(null, "Error");
		}
	}
}
