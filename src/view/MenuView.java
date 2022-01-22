package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuView extends JPanel implements ActionListener{
	JButton restart = new JButton("Restart");
	JButton hint = new JButton("Can you continue ?");
	JButton changeGame = new JButton("Switch Game");
	JButton randomSolve = new JButton("Random");
	JPanel gridView;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MenuView(JPanel gridView) {
		setBackground(Color.WHITE);
		add(restart,BorderLayout.NORTH);
		add(hint,BorderLayout.SOUTH);
		add(randomSolve);
		add(changeGame);
		
		changeGame.addActionListener(this);
		restart.addActionListener(this);
		hint.addActionListener(this);
		randomSolve.addActionListener(this);
		this.gridView=gridView;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) { // le faire dans controller ? mais comment ? 
		// TODO Auto-generated method stub
		if(e.getSource()==this.hint) {
			((GridView)gridView).activHint();
		}
		if(e.getSource()==this.randomSolve) {
			((GridView)gridView).startRandomSolve();
		}
		
	}
	


}
