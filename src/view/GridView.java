package view;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

import model.IGridGame;

/**
 * This class create the grid game (morpion) view. The game is composed by a grid
 * where points are placed by the player. 
 * @author MiaouLeLion
 *
 */

public class GridView extends JPanel{
	private final int NUMBEROFGRIDLINES=50;
	private final int POINTWIDTH=10;
	private final int GRIDLINESWIDTH=40;
	private IGridGame gameModel;
	


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public GridView(IGridGame g) {
		this.gameModel=g;
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		for(int i=0;i<this.NUMBEROFGRIDLINES;++i) {
			g.drawLine(i*this.GRIDLINESWIDTH, 0, i*this.GRIDLINESWIDTH,this.getHeight());
			g.drawLine(0, i*this.GRIDLINESWIDTH,this.getWidth() , i*this.GRIDLINESWIDTH);
		}
	
		for(model.Point p:this.gameModel.getGridPoints()) {
			g.fillOval(p.getX()*GRIDLINESWIDTH-(POINTWIDTH/2), p.getY()*GRIDLINESWIDTH-(POINTWIDTH/2), 
					POINTWIDTH, POINTWIDTH);
		}
	}

	
	
	public int getWIDTH() {
		return GRIDLINESWIDTH;
	}

	public int getNUMBEROFLINES() {
		return NUMBEROFGRIDLINES;
	}

	
	

}
