package main.view;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class App {

	public static void main(String[] args) {
		JFrame frame= new JFrame("Join Five Game");
		frame.setSize(900, 600);
		JPanel game = new GameView();
		frame.setContentPane(game);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
	}
	
}
