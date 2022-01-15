package applyGame;

import javax.swing.JFrame;
import javax.swing.JPanel;

import view.Game;

public class ApplyGridGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JFrame frame= new JFrame("Join Five Game");
		frame.setSize(800, 600);
		JPanel game = new Game();
		frame.setContentPane(game);
		frame.setVisible(true);
		//frame.isVisible();

	}
	
}
