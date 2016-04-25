package test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import prgm.Face;
import prgm.FigureLoader;
import prgm.Point;
import prgm.Segment;


public class TestFigure {
	FigureLoader figure;
	private List<Point> listeDePoints;
	private List<Segment> listeDeSegments;
	private List<Face> listeDeFaces;

	@Before
	public void setUp() throws Exception {
		figure = new FigureLoader("/gts/cube.gts");
		listeDePoints = new ArrayList<Point>(); remplirlistePoint();
		listeDeSegments = new ArrayList<Segment>(); remplirlisteSegment();
		listeDeFaces = new ArrayList<Face>(); remplirlisteFace();
	}
	
	public void remplirlistePoint(){
		listeDePoints.add(new Point(0.0, -1.63299, -1.1547));
		listeDePoints.add(new Point(-1.63299, 0.0, -1.1547));
		listeDePoints.add(new Point(0.0, 1.63299, -1.1547));
		listeDePoints.add(new Point(1.63299, 0.0, -1.1547));
		listeDePoints.add(new Point(0.0, -1.63299, 1.1547));
		listeDePoints.add(new Point(-1.63299, 0.0, 1.1547));
		listeDePoints.add(new Point(0.0, 1.63299, 1.1547));
		listeDePoints.add(new Point(1.63299, 0.0, 1.1547));
	}
	
	public void remplirlisteSegment(){
		listeDeSegments.add(new Segment(listeDePoints.get(2), listeDePoints.get(0)));
		listeDeSegments.add(new Segment(listeDePoints.get(1), listeDePoints.get(0)));
		listeDeSegments.add(new Segment(listeDePoints.get(5), listeDePoints.get(0)));
		listeDeSegments.add(new Segment(listeDePoints.get(1), listeDePoints.get(5)));
		listeDeSegments.add(new Segment(listeDePoints.get(1), listeDePoints.get(6)));
		listeDeSegments.add(new Segment(listeDePoints.get(2), listeDePoints.get(1)));
		listeDeSegments.add(new Segment(listeDePoints.get(2), listeDePoints.get(6)));
		listeDeSegments.add(new Segment(listeDePoints.get(2), listeDePoints.get(7)));
		listeDeSegments.add(new Segment(listeDePoints.get(3), listeDePoints.get(2)));
		listeDeSegments.add(new Segment(listeDePoints.get(3), listeDePoints.get(7)));
		listeDeSegments.add(new Segment(listeDePoints.get(4), listeDePoints.get(0)));
		listeDeSegments.add(new Segment(listeDePoints.get(3), listeDePoints.get(4)));
		listeDeSegments.add(new Segment(listeDePoints.get(0), listeDePoints.get(3)));
		listeDeSegments.add(new Segment(listeDePoints.get(5), listeDePoints.get(4)));
		listeDeSegments.add(new Segment(listeDePoints.get(6), listeDePoints.get(5)));
		listeDeSegments.add(new Segment(listeDePoints.get(4), listeDePoints.get(7)));
		listeDeSegments.add(new Segment(listeDePoints.get(6), listeDePoints.get(4)));
		listeDeSegments.add(new Segment(listeDePoints.get(7), listeDePoints.get(6)));
	}
	
	public void remplirlisteFace(){
		listeDeFaces.add(new Face(listeDeSegments.get(8), listeDeSegments.get(12), listeDeSegments.get(0)));
		listeDeFaces.add(new Face(listeDeSegments.get(5), listeDeSegments.get(0), listeDeSegments.get(1)));
		listeDeFaces.add(new Face(listeDeSegments.get(3), listeDeSegments.get(1), listeDeSegments.get(2)));
		listeDeFaces.add(new Face(listeDeSegments.get(13), listeDeSegments.get(2), listeDeSegments.get(10)));
		listeDeFaces.add(new Face(listeDeSegments.get(3), listeDeSegments.get(14), listeDeSegments.get(4)));
		listeDeFaces.add(new Face(listeDeSegments.get(5), listeDeSegments.get(4), listeDeSegments.get(6)));
		listeDeFaces.add(new Face(listeDeSegments.get(6), listeDeSegments.get(17), listeDeSegments.get(7)));
		listeDeFaces.add(new Face(listeDeSegments.get(8), listeDeSegments.get(7), listeDeSegments.get(9)));
		listeDeFaces.add(new Face(listeDeSegments.get(9), listeDeSegments.get(15), listeDeSegments.get(11)));
		listeDeFaces.add(new Face(listeDeSegments.get(12), listeDeSegments.get(11), listeDeSegments.get(10)));
		listeDeFaces.add(new Face(listeDeSegments.get(14), listeDeSegments.get(13), listeDeSegments.get(16)));
		listeDeFaces.add(new Face(listeDeSegments.get(17), listeDeSegments.get(16), listeDeSegments.get(15)));
	}
	

