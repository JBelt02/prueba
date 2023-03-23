package Package;

import java.applet.Applet;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class Recursos {
	
	public static String IMAGEN_NAVE = "nave.png";
	public static String IMAGEN_FONDO = "fondo.png";
	private HashMap<String, Object> hm = new HashMap<String, Object>();
	private String nombreCarpetaParaFile = "./src/Recursos/";
	private String nombreCarpeta = "Recursos/";
	
	private static Recursos instance= null;
	
	/**
	 * Getter Singleton
	 * @return
	 */
	public static Recursos getInstance () {
		if (instance == null) {
			instance = new Recursos();
		}
		return instance;
	}
	
	/**
	 * 
	 * @param nombreFichero
	 */
	private void cargarFicheroEnHashMap (String nombreFichero) {
		// Obtengo un objeto URL para localizar el recurso
		URL url = null;
		url = getClass().getResource(nombreCarpeta + nombreFichero);
		try {
			if (nombreFichero.endsWith(".jpng") || nombreFichero.endsWith(".png")) {
				this.hm.put(nombreFichero, ImageIO.read(url));
			} 
		}
		catch (Exception ex) {
			System.out.println("No se pudo cargar el recurso " + nombreFichero);
			ex.printStackTrace();
		}
	}
	
	/**
	 * 
	 */
	public void cargarRecursosEnMemoria () {
		File carpeta = new File(nombreCarpetaParaFile);
		for (File fichero : carpeta.listFiles()) {
	        if (fichero.isFile()) {
	        	cargarFicheroEnHashMap(fichero.getName());
	        }
	    }
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public BufferedImage getImagen(String nombreFichero) {
		return (BufferedImage) hm.get(nombreFichero);
	}
	
}
