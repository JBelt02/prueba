package Package;

import java.awt.Color;
import java.awt.Graphics;

public class Pelota extends Actor {

	protected int velX;
	protected int velY;
	/**
	 * 
	 */
	public Pelota() {
		super();
		
	}
	/**
	 * @param x
	 * @param y
	 * @param ancho
	 * @param alto
	 */
	public Pelota(int x, int y, int ancho, int alto) {
		super(x, y, ancho, alto);
		this.velX = velX;
		this.velY = velY;
		
	}
	
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.RED);
		g.fillOval(this.x, this.y, this.ancho, this.alto);
	}
	
	@Override
	public void actua() {
		super.actua();
		this.x += this.velX;
		if (this.x < 0 || (this.x + this.ancho) > Arkanoid.getInstance().getCanvas().getWidth()) {
			this.velX = -this.velX;
		}
		
		this.y += this.velY;
		if (this.y < 0 || (this.y + this.alto) > Arkanoid.getInstance().getCanvas().getHeight()) {
			this.velY = -this.velY;
		}
	}
	
	@Override
	public void colisionaCon(Actor a) {
		super.colisionaCon(a);
		if (a instanceof Ladrillo || a instanceof Nave) {
			this.velY = -velY;
		}
	}
	
	@Override
	public String toString() {
		return "Pelota [velX=" + velX + ", velY=" + velY + ", x=" + x + ", y=" + y + ", ancho=" + ancho + ", alto="
				+ alto + "]";
	}
	
	
	/**
	 * @return the velX
	 */
	public int getVelX() {
		return velX;
	}
	/**
	 * @param velX the velX to set
	 */
	public void setVelX(int velX) {
		this.velX = velX;
	}
	/**
	 * @return the velY
	 */
	public int getVelY() {
		return velY;
	}
	/**
	 * @param velY the velY to set
	 */
	public void setVelY(int velY) {
		this.velY = velY;
	}
	
	
}
