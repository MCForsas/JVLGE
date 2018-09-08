package objects;

import graphics.SpriteSheet;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/*
	Abstract GameObject, used for game objects, has tick and render methods, holds values like: x, y, spritesheet and
	sprite
	@author MCForsas 2018
 */

public abstract class GameObject {
	protected int x = 0;
	protected int y = 0;
	protected SpriteSheet spriteSheet;
	protected BufferedImage sprite;

	/*
	 * Ticks (loops trough object logic each game tick)
	 */
	public abstract void tick();

	/*
	 * Draws sprite if it's set
	 * @param Graphics g
	 */
	public void render(Graphics g){
		if(this.sprite != null){
			g.drawImage(
				this.sprite,
					this.x,
					this.y,
					null
			);
		}
	};

	public int getX() {
		return this.x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return this.y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
