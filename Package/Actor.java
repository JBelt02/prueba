package Package;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Actor {
	
	protected int x ; 
	protected int y ; 
	protected int ancho ; 
	protected int alto ; 
	protected BufferedImage spriteActual;
	protected int velocidadSprite = 0;
	private int Tiempo = 0;
	protected List<BufferedImage> spritesDeAnimacion = new ArrayList<BufferedImage>();
	protected boolean Eliminacion = false;
	
	public void paint(Graphics g) {
		g.drawImage(this.spriteActual, this.x, this.y, null);
	}
	
	public void actua() {
		if (this.spritesDeAnimacion != null && this.spritesDeAnimacion.size() > 0) {
			Tiempo++;
			if (Tiempo % velocidadSprite == 0){
				Tiempo = 0;
				int indiceSpriteActual = spritesDeAnimacion.indexOf(this.spriteActual);
				int indiceSiguienteSprite = (indiceSpriteActual + 1) % spritesDeAnimacion.size();
				this.spriteActual = spritesDeAnimacion.get(indiceSiguienteSprite);
			}
		}
	}
	
	/**
	 * 
	 * @param a
	 */
	public void colisionaCon(Actor a) {
		
	}

	/**
	 * 
	 */
	public Actor() {
		super();
	}


	/**
	 * @param x
	 * @param y
	 * @param ancho
	 * @param alto
	 */
	public Actor(int x, int y, int ancho, int alto) {
		super();
		this.x = x;
		this.y = y;
		this.ancho = ancho;
		this.alto = alto;
	}




	@Override
	public String toString() {
		return "Actor [x=" + x + ", y=" + y + ", ancho=" + ancho + ", alto=" + alto + ", spriteActual=" + spriteActual
				+ ", velocidadSprite=" + velocidadSprite + ", Tiempo=" + Tiempo + ", spritesDeAnimacion="
				+ spritesDeAnimacion + ", Eliminacion=" + Eliminacion + "]";
	}


	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return the ancho
	 */
	public int getAncho() {
		return ancho;
	}

	/**
	 * @param ancho the ancho to set
	 */
	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	/**
	 * @return the alto
	 */
	public int getAlto() {
		return alto;
	}

	/**
	 * @param alto the alto to set
	 */
	public void setAlto(int alto) {
		this.alto = alto;
	}

	/**
	 * @return the spriteActual
	 */
	public BufferedImage getSpriteActual() {
		return spriteActual;
	}

	/**
	 * @param spriteActual the spriteActual to set
	 */
	public void setSpriteActual(BufferedImage spriteActual) {
		this.spriteActual = spriteActual;
		this.ancho = this.spriteActual.getWidth();
		this.alto = this.spriteActual.getHeight();
	}

	/**
	 * @return the spritesDeAnimacion
	 */
	public List<BufferedImage> getSpritesDeAnimacion() {
		return spritesDeAnimacion;
	}

	/**
	 * @param spritesDeAnimacion the spritesDeAnimacion to set
	 */
	public void setSpritesDeAnimacion(List<BufferedImage> spritesDeAnimacion) {
		this.spritesDeAnimacion = spritesDeAnimacion;
	}
	
}
