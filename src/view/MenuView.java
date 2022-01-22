package view;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuView extends JPanel {//implements ActionListener{
	JButton restart = new JButton("Restart");
	JButton hint = new JButton("Can you continue ?");
	JButton changeGame = new JButton("Switch Game");
	JButton randomSolve = new JButton("Random");


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MenuView() {
		setBackground(Color.WHITE);
		add(restart,BorderLayout.NORTH);
		add(hint,BorderLayout.SOUTH);
		add(randomSolve);
		add(changeGame);
		
	}

	
	

	public JButton getRestart() {
		return restart;
	}

	public JButton getHint() {
		return hint;
	}

	public JButton getChangeGame() {
		return changeGame;
	}

	public JButton getRandomSolve() {
		return randomSolve;
	}
	
	


}
