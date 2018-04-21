package main;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AlienMouseAdapter extends MouseAdapter{
	private Game game;
	
	public AlienMouseAdapter(Game game) {
		this.game = game;
	}
	
	public void mouseClicked(MouseEvent e) {
		System.out.println(e.getSource().getClass() + " " + e.getX() + " " + e.getY());
		
		System.out.println(game.getAccessibleContext());
		
	}

}
