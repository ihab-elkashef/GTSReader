package ihm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class DisplayMouseListener implements MouseListener {
	
	private Display disp;
	private JPopupMenu popup;
	
	public DisplayMouseListener(Display display) {
		// TODO Auto-generated constructor stub
		disp = display;
	}
	
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		DisplayMouseMotionListener.x = e.getX();
		DisplayMouseMotionListener.y = e.getY();
		if(e.getButton() == MouseEvent.BUTTON3){
			if(popup != null){
				popup.setVisible(false);
				popup.repaint();
				disp.repaint();
			}
			showPopup(e);
		}
	}

	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		DisplayMouseMotionListener.x = e.getX();
		DisplayMouseMotionListener.y = e.getY();		
	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Génère un menu contextuel.
	 * @param e Evènement produit par la souris.
	 */
	private void showPopup(MouseEvent e) {
		popup = new JPopupMenu();
		JCheckBoxMenuItem checkBoxMenuItem = new JCheckBoxMenuItem("Translation");
		checkBoxMenuItem.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DisplayMouseMotionListener.translation = true;
			}
		});
		if(DisplayMouseMotionListener.translation){
			checkBoxMenuItem.setSelected(true);
		}
		popup.add(checkBoxMenuItem);
		checkBoxMenuItem = new JCheckBoxMenuItem("Rotation");
		checkBoxMenuItem.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DisplayMouseMotionListener.translation = false;
			}
		});
		if(!DisplayMouseMotionListener.translation){
			checkBoxMenuItem.setSelected(true);
		}
		popup.add(checkBoxMenuItem);
		popup.addSeparator();
		JMenuItem menuItem = new JMenuItem();
		menuItem.setText("Quitter");
		menuItem.addActionListener(new java.awt.event.ActionListener() {
		   public void actionPerformed(java.awt.event.ActionEvent e) {
		      System.exit(0);
		   }
		});
		popup.add(menuItem);
		popup.show(disp.getLeft(), e.getX(), e.getY());
	}
}
