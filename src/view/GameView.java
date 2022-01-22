package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Objects;

import javax.swing.JPanel;

import controller.GridController;
import model.GridGame5T;
import model.IGridGame;

public class GameView extends JPanel{
	private IGridGame gridGame= new GridGame5T();
	private GridView gridView=new GridView(this.gridGame);
	private JPanel MenuView=new MenuView(gridView);
	MouseListener gameController=new GridController(this.gridView, this.gridGame);

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
	}
	

	public IGridGame getGridGame() {
		return gridGame;
	}



	public void setGridGame(IGridGame gameModel) {
		Objects.requireNonNull(gameModel);
		this.gridGame = gameModel;
	}


	
	
}
