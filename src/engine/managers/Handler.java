package engine.managers;

import java.awt.Graphics;
import java.util.LinkedList;

import objects.GameObject;

/*
 * Handles the game objects: ticks them, renders, adds or removes them
 * @author MCForsas 2018
 */

public class Handler{

	public LinkedList<GameObject> object = new LinkedList<GameObject>();

	/*
	 * Returns game object list
	 */
	public LinkedList<GameObject> getObject() {
		return this.object;
	}

	/*
	 * Ticks game objects
	 */
	public void tick() {
		for (int i = 0; i < object.size(); i++) {
			this.object.get(i).tick();;
		}
	}

	/*
	 * Render game objects
	 * @param Graphics g graphics object, used for rendering
	 */
	
	public void render(Graphics g) {
		for (int i = 0; i < object.size(); i++) {
			GameObject tempObject = object.get(i);
			tempObject.render(g);
		}
	}

	/*
	 * Adds game object to list
	 * @param GameObject object 
	 */
	public void addObject(GameObject object) {
		this.object.add(object);
	}

	/*
	 * Removes game object from list
	 * @param GameObject object 
	 */
	public void removeObject(GameObject object) {
		this.object.remove(object);
	}
	
	/*
	 * Removes all game objects
	 */
	public void clear() {
		this.object.clear();
	}
}
