package applyGame;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.GridGame5D;
import model.IGridGame;
import view.GameView;
import view.GridView;

public class ApplyGridGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IGridGame gameModel=new GridGame5D();
		JFrame frame= new JFrame("Join Five Game");
		frame.setSize(800, 600);
		JPanel game1=new GridView(gameModel);
		JPanel game = new GameView(gameModel);
		frame.setContentPane(game1);
		frame.setVisible(true);
		//frame.isVisible();

	}
	
}
