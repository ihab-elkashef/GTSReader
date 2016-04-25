package prgm;

import java.util.List;


public class Zoom {
	
	private static int currentZoom = 0;
	private static int MIN = -10;
	private static int MAX = 10;
	public static int NO_ZOOM = 0;

	public static void zoomPlus(Figure fig){
		if(currentZoom < MAX){
			List<Point> points = fig.getLoader().getListeDePoints();
			int size = points.size();
			for(int i=0 ; i < size ; i++){
				points.get(i).setX(points.get(i).getX()*2.00);
				points.get(i).setY(points.get(i).getY()*2.00);
				points.get(i).setZ(points.get(i).getZ()*2.00);
			}
			currentZoom++;
		}
	}
	public static void zoomMoins(Figure fig){
		if(currentZoom > MIN){
			List<Point> points = fig.getLoader().getListeDePoints();
			int size = points.size();
			for(int i=0 ; i < size ; i++){
				points.get(i).setX(points.get(i).getX()*0.50);
				points.get(i).setY(points.get(i).getY()*0.50);
				points.get(i).setZ(points.get(i).getZ()*0.50);
			}
			currentZoom--;
		}
	}
	
	public static void setZoomCurrent(int zoom){
		currentZoom = zoom;
	}
}
