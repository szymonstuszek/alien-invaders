package main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AlienAdapter extends KeyAdapter {
	private Game game;
	int key;
	
	public AlienAdapter(Game game) {
		this.game = game;
	}

	public void keyPressed(KeyEvent e) {
		
		if(!game.isInGame()) {
			game.initGame();
			game.restartGame();
		}
		key = e.getKeyCode();
		if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) {
			game.getPlayer().moveLeft();
		} else

		if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) {
			game.getPlayer().moveRight();
		} else

		if (key == KeyEvent.VK_SPACE) {
			game.getPlayer().shoot();
		}

	}

}
