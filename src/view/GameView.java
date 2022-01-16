package view;

import java.awt.Graphics;
import java.util.Objects;

import javax.swing.JPanel;

import model.IGridGame;

public class GameView extends JPanel{
	private IGridGame gridGame;
	private JPanel gridView;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	public GameView(IGridGame gameModel) {
		Objects.requireNonNull(gameModel);
		this.gridGame=gameModel;
		this.gridView=new GridView(gameModel);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.gridView.paintComponents(g);
	}



	public IGridGame getGridGame() {
		return gridGame;
	}



	public void setGridGame(IGridGame gameModel) {
		Objects.requireNonNull(gameModel);
		this.gridGame = gameModel;
	}
	
	
}
