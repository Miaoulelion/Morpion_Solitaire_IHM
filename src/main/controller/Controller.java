package main.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;

import main.model.IGridGame;
import main.view.GameView;
import main.view.GridView;
import main.view.MenuView;

public class Controller extends MouseAdapter implements ActionListener {
	private GridView gridView;
	private IGridGame gameModel;
	private MenuView menuView;
	private GameView gameView;

	public Controller(GameView gameView,IGridGame gameModel) {
		Objects.requireNonNull(gameView);
		Objects.requireNonNull(gameModel);
		this.gridView=gameView.getGridView();
		this.gameView=gameView;
		this.gameModel=gameModel;
		this.menuView=gameView.getMenuView();
		this.menuView.getHint().addActionListener(this);
		this.menuView.getRestart().addActionListener(this);
		this.menuView.getRandomSolve().addActionListener(this);
		this.menuView.getChangeGame().addActionListener(this);
	}

	/**
	 * @param MouseEvent e (here click)
	 * When the mouse click on the grid, we take its position and place a point on the grid.
	 * The point is placed thanks to the placePont() method of the model class.
	 * The point is placed only if the click position is close to an line/column intersection of the grid (look at the if condition).
	 */

	@Override
	public void mouseClicked(MouseEvent e) {
		double x=(double)e.getX()/(double)GridView.GRIDLINESWIDTH;
		double y=(double)e.getY()/(double)GridView.GRIDLINESWIDTH;
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.menuView.getHint()) {
			this.activHint();
		}
		else if(e.getSource()==this.menuView.getRandomSolve()) {
			this.startRandomSolve();
		}
		else if(e.getSource()==this.menuView.getRestart()) {
			this.restartGame();
		}
		else if(e.getSource()==this.menuView.getChangeGame()) {
			this.gameView.changeGame();
		}
		
	}
	
	public void startRandomSolve() {
		this.gameModel.randomSolve();
		this.gridView.repaint();	
	}
	
	public void restartGame() {
		this.gameModel.restartGame();
		this.gridView.repaint();
	}
	
	public void activHint() {
		this.gridView.setHint(true);
		this.gridView.repaint();
	}

	public void setGameModel(IGridGame gameModel) {
		Objects.requireNonNull(gameModel);
		this.gameModel = gameModel;
	}
}
