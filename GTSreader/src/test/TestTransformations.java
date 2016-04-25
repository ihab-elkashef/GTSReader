package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import prgm.Figure;
import prgm.Rotation;
import prgm.Symetrie;
import prgm.Translation;
import prgm.Zoom;

public class TestTransformations {

	private Figure figureModif, figureDeBase;

	@Before
	public void setUp() throws Exception {
		figureModif = new Figure("/gts/cube.gts");
		figureDeBase = new Figure("/gts/cube.gts");
	}


	@Test
	public void testZoomMoins() {
		Zoom.zoomMoins(figureModif);
		for(int i=0; i< figureModif.getLoader().getListeDePoints().size(); i++){
			assertTrue(figureDeBase.getLoader().getListeDePoints().get(i).getX()*0.50 == figureModif.getLoader().getListeDePoints().get(i).getX());
			assertTrue(figureDeBase.getLoader().getListeDePoints().get(i).getY()*0.50 == figureModif.getLoader().getListeDePoints().get(i).getY());
			assertTrue(figureDeBase.getLoader().getListeDePoints().get(i).getZ()*0.50 == figureModif.getLoader().getListeDePoints().get(i).getZ());
		}
	}

	@Test
	public void testZoomPlus() {
		Zoom.zoomPlus(figureModif);
		for(int i=0; i< figureModif.getLoader().getListeDePoints().size(); i++){
			assertTrue(figureDeBase.getLoader().getListeDePoints().get(i).getX()*2.00 == figureModif.getLoader().getListeDePoints().get(i).getX());
			assertTrue(figureDeBase.getLoader().getListeDePoints().get(i).getY()*2.00 == figureModif.getLoader().getListeDePoints().get(i).getY());
			assertTrue(figureDeBase.getLoader().getListeDePoints().get(i).getZ()*2.00 == figureModif.getLoader().getListeDePoints().get(i).getZ());
		}
	}

	@Test
	public void testTranslationVersLaDroite() {
		Translation.translationHorizDroit(figureModif, 1);
		for(int i=0; i< figureModif.getLoader().getListeDePoints().size(); i++){
			assertTrue(figureDeBase.getLoader().getListeDePoints().get(i).getX()+1 == figureModif.getLoader().getListeDePoints().get(i).getX());
		}
	}

	@Test
	public void testTranslationVersLaGauche() {
		Translation.translationHorizGauche(figureModif, 1);
		for(int i=0; i< figureModif.getLoader().getListeDePoints().size(); i++){
			assertTrue(figureDeBase.getLoader().getListeDePoints().get(i).getX()-1 == figureModif.getLoader().getListeDePoints().get(i).getX());
		}
	}

	@Test
	public void testTranslationVersLeHaut() {
		Translation.translationVertiHaut(figureModif, 1);
		for(int i=0; i< figureModif.getLoader().getListeDePoints().size(); i++){
			assertTrue(figureDeBase.getLoader().getListeDePoints().get(i).getY()-1 == figureModif.getLoader().getListeDePoints().get(i).getY());
		}
	}

	@Test
	public void testTranslationVersLeBas() {
		Translation.translationVertiBas(figureModif, 1);
		for(int i=0; i< figureModif.getLoader().getListeDePoints().size(); i++){
			assertTrue(figureDeBase.getLoader().getListeDePoints().get(i).getY()+1 == figureModif.getLoader().getListeDePoints().get(i).getY());
		}
	}

	@Test
	public void testRotationVersLeHaut() {
		Rotation.rotationVersLeHaut(figureModif);
		double tmpY,tmpZ;
		for(int i=0; i< figureModif.getLoader().getListeDePoints().size(); i++){
			tmpY = figureDeBase.getLoader().getListeDePoints().get(i).getY();
			tmpZ = figureDeBase.getLoader().getListeDePoints().get(i).getZ();
			assertTrue((tmpY*Math.cos(Math.PI/90) - tmpZ*Math.sin(Math.PI/90)) == figureModif.getLoader().getListeDePoints().get(i).getY());
			assertTrue((tmpY*Math.sin(Math.PI/90) + tmpZ*Math.cos(Math.PI/90)) == figureModif.getLoader().getListeDePoints().get(i).getZ());
		}
	}

