package view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Objects;

import javax.swing.JPanel;

import model.GridGameAbstract;
import model.IGridGame;

/**
 * This class create the grid game (morpion) view. The game is composed by a grid
 * where points are placed by the player. 
 * @author MiaouLeLion
 *
 */

public class GridView extends JPanel{
	public static final int GRIDLINESWIDTH=40;
	private final int NUMBEROFGRIDLINES=50;
	private final int POINTWIDTH=10;
	private IGridGame gameModel;
	private LinesView linesView;
	private boolean hint=false;


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public GridView(IGridGame g) {
		this.gameModel=g;
		this.linesView=new LinesView(g);
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
		
		g.setColor(Color.RED);
		int cpt=1;
		for(model.Point p:((GridGameAbstract)this.gameModel).getPointPlayed()) {
			g.drawString(""+cpt, p.getX()*GRIDLINESWIDTH-(POINTWIDTH/2), p.getY()*GRIDLINESWIDTH-(POINTWIDTH/2));
			++cpt;
			
		}
		
		
		this.linesView.draw(g);
		
		if(hint) {
			g.setColor(Color.red);
			for(model.Point p:this.gameModel.getPossiblePoint()) {
				g.fillOval(p.getX()*GRIDLINESWIDTH-(POINTWIDTH/2), p.getY()*GRIDLINESWIDTH-(POINTWIDTH/2), 
						POINTWIDTH, POINTWIDTH);
			}
			hint=false;
		}
		
	}

	public void setHint(boolean hint) {
		this.hint = hint;
	}


	public void setGameModel(IGridGame gameModel) {
		Objects.requireNonNull(gameModel);
		this.gameModel = gameModel;
		this.linesView=new LinesView(gameModel);
	}






	

}
