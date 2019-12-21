package com.invaders;

import java.awt.Graphics;

public class Particle extends Entity {
	private int lifetime = 0;

	public Particle(Game game, int x, int y) {
		super(game, x, y);
		lifetime = 20 + rand.nextInt(20);
	}
	
	protected void draw(Graphics g) {
			g.drawImage(sprite.getParticle(), x, y, null);
	}
	
	public void update() {
		move();
		lifetime--;
		if(lifetime <= 0 || this.y >= GROUND_HEIGHT) {
			visible = false;
			remove();
		}
	}
	
	protected void move() {
		
		if(rand.nextInt(2) == 0) {
			this.x += rand.nextInt(3);
		} else {
			this.x -= rand.nextInt(3);
		}
		
		if(lifetime < 15 + rand.nextInt(10)) {
			this.y += rand.nextInt(3);
		} else {
			this.y -= rand.nextInt(3);
		}
		
	}

}