	@Test
	public void testRotationVersLeBas() {
		Rotation.rotationVersLeBas(figureModif);
		double tmpY,tmpZ;
		for(int i=0; i< figureModif.getLoader().getListeDePoints().size(); i++){
			tmpY = figureDeBase.getLoader().getListeDePoints().get(i).getY();
			tmpZ = figureDeBase.getLoader().getListeDePoints().get(i).getZ();
			assertTrue((tmpY*Math.cos(Math.PI/90) + tmpZ*Math.sin(Math.PI/90)) == figureModif.getLoader().getListeDePoints().get(i).getY());
			assertTrue((-tmpY*Math.sin(Math.PI/90) + tmpZ*Math.cos(Math.PI/90)) == figureModif.getLoader().getListeDePoints().get(i).getZ());
		}
	}

	@Test
	public void testRotationVersLaGauche() {
		Rotation.rotationVersLaGauche(figureModif);
		double tmpX,tmpZ;
		for(int i=0; i< figureModif.getLoader().getListeDePoints().size(); i++){
			tmpX = figureDeBase.getLoader().getListeDePoints().get(i).getX();
			tmpZ = figureDeBase.getLoader().getListeDePoints().get(i).getZ();
			assertTrue((tmpX*Math.cos(Math.PI/90) + tmpZ*Math.sin(Math.PI/90)) == figureModif.getLoader().getListeDePoints().get(i).getX());
			assertTrue((-tmpX*Math.sin(Math.PI/90) + tmpZ*Math.cos(Math.PI/90)) == figureModif.getLoader().getListeDePoints().get(i).getZ());
		}
	}

	@Test
	public void testRotationVersLaDroite() {
		Rotation.rotationVersLaDroite(figureModif);
		double tmpX,tmpZ;
		for(int i=0; i< figureModif.getLoader().getListeDePoints().size(); i++){
			tmpX = figureDeBase.getLoader().getListeDePoints().get(i).getX();
			tmpZ = figureDeBase.getLoader().getListeDePoints().get(i).getZ();
			assertTrue((tmpX*Math.cos(Math.PI/90) + tmpZ*Math.sin(Math.PI/90)) == figureModif.getLoader().getListeDePoints().get(i).getX());
			assertTrue((-tmpX*Math.sin(Math.PI/90) + tmpZ*Math.cos(Math.PI/90)) == figureModif.getLoader().getListeDePoints().get(i).getZ());
		}
	}

	@Test
	public void testRotationZPlus() {
		Rotation.rotationZPlus(figureModif);
		double tmpX,tmpY;
		for(int i=0; i< figureModif.getLoader().getListeDePoints().size(); i++){
			tmpX = figureDeBase.getLoader().getListeDePoints().get(i).getX();
			tmpY = figureDeBase.getLoader().getListeDePoints().get(i).getY();
			assertTrue((tmpX*Math.cos(Math.PI/90) - tmpY*Math.sin(Math.PI/90)) == figureModif.getLoader().getListeDePoints().get(i).getX());
			assertTrue((tmpX*Math.sin(Math.PI/90) + tmpY*Math.cos(Math.PI/90)) == figureModif.getLoader().getListeDePoints().get(i).getY());
		}
	}

	@Test
	public void testRotationZMoins() {
		Rotation.rotationZMoins(figureModif);
		double tmpX,tmpY;
		for(int i=0; i< figureModif.getLoader().getListeDePoints().size(); i++){
			tmpX = figureDeBase.getLoader().getListeDePoints().get(i).getX();
			tmpY = figureDeBase.getLoader().getListeDePoints().get(i).getY();
			assertTrue((tmpX*Math.cos(Math.PI/90) + tmpY*Math.sin(Math.PI/90)) == figureModif.getLoader().getListeDePoints().get(i).getX());
			assertTrue((-tmpX*Math.sin(Math.PI/90) + tmpY*Math.cos(Math.PI/90)) == figureModif.getLoader().getListeDePoints().get(i).getY());
		}
	}
	
	@Test
	public void testsymetrieHorizontale() {
		Symetrie.symetrieHorizontale(figureModif);
		for(int i=0; i< figureModif.getLoader().getListeDePoints().size(); i++){
			assertTrue(figureDeBase.getLoader().getListeDePoints().get(i).getX()*-1 == figureModif.getLoader().getListeDePoints().get(i).getX());
		}
	}
	
	@Test
	public void testsymetrieVerticale() {
		Symetrie.symetrieVerticale(figureModif);
		for(int i=0; i< figureModif.getLoader().getListeDePoints().size(); i++){
			assertTrue(figureDeBase.getLoader().getListeDePoints().get(i).getY()*-1 == figureModif.getLoader().getListeDePoints().get(i).getY());
		}
	}




}
