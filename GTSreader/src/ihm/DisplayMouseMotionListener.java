package ihm;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import prgm.Rotation;
import prgm.Translation;

public class DisplayMouseMotionListener implements MouseMotionListener {
	
	private Display disp;
	public static int x, y;
	public static boolean translation = true;
	
	public DisplayMouseMotionListener(Display display) {
		// TODO Auto-generated constructor stub
		this.disp = display;
	}

	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		if(translation){
			int speed;
			if(x - e.getX() < 0){
				speed = e.getX() - x;
				Translation.translationHorizDroit(disp.getGtsDisplay(), speed);
			} else if(x - e.getX() > 0){
				speed = x - e.getX();
				Translation.translationHorizGauche(disp.getGtsDisplay(), speed);
			}
			if(y - e.getY() < 0){
				speed = e.getY() - y;
				Translation.translationVertiBas(disp.getGtsDisplay(), speed);
			} else if(y - e.getY() > 0){
				speed = y - e.getY();
				Translation.translationVertiHaut(disp.getGtsDisplay(), speed);
			}
			disp.revalidate();
			disp.repaint();
			disp.getGtsDisplay().revalidate();
			disp.getGtsDisplay().repaint();
			x = e.getX();
			y = e.getY();
		} else {
			int speed = 5;
			if(x - e.getX() < 0){
				for(int cpt=0 ; cpt<speed ; cpt++){
					Rotation.rotationVersLaGauche(disp.getGtsDisplay());
				}
			} else if(x - e.getX() > 0){
				for(int cpt=0 ; cpt<speed ; cpt++){
					Rotation.rotationVersLaDroite(disp.getGtsDisplay());
				}
			}
			if(y - e.getY() < 0){
				for(int cpt=0 ; cpt<speed ; cpt++){
					Rotation.rotationVersLeBas(disp.getGtsDisplay());
				}
			} else if(y - e.getY() > 0){
				for(int cpt=0 ; cpt<speed ; cpt++){
					Rotation.rotationVersLeHaut(disp.getGtsDisplay());
				}
			}
			disp.revalidate();
			disp.repaint();
			disp.getGtsDisplay().revalidate();
			disp.getGtsDisplay().repaint();
			x = e.getX();
			y = e.getY();
		}
	}

	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
	}
}