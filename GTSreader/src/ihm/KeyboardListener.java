package ihm;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import prgm.Rotation;
import prgm.Translation;
import prgm.Zoom;


public class KeyboardListener implements KeyListener {

	private Display disp;
	
	public KeyboardListener(Display display) {
		// TODO Auto-generated constructor stub
		disp = display;
	}
	
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch(e.getKeyCode()){
			case KeyEvent.VK_LEFT :
				Translation.translationHorizGauche(disp.getGtsDisplay(), Translation.DEFAULT_SPEED);
				disp.revalidate();
				disp.repaint();
				disp.getGtsDisplay().revalidate();
				disp.getGtsDisplay().repaint();
				break;
			case KeyEvent.VK_RIGHT :
				Translation.translationHorizDroit(disp.getGtsDisplay(), Translation.DEFAULT_SPEED);
				disp.revalidate();
				disp.repaint();
				disp.getGtsDisplay().revalidate();
				disp.getGtsDisplay().repaint();
				break;
			case KeyEvent.VK_UP :
				Translation.translationVertiHaut(disp.getGtsDisplay(), Translation.DEFAULT_SPEED);
				disp.revalidate();
				disp.repaint();
				disp.getGtsDisplay().revalidate();
				disp.getGtsDisplay().repaint();
				break;
			case KeyEvent.VK_DOWN :
				Translation.translationVertiBas(disp.getGtsDisplay(), Translation.DEFAULT_SPEED);
				disp.revalidate();
				disp.repaint();
				disp.getGtsDisplay().revalidate();
				disp.getGtsDisplay().repaint();
				break;
			case KeyEvent.VK_PAGE_UP :
				Zoom.zoomPlus(disp.getGtsDisplay());
				disp.revalidate();
    			disp.repaint();
    			disp.getGtsDisplay().revalidate();
    			disp.getGtsDisplay().repaint();
				break;
			case KeyEvent.VK_PAGE_DOWN :
				Zoom.zoomMoins(disp.getGtsDisplay());
				disp.revalidate();
    			disp.repaint();
    			disp.getGtsDisplay().revalidate();
    			disp.getGtsDisplay().repaint();
				break;
			case KeyEvent.VK_Z :
				Rotation.rotationVersLeHaut(disp.getGtsDisplay());
				disp.revalidate();
				disp.repaint();
				disp.getGtsDisplay().revalidate();
				disp.getGtsDisplay().repaint();
				break;
			case KeyEvent.VK_Q :
				Rotation.rotationVersLaGauche(disp.getGtsDisplay());
				disp.revalidate();
				disp.repaint();
				disp.getGtsDisplay().revalidate();
				disp.getGtsDisplay().repaint();
				break;
			case KeyEvent.VK_S :
				Rotation.rotationVersLeBas(disp.getGtsDisplay());
				disp.revalidate();
				disp.repaint();
				disp.getGtsDisplay().revalidate();
				disp.getGtsDisplay().repaint();
				break;
			case KeyEvent.VK_D :
				Rotation.rotationVersLaDroite(disp.getGtsDisplay());
				disp.revalidate();
				disp.repaint();
				disp.getGtsDisplay().revalidate();
				disp.getGtsDisplay().repaint();
				break;
			case KeyEvent.VK_A :
				Rotation.rotationZMoins(disp.getGtsDisplay());
				disp.revalidate();
				disp.repaint();
				disp.getGtsDisplay().revalidate();
				disp.getGtsDisplay().repaint();
				break;
			case KeyEvent.VK_E :
				Rotation.rotationZPlus(disp.getGtsDisplay());
				disp.revalidate();
				disp.repaint();
				disp.getGtsDisplay().revalidate();
				disp.getGtsDisplay().repaint();
				break;
		}
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
