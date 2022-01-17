package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Objects;

import javax.swing.JPanel;

import controller.GridController;
import model.GridGame5D;
import model.IGridGame;

public class GameView extends JPanel{
	private IGridGame gridGame= new GridGame5D();
	private GridView gridView=new GridView();
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
	}
	


/*		setLayout(new BorderLayout(0,0));
		board.setPreferredSize(new Dimension(680,600));		
		add(buttons, BorderLayout.NORTH);	
		board.addMouseListener(m);		
		add(board, BorderLayout.SOUTH);	*/

	public IGridGame getGridGame() {
		return gridGame;
	}



	public void setGridGame(IGridGame gameModel) {
		Objects.requireNonNull(gameModel);
		this.gridGame = gameModel;
	}


	
	
}
