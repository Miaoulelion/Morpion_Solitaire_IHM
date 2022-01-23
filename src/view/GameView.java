package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseMotionListener;
import java.util.Objects;

import javax.swing.JPanel;

import controller.Controller;
import model.GridGame5D;
import model.GridGame5T;
import model.IGridGame;

public class GameView extends JPanel{
	private IGridGame gameModel= new GridGame5D();
	private GridView gridView=new GridView(this.gameModel);
	private MenuView MenuView=new MenuView();
	Controller gameController=new Controller(this, this.gameModel);

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	
	
	public GameView() {
		this.setLayout(new BorderLayout(0,0));
		this.gridView.setPreferredSize(new Dimension(800,600));	
		this.gridView.addMouseListener(this.gameController);
		this.gridView.addMouseMotionListener((MouseMotionListener) this.gameController);
		this.add(this.gridView, BorderLayout.SOUTH);
		this.add(MenuView, BorderLayout.NORTH);
		this.MenuView.gameName.setText("5D Version");
		
	}
	

	public IGridGame getGridGame() {
		return gameModel;
	}
	


	public void setGridGame(IGridGame gameModel) {
		Objects.requireNonNull(gameModel);
		this.gameModel = gameModel;
		
	}

	public void changeGame() {
		if(this.gameModel instanceof GridGame5D) {
			this.gameModel = new GridGame5T();
			this.gridView.setGameModel(gameModel);
			this.gameController.setGameModel(gameModel);
			this.MenuView.gameName.setText("5T Version");
			this.gridView.repaint();
		}else {
			this.gameModel= new GridGame5D();
			this.gridView.setGameModel(gameModel);
			this.gameController.setGameModel(gameModel);
			this.MenuView.gameName.setText("5D Version");
			this.gridView.repaint();

		}
	
	}


	public GridView getGridView() {
		return gridView;
	}


	public MenuView getMenuView() {
		return MenuView;
	}

	
	
}
