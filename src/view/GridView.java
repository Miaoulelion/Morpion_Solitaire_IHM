package view;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * This class create the grid game (morpion) view. The game is composed by a grid
 * where points are placed by the player. 
 * @author MiaouLeLion
 *
 */

public class GridView extends JPanel{
	private final int NUMBEROFGRIDLINES=50;
	private final int GRIDLINESWIDTH=50;
	private int x1,y1,x2,y2;
	private boolean isMousePressed;
	


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		for(int i=0;i<this.NUMBEROFGRIDLINES;++i) {
			g.drawLine(i*this.GRIDLINESWIDTH, 0, i*this.GRIDLINESWIDTH,this.getHeight());
			g.drawLine(0, i*this.GRIDLINESWIDTH,this.getWidth() , i*this.GRIDLINESWIDTH);
		}
		if(this.isMousePressed) {
			g.drawLine(this.x1, this.y1, this.x2, this.y2);
		}
		
	}

	public int getWIDTH() {
		return GRIDLINESWIDTH;
	}

	public int getNUMBEROFLINES() {
		return NUMBEROFGRIDLINES;
	}
	
	public void setX1(int x) {
		this.x1=x;
	}
	
	public void setY1(int y) {
		this.y1=y;
	}
	
	public void setX2(int x) {
		this.x2=x;
	}
	
	public void setY2(int y) {
		this.y2=y;
	}

	public void setMousePressed(boolean isMousePressed) {
		this.isMousePressed = isMousePressed;
	}
	
	
	

}
