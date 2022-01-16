package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Objects;

import javax.swing.JPanel;

import model.IGridGame;

/**
 * This class create the grid game (morpion) view. The game is composed by a grid
 * where points are placed by the player. 
 * @author MiaouLeLion
 *
 */

public class GridView extends JPanel{
	private final int NUMBEROFLINES=50;
	private final int LINESWIDTH=50;
	private IGridGame gridGame; 

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public GridView(IGridGame gameModel) {
		Objects.requireNonNull(gameModel);
		this.setGridGame(gameModel);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		for(int i=0;i<this.NUMBEROFLINES;++i) {
			g.drawLine(i*this.LINESWIDTH, 0, i*this.LINESWIDTH,800);
			g.drawLine(0, i*this.LINESWIDTH, 800, i*this.LINESWIDTH);
		}
		
	}

	public int getWIDTH() {
		return LINESWIDTH;
	}

	public IGridGame getGridGame() {
		return gridGame;
	}

	public void setGridGame(IGridGame gameModel) {
		Objects.requireNonNull(gameModel);
		this.gridGame = gameModel;
	}

	public int getNUMBEROFLINES() {
		return NUMBEROFLINES;
	}
	
	
	

}