	@Test
	public void testListpointPasVide() {
		assertFalse(figure.getListeDePoints().isEmpty());
	}
	
	@Test
	public void testListSegmentPasVide() {
		assertFalse(figure.getListeDeSegments().isEmpty());
	}
	
	
	public void testListFacetPasVide() {
		assertFalse(figure.getListeDeFaces().isEmpty());
	}
	
	@Test
	public void testListPointBienRempli() {
		for(int i=0; i<figure.getListeDePoints().size();i++){
			assertTrue(listeDePoints.get(i).getX() == figure.getListeDePoints().get(i).getX());	
			assertTrue(listeDePoints.get(i).getY() == figure.getListeDePoints().get(i).getY());
			assertTrue(listeDePoints.get(i).getZ() == figure.getListeDePoints().get(i).getZ());	
		}
	}

	@Test
	public void testListSegBienRempli() {
		for(int i=0; i<figure.getListeDeSegments().size();i++){
			//Test pour le point1 en parametre de l'objet segment
			assertTrue(listeDeSegments.get(i).getPt1().getX() == figure.getListeDeSegments().get(i).getPt1().getX());
			assertTrue(listeDeSegments.get(i).getPt1().getY() == figure.getListeDeSegments().get(i).getPt1().getY());
			assertTrue(listeDeSegments.get(i).getPt1().getZ() == figure.getListeDeSegments().get(i).getPt1().getZ());
			
			//Test pour le point2 en parametre de l'objet segment
			assertTrue(listeDeSegments.get(i).getPt2().getX() == figure.getListeDeSegments().get(i).getPt2().getX());
			assertTrue(listeDeSegments.get(i).getPt2().getY() == figure.getListeDeSegments().get(i).getPt2().getY());
			assertTrue(listeDeSegments.get(i).getPt2().getZ() == figure.getListeDeSegments().get(i).getPt2().getZ());
		}
	}
	
	@Test
	public void testListFaceBienRempli() {
		for(int i=0; i<figure.getListeDeFaces().size();i++){
			//test pour le segment1 un en parametre de l'objet face
			
			assertTrue(listeDeFaces.get(i).getSeg1().getPt1().getX() == figure.getListeDeFaces().get(i).getSeg1().getPt1().getX());
			assertTrue(listeDeFaces.get(i).getSeg1().getPt1().getY() == figure.getListeDeFaces().get(i).getSeg1().getPt1().getY());
			assertTrue(listeDeFaces.get(i).getSeg1().getPt1().getZ() == figure.getListeDeFaces().get(i).getSeg1().getPt1().getZ());
			
			assertTrue(listeDeFaces.get(i).getSeg1().getPt2().getX() == figure.getListeDeFaces().get(i).getSeg1().getPt2().getX());
			assertTrue(listeDeFaces.get(i).getSeg1().getPt2().getY() == figure.getListeDeFaces().get(i).getSeg1().getPt2().getY());
			assertTrue(listeDeFaces.get(i).getSeg1().getPt2().getZ() == figure.getListeDeFaces().get(i).getSeg1().getPt2().getZ());
			
			//test pour le segment3 un en parametre de l'objet face
			assertTrue(listeDeFaces.get(i).getSeg2().getPt1().getX() == figure.getListeDeFaces().get(i).getSeg2().getPt1().getX());
			assertTrue(listeDeFaces.get(i).getSeg2().getPt1().getY() == figure.getListeDeFaces().get(i).getSeg2().getPt1().getY());
			assertTrue(listeDeFaces.get(i).getSeg2().getPt1().getZ() == figure.getListeDeFaces().get(i).getSeg2().getPt1().getZ());
			
			assertTrue(listeDeFaces.get(i).getSeg2().getPt2().getX() == figure.getListeDeFaces().get(i).getSeg2().getPt2().getX());
			assertTrue(listeDeFaces.get(i).getSeg2().getPt2().getY() == figure.getListeDeFaces().get(i).getSeg2().getPt2().getY());
			assertTrue(listeDeFaces.get(i).getSeg2().getPt2().getZ() == figure.getListeDeFaces().get(i).getSeg2().getPt2().getZ());
			
			//test pour le segment3 un en parametre de l'objet face
			assertTrue(listeDeFaces.get(i).getSeg3().getPt1().getX() == figure.getListeDeFaces().get(i).getSeg3().getPt1().getX());
			assertTrue(listeDeFaces.get(i).getSeg3().getPt1().getY() == figure.getListeDeFaces().get(i).getSeg3().getPt1().getY());
			assertTrue(listeDeFaces.get(i).getSeg3().getPt1().getZ() == figure.getListeDeFaces().get(i).getSeg3().getPt1().getZ());
			
			assertTrue(listeDeFaces.get(i).getSeg3().getPt2().getX() == figure.getListeDeFaces().get(i).getSeg3().getPt2().getX());
			assertTrue(listeDeFaces.get(i).getSeg3().getPt2().getY() == figure.getListeDeFaces().get(i).getSeg3().getPt2().getY());
			assertTrue(listeDeFaces.get(i).getSeg3().getPt2().getZ() == figure.getListeDeFaces().get(i).getSeg3().getPt2().getZ());	
		}
	}
	

