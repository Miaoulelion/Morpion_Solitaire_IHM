package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import model.IGridGame;
import view.GridView;

public class GridController extends MouseAdapter {
	private final int GRIDLINESWIDTH=40;
	private GridView gridView;
	private IGridGame gameModel;
	
	public GridController(GridView gridView, IGridGame gameModel) {
		this.gridView=gridView;
		this.gameModel=gameModel;
	}
	

	/**
	 * @param MouseEvent e (here click)
	 * When the mouse click on the grid, we take its position and place a point on the grid.
	 * The point is placed thanks to the placePont() method of the model class.
	 * The point is placed only if the click position is close to an line/column intersection of the grid (look at the if condition).
	 */

	@Override
	public void mouseClicked(MouseEvent e) {
		double x=(double)e.getX()/(double)GRIDLINESWIDTH;
		double y=(double)e.getY()/(double)GRIDLINESWIDTH;
		if(!((Math.abs(x-Math.round(x))>0.25&&Math.abs(x-Math.round(x))<0.75)
				||(Math.abs(y-Math.round(y))>0.25&&Math.abs(y-Math.round(y))<0.75))){
			gameModel.placePoint((int)Math.round(x), (int)Math.round(y));
			gridView.repaint();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	


}
