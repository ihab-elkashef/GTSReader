package prgm;

import java.util.List;

public class Rotation {
	
	/**
	 * Effectue une rotation positive autour de l'axe X.
	 * @param fig Mod�le GTS
	 */
	public static void rotationVersLeHaut(Figure fig){
		List<Point> points = fig.getLoader().getListeDePoints();
		for(Point point : points){
			double tmpY = point.getY();
			double tmpZ = point.getZ();
			point.setY(tmpY*Math.cos(Math.PI/90) - tmpZ*Math.sin(Math.PI/90));
			point.setZ(tmpY*Math.sin(Math.PI/90) + tmpZ*Math.cos(Math.PI/90));		
		}
	}
	
	/**
	 * Effectue une rotation n�gative autour de l'axe X.
	 * @param fig Mod�le GTS
	 */
	public static void rotationVersLeBas(Figure fig){
		List<Point> points = fig.getLoader().getListeDePoints();
		for(Point point : points){
			double tmpY = point.getY();
			double tmpZ = point.getZ();
			point.setY(tmpY*Math.cos(Math.PI/90) + tmpZ*Math.sin(Math.PI/90));
			point.setZ(-tmpY*Math.sin(Math.PI/90) + tmpZ*Math.cos(Math.PI/90));	
		}
	}
	
	/**
	 * Effectue une rotation n�gative autour de l'axe Y.
	 * @param fig Mod�le GTS
	 */
	public static void rotationVersLaGauche(Figure fig){
		List<Point> points = fig.getLoader().getListeDePoints();
		for(Point point : points){
			double tmpX = point.getX();
			double tmpZ = point.getZ();
			point.setX(tmpX*Math.cos(Math.PI/90) + tmpZ*Math.sin(Math.PI/90));
			point.setZ(-tmpX*Math.sin(Math.PI/90) + tmpZ*Math.cos(Math.PI/90));	
		}
		
	}
	
	/**
	 * Effectue une rotation positive autour de l'axe Y.
	 * @param fig Mod�le GTS
	 */
	public static void rotationVersLaDroite(Figure fig){
		List<Point> points = fig.getLoader().getListeDePoints();
		for (Point point : points){
			double tmpX = point.getX();
			double tmpZ = point.getZ();
			point.setX(tmpX*Math.cos(Math.PI/90) + tmpZ*Math.sin(Math.PI/90));
			point.setZ(-tmpX*Math.sin(Math.PI/90) + tmpZ*Math.cos(Math.PI/90));	
		}
	}
	
	/**
	 * Effectue une rotation positive autour de l'axe Z.
	 * @param fig Mod�le GTS
	 */
	public static void rotationZPlus(Figure fig){
		List<Point> points = fig.getLoader().getListeDePoints();
		for(Point point : points){
			double tmpX = point.getX();
			double tmpY = point.getY();
			point.setX(tmpX*Math.cos(Math.PI/90) - tmpY*Math.sin(Math.PI/90));
			point.setY(tmpX*Math.sin(Math.PI/90) + tmpY*Math.cos(Math.PI/90));		
		}
	}
	
	/**
	 * Effectue une rotation n�gative autour de l'axe Z.
	 * @param fig Mod�le GTS
	 */
	public static void rotationZMoins(Figure fig){
		List<Point> points = fig.getLoader().getListeDePoints();
		for(Point point : points){
			double tmpX = point.getX();
			double tmpY = point.getY();
			point.setX(tmpX*Math.cos(Math.PI/90) + tmpY*Math.sin(Math.PI/90));
			point.setY(-tmpX*Math.sin(Math.PI/90) + tmpY*Math.cos(Math.PI/90));		
		}
	}
}