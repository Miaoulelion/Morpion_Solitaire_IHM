package main.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;

import main.controller.Controller;
import main.model.GridGame5D;
import main.model.GridGame5T;
import main.model.IGridGame;


public class GameView extends JPanel{
	private IGridGame gameModel= new GridGame5D();
	private MenuView MenuView=new MenuView();
	private GridView gridView=new GridView(this.gameModel, this.MenuView);
	Controller gameController=new Controller(this, this.gameModel);
	private static final long serialVersionUID = 1L;

	public GameView() {
		this.setLayout(new BorderLayout(0,0));
		this.gridView.setPreferredSize(new Dimension(800,600));	
		this.gridView.addMouseListener(this.gameController);
		this.gridView.addMouseMotionListener((MouseMotionListener) this.gameController);
		this.add(this.gridView, BorderLayout.SOUTH);
		this.add(MenuView, BorderLayout.NORTH);
		this.MenuView.getGameNameLabel().setText("5D Version");	
	}

	public void changeGame() {
		if(this.gameModel instanceof GridGame5D) {
			this.gameModel = new GridGame5T();
			this.gridView.setGameModel(gameModel);
			this.gameController.setGameModel(gameModel);
			this.MenuView.getGameNameLabel().setText("5T Version");
			this.MenuView.setActualScore(this.gameModel.getListOfAlignment().size());
			this.MenuView.repaint();
			this.gridView.repaint();
		}else {
			this.gameModel= new GridGame5D();
			this.gridView.setGameModel(gameModel);
			this.gameController.setGameModel(gameModel);
			this.MenuView.getGameNameLabel().setText("5D Version");
			this.MenuView.setActualScore(this.gameModel.getListOfAlignment().size());
			this.MenuView.repaint();
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
