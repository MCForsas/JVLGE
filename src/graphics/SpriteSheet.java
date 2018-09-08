package graphics;

import java.awt.image.BufferedImage;

/*
 * Divides image into sprites by width and can grab an image from sprite sheet
 * @author MCForsas 2018
 */

public class SpriteSheet {
	private BufferedImage sprite;
	private int imageSize = 0;

	/*
	 * assigns image and imageSize
	 * @param BufferedImage sprite image to get sprites from
	 * @param int imagesize sprite size 
	 */
	public SpriteSheet(BufferedImage sprite, int imageSize) {
		this.sprite = sprite;
		this.imageSize = imageSize;
	}

	/*
	 * Grabs part of image to be used as game sprite
	 * @param int column column in which sprite is
	 * @param int row row in which sprite is
	 * @return BuffedImage image returns image, which is used for sprite
	 */
	public BufferedImage grabImage(int column, int row, int width, int height) {
		BufferedImage image;
		image = this.sprite.getSubimage(
				row * imageSize - imageSize,
				column * imageSize - imageSize,
				width,
				height
		);
		return image;
	}
}
