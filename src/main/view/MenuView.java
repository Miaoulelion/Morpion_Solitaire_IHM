package main.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuView extends JPanel {//implements ActionListener{
	private JButton restart = new JButton("Restart");
	private JButton hint = new JButton("Can you continue ?");
	private JButton changeGame = new JButton("Switch Game");
	private JButton randomSolve = new JButton("Random");
	private JButton cancelPlay = new JButton("Cancel");
	private JLabel scoreLabel = new JLabel();
	private JLabel gameNameLabel=new JLabel();
	private JLabel gameOver=new JLabel();
	private int actualScore;
	private static final long serialVersionUID = 1L;

	
	public MenuView() {
		setBackground(Color.WHITE);
		add(scoreLabel,BorderLayout.SOUTH);
		add(restart,BorderLayout.NORTH);
		add(hint,BorderLayout.SOUTH);
		add(randomSolve);
		add(cancelPlay);
		add(changeGame);
		add(gameNameLabel,BorderLayout.EAST);
		add(gameOver);
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

	public JLabel getGameName() {
		return gameNameLabel;
	}

	public JLabel getScoreLabel() {
		return scoreLabel;
	}

	public JButton getCancelPlay() {
		return cancelPlay;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.getScoreLabel().setText("Score : " + this.actualScore);
	}

	public void setActualScore(int actualScore){
		if(actualScore<0) {
			throw new IllegalArgumentException("The score can't be negative.");
		}
		this.actualScore = actualScore;
	}

	public JLabel getGameNameLabel() {
		return gameNameLabel;
	}

	public JLabel getGameOver() {
		return gameOver;
	}



}
