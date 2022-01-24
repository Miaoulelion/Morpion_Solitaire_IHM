package main.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;

import main.model.IGridGame;
import main.view.GameView;
import main.view.GridView;

public class Controller extends MouseAdapter implements ActionListener {
	private IGridGame gameModel;
	private GameView gameView;

	public Controller(GameView gameView,IGridGame gameModel) {
		Objects.requireNonNull(gameView);
		Objects.requireNonNull(gameModel);
		this.gameView=gameView;
		this.gameModel=gameModel;
		this.gameView.getMenuView().getHint().addActionListener(this);
		this.gameView.getMenuView().getRestart().addActionListener(this);
		this.gameView.getMenuView().getRandomSolve().addActionListener(this);
		this.gameView.getMenuView().getChangeGame().addActionListener(this);
		this.gameView.getMenuView().getCancelPlay().addActionListener(this);
	}

	/**
	 * @param MouseEvent e (here click)
	 * When the mouse click on the grid, we take its position and place a point on the grid.
	 * The point is placed thanks to the placePont() method of the model class.
	 * The point is placed only if the click position is close to an line/column intersection of the grid (look at the if condition).
	 * At the same time the score is incremented and the menu print the new score.
	 */

	@Override
	public void mouseClicked(MouseEvent e) {
		double x=(double)e.getX()/(double)GridView.GRIDLINESWIDTH;
		double y=(double)e.getY()/(double)GridView.GRIDLINESWIDTH;
		if(!((Math.abs(x-Math.round(x))>0.25&&Math.abs(x-Math.round(x))<0.75)
				||(Math.abs(y-Math.round(y))>0.25&&Math.abs(y-Math.round(y))<0.75))){
			gameModel.placePoint((int)Math.round(x), (int)Math.round(y));
			this.gameView.getMenuView().setActualScore(this.gameModel.getListOfAlignment().size());
			this.gameView.getMenuView().repaint();
			this.gameView.getGridView().repaint();
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
	
	/**
	 * This method allows to react to a button click.
	 * It allows to give a hint, get a random solution, restart the game,
	 * change the game, and undo a point played, by reaction an the button click.
	 * @param e (represents an event : we take the click on the MenuView buttons).
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.gameView.getMenuView().getHint()) {
			if(this.gameModel.getPossiblePoint().size()==0) {
				this.gameView.getMenuView().getGameOver().setText("  Game over...");
			}	
			this.activHint();
		}
		else if(e.getSource()==this.gameView.getMenuView().getRandomSolve()) {
			this.gameView.getMenuView().getGameOver().setText("  Game over...");
			this.startRandomSolve();
		}
		else if(e.getSource()==this.gameView.getMenuView().getRestart()) {
			if(this.gameModel.getPossiblePoint().size()==0) {
				this.gameView.getMenuView().getGameOver().setText("");
			}
			this.restartGame();
		}
		else if(e.getSource()==this.gameView.getMenuView().getChangeGame()) {
			this.gameView.changeGame();
		}
		else if(e.getSource()==this.gameView.getMenuView().getCancelPlay()) {
			this.gameModel.cancelPlay();
			this.gameView.getMenuView().getGameOver().setText("");
			this.gameView.getMenuView().setActualScore(this.gameModel.getListOfAlignment().size());
			this.gameView.getMenuView().repaint();
			this.gameView.getGridView().repaint();
		}
		
	}

	
	public void startRandomSolve() {
		this.gameModel.randomSolve();
		this.gameView.getMenuView().setActualScore(this.gameModel.getListOfAlignment().size());
		this.gameView.getMenuView().repaint();
		this.gameView.getGridView().repaint();
	}
	
	public void restartGame() {
		this.gameModel.restartGame();
		this.gameView.getMenuView().setActualScore(this.gameModel.getListOfAlignment().size());
		this.gameView.getMenuView().repaint();
		this.gameView.getGridView().repaint();
	}
	
	public void activHint() {
		this.gameView.getGridView().setHint(true);
		this.gameView.getGridView().repaint();
	}

	public void setGameModel(IGridGame gameModel) {
		Objects.requireNonNull(gameModel);
		this.gameModel = gameModel;
	}
}
