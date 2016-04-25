package ihm;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.ResultSet;

import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import bdd.Database;
import prgm.Figure;
import prgm.Rotation;
import prgm.Symetrie;
import prgm.Translation;
import prgm.Zoom;


public class DisplayListener implements ActionListener {

	private Display disp;
	private final int ROTATION_SPEED = 10;
	
	public DisplayListener(Display display) {
		// TODO Auto-generated constructor stub
		disp = display;
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(disp.getHautZ())){
			Zoom.zoomPlus(disp.getGtsDisplay());
			disp.revalidate();
			disp.repaint();
			disp.getGtsDisplay().revalidate();
			disp.getGtsDisplay().repaint();
		}
		if(e.getSource().equals(disp.getBasZ())){
			Zoom.zoomMoins(disp.getGtsDisplay());
			disp.revalidate();
			disp.repaint();
			disp.getGtsDisplay().revalidate();
			disp.getGtsDisplay().repaint();
		}
		if(e.getSource().equals(disp.getHaut())){
			Translation.translationVertiHaut(disp.getGtsDisplay(), Translation.DEFAULT_SPEED);
			disp.revalidate();
			disp.repaint();
			disp.getGtsDisplay().revalidate();
			disp.getGtsDisplay().repaint();
		}
		if(e.getSource().equals(disp.getBas())){
			Translation.translationVertiBas(disp.getGtsDisplay(), Translation.DEFAULT_SPEED);
			disp.revalidate();
			disp.repaint();
			disp.getGtsDisplay().revalidate();
			disp.getGtsDisplay().repaint();
		}
		if(e.getSource().equals(disp.getGauche())){
			Translation.translationHorizGauche(disp.getGtsDisplay(), Translation.DEFAULT_SPEED);
			disp.revalidate();
			disp.repaint();
			disp.getGtsDisplay().revalidate();
			disp.getGtsDisplay().repaint();
		}
		if(e.getSource().equals(disp.getDroite())){
			Translation.translationHorizDroit(disp.getGtsDisplay(), Translation.DEFAULT_SPEED);
			disp.revalidate();
			disp.repaint();
			disp.getGtsDisplay().revalidate();
			disp.getGtsDisplay().repaint();
		}
		if(e.getSource().equals(disp.getHautR())){
			for(int i=0 ; i<ROTATION_SPEED ; i++){
				Rotation.rotationVersLeHaut(disp.getGtsDisplay());
			}
			disp.revalidate();
			disp.repaint();
			disp.getGtsDisplay().revalidate();
			disp.getGtsDisplay().repaint();
		}
		if(e.getSource().equals(disp.getBasR())){
			for(int i=0 ; i<ROTATION_SPEED ; i++){
				Rotation.rotationVersLeBas(disp.getGtsDisplay());
			}
			disp.revalidate();
			disp.repaint();
			disp.getGtsDisplay().revalidate();
			disp.getGtsDisplay().repaint();
		}
		if(e.getSource().equals(disp.getGaucheR())){
			for(int i=0 ; i<ROTATION_SPEED ; i++){
				Rotation.rotationVersLaGauche(disp.getGtsDisplay());
			}
			disp.revalidate();
			disp.repaint();
			disp.getGtsDisplay().revalidate();
			disp.getGtsDisplay().repaint();
		}
		if(e.getSource().equals(disp.getDroiteR())){
			for(int i=0 ; i<ROTATION_SPEED ; i++){
				Rotation.rotationVersLaDroite(disp.getGtsDisplay());
			}
			disp.revalidate();
			disp.repaint();
			disp.getGtsDisplay().revalidate();
			disp.getGtsDisplay().repaint();
		}
		if(e.getSource().equals(disp.getQuitter())){
			System.exit(0);
		}
		if(e.getSource().equals(disp.getCouleurModele())){
			Color couleur = JColorChooser.showDialog (null, "Couleur du modï¿½le", Color.BLACK);
			if(couleur != null){
				disp.setColorModele(couleur);
				disp.getGtsDisplay().setColor(couleur);
				Figure.setMultiColore(false);
			}
			disp.revalidate();
			disp.repaint();
			disp.getGtsDisplay().revalidate();
			disp.getGtsDisplay().repaint();
		}
		if(e.getSource().equals(disp.getCouleurFond())){
			Color couleur = JColorChooser.showDialog (null, "Couleur du fond", UIManager.getColor("Panel.background"));
			if(couleur != null)
				disp.getLeft().setBackground(couleur);
			disp.revalidate();
			disp.repaint();
			disp.getLeft().revalidate();
			disp.getLeft().repaint();
		}
		if(e.getSource().equals(disp.getCouleurMulti())){
			Figure.setMultiColore(!Figure.isMultiColore());
			if(!Figure.isMultiColore()){
				disp.getCouleurMulti().setText("Activer le mode multicolore");
			} else {
				disp.getCouleurMulti().setText("Dï¿½sactiver le mode multicolore");
			}
			disp.revalidate();
			disp.repaint();
			disp.getGtsDisplay().revalidate();
			disp.getGtsDisplay().repaint();
		}
		if(e.getSource().equals(disp.getSymetrieHoriz())){
			Symetrie.symetrieHorizontale(disp.getGtsDisplay());
			disp.revalidate();
			disp.repaint();
			disp.getGtsDisplay().revalidate();
			disp.getGtsDisplay().repaint();
		}
		if(e.getSource().equals(disp.getSymetrieVerti())){
			Symetrie.symetrieVerticale(disp.getGtsDisplay());
			disp.revalidate();
			disp.repaint();
			disp.getGtsDisplay().revalidate();
			disp.getGtsDisplay().repaint();
		}
		if(e.getSource().equals(disp.getReset())){
			Symetrie.setSymetrieHoriz(false);
			Symetrie.setSymetrieVerti(false);
			Zoom.setZoomCurrent(Zoom.NO_ZOOM);
			Figure.setMultiColore(false);
			disp.getCouleurMulti().setText("Activer le mode multicolore");
			disp.getLeft().removeAll();
			Figure fig = new Figure(disp.getUrl());
			fig.setOpaque(false);
			fig.setColor(Color.BLACK);
			disp.setColorModele(Color.BLACK);
			disp.getLeft().setBackground(UIManager.getColor("Panel.background"));
			disp.setGtsDisplay(fig);
			disp.getLeft().add(fig);
			disp.revalidate();
			disp.repaint();
			disp.getGtsDisplay().revalidate();
			disp.getGtsDisplay().repaint();
		}
		if(e.getSource().equals(disp.getHideListeItem())){
			disp.hideListe();
		}
		if(e.getSource().equals(disp.getHideCtrlPannelItem())){
			disp.hideCtrlPannel();
		}
		if(e.getSource().equals(disp.getAPropos())){
			JOptionPane.showMessageDialog(null, "Ce programme a ï¿½tï¿½ dï¿½veloppï¿½ dans le cadre du projet de S3\ndu DUT informatique de l'IUT Lille A par les ï¿½tudiants suivants :\n- LEFEBVRE Benjamin\n- ZIYADI Bader\n- NJIEDJOUK Zachï¿½\n- EL KASHEF Ihab", "A propos de : GTS Reader", JOptionPane.INFORMATION_MESSAGE);
		}
		if(e.getSource().equals(disp.getEnregistrer())){
			try {
				JFileChooser fileChooser = new JFileChooser();
				int returnVal = fileChooser.showDialog(null, "Enregistrer");
				if(returnVal == JFileChooser.APPROVE_OPTION)
					disp.getGtsDisplay().enregistrer(fileChooser.getSelectedFile().getAbsolutePath());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.getMessage();
			}
		}
		if(e.getSource().equals(disp.getModifTags())){
			try {
				Database db = new Database();
				db.connect();
				ResultSet rs = db.getResultOf("Select * from gts where path='"+disp.getUrl()+"';");
				String tags = rs.getString(2);
				tags = JOptionPane.showInputDialog("Mot clé :", tags);
				db.updateValue("Update gts set tags='"+tags+"' where path='"+disp.getUrl()+"';");
				db.disconnect();
			} catch(Exception ex){
				System.out.println(ex.getMessage());
			}
		}
		if(e.getSource().equals(disp.getRechercher())){
			try {
				String tags = JOptionPane.showInputDialog("Veuillez entrer un mot clé :", "");
				Database db = new Database();
				db.connect();
				ResultSet rs = db.getResultOf("Select * from gts where tags='"+tags+"';");
				String retour = "";
				boolean empty = true;
				while(rs.next()){
					empty = false;
					retour += rs.getString(1)+"\n";
				}
				if(empty)
					retour = "Aucun résultat";
				JOptionPane.showMessageDialog(disp, retour, "Résultat de la recherche", JOptionPane.INFORMATION_MESSAGE);
				db.disconnect();
			} catch(Exception ex){
				System.out.println(ex.getMessage());
			}
		}
	}
}
