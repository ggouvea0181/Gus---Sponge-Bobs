		
// GraphicsLab06st.java
// This is the Student Version of the Lab11GRFX06 assignment.

import java.awt.*;
import java.applet.*;
import java.util.*;

public class GraphicsLab06st extends Applet
{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void paint(Graphics g)
	{
		int circleCount = 40;
		Circles circles = new Circles(g,circleCount);
	}
}

class Circles
{
	private int circleCount;
	private Random rnd;
	private Color randomColor;
	private int colorRow;
	
	private int redCount, greenCount, blueCount;
	
	public Circles(Graphics g,int c)
	{
		rnd = new Random(12345);
		circleCount = c;
		redCount = 1;
		greenCount = 1;
		blueCount = 1;
		drawSquares(g);
		for (int k = 1; k <= circleCount; k++)
			drawRandomCircle(g);
	}	
				
	public void drawSquares(Graphics g)
	{
		g.setColor(Color.red);
		g.fillRect(10,100,30,30);
		g.setColor(Color.green);
		g.fillRect(10,250,30,30);
		g.setColor(Color.blue);
		g.fillRect(10,400,30,30);
	}
	
	public void drawRandomCircle(Graphics g)
	{
		getRandomColor(g);
		
		int win = 0;
		
		if(g.getColor().getBlue() > g.getColor().getRed()){
			if(g.getColor().getBlue() > g.getColor().getGreen()){
				win = 1;
			}
		}else if(g.getColor().getRed() > g.getColor().getGreen()){
			win = 2;
		}else if((g.getColor().getGreen() > g.getColor().getRed()) && (g.getColor().getGreen() > g.getColor().getBlue())){
			win = 3;
		}
		
		switch (win){
		case 1: 
			if(blueCount > 17){
				g.fillOval(10+(blueCount-17)*50,450,40,40);
			}else{
				g.fillOval(10+blueCount*50,400,40,40);
			}
			
			blueCount++;
			break;
		case 2: 
			if(redCount > 17){
				g.fillOval(10+(redCount-17)*50,150,40,40);
			}else{
				g.fillOval(10+redCount*50,100,40,40);
			}
			redCount++;
			break;
		case 3: 
			if(greenCount > 17){
				g.fillOval(10+(greenCount-17)*50,300,40,40);
			}else{
				g.fillOval(10+greenCount*50,250,40,40);
			}
			greenCount++;
			break;
			
		}
		
		}
		
	
	public Graphics getRandomColor(Graphics g)
	{
		Random rand = new Random();
		float r = rand.nextFloat();
		float gr = rand.nextFloat();
		float b = rand.nextFloat();
		Color rand1 = new Color(r, gr, b);
		g.setColor(rand1);
		return g;
		
	}
}

