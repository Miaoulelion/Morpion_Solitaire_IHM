package main.view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Objects;

import javax.swing.JPanel;

import main.model.GridGameAbstract;
import main.model.IGridGame;

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
	private LinesView linesView;
	private boolean hint=false;
	private MenuView menuView;


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public GridView(IGridGame g, MenuView menuView) {
		this.gameModel=g;
		this.linesView=new LinesView(g);
		this.menuView=menuView;
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		for(int i=0;i<this.NUMBEROFGRIDLINES;++i) {
			g.drawLine(i*GRIDLINESWIDTH, 0, i*GRIDLINESWIDTH,this.getHeight());
			g.drawLine(0, i*GRIDLINESWIDTH,this.getWidth() , i*GRIDLINESWIDTH);
		}
		for(main.model.Point p:this.gameModel.getGridPoints()) {
			g.fillOval(p.getX()*GRIDLINESWIDTH-(POINTWIDTH/2), p.getY()*GRIDLINESWIDTH-(POINTWIDTH/2), 
					POINTWIDTH, POINTWIDTH);			
		}
		g.setColor(Color.red);
		int cpt=1;
		for(main.model.Point p:((GridGameAbstract)this.gameModel).getPointPlayed()) {
			//g.drawOval(p.getX()*GRIDLINESWIDTH-(POINTWIDTH/2), p.getY()*GRIDLINESWIDTH-(POINTWIDTH/2), POINTWIDTH, POINTWIDTH);

			g.drawString(""+cpt, p.getX()*GRIDLINESWIDTH-(POINTWIDTH/2), p.getY()*GRIDLINESWIDTH-(POINTWIDTH/2));
			++cpt;	
		}
		this.linesView.draw(g);
		
		if(hint) {
			g.setColor(Color.blue);
			for(main.model.Point p:this.gameModel.getPossiblePoint()) {
				g.fillOval(p.getX()*GRIDLINESWIDTH-(POINTWIDTH/2), p.getY()*GRIDLINESWIDTH-(POINTWIDTH/2), 
						POINTWIDTH, POINTWIDTH);
			}
			hint=false;
		}
		this.updateScore(this.gameModel.getListOfAlignment().size());
	}

	public void setHint(boolean hint) {
		this.hint = hint;
	}


	public void setGameModel(IGridGame gameModel) {
		Objects.requireNonNull(gameModel);
		this.gameModel = gameModel;
		this.linesView=new LinesView(gameModel);
	}
	


	public void updateScore(int score) {
		this.menuView.getScoreLabel().setText("Score : " + score);
	}




	

}