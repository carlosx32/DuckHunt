package _UI_LN;

import java.applet.AudioClip;

public class Sonido {
	// CLASE QUE CONTROLA LOS SONIDOS DE EL JUEGO
	AudioClip sonidoD;

	public Sonido() {
	}

	public void sonido_pato() {
		sonidoD = java.applet.Applet.newAudioClip(getClass().getResource(
				"/imagenes/duck_1.wav"));
		sonidoD.play();
	}

	public void explosion() {
		sonidoD = java.applet.Applet.newAudioClip(getClass().getResource(
				"/imagenes/explosion.wav"));
		sonidoD.play();
	}

	public void shotgun1() {
		sonidoD = java.applet.Applet.newAudioClip(getClass().getResource(
				"/imagenes/shotgun.wav"));
		sonidoD.play();

	}

}
