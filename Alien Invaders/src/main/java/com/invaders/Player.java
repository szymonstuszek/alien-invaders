package com.invaders;

import java.awt.Graphics;

public class Player extends Entity {
	private int shots = 0;
	private int maxShots = MAX_NUMBER_OF_SHOTS;
	private PlayerProjectile p;
	private boolean hit = false;
	private int hitTimer = 0;
	private int frameCount = 0;
	private int health = PLAYER_HEALTH;
	private int bonusTimer = 0;
	private boolean pickedUpBonus = false;

	public Player(Game game, int x, int y) {
		super(game, x, y);
		this.x = x;
		this.y = y;
		System.out.println(health);

	}

	protected void update() {
		checkCollision();
		cooldown();
		die();
		checkForBonus();
	}
	
	public void cooldown() {
		if(hit) {
			hitTimer++;
			if(hitTimer > 100) {
				hit = false;
			}
		}
	}
	
	public void resetStats() {
		maxShots = 3;
	}
	
	public void checkForBonus() {
		if(pickedUpBonus) {
			bonusTimer++;
		}
		
		if(bonusTimer > 200) {
			bonusTimer = 0;
			pickedUpBonus = false;
			resetStats();
		}
	}
	
	public void pickUp() {
		System.out.println("Bonus!!");
		maxShots = 10;
		pickedUpBonus = true;
	}


	protected void draw(Graphics g) {
		if(hit) {
			frameCount++;
			if(frameCount % 2 == 0) {
				g.drawImage(sprite.getPlayer(), x, y, null);
			} else {
				g.drawImage(sprite.getPlayerDie(), x, y, null);
			}
			
		} else {
			g.drawImage(sprite.getPlayer(), x, y, null);
			
		}
	}

	protected void shoot() {
		if (shots < maxShots) {
			shots++;
			p = new PlayerProjectile(game, x, y);
			game.getProjectiles().add(p);
		}
	}

	public int getShots() {
		return shots;
	}

	public void setShots(int shots) {
		this.shots = shots;
	}
	
	public void die() {
		if(health == 0) {
			game.setInGame(false);
		}
		
	}
	
	public void checkCollision() {
		if (game.getProjectiles().size() != 0) {
			for (int i = 0; i < game.getProjectiles().size(); i++) {
				if (game.getProjectiles().get(i) instanceof AlienProjectile
						&& game.getProjectiles().get(i).getX() >= this.getX()
						&& game.getProjectiles().get(i).getX() <= this.getX() + 30
						&& game.getProjectiles().get(i).getY() >= this.getY()
						&& game.getProjectiles().get(i).getY() <= this.getY() + 30) {
					hit = true;
					health--;
					game.getProjectiles().get(i).visible = false;
					game.getProjectiles().get(i).remove();
					
				}
			}
		}
	}

	public boolean isHit() {
		return hit;
	}

	public void setHit(boolean hit) {
		this.hit = hit;
	}
}
