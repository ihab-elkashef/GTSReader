package prgm;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class FigureLoader {
	
	private List<Point> listeDePoints = new ArrayList<Point>();
	private List<Segment> listeDeSegments = new ArrayList<Segment>();
	private List<Face> listeDeFaces = new ArrayList<Face>();
	
	public FigureLoader(String cheminFichierGTS) throws FileNotFoundException{

		Scanner s = new Scanner(getClass().getResourceAsStream(cheminFichierGTS));
		String ligne;
		
		//Parcours du fichier GTS ligne par ligne
		ligne = s.nextLine(); //Saute la premiere ligne où est specifié le nb de points, segments, faces.
		while (s.hasNextLine()){
			ligne = s.nextLine();
			String[] tab = ligne.split(" ");
			
			//Permet de vérifier que cette ligne correspond bien a des coordonnées de points
			if(tab.length == 3 && listeDeSegments.isEmpty()){
				listeDePoints.add(new Point(new Double((tab[0])), new Double(tab[1]), new Double(tab[2]))); //Les points sont stockés dans la liste
			} else if(tab.length == 2){ //Verifie que cette ligne correspond à des indices de segment
				listeDeSegments.add(new Segment(listeDePoints.get(Integer.parseInt(tab[0])-1), listeDePoints.get(Integer.parseInt(tab[1])-1))); //Les segments sont ajoutés dans la liste aprés avoir récupéré les points nécessaires dans listeDePoints
			} else {
				listeDeFaces.add(new Face(listeDeSegments.get(Integer.parseInt(tab[0])-1), listeDeSegments.get(Integer.parseInt(tab[1])-1), listeDeSegments.get(Integer.parseInt(tab[2])-1)));
			}
		}
		s.close();
	}

	public List<Point> getListeDePoints() {
		return listeDePoints;
	}
	public List<Segment> getListeDeSegments() {
		return listeDeSegments;
	}
	public List<Face> getListeDeFaces() {
		return listeDeFaces;
	}
}