package ihm;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import prgm.Zoom;


public class DisplayMouseWheelListener implements MouseWheelListener {

	private Display disp;
	private int count;
	
	public DisplayMouseWheelListener(Display display) {
		// TODO Auto-generated constructor stub
		disp = display;
	}
	
	public void mouseWheelMoved(MouseWheelEvent e) {
		// TODO Auto-generated method stub
		if(e.getPreciseWheelRotation() > 0){
			count++;
			if(count > 5){
				Zoom.zoomPlus(disp.getGtsDisplay());
    			disp.revalidate();
    			disp.repaint();
    			disp.getGtsDisplay().revalidate();
    			disp.getGtsDisplay().repaint();
				count = 0;
			}
		} else if(e.getPreciseWheelRotation() < 0) {
			count++;
			if(count > 5){
				Zoom.zoomMoins(disp.getGtsDisplay());
				disp.revalidate();
    			disp.repaint();
    			disp.getGtsDisplay().revalidate();
    			disp.getGtsDisplay().repaint();
				count = 0;
			}
		}
	}
}
