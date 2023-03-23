package Package;

import java.awt.Canvas;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.List;

public class Canvass extends Canvas {
	
	List<Actor> actores = null;
	private BufferStrategy estrategia = null;
	protected BufferedImage back;
	
	
	
	/**
	 * @param actores
	 */
	public Canvass(List<Actor> actores) {
		super();
		this.actores = actores;
	}

	public void pintarEscena () {
		
		// Tengo que inicializar el objeto "strategy" una �nica vez
		if (this.estrategia == null) {
			// El Canvas se dibujar� en pantalla con una estrategia de doble b�ffer
			this.createBufferStrategy(2);
			// Obtengo una referencia a la estrategia de doble b�ffer.
			estrategia = getBufferStrategy();
			// Resuelve un problema de sincronizaci�n de memoria de v�deo en Linux
		}
		Toolkit.getDefaultToolkit().sync();			
		
		// Obtengo el objeto gr�fico que me permita pintar en el doble b�ffer
		Graphics2D g = (Graphics2D)estrategia.getDrawGraphics();
		
		// Pinto la imagen de fondo
		this.setBack(Recursos.getInstance().getImagen(Recursos.IMAGEN_FONDO));
		g.drawImage(this.back, 0,0, this.getWidth(), this.getHeight(), null);
		

		// Pinto cada uno de los actores
		for (Actor a : this.actores) {
			a.paint(g);
		}

		// Muestro en pantalla el buffer con el nuevo frame creado para el juego
		estrategia.show();
	}

	/**
	 * @return the back
	 */
	public BufferedImage getBack() {
		return back;
	}

	/**
	 * @param back the back to set
	 */
	public void setBack(BufferedImage back) {
		this.back = back;
	}
	
}
