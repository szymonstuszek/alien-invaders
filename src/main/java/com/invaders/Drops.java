package com.invaders;

import java.awt.Graphics;

public class Drops extends Entity{

	public Drops(Game game, int x, int y) {
		super(game, x, y);
	}
	
	protected void draw(Graphics g) {
		if(visible) {
			g.drawImage(sprite.getDrop(), x, y, null);
		}
	}
	
	protected void update() {
		move();
		collide();
	}
	
	protected void move() {
		if(this.getY() <= SURFACE_HEIGHT) {
			moveDown();
		}
	}
	
	public void collide() {
		if(this.getX() == game.getPlayer().getX() && this.getY() >= PLAYER_Y_POSITION) {
			setVisible(false);
			this.remove();
			game.getPlayer().pickUp();
		}
		
	}

}
