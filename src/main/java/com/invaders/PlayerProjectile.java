package com.invaders;

import java.awt.Graphics;

public class PlayerProjectile extends Projectile{

	public PlayerProjectile(Game game, int x, int y) {
		super(game, x, y);
		
	}
	
	protected void draw(Graphics g) {
		if(this.visible) {
			g.drawImage(sprite.getPlayerBomb(), x + 15, y, null);
		}
		
	}
	
	protected void update() {
		moveUp();
		collide();
	}
	
	public void collide() {
		if(this.y == 0) {
			visible = false;
			remove();
			game.getPlayer().setShots(game.getPlayer().getShots() - 1);
		}
	}
	

}
