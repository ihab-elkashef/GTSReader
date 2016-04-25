package prgm;
import java.util.List;


public class Translation {
	
	public static final int DEFAULT_SPEED = 50;

	public static void translationHorizDroit(Figure fig, int speed){
		List<Point> points = fig.getLoader().getListeDePoints();
		int size = points.size();
		for(int i=0 ; i < size ; i++){
			points.get(i).setX(points.get(i).getX()+speed);
		}		
	}	
	public static void translationHorizGauche(Figure fig, int speed){
		List<Point> points = fig.getLoader().getListeDePoints();
		int size = points.size();
		for(int i=0 ; i < size ; i++){
			points.get(i).setX(points.get(i).getX()-speed);
		}
	}	
	public static void translationVertiBas(Figure fig, int speed){
		List<Point> points = fig.getLoader().getListeDePoints();
		int size = points.size();
		for(int i=0 ; i < size ; i++){
			points.get(i).setY(points.get(i).getY()+speed);
		}
	}
	public static void translationVertiHaut(Figure fig, int speed){
		List<Point> points = fig.getLoader().getListeDePoints();
		int size = points.size();
		for(int i=0 ; i < size ; i++){
			points.get(i).setY(points.get(i).getY()-speed);
		}
	}	
}