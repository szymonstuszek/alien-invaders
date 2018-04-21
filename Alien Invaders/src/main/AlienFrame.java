package main;

import javax.swing.JFrame;

public class AlienFrame extends JFrame {
	
	public AlienFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Space Invaders");
		
		setVisible(true);
		
		
		
	}
	
	public void initFrame() {
		setResizable(false);
		pack();
	}
}
