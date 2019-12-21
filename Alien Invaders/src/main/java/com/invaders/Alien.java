package com.invaders;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Alien extends Entity {
	private Drops drop;
	private boolean left = false;
	private boolean right = true;
	private int borderReached = 0;
	private boolean hit = false;
	private int hitCounter = 0;
	Random r = new Random();
	
	BufferedImage img;
	
	private int shots = 0;

	public Alien(Game game, int x, int y) {
		super(game, x, y);
		this.x = x;
		this.y = y;
		assignSprite();
	}
	
	private void assignSprite() {
		
		if(r.nextInt(2) == 0) {
			img = sprite.getAlien();
		} else {
			img = sprite.getAlien2();
		}
		
	}

	protected void draw(Graphics g) {
		if (hit) {
			g.drawImage(sprite.getExplosion(), x, y, null);
		}

		if (visible) {
			g.drawImage(img, x, y, null);
		}
	}
	
	protected void bossShoot() {
		AlienProjectile p = new AlienProjectile(game, getX() + 25 , getY() + 150);
		AlienProjectile p1 = new AlienProjectile(game, getX() + 75 , getY() + 150);
		game.getProjectiles().add(p);
		game.getProjectiles().add(p1);
	}
	
	
	
	//for boss
	protected void shoot() {
		AlienProjectile p = new AlienProjectile(game, getX() , getY());
		game.getProjectiles().add(p);
	}

	public void checkCollision() {
		if (game.getProjectiles().size() != 0) {
			for (int i = 0; i < game.getProjectiles().size(); i++) {
				if (game.getProjectiles().get(i) instanceof PlayerProjectile 
						&& game.getProjectiles().get(i).getX() >= this.getX()
						&& game.getProjectiles().get(i).getX() <= this.getX() + 30
						&& game.getProjectiles().get(i).getY() >= this.getY()
						&& game.getProjectiles().get(i).getY() <= this.getY() + 30) {
					game.getPlayer().setShots(game.getPlayer().getShots() - 1);
					game.getProjectiles().get(i).visible = false;
					game.getProjectiles().get(i).remove();
					hit = true;
					visible = false;
					
					for(int k = 0; k < (1 + rand.nextInt(5)) ; k++){
					Particle p = new Particle(game, getX(), getY());
					game.getEntities().add(p);
					}
					
					//drop bonus
					if(r.nextInt(10) == 1){
					drop = new Drops(game, getX(), getY());
					game.getEntities().add(drop);
					}
				}
			}
		}
	}
	
	protected void move() {
		if(this.getY() >= SURFACE_HEIGHT - 35) {
			for(int i = 0; i < game.getEntities().size(); i++) {
				if(game.getEntities().get(i) instanceof Shields) {
					game.getEntities().get(i).visible = false;
					game.getEntities().get(i).remove();
				}
			}
			
		}
		
		if(!hit) {
			checkCollision();
			if (right) {
				moveRight();
				if (x == Commons.BOARD_WIDTH) {
					right = false;
					left = true;
					this.y += 30;
				}
			} else {
				moveLeft();
				if (x == 0) {
					left = false;
					right = true;
					this.y += 30;
				}
			}
		}
	}

	protected void update() {
		if(shots < 1) {
			// shot frequency
			if(r.nextInt(2000) == 1) {
				shoot();
			}
		}
		
		if(hit) {
			hitCounter++;
		} else {
			move();
		}
		
		if (hit && hitCounter > 10) {
			remove();
			game.setKillsCount(game.getKillsCount() + 1);
		}
		
	}
}
