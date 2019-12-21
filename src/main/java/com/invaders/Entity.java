package com.invaders;

import java.awt.Graphics;
import java.util.Random;

public class Entity implements Commons {
	protected Random rand = new Random();
	protected int x, y;
	protected Sprites sprite;
	protected boolean visible = true;
	protected int health = 0;
	
	protected Game game;
	
	public Entity(Game game, int x, int y) {
		this.game = game;
		this.sprite = game.getBoard().getSprites();
		this.x = x;
		this.y = y;
		
	}
	
	
	protected void remove() {
		if(!visible) {
			if(this instanceof Projectile) {
				game.getProjectiles().remove(this);
			} else {
				game.getEntities().remove(this);
			}
			
		}
	}
	
	public void moveRight() {
		this.x += 2;
	}
	
	public void moveLeft() {
		this.x -= 2;
	}
	
	public void moveUp() {
		this.y -= 5;
	}
	
	public void moveDown() {
		this.y += 5;
	}
	
	protected void shoot() {
		
	}
	
	protected void update() {
	}
	
	protected void draw(Graphics g) {
		
	}
	

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Sprites getSprite() {
		return sprite;
	}

	public void setSprite(Sprites sprite) {
		this.sprite = sprite;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	

}
