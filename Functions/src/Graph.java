import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Graph extends JPanel{

	
	static String[] arr;
	static String[] arr2;
	static String text = "";
	static int y1=0,y2=0;
	static boolean done = false;
	public Graph()
	{
		File dir = new File("C:\\Functions");
		arr = dir.list();
		Timer t = new Timer(10,new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				repaint();
				
			}
			
		});
		
		t.restart();
	}
	static int choosen = -1,choosen2 = -1;
	public void paintComponent(Graphics g)
	{//Mistener.tx,Mistener.ty,Mistener.dx,Mistener.dy
	//bg
	g.setColor(new Color(33,33,33));
	g.fillRect(0, 0, 800, 600);
	//list of langs
	g.setColor(new Color(50,50,50));
	g.fillRect(0,0,273,605);
	//data
	
	
	//g.setColor(new Color(67-40,67-40,67-40));
	//g.fillRect(273,361,546,267);//
	
	if(onElement(291,380,492,160))
		g.setColor(new Color(10,10,10));
	else
	g.setColor(new Color(0,0,0));
	g.fillRect(291,380,492,160);//273,361,546,267
	
	g.setColor(Color.white);
	
	String[] out = text.split("\n");
	for(int i = 0; i<out.length;i++)
		if(400+i*25+y2>400-25)
	drawText((i<9?"0":"")+(i+1)+"| "+out[i], 295,400+i*25+y2,20, g);
	
	
	g.setColor(new Color(67,67,67));
	g.fillRect(273,361,528,19);
	g.fillRect(273,361,18,241);
	g.fillRect(273,539,540,148);
	g.fillRect(783,361,57,249);

	if(!done)
	{
		if(onElement(291,544,491,47))
			g.setColor(new Color(0,173,181));
		else
			g.setColor(new Color(0,255,245));
	}
	else
	{
		if(onElement(291,544,491,47))
			g.setColor(new Color(0,173+55,181-55));
		else
			g.setColor(new Color(0,255,245-155));
	}
	g.fillRoundRect(291,544,491,47, 50,50);
	
	
	g.setColor(new Color(33,33,33));
	if(!done)
		drawText("Скопировать",413,581,40,g);
	else
		drawText("Скопировано",413,581,40,g);
	
	///////////
	
	//получаем список
	
	//String[] arr= {"ie","ed","dd"};
	
	
	
	for(int i = 0; i<arr.length;i++)
	{
		
		if(onElement(0,3+i*36,237,35)||i==choosen)
		{
			g.setColor(new Color(67,67,67));
			
		} else g.setColor(new Color(40,40,40));
		
		g.fillRect(0,3+i*36,273,36);
		
		g.setColor(new Color(0,255,245));
		
		drawText(arr[i],12,33+i*35,30,g);
	
	}
	
	if(choosen>-1&&choosen<arr.length)
	{
		File dir = new File("C:\\Functions\\"+arr[choosen]);
		arr2 = dir.list();
	
		for(int i = 0; i<arr2.length;i++)
		{
			
			
			if(onElement(274,6+i*24+y1,600,24)||choosen2==i)
				g.setColor(new Color(40,40,40));
			else
				g.setColor(new Color(33,33,33));
			g.fillRect(274,6+i*25+y1,600,24);
			g.setColor(Color.white);
			drawText(arr2[i].replaceFirst(".txt", ""),283,24+i*25+y1,20,g);
		}
	}
	
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
	
	double dist(double x,double y,double x1, double y1)
	{
		return Math.sqrt((x-x1)*(x-x1)+(y-y1)*(y-y1));
	}
	
	double rotateX(double x0,double y0,double x,double y,double a){
		return (Math.cos(Math.PI/180*a)*(x-x0)+Math.sin(Math.PI/180*a)*(y0-y)+x0);
	}

	double rotateY(double x0,double y0,double x,double y,double a){
		return (Math.cos(Math.PI/180*a)*(y-y0)+Math.sin(Math.PI/180*a)*(x-x0))+y0;
	}
	
	void drawText(String str, int x, int y, float size,Graphics g) {
		Font save = g.getFont();
		g.setFont(g.getFont().deriveFont(size));
		g.drawString(str, x, y);
		g.setFont(save);
	}
	


	static boolean onElement(int x,int y, int w, int h)
	{
		int x2=x+w;
		int y2=y+h;
		int mx = Mistener.mx;
		int my = Mistener.my;
	return (mx>=x&&mx<=x2)&&(my>=y&&my<=y2);	
	}
	
	
}