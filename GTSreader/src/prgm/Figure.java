package prgm;
import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import javax.swing.JPanel;


public class Figure extends JPanel {

	private static final long serialVersionUID = 1L;

	private FigureLoader loader;
	private Color color = Color.BLACK;
	private static boolean multiColore = false;

	public Figure(String cheminFichierGTS) {
		try {
			loader = new FigureLoader(cheminFichierGTS);
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Dessine le mod��le 3D.
	 * @param g Graphics
	 */
	public void paintModel(Graphics g){
		if(multiColore){
			color = new Color(new Random().nextInt(255), new Random().nextInt(255), new Random().nextInt(255));
		}
		int[] tabX = new int[4];
		int[] tabY = new int[4];

		final int xSize = this.getWidth()/2;
		final int ySize = this.getHeight()/2;

		for (Face face : this.loader.getListeDeFaces()){
			g.setColor(eclairage(face));

			tabX[0] = (int) face.getSeg1().getPt1().getX() + xSize;
			tabY[0] = (int) face.getSeg1().getPt1().getY() + ySize;
			tabX[1] = (int) face.getSeg1().getPt2().getX() + xSize;
			tabY[1] = (int) face.getSeg1().getPt2().getY() + ySize;
			tabX[2] = (int) face.getSeg2().getPt2().getX() + xSize;
			tabY[2] = (int) face.getSeg2().getPt2().getY() + ySize;

			g.fillPolygon(tabX, tabY, 3);

			tabX[0] = (int) face.getSeg1().getPt1().getX() + xSize;
			tabY[0] = (int) face.getSeg1().getPt1().getY() + ySize;
			tabX[1] = (int) face.getSeg2().getPt1().getX() + xSize;
			tabY[1] = (int) face.getSeg2().getPt1().getY() + ySize;
			tabX[2] = (int) face.getSeg2().getPt2().getX() + xSize;
			tabY[2] = (int) face.getSeg2().getPt2().getY() + ySize;

			g.fillPolygon(tabX, tabY, 3);

			tabX[0] = (int) face.getSeg1().getPt2().getX() + xSize;
			tabY[0] = (int) face.getSeg1().getPt2().getY() + ySize;
			tabX[1] = (int) face.getSeg2().getPt1().getX() + xSize;
			tabY[1] = (int) face.getSeg2().getPt1().getY() + ySize;
			tabX[2] = (int) face.getSeg2().getPt2().getX() + xSize;
			tabY[2] = (int) face.getSeg2().getPt2().getY() + ySize;

			g.fillPolygon(tabX, tabY, 3);

			tabX[0] = (int) face.getSeg1().getPt1().getX() + xSize;
			tabY[0] = (int) face.getSeg1().getPt1().getY() + ySize;
			tabX[1] = (int) face.getSeg1().getPt2().getX() + xSize;
			tabY[1] = (int) face.getSeg1().getPt2().getY() + ySize;
			tabX[2] = (int) face.getSeg2().getPt1().getX() + xSize;
			tabY[2] = (int) face.getSeg2().getPt1().getY() + ySize;

			g.fillPolygon(tabX, tabY, 3);
		}
	}

	public Color eclairage(Face face){
		//Recuperation de deux vecteurs directeur du plan "face"
		Point u = face.getSeg1().getPt1();
		Point v = face.getSeg2().getPt2();  //on les stocke dans des Point car c plus facile a manipuler et tout comme un point, un vecteur contient 3 composantes x, y, z

		//Creation du vecteur normal
		Point n = u.vectoriel(v);
		n.vecteurUnitaire();

		Point source = new Point(0, 0, -1); // on a d��cid�� de toujours d��finir la source par rapport au point (0, 0, 1)

		double angle = Math.abs(n.scalaire(source));

		float[] hsbCol = Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), null);
		hsbCol[2] = (float) angle;
		return Color.getHSBColor(hsbCol[0], hsbCol[1], hsbCol[2]);
	}

	/**
	 * La fonction prend en paramètre le chemin absolu du fichier gts qui sera créé avecS les nouvelles valeurs
	 * sont stockées
	 */
	public void enregistrer(String cheminAbsolu) throws IOException{
		File file = new File(cheminAbsolu);
		file.createNewFile();
		FileWriter fichier = new FileWriter(file);
		
		for (int i = 0 ; i < loader.getListeDePoints().size() ; i++){
			fichier.write(Double.toString(loader.getListeDePoints().get(i).getX()));
			fichier.write(" ");
			fichier.write(Double.toString(loader.getListeDePoints().get(i).getY()));
			fichier.write(" ");
			fichier.write(Double.toString(loader.getListeDePoints().get(i).getZ()));
			fichier.write("\r\n");
		}

		for (int i = 0 ; i < loader.getListeDeSegments().size() ; i++){
			fichier.write(Integer.toString(loader.getListeDePoints().indexOf(loader.getListeDeSegments().get(i).getPt1())));
			fichier.write(" ");
			fichier.write(Integer.toString(loader.getListeDePoints().indexOf(loader.getListeDeSegments().get(i).getPt2())));
			fichier.write("\r\n");
		}

		for (int i = 0 ; i < loader.getListeDeFaces().size() ; i++){
			fichier.write(Integer.toString(loader.getListeDeSegments().indexOf(loader.getListeDeFaces().get(i).getSeg1())));
			fichier.write(" ");
			fichier.write(Integer.toString(loader.getListeDeSegments().indexOf(loader.getListeDeFaces().get(i).getSeg2())));
			fichier.write(" ");
			fichier.write(Integer.toString(loader.getListeDeSegments().indexOf(loader.getListeDeFaces().get(i).getSeg3())));
			fichier.write("\r\n");
		}
		fichier.close();
	}

	public void paintComponent(Graphics g){
		super.paintComponents(g);
		this.paintModel(g);
		this.setOpaque(false);
	}

	public FigureLoader getLoader() {
		return loader;
	}
	public void setLoader(FigureLoader loader) {
		this.loader = loader;
	}
	public Color getColor(){
		return this.color;
	}
	public void setColor(Color color){
		this.color = color;
	}
	public static boolean isMultiColore() {
		return multiColore;
	}
	public static void setMultiColore(boolean multiColore) {
		Figure.multiColore = multiColore;
	}
}