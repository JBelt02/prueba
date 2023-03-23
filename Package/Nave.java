package Package;

import java.awt.event.KeyEvent;

public class Nave extends Actor {
	
	boolean r ;
	boolean i ;
	private static int velocidad = 5 ;
	
	/**
	 * 
	 */
	public Nave() {
		super();
		
	}

	/**
	 * @param x
	 * @param y
	 * @param ancho
	 * @param alto
	 */
	public Nave(int x, int y, int ancho, int alto) {
		super(x, y, ancho, alto);
		this.setSpriteActual(Recursos.getInstance().getImagen(Recursos.IMAGEN_NAVE));
	}
	
	public void mover(int x) {
		this.x = x;
		
		Canvass canvas = Arkanoid.getInstance().getCanvas(); 
		
		if (this.x > (canvas.getWidth() - this.ancho)) {
			this.x = canvas.getWidth() - this.ancho;
		}

		if (this.x < 0) {
			this.x = 0;
		}
	}
	
	
	@Override
	public void actua() {
		if (i) this.x -= velocidad;
		if (r) this.x += velocidad;
		
		mover(this.x);
		
	}

	/**
	 * 
	 * @param e
	 */
	public void keyPressed (KeyEvent e) {
		switch (e.getKeyCode()) {
		
		case KeyEvent.VK_LEFT:
			i = true; 
			break;
			
		case KeyEvent.VK_RIGHT:
			r = true; 
			break;
		}
	}
	
	/**
	 * 
	 * @param e
	 */
	public void keyReleased (KeyEvent e) {
		switch (e.getKeyCode()) {
		
		case KeyEvent.VK_LEFT:
			i = false; 
			break;
			
		case KeyEvent.VK_RIGHT:
			r = false; 
			break;
		}
	}
}
