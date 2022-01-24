package main.view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Objects;

import javax.swing.JPanel;

import main.model.GridGameAbstract;
import main.model.IGridGame;
import main.model.Line;

/**
 * This class create the grid game (morpion) view. The game is composed by a grid
 * where points are placed by the player. 
 * @author MiaouLeLion
 *
 */

public class GridView extends JPanel{
	public static final int GRIDLINESWIDTH=40;
	private final int NUMBEROFGRIDLINES=50;
	private final int POINTWIDTH=15;
	private IGridGame gameModel;
	private boolean hint=false;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public GridView(IGridGame g, MenuView menuView) {
		this.gameModel=g;
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.GRAY);
		for(int i=0;i<this.NUMBEROFGRIDLINES;++i) {
			g.drawLine(i*GRIDLINESWIDTH, 0, i*GRIDLINESWIDTH,this.getHeight());
			g.drawLine(0, i*GRIDLINESWIDTH,this.getWidth() , i*GRIDLINESWIDTH);
		}
		g.setColor(Color.BLACK);
		for(main.model.Point p:this.gameModel.getGridPoints()) {
			g.fillOval(p.getX()*GRIDLINESWIDTH-(POINTWIDTH/2), p.getY()*GRIDLINESWIDTH-(POINTWIDTH/2), 
					POINTWIDTH, POINTWIDTH);			
		}
		g.setColor(Color.red);
		int cpt=1;
		for(main.model.Point p:((GridGameAbstract)this.gameModel).getPointPlayed()) {
			g.drawString(""+cpt, p.getX()*GRIDLINESWIDTH-(POINTWIDTH/2), p.getY()*GRIDLINESWIDTH-(POINTWIDTH/2));
			++cpt;	
		}
		//Here we draw the validates lines.
		for(Line line : this.gameModel.getListOfAlignment()) {
			g.drawLine(line.getLinePoint().get(0).getX()*GRIDLINESWIDTH, 
					line.getLinePoint().get(0).getY()*GRIDLINESWIDTH, 
					line.getLinePoint().get(line.getLinePoint().size()-1).getX()*GRIDLINESWIDTH, 
					line.getLinePoint().get(line.getLinePoint().size()-1).getY()*GRIDLINESWIDTH);
		}
		
		if(hint) {
			g.setColor(Color.blue);
			for(main.model.Point p:this.gameModel.getPossiblePoint()) {
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
	}

}