	@Test
	public void testPointsConfondus() {
		/*Dans un triangle il y a 3 sommets, les points sont donc confondus
		 *  à 3 endroits que l'on va vérifier grace à cette variable*/ 
		final int NbSommet = 3;
		int confondu;
		for(int i=0; i<figure.getListeDeFaces().size();i++){
			confondu = 0;
			//verification du premier sommet
			if(figure.getListeDeFaces().get(i).getSeg1().getPt1().equals(figure.getListeDeFaces().get(i).getSeg2().getPt1()) || 
				figure.getListeDeFaces().get(i).getSeg1().getPt1().equals(figure.getListeDeFaces().get(i).getSeg2().getPt2())){
				confondu++;
			}else if(figure.getListeDeFaces().get(i).getSeg1().getPt1().equals(figure.getListeDeFaces().get(i).getSeg3().getPt1()) || 
					figure.getListeDeFaces().get(i).getSeg1().getPt1().equals(figure.getListeDeFaces().get(i).getSeg3().getPt2())){
					confondu++;
			}
			
			//verification du deuxieme sommet
			if(figure.getListeDeFaces().get(i).getSeg1().getPt2().equals(figure.getListeDeFaces().get(i).getSeg2().getPt1()) || 
					figure.getListeDeFaces().get(i).getSeg1().getPt2().equals(figure.getListeDeFaces().get(i).getSeg2().getPt2())){
					confondu++;
				}else if(figure.getListeDeFaces().get(i).getSeg1().getPt2().equals(figure.getListeDeFaces().get(i).getSeg3().getPt1()) || 
						figure.getListeDeFaces().get(i).getSeg1().getPt2().equals(figure.getListeDeFaces().get(i).getSeg3().getPt2())){
						confondu++;
				}
			
			//Verification du troisieme sommet
			if(figure.getListeDeFaces().get(i).getSeg2().getPt1().equals(figure.getListeDeFaces().get(i).getSeg3().getPt1()) || 
					figure.getListeDeFaces().get(i).getSeg2().getPt1().equals(figure.getListeDeFaces().get(i).getSeg3().getPt2())){
					confondu++;
				}else if(figure.getListeDeFaces().get(i).getSeg2().getPt2().equals(figure.getListeDeFaces().get(i).getSeg3().getPt1()) || 
						figure.getListeDeFaces().get(i).getSeg2().getPt2().equals(figure.getListeDeFaces().get(i).getSeg3().getPt2())){
						confondu++;
				}
			
			//On teste s'il y bien sommets confondu
			assertEquals(confondu, NbSommet);
				
		}
	}
	
	
}
