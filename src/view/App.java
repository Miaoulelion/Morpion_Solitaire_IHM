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
		frame.setSize(900, 600);
		//JPanel game1=new GridView(gameModel);
		JPanel game = new GameView();
		frame.setContentPane(game);
		frame.setVisible(true);
		//frame.isVisible();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
	}
	
}
