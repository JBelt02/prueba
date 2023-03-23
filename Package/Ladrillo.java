package Package;

import java.awt.Color;
import java.awt.Graphics;

public class Ladrillo extends Actor {
	Color color ;

	/**
	 * 
	 */
	public Ladrillo() {
		super();
		
	}

	/**
	 * @param x
	 * @param y
	 * @param ancho
	 * @param alto
	 */
	public Ladrillo(int x, int y, int ancho, int alto, Color color) {
		super(x, y, ancho, alto);
		this.color=color;
		
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, ancho, alto);
		super.paint(g);
	}

	@Override
	public void actua() {
		
		super.actua();
	}

	@Override
	public void colisionaCon(Actor a) {
		
		super.colisionaCon(a);
	}

	/**
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(Color color) {
		this.color = color;
	}
	
	
	
	
	
}
