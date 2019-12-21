package com.invaders;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Shields extends Entity {
	private int health = SHIELD_HEALTH;
	private Rectangle r;
	

	public Shields(Game game, int x, int y) {
		super(game, x, y);
		r = new Rectangle(x, y, SHIELD_WIDTH, SHIELD_HEIGHT);
		game.getEntities().add(this);
		
	}
	
	public void initShields() {
		for(int i = 0; i < 20; i++) {
			for(int j = 0; j < 2; j++) {
			Shields shield = new Shields(game, i * 5 + 50, 500 - 5 * j);
			}
		}
		
		for(int i = 0; i < 20; i++) {
			for(int j = 0; j < 2; j++) {
			Shields shield = new Shields(game, i * 5 + 250, 500 - 5 * j);
			}
		}
		
		for(int i = 0; i < 20; i++) {
			for(int j = 0; j < 2; j++) {
			Shields shield = new Shields(game, i * 5 + 450, 500 - 5 * j);
			}
		}
		
		for(int i = 0; i < 20; i++) {
			for(int j = 0; j < 2; j++) {
			Shields shield = new Shields(game, i * 5 + 650, 500 - 5 * j);
			}
		}
	}
	
	protected void update() {
		checkDamage();
		checkCollsion();
	}
	
	public void checkCollsion() {
		if (game.getProjectiles().size() != 0) {
			for (int i = 0; i < game.getProjectiles().size(); i++) {
				if (game.getProjectiles().get(i) instanceof AlienProjectile 
						&& r.contains(game.getProjectiles().get(i).getX(), game.getProjectiles().get(i).getY())) {
					//particles
					
					for(int k = 0; k < (10 + rand.nextInt(50)) ; k++){
					Particle p = new Particle(game, getX(), getY());
					game.getEntities().add(p);
					}
					
					game.getProjectiles().get(i).visible = false;
					game.getProjectiles().get(i).remove();
					health--;
				}
			}
		}
	}
	
	public void checkDamage() {
		if(health == 0) {
			visible = false;
			this.remove();
		}
	}
	
	protected void draw(Graphics g) {
		if(visible) {
			if(health == 3) {
				g.drawImage(sprite.getShield3(), x, y, null);
			} else if(health == 2) {
				g.drawImage(sprite.getShield2(), x, y, null);
			} else if(health == 1) {
				g.drawImage(sprite.getShield1(), x, y, null);
			} 
		}
	}

	public Rectangle getR() {
		return r;
	}

	public void setR(Rectangle r) {
		this.r = r;
	}

}
