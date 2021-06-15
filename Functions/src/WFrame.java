

import java.awt.Component;
import javax.swing.JFrame;


public class WFrame extends JFrame {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1039407681236345976L;

public WFrame(int w, int h, String title, boolean undec,Component graph) {
	
	super.setSize(w,h);	
	super.setTitle(title);
	super.setLocationRelativeTo(null);
	super.add(graph);
	super.setUndecorated(undec);
	super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	super.setVisible(true);
	
	}

public WFrame() {
	
}
}
