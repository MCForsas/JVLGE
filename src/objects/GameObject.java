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
	protected float x = 0f;
	protected float y = 0f;
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
					(int) this.x,
					(int) this.y,
					null
			);
		}
	};

	public float getX() {
		return this.x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return this.y;
	}

	public void setY(float y) {
		this.y = y;
	}
}
