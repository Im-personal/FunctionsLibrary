import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Mistener implements MouseMotionListener, MouseListener, KeyListener{
	
	static int tx=0,ty=0,dx=0,dy=0,mx=0,my=0;
	
	@Override
	public void mouseDragged(MouseEvent e) {
		dx=e.getX()-tx;
		dy=e.getY()-ty;
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mx=e.getX();
		my=e.getY();
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		tx = e.getX(); ty = e.getY();
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		System.out.println(tx+","+ty+","+(e.getX()-tx)+","+(e.getY()-ty));
		
		if(Graph.onElement(291,544,491,47))
		{
			copy(Graph.text);
			Graph.done=true;
		}
		
		for(int i = 0; i<Graph.arr.length;i++)
		if(Graph.onElement(0,3+i*36,237,35))
		{
			
		Graph.choosen=i; Graph.y1=0; Graph.choosen2=-1;
		}
		
		if(Graph.onElement(273,0,527,359))
		if(Graph.arr2!=null)
		for(int i = 0; i<Graph.arr2.length;i++)
		{
			
			if(Graph.onElement(274,6+i*24+Graph.y1,600,24)||Graph.choosen2==i)
				{
				Graph.choosen2=i; Graph.y2=0;
				Graph.text = getFileStr("C:\\Functions\\"+Graph.arr[Graph.choosen]+"\\"+Graph.arr2[Graph.choosen2]);
				Graph.done=false;
				}
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		switch(e.getKeyCode())
		{
		case 27:
			System.exit(0);
			break;
		
		case 40:
			if(Graph.onElement(291,380,492,160))
				{if(Graph.y2>-Graph.text.split("\n").length*25+6*25)Graph.y2-=5;}//log(Graph.y2+" : "+-Graph.text.split("\n").length*25+6*25);}
			else
				Graph.y1-=5;
			break;
			
		case 38:
			if(Graph.onElement(291,380,492,160))
				{if(Graph.y2<0)Graph.y2+=5;}
			else
				{if(Graph.y1<0)Graph.y1+=5;}
			break;
		default:
			System.out.println(e.getKeyChar()+": "+e.getKeyCode());
			break;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	void log()
	{
		System.out.println("DEBUG!!");
	}
	
	void log(int i)
	{
		System.out.println(i);
	}
	
	void log(String str)
	{
		System.out.println(str);
	}
	
	void log(boolean bool)
	{
		System.out.println(bool);
	}
	
	void log(char c)
	{
		System.out.println(c);
	}
	
	public String getFileStr(String src) {
		String str="";
		File f = new File(src);
		try {
			FileReader ff = new FileReader(f);
			int c;
			while((c=ff.read())!=-1)
				str+=(char)c;
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}
	
	void copy(String str)
	{
		StringSelection ss = new StringSelection(str);
		Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
		cb.setContents(ss, null);
	}
	
	
	
}
