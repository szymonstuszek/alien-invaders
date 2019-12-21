package com.invaders;

import java.io.File;
import java.util.ArrayList;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;

public class Game extends JFrame implements Runnable, Commons {
	private AlienFrame alienFrame;
	private Board board;
	private Thread animator;
	private Player player;
	private Shields shields;

	private int killsCount = 0;

	private boolean inGame;

	private ArrayList<Projectile> projectiles;
	private ArrayList<Entity> entities;

	public Game() {
		alienFrame = new AlienFrame();
		board = new Board(this);

		projectiles = new ArrayList<Projectile>();
		entities = new ArrayList<Entity>();

		alienFrame.add(board);
		alienFrame.initFrame();

		player = new Player(this, BOARD_WIDTH / 2, PLAYER_Y_POSITION);

		board.addKeyListener(new AlienAdapter(this));
		board.addMouseListener(new AlienMouseAdapter(this));
		board.setFocusable(true);

		initGameAssets();
		initGame();
	}


	public void initGame() {

		if (animator == null || !inGame) {
			animator = new Thread(this);
			animator.start();
			inGame = true;
			
		}
	}

	public void initGameAssets() {
		// dummy values to initialize the Shields class
		shields = new Shields(this, -5, -20);
		entities.add(player);
		initAliens();
		shields.initShields();
	}

	public void restartGame() {
		player = new Player(this, BOARD_WIDTH / 2, BOARD_HEIGHT - 80);
		projectiles = new ArrayList<Projectile>();
		entities = new ArrayList<Entity>();
		entities.add(player);
		initAliens();
		killsCount = 0;
		player.setHit(false);
		shields.initShields();
		try {
			animator.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void initBoss() {

		for (int i = 0; i < 1; i++) {
			for (int j = 0; j < 1; j++) {
				Alien alien = new Alien(this, i * 50, j * 50);
				entities.add(alien);
			}
		}
	}

	public void initAliens() {

		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 5; j++) {
				Alien alien = new Alien(this, i * 50, j * 50);
				entities.add(alien);
			}
		}

		// Drops drop = new Drops(this, 400, 400);
		// entities.add(drop);
	}

	public void update() {
		if (killsCount >= 50) {
			inGame = false;
		}
		int count = 0;
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).update();
		}

		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).update();
		}

		// for(int i = 0; i < entities.size(); i++) {
		// if(entities.get(i) instanceof Particle) count++;
		// }
		// System.out.println(count);
	}

	public void render() {
		board.repaint();

	}

	@Override
	public void run() {
		long previousTime, now, timeDifference, sleep;
		int fps;

		previousTime = System.currentTimeMillis();
		while (inGame) {
			update();
			render();
			timeDifference = System.currentTimeMillis() - previousTime;

			sleep = TIME_PER_FRAME - timeDifference;
			try {
				if (sleep < 0) {
					sleep = 1;
				}
				Thread.sleep(sleep);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			previousTime = System.currentTimeMillis();
		}

		// long lastTime = System.nanoTime();
		// long timer = System.currentTimeMillis();
		// final double ns = 1000000000.0 / 60.0;
		// int frames = 0;
		// int updates = 0;
		// double delta = 0;
		//
		// requestFocus();
		// while(inGame) {
		// long now = System.nanoTime();
		// delta += (now - lastTime) / ns;
		// lastTime = now;
		// while(delta>=1){
		// update();
		// updates++;
		// delta--;
		// }
		// render();
		// frames++;
		// if(System.currentTimeMillis() - timer >= 1000){
		// timer += 1000;
		// alienFrame.setTitle("ups: " + updates + " | fps:" + frames);
		// frames = 0;
		// updates = 0;
		// }
		// }
	}

	public AlienFrame getAlienFrame() {
		return alienFrame;
	}

	public void setAlienFrame(AlienFrame alienFrame) {
		this.alienFrame = alienFrame;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public Thread getAnimator() {
		return animator;
	}

	public void setAnimator(Thread animator) {
		this.animator = animator;
	}

	public boolean isInGame() {
		return inGame;
	}

	public void setInGame(boolean inGame) {
		this.inGame = inGame;
	}

	public ArrayList<Projectile> getProjectiles() {
		return projectiles;
	}

	public void setProjectiles(ArrayList<Projectile> projectiles) {
		this.projectiles = projectiles;
	}

	public ArrayList<Entity> getEntities() {
		return entities;
	}

	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public int getKillsCount() {
		return killsCount;
	}

	public void setKillsCount(int killsCount) {
		this.killsCount = killsCount;
	}

}
