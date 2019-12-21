package com.invaders;

import java.awt.Graphics;

public class AlienProjectile extends Projectile{

	public AlienProjectile(Game game, int x, int y) {
		super(game, x, y);
	}
	
	protected void draw(Graphics g) {
		if(visible) {
			g.drawImage(sprite.getAlienBomb(), x, y, null);
		}
	}
	
	protected void update() {
		moveDown();
		collide();
	}
	
	// alt movement
//	public void moveDown() {
//		this.y += 1;
//		
//		if(r.nextInt(2) == 0) {
//			this.x += r.nextInt(5);
//		} else {
//			this.x -= r.nextInt(5);
//		}
//	}
	
	public void collide() {
		if(this.y == Commons.BOARD_HEIGHT - 50) {
			for(int k = 0; k < (10 + rand.nextInt(50)) ; k++){
				Particle p = new Particle(game, getX(), getY());
				game.getEntities().add(p);
			}
			visible = false;
			remove();
			game.getProjectiles().remove(this);
		}
	}

}
