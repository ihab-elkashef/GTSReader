package prgm;
import java.util.List;


public class Symetrie {
	
	private static boolean symetrieHoriz = false;
	private static boolean symetrieVerti = false;
	
	public static void symetrieHorizontale(Figure fig){
		List<Point> points = fig.getLoader().getListeDePoints();
		int size = points.size();
		for(int i=0 ; i < size ; i++){
			points.get(i).setX(points.get(i).getX()*-1);
		}
		symetrieHoriz = !symetrieHoriz;
	}
	public static void symetrieVerticale(Figure fig){
		List<Point> points = fig.getLoader().getListeDePoints();
		int size = points.size();
		for(int i=0 ; i < size ; i++){
			points.get(i).setY(points.get(i).getY()*-1);
		}
		symetrieVerti = !symetrieVerti;
	}
	
	public static boolean getSymetrieHoriz(){
		return symetrieHoriz;
	}
	public static void setSymetrieHoriz(boolean s){
		symetrieHoriz = s;
	}
	public static boolean getSymetrieVerti(){
		return symetrieVerti;
	}
	public static void setSymetrieVerti(boolean s){
		symetrieVerti = s;
	}
}