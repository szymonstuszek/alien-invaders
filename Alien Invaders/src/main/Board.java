package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Board extends JPanel implements Commons {
	private int boardWidth = BOARD_WIDTH;
	private int boardHeight = BOARD_HEIGHT;
	private Dimension dim = new Dimension(boardWidth, boardHeight);
	
	private Game game;
	private Sprites sprites;
	
	public Board(Game game) {
		this.game = game;
		setBackground(Color.BLACK);
		setPreferredSize(dim);
		
		sprites = new Sprites();
		setDoubleBuffered(true);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
//		if(!game.isInGame()) {
//			if(game.getKillsCount() >= 10) {
//				gameWon(g);
//			} else {
//				gameOver(g);
//			}
		
		
		if(!game.isInGame()) {
			gameOver(g);
			
		} else {
			g.setColor(Color.LIGHT_GRAY);
			g.fillRect(0, GROUND_HEIGHT , boardWidth + 100, 100);
			drawStats(g);
			
			for(int i = 0; i < game.getEntities().size(); i++) {
				game.getEntities().get(i).draw(g);
			}
			
			if(game.getProjectiles().size() != 0) {
				for(int i = 0; i < game.getProjectiles().size(); i++) {
					game.getProjectiles().get(i).draw(g);
				}
			}
		}
		
//		if(game.getKillsCount() >= 10) {
//			gameWon(g);
//			game.setInGame(false);
//		}
	}
	
	public void drawStats(Graphics g) {
		String kills = Integer.toString(game.getKillsCount());
		kills = "Aliens destroyed: " + kills;
		g.setColor(Color.WHITE);
		g.drawString(kills, 10 , BOARD_HEIGHT - 30);
	}
	
	public void gameOver(Graphics g) {
		g.setColor(Color.RED);
		Font font = new Font("Helvetica2", Font.BOLD, 48);
		g.setFont(font);
		g.drawString("GAME OVER", BOARD_WIDTH / 3 , BOARD_HEIGHT / 2);
	}
	
	public void gameWon(Graphics g) {
		g.setColor(Color.RED);
		Font font = new Font("Helvetica2", Font.BOLD, 48);
		g.setFont(font);
		g.drawString("You saved the galaxy!", 100 , BOARD_HEIGHT / 2);
	}

	public Sprites getSprites() {
		return sprites;
	}

	public void setSprites(Sprites sprites) {
		this.sprites = sprites;
	}
	
	

}
