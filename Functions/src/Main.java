
public class Main {

	static boolean fullscreen=false;
	static WFrame fr = new WFrame(800,600,"Window",true, new Graph());
	public static void main(String[] args) {
		
		fr.addKeyListener(new Mistener());
		fr.addMouseListener(new Mistener());
		fr.addMouseMotionListener(new Mistener());
	}

}
