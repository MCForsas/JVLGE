package engine;

import java.awt.Graphics;

import objects.gameObjects.DefaultObject;

/*
 * Manages all levels ticks them, changes and cleans up
 * @author MCForsas 2018
 */
public class LevelManager {
	
	private static Levels currentLevel;
	public static Handler handler;
	
	/*
	 * Initializes object and start the defauult level
	 * @param Levels first level
	 */
	LevelManager(Levels startLevel) {
		handler = new Handler();
		currentLevel = startLevel;
		startLevel();
	}
	
	/*
	 * Changes current level to the one provided
	 * @param Levels level
	 */
	public static void changeLevel(Levels level) {
		currentLevel = level;
		startLevel();
	}
	
	/*
	 * Starts the level - clean all objects and initiate level objects
	 */
	private static void startLevel() {
		handler.clear();
		switch (currentLevel) {
			case TEST:{
				/*
				 * Main menu
				 */
				handler.addObject(new DefaultObject());
				break;
			}

			default:
				break;
		}
	}
	
	/*
	 * Ticks all objects
	 */
	public void tick() {
		handler.tick();
	}
	
	/*
	 * Renders all objects
	 * @param Graphics g
	 */
	public void render(Graphics g) {
		handler.render(g);
	}
}