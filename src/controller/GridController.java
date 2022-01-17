package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import model.IGridGame;
import view.GameView;
import view.GridView;

public class GridController extends MouseAdapter {
	private final int GRIDLINESWIDTH=50;
	private GridView gridView;
	private IGridGame gameModel;
	
	public GridController(GridView gridView, IGridGame gameModel) {
		this.gridView=gridView;
		this.gameModel=gameModel;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		System.out.println("x="+e.getX());
		int x = Math.round((e.getX()+10)/ 10) * 10;
		int y = Math.round((e.getY()+10)/ 10) * 10;
		System.out.println("new x="+x);
		if(x/GRIDLINESWIDTH<=100 && y/GRIDLINESWIDTH<=100) {
			System.out.println("Adding"+y/50+"; "+x/50);
			gameModel.placePoint(x/GRIDLINESWIDTH, y/GRIDLINESWIDTH);
			//System.out.println(gameModel);
		}
		
		gridView.repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		this.gridView.setMousePressed(true);
		this.gridView.setX1(e.getX());
		this.gridView.setY1(e.getY());
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		this.gridView.setMousePressed(false);
		this.gridView.repaint();
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
		this.gridView.setX2(e.getX());
		this.gridView.setY2(e.getY());
		this.gridView.repaint();
		
	}

}
