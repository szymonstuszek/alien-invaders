package com.invaders;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Sprites {
	private BufferedImage alien, alien2, boss, player, explosion, alienBomb, playerBomb, playerDie,
	shield3, shield2, shield1, drop, particle, plasma;
	private URL alienURL, alien2URL, bossURL, playerURL, explosionURL, alienBombURL, playerBombURL, playerDieURL,
	shield3URL, shield2URL, shield1URL, dropURL, particleURL, plasmaURL;
	
	public Sprites() {
		initGraphics();
	}
	
	public void initGraphics() {
		alienURL = Sprites.class.getResource("/alien.png");
		alien2URL = Sprites.class.getResource("/alien2.png");
		playerURL = Sprites.class.getResource("/player.png");
		explosionURL = Sprites.class.getResource("/alien_die.png");
		playerDieURL = Sprites.class.getResource("/player_die.png");
		alienBombURL = Sprites.class.getResource("/alien_bomb.png");
		playerBombURL = Sprites.class.getResource("/player_bomb.png");
		shield3URL = Sprites.class.getResource("/shield3.png");
		shield2URL = Sprites.class.getResource("/shield2.png");
		shield1URL = Sprites.class.getResource("/shield1.png");
		dropURL = Sprites.class.getResource("/drop.png");
		bossURL = Sprites.class.getResource("/boss.png");
		plasmaURL = Sprites.class.getResource("/plasma.png");
		particleURL = Sprites.class.getResource("/particle.png");
		
		try {
			setAlien(ImageIO.read(alienURL));
			setAlien2(ImageIO.read(alien2URL));
			setPlayer(ImageIO.read(playerURL));
			setPlayerBomb(ImageIO.read(playerBombURL));
			setAlienBomb(ImageIO.read(alienBombURL));
			setExplosion(ImageIO.read(explosionURL));
			setPlayerDie(ImageIO.read(playerDieURL));
			setShield3(ImageIO.read(shield3URL));
			setShield2(ImageIO.read(shield2URL));
			setShield1(ImageIO.read(shield1URL));
			setDrop(ImageIO.read(dropURL));
			setBoss(ImageIO.read(bossURL));
			setPlasma(ImageIO.read(plasmaURL));
			setParticle(ImageIO.read(particleURL));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public BufferedImage getAlien() {
		return alien;
	}

	public void setAlien(BufferedImage alien) {
		this.alien = alien;
	}

	public BufferedImage getPlayer() {
		return player;
	}

	public void setPlayer(BufferedImage player) {
		this.player = player;
	}

	public BufferedImage getExplosion() {
		return explosion;
	}

	public void setExplosion(BufferedImage explosion) {
		this.explosion = explosion;
	}

	public BufferedImage getAlienBomb() {
		return alienBomb;
	}

	public void setAlienBomb(BufferedImage alienBomb) {
		this.alienBomb = alienBomb;
	}

	public BufferedImage getPlayerBomb() {
		return playerBomb;
	}

	public void setPlayerBomb(BufferedImage playerBomb) {
		this.playerBomb = playerBomb;
	}

	public BufferedImage getPlayerDie() {
		return playerDie;
	}

	public void setPlayerDie(BufferedImage playerDie) {
		this.playerDie = playerDie;
	}

	public BufferedImage getShield3() {
		return shield3;
	}

	public void setShield3(BufferedImage shield3) {
		this.shield3 = shield3;
	}

	public BufferedImage getShield2() {
		return shield2;
	}

	public void setShield2(BufferedImage shield2) {
		this.shield2 = shield2;
	}

	public BufferedImage getShield1() {
		return shield1;
	}

	public void setShield1(BufferedImage shield1) {
		this.shield1 = shield1;
	}

	public URL getDropURL() {
		return dropURL;
	}

	public void setDropURL(URL dropURL) {
		this.dropURL = dropURL;
	}

	public BufferedImage getDrop() {
		return drop;
	}

	public void setDrop(BufferedImage drop) {
		this.drop = drop;
	}

	public BufferedImage getAlien2() {
		return alien2;
	}

	public void setAlien2(BufferedImage alien2) {
		this.alien2 = alien2;
	}

	public URL getAlien2URL() {
		return alien2URL;
	}

	public void setAlien2URL(URL alien2url) {
		alien2URL = alien2url;
	}

	public URL getBossURL() {
		return bossURL;
	}

	public void setBossURL(URL bossURL) {
		this.bossURL = bossURL;
	}

	public BufferedImage getBoss() {
		return boss;
	}

	public void setBoss(BufferedImage boss) {
		this.boss = boss;
	}

	public URL getPlasmaURL() {
		return plasmaURL;
	}

	public void setPlasmaURL(URL plasmaURL) {
		this.plasmaURL = plasmaURL;
	}

	public BufferedImage getPlasma() {
		return plasma;
	}

	public void setPlasma(BufferedImage plasma) {
		this.plasma = plasma;
	}

	public BufferedImage getParticle() {
		return particle;
	}

	public void setParticle(BufferedImage particle) {
		this.particle = particle;
	}

	public URL getParticleURL() {
		return particleURL;
	}

	public void setParticleURL(URL particleURL) {
		this.particleURL = particleURL;
	}
	
	

}
