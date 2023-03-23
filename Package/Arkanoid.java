package Package;

import java.awt.BorderLayout;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFrame;

public class Arkanoid {
	
	private static int FPS = 60;
	private JFrame ventana = null;
	private List<Actor> actores = new ArrayList<Actor>();
	private Canvass canvas = null;
	private static Nave nave = null;
	private static Pelota pelota = null;
	private List<Actor> actoresEliminar = new ArrayList<Actor>();
	private List<Actor> actoresIncorporar = new ArrayList<Actor>();
	
	private static Arkanoid instance = null;
	
	public static Arkanoid getInstance () {
		if (instance == null) {
			instance = new Arkanoid();
		}
		return instance;
	} 
	
	public Arkanoid () {
		ventana = new JFrame("Arkanoid");
		ventana.setBounds(400, 0, 605, 700);
		ventana.getContentPane().setLayout(new BorderLayout());
		actores = creaActores();
		canvas = new Canvass(actores);
		
			canvas.addMouseMotionListener(new MouseAdapter() {
				@Override
				public void mouseMoved(MouseEvent e) {
					super.mouseMoved(e);
					nave.mover(e.getX());
				}			
			});
	
			canvas.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					super.keyPressed(e);
					nave.keyPressed(e);
				}
					@Override
				public void keyReleased(KeyEvent e) {
					super.keyReleased(e);
					nave.keyReleased(e);
				}
			});
		
		ventana.getContentPane().add(canvas, BorderLayout.CENTER);
		
		// ventana no se redibuje por los eventos de Windows
		ventana.setIgnoreRepaint(true);
		// ventana sea visible
		ventana.setVisible(true);
		//ventana no se pueda redimensionar
		ventana.setResizable(false);
		canvas.requestFocus();
		
		ventana.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		ventana.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				cerrarAplicacion();
			}
		});		
	}
	
	private List<Actor> creaActores() {
		// TODO Auto-generated method stub
		return null;
	}

	private void cerrarAplicacion() {
		String [] opciones = {"Aceptar","Cancelar"};
		Scanner sc = new Scanner(System.in);
		String eleccion = sc.next();
		if (eleccion == "Aceptar") {
			System.exit(0);
		}
	}
	
	
	public void juego () {
		int millisPorCadaFrame = 1000 / FPS;
		do {
			long millisAntesEscena = new Date().getTime();
			canvas.pintarEscena();
			for (Actor a : actores) {
				a.actua();
			}
			detectaColisiones();
			actualizaActores();
			long millisDespuesDeProcesarEscena = new Date().getTime();
			int millisDeProcesamientoDeEscena = (int) (millisDespuesDeProcesarEscena - millisAntesEscena);
			int millisPausa = millisPorCadaFrame - millisDeProcesamientoDeEscena;
			millisPausa = (millisPausa < 0)? 0 : millisPausa;
			
			// "Duermo" el proceso principal durante los millis calculados.
			try {
				Thread.sleep(millisPausa);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while (true);
	}
	
	private void actualizaActores() {
		// TODO Auto-generated method stub
		
	}

	private void detectaColisiones() {
		
		 for (Actor actor : this.actores) {
	            Rectangle rectangulo1 = new Rectangle(actor.getX(), actor.getY(), actor.getAncho(), actor.getAlto());
	             
	            if(!actor.equals(pelota)) {
	                Rectangle rectangulo2 = new Rectangle(pelota.getX(), pelota.getY(), pelota.getAncho(), pelota.getAlto());
	               
	                if (rectangulo1.intersects(rectangulo2)) {
	                    actor.colisionaCon(pelota); 
	                    pelota.colisionaCon(actor); 
	                }
	            }

	         }
	}

	/**
	 * @return the canvas
	 */
	public Canvass getCanvas() {
		return canvas;
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// Realizo la carga de los recursos en memoria
		Recursos.getInstance().cargarRecursosEnMemoria();
		
		// Comienzo un bucle, que consistirá en el juego completo
		Arkanoid.getInstance().juego();
	}
	
}
