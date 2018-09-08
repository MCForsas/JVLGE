package engine;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.image.BufferStrategy;

import graphics.Window;

import java.awt.Graphics;

/*
 * Runs the game, instantiate needed object, hold game thread, hold all global fields
 * @author MCForsas 2018
 */

public class Game extends Canvas implements Runnable {

	public static final int WINDOW_WIDTH = 720, WINDOW_HEIGHT = WINDOW_WIDTH / 12 * 9;

	private static int fps = 0;
	private static final long serialVersionUID = -1178041823728909735L;
	private Thread thread;
	private boolean running = false;
	private LevelManager level;

	/*
	 * Instantiates objects and window
	 */
	private Game() {
		//Load all resources
		ResourceManager resourceManager = new ResourceManager();

		resourceManager.loadFont("BEBAS.ttf");
		resourceManager.loadMusic("menuMusic","Music.ogg");
		resourceManager.loadSound("victory","victory.ogg");

		//Create level manager and
		this.level = new LevelManager(Levels.TEST);
		
		//Add input listeners
		this.addKeyListener(new KeyboardManager());
		this.addMouseListener(new MouseManager());
		
		//Create game window
		new Window(WINDOW_WIDTH, WINDOW_HEIGHT, "Chess", this);
	}

	
	/*
	 * Starts a new thread, on which all game is held
	 */
	public synchronized void start() {
		this.thread = new Thread(this);
		this.thread.start();
		this.running = true;
	}
	
	/*
	 * Stops the thread;
	 */
	private synchronized void stop() {
		try {
			this.thread.join();
			this.running = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Adds 'ticks' to the game. Get FPS. Call tick() and render()
	 */
	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while (this.running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				delta--;
			}
			if (this.running) render();
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				fps = frames;
				frames = 0;
			}
		}
		stop();
	}

	/*
	 * Ticks the game objects
	 */
	private void tick() {
		this.level.tick();
	}

	/*
	 * Renders all game objects, backgrouds, hud's and etc
	 */
	private void render() {
		BufferStrategy bufferStrategy = this.getBufferStrategy();
		if (bufferStrategy == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bufferStrategy.getDrawGraphics();
		
		//Render background
		g.setColor(new Color(0,0,0));
		g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);

		//Render level
		this.level.render(g);
		
		g.dispose();
		bufferStrategy.show();
	}

	/*
		Returns current game fps
		@return int fps game fps
	 */
	public static int getFps() {
		return fps;
	}

	/*
	 * Starts the game
	 */
	public static void main(String args[]) {
		new Game();
	}
}
