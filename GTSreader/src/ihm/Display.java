package ihm;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import bdd.TableMaker;
import prgm.Figure;
import prgm.Zoom;

/**
 * Cette classe gère l'affichage de la fenêtre et de ses composants.
 * 
 */
public class Display extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private ActionListener listener = new DisplayListener(this);
	private KeyListener keyListener = new KeyboardListener(this);
	private MouseListener mouselistener = new DisplayMouseListener(this);
	private MouseWheelListener mouseWheelListener = new DisplayMouseWheelListener(this);
	private MouseMotionListener mouseMotionListener = new DisplayMouseMotionListener(this);
	
	private JPanel conteneur = new JPanel();
	
	private JMenuBar menu = new JMenuBar();
	private JMenu fichier = new JMenu("Fichier"), edition = new JMenu("Edition"), affichage = new JMenu("Affichage"), aide = new JMenu("?");
	private JMenuItem /*ouvrir = new JMenuItem("Ouvrir"),*/ enregistrer = new JMenuItem("Enregistrer la session"), modifTags = new JMenuItem("Modifier le mot clé"), rechercher = new JMenuItem("Recherche par mot clé"), quitter = new JMenuItem("Quitter");
	private JMenuItem couleurModele = new JMenuItem("Changer la couleur du modèle");
	private JMenuItem couleurFond = new JMenuItem("Changer la couleur du fond");
	private JMenuItem couleurMulti = new JMenuItem("Activer le mode multicolore");
	private JMenuItem symetrieHoriz = new JMenuItem("Retourner horizontalement");
	private JMenuItem symetrieVerti = new JMenuItem("Retourner verticalement");
	private JMenuItem reset = new JMenuItem("Réinitialiser");
	private JMenuItem hideListeItem = new JMenuItem("Cacher le volet de droite");
	private JMenuItem hideCtrlPannelItem = new JMenuItem("Cacher le panneau de contrôle");
	private JMenuItem aPropos = new JMenuItem("A propos de ...");
	
	private JSplitPane splitpane = new JSplitPane(JSplitPane.VERTICAL_SPLIT), splitpane2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
	private JPanel top = new JPanel(), bottom = new JPanel(), left = new JPanel(), right = new JPanel();
	/* "bottom" désigne le bas de la fenêtre, bottom1-2-3 désignent les divisions de celle-ci. */
	private JPanel bottom1 = new JPanel(), bottom2 = new JPanel(), bottom3 = new JPanel();
	
	/* hautZ, basZ = boutons de zoom */
	private JButton hautZ = new JButton(), basZ = new JButton();
	
	/* haut, bas, gauche, droite = boutons de translation */
	private JButton haut = new JButton(), bas = new JButton(), gauche = new JButton(), droite = new JButton();

	/* hautR, basR, gaucheR, droiteR = boutons de rotation */
	private JButton hautR = new JButton(), basR = new JButton(), gaucheR = new JButton(), droiteR = new JButton();
	
	private JList<String> listeGTS = new JList<String>();
	private boolean hideListe;
	private boolean hideCtrlPannel;
	private Figure gtsDisplay;
	private Color colorModele = Color.BLACK;
	private String url;
	
	/**
	 * Génère une fenêtre contenant tout les éléments du logiciel.
	 * @param url Chemin vers un fichier *.gts
	 */
	public Display(String url) {
		// TODO Auto-generated constructor stub
		this.url = url;
		gtsDisplay = new Figure(url);
		String[] data = new ListerRessources().genererTabGts();
		listeGTS = new JList<String>(data);
		listeGTS.addListSelectionListener(new ListSelectionListener() {
			
			public void valueChanged(ListSelectionEvent arg0) {
				// TODO Auto-generated method stub
				String item = listeGTS.getSelectedValue();
				Display.this.url = item;
				Zoom.setZoomCurrent(Zoom.NO_ZOOM);
				left.removeAll();
				gtsDisplay = new Figure(item);
				gtsDisplay.setColor(getColorModele());
				gtsDisplay.setOpaque(false);
				left.add(gtsDisplay);
				Display.this.setTitle(item+" - GTS Reader");
				Display.this.revalidate();
				Display.this.repaint();
				gtsDisplay.revalidate();
				gtsDisplay.repaint();
			}
		});
		
		left.setLayout(new GridLayout(1, 1));
		left.add(gtsDisplay);
		right.setLayout(new GridLayout(1, 1));
		right.add(listeGTS);
		
		splitpane2.setDividerLocation(800);
		splitpane2.add(left);
		splitpane2.add(right);
		
		top.setLayout(new GridLayout(1, 1));
		top.add(splitpane2);
		
		splitpane.setDividerLocation(550);
		splitpane.setEnabled(false);
		splitpane.add(top);
		splitpane.add(bottom);

		ImageIcon imgHaut = new ImageIcon(getClass().getResource("/img/flecheHaut.png"));
		ImageIcon imgBas = new ImageIcon(getClass().getResource("/img/flecheBas.png"));
		ImageIcon imgGauche = new ImageIcon(getClass().getResource("/img/flecheGauche.png"));
		ImageIcon imgDroite = new ImageIcon(getClass().getResource("/img/flecheDroite.png"));
		
		bottom.setLayout(new GridLayout(1, 3));
		
		bottom.add(bottom1); bottom.add(bottom2); bottom.add(bottom3);
		bottom2.setLayout(new GridLayout(4,3));
		bottom3.setLayout(new GridLayout(4,3));
		
		bottom1.setLayout(new GridLayout(4,1));
		bottom1.add(new JLabel("Zoom", SwingConstants.CENTER));
		hautZ.setIcon(imgHaut);
		hautZ.setBorderPainted(false);
		hautZ.setContentAreaFilled(false);
		bottom1.add(hautZ);
		bottom1.add(new JLabel());
		basZ.setIcon(imgBas);
		basZ.setBorderPainted(false);
		basZ.setContentAreaFilled(false);
		bottom1.add(basZ);
		
		haut.setIcon(imgHaut);
		haut.setBorderPainted(false);
		haut.setContentAreaFilled(false);
		bas.setIcon(imgBas);
		bas.setBorderPainted(false);
		bas.setContentAreaFilled(false);
		gauche.setIcon(imgGauche);
		gauche.setBorderPainted(false);
		gauche.setContentAreaFilled(false);
		droite.setIcon(imgDroite);
		droite.setBorderPainted(false);
		droite.setContentAreaFilled(false);
		
		bottom2.add(new JLabel());
		bottom2.add(new JLabel("Translation", SwingConstants.CENTER));
		bottom2.add(new JLabel());
		bottom2.add(new JLabel());
		bottom2.add(haut);
		bottom2.add(new JLabel());
		bottom2.add(gauche);
		bottom2.add(new JLabel());
		bottom2.add(droite);
		bottom2.add(new JLabel());
		bottom2.add(bas);
		bottom2.add(new JLabel());
		
		//bottom3.add(new JLabel("Rotation", SwingConstants.CENTER));
		//bottom3.add(rotationX);
		//bottom3.add(rotationY);
		
		hautR.setIcon(imgHaut);
		hautR.setBorderPainted(false);
		hautR.setContentAreaFilled(false);
		basR.setIcon(imgBas);
		basR.setBorderPainted(false);
		basR.setContentAreaFilled(false);
		gaucheR.setIcon(imgGauche);
		gaucheR.setBorderPainted(false);
		gaucheR.setContentAreaFilled(false);
		droiteR.setIcon(imgDroite);
		droiteR.setBorderPainted(false);
		droiteR.setContentAreaFilled(false);
		
		bottom3.add(new JLabel());
		bottom3.add(new JLabel("Rotation", SwingConstants.CENTER));
		bottom3.add(new JLabel());
		bottom3.add(new JLabel());
		bottom3.add(hautR);
		bottom3.add(new JLabel());
		bottom3.add(gaucheR);
		bottom3.add(new JLabel());
		bottom3.add(droiteR);
		bottom3.add(new JLabel());
		bottom3.add(basR);
		bottom3.add(new JLabel());
		
		conteneur.setLayout(new GridLayout(1,1));
		conteneur.add(splitpane);
		
		//ouvrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_MASK));
		//fichier.add(ouvrir);
		//enregistrer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_MASK));
		fichier.add(enregistrer);
		fichier.addSeparator();
		modifTags.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, KeyEvent.CTRL_MASK));
		fichier.add(modifTags);
		fichier.add(rechercher);
		fichier.addSeparator();
		quitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.CTRL_MASK));
		fichier.add(quitter);

		couleurModele.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, KeyEvent.CTRL_MASK));
		edition.add(couleurModele);
		couleurFond.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, KeyEvent.CTRL_MASK));
		edition.add(couleurFond);
		couleurMulti.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, KeyEvent.CTRL_MASK + KeyEvent.SHIFT_MASK));
		edition.add(couleurMulti);
		edition.addSeparator();
		symetrieHoriz.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, KeyEvent.CTRL_MASK));
		edition.add(symetrieHoriz);
		symetrieVerti.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_MASK));
		edition.add(symetrieVerti);
		edition.addSeparator();
		reset.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, KeyEvent.CTRL_MASK));
		edition.add(reset);
		
		hideListeItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, KeyEvent.CTRL_MASK));
		affichage.add(hideListeItem);
		hideCtrlPannelItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.CTRL_MASK));
		affichage.add(hideCtrlPannelItem);
		
		aide.add(aPropos);
		
		menu.add(fichier);
		menu.add(edition);
		menu.add(affichage);
		menu.add(aide);
		
		hautZ.addActionListener(listener);
		basZ.addActionListener(listener);
		
		haut.addActionListener(listener);
		bas.addActionListener(listener);
		gauche.addActionListener(listener);
		droite.addActionListener(listener);

		hautR.addActionListener(listener);
		basR.addActionListener(listener);
		gaucheR.addActionListener(listener);
		droiteR.addActionListener(listener);
		
		enregistrer.addActionListener(listener);
		modifTags.addActionListener(listener);
		rechercher.addActionListener(listener);
		quitter.addActionListener(listener);
		couleurModele.addActionListener(listener);
		couleurFond.addActionListener(listener);
		couleurMulti.addActionListener(listener);
		symetrieHoriz.addActionListener(listener);
		symetrieVerti.addActionListener(listener);
		reset.addActionListener(listener);
		hideListeItem.addActionListener(listener);
		hideCtrlPannelItem.addActionListener(listener);
		aPropos.addActionListener(listener);
		
		left.addMouseListener(mouselistener);
		left.addMouseWheelListener(mouseWheelListener);
		left.addMouseMotionListener(mouseMotionListener);
		
		this.addKeyListener(keyListener);
		this.setFocusable(true);
		/*TimerTask task = new TimerTask(){
			@Override
			public void run(){
				Display.this.requestFocus();
			}	
		};
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(task, 0, 1000);*/
		this.addFocusListener( //Permet de maintenir l'écoute du clavier
				new FocusListener() {
					public void focusGained(FocusEvent e) {
						//doNothing();
		            }
		            public void focusLost(FocusEvent e) {
		                requestFocus();
		            }
		});
		this.getContentPane().add(conteneur);
		this.setJMenuBar(menu);
		this.setTitle("/gts/space_shuttle.gts - GTS Reader");
		this.setSize(1000, 800);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	/**
	 * Cache / Affiche le volet contenant la liste des fichiers *.gts .
	 */
	public void hideListe(){
		if(!hideListe){
			splitpane2.setDividerLocation(1000);
			hideListe = true;
			hideListeItem.setText("Afficher le volet de droite");
		} else {
			splitpane2.setDividerLocation(800);
			hideListe = false;
			hideListeItem.setText("Cacher le volet de droite");
		}
	}
	
	/**
	 * Cache / Affiche le volet contenant les boutons de contrôles (Zoom, Translation, Rotation).
	 */
	public void hideCtrlPannel(){
		if(!hideCtrlPannel){
			splitpane.setDividerLocation(1000);
			hideCtrlPannel = true;
			hideCtrlPannelItem.setText("Afficher le panneau de contrôle");
		} else {
			splitpane.setDividerLocation(550);
			hideCtrlPannel = false;
			hideCtrlPannelItem.setText("Cacher le panneau de contrôle");
		}
	}
	
	public JButton getHaut() {
		return haut;
	}
	public void setHaut(JButton haut) {
		this.haut = haut;
	}
	public JButton getBas() {
		return bas;
	}
	public void setBas(JButton bas) {
		this.bas = bas;
	}
	public JButton getGauche() {
		return gauche;
	}
	public void setGauche(JButton gauche) {
		this.gauche = gauche;
	}
	public JButton getDroite() {
		return droite;
	}
	public void setDroite(JButton droite) {
		this.droite = droite;
	}
	public Figure getGtsDisplay() {
		return gtsDisplay;
	}
	public void setGtsDisplay(Figure gtsDisplay) {
		this.gtsDisplay = gtsDisplay;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public JMenuItem getQuitter(){
		return this.quitter;
	}
	public JMenuItem getCouleurModele(){
		return this.couleurModele;
	}
	public JMenuItem getCouleurFond(){
		return this.couleurFond;
	}
	public JMenuItem getAPropos(){
		return this.aPropos;
	}
	public JButton getHautR(){
		return this.hautR;
	}
	public JButton getBasR(){
		return this.basR;
	}
	public JButton getGaucheR(){
		return this.gaucheR;
	}
	public JButton getDroiteR(){
		return this.droiteR;
	}
	public JPanel getLeft(){
		return this.left;
	}
	public Color getColorModele(){
		return this.colorModele;
	}
	public void setColorModele(Color color){
		this.colorModele = color;
	}
	public JMenuItem getSymetrieHoriz(){
		return this.symetrieHoriz;
	}
	public JMenuItem getSymetrieVerti(){
		return this.symetrieVerti;
	}
	public JMenuItem getReset(){
		return this.reset;
	}
	public JMenuItem getHideListeItem(){
		return this.hideListeItem;
	}
	public JMenuItem getHideCtrlPannelItem(){
		return this.hideCtrlPannelItem;
	}
	public JButton getHautZ(){
		return this.hautZ;
	}
	public JButton getBasZ(){
		return this.basZ;
	}
	public JMenuItem getCouleurMulti(){
		return this.couleurMulti;
	}
	public JMenuItem getEnregistrer(){
		return this.enregistrer;
	}
	public JMenuItem getModifTags(){
		return this.modifTags;
	}
	public JMenuItem getRechercher(){
		return this.rechercher;
	}
	
	public static void main(String[] args) {
		new TableMaker();
		new Display("/gts/space_shuttle.gts");
	}
}