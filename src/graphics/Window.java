package graphics;

import java.awt.*;

import javax.swing.JFrame;

import engine.game.Game;

/*
 * Creates window and adds game to it
 * @author MCForsas 2018
 */

public class Window extends Canvas {

	private static final long serialVersionUID = -240840600533728354L;
	static GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];
	private int windowWidth = 1280, windowHeight = 720;
	private int displayWidth = device.getDisplayMode().getWidth(), displayHeight = device.getDisplayMode().getHeight();
	private JFrame frame;
	private boolean isInFullScreen = false;

	/*
	 *Creates window, adds game to it and starts the game
	 *@param int width window width
	 *@param int height window height
	 *@param String title window title
	 *@param Game game game object
	 */
	public Window(int width, int height, String title, Game game) {
		windowWidth = width;
		windowHeight = height;
		frame = new JFrame(title);
		frame.setPreferredSize(new Dimension(windowWidth, windowHeight));
		frame.setMaximumSize(new Dimension(windowWidth, windowHeight));
		frame.setMinimumSize(new Dimension(windowWidth, windowHeight));

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		//frame.setLocationRelativeTo(null);
		centerWindow();
		frame.add(game);

		//frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

		frame.setBackground(Color.BLACK);
		frame.setVisible(true);

		System.out.println(
				"Created window: size: " + windowWidth + "x" + windowHeight +
				". Display size: " + displayWidth + "x" + displayHeight +
				"@" + device.getDisplayMode().getRefreshRate() + "Hz"
		);

		game.start();
	}


	/*
		Turns on full screen
	 */
	public void enableFullscreen(){
		device.setFullScreenWindow(frame);
		frame.setUndecorated(true);
		isInFullScreen = true;
	}

	/*
		Turns off full screen
	 */
	public void disableFullscreen(){
		device.setFullScreenWindow(null);
		frame.setUndecorated(false);
		isInFullScreen = false;
	}

	/*
		Centers game window in the middle of the screen
	 */
	public void centerWindow(){
		if(!isInFullScreen){
			frame.setLocation(displayWidth/2 - windowWidth/2,displayHeight/2 - windowHeight/2);
			//frame.setLocationRelativeTo(null);
		}
	}

}
