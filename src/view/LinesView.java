package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

import model.IGridGame;
import model.Line;

public class LinesView extends JPanel{

	private int x1,x2,y1,y2;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LinesView(int x1, int y1, int x2, int y2) {
		this.x1=x1;
		this.y1=y1;
		this.x2=x2;
		this.y2=y2;
	}
	
	
	public void draw(Graphics g) {
		super.paintComponents(g);
		g.setColor(Color.GREEN);
		g.drawLine(this.x1, this.y1, this.x2, this.y2);

		/*
		ArrayList<Line> Lines = this.gameModel.getListOfAlignment();
		for(Line line : Lines) {
			g.drawLine(line.getLinePoint().get(0).getX(), line.getLinePoint().get(0).getY(), 
					line.getLinePoint().get(line.getLinePoint().size()-1).getX(), 
					line.getLinePoint().get(line.getLinePoint().size()-1).getY());
		}*/
	}
	
	
	
}
