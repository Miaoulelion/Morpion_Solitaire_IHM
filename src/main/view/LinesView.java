package main.view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import main.model.IGridGame;
import main.model.Line;

public class LinesView extends JPanel{
	private final int GRIDLINESWIDTH=40;
	private IGridGame gameModel;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public LinesView(IGridGame gameModel) {
		this.gameModel=gameModel;
	}
	
	/**
	 * We take all the lines created by the player given by the getLinePoint() gameModel method.
	 * All the points of this lines are sorted. We trace a line between the first and the last point. 
	 * @param g
	 */
	
	
	public void draw(Graphics g) {
		super.paintComponents(g);
		g.setColor(Color.RED);
		ArrayList<Line> Lines = this.gameModel.getListOfAlignment();
		for(Line line : Lines) {
			g.drawLine(line.getLinePoint().get(0).getX()*GRIDLINESWIDTH, 
					line.getLinePoint().get(0).getY()*GRIDLINESWIDTH, 
					line.getLinePoint().get(line.getLinePoint().size()-1).getX()*GRIDLINESWIDTH, 
					line.getLinePoint().get(line.getLinePoint().size()-1).getY()*GRIDLINESWIDTH);
		}
	}
	
	
	
}