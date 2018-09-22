package engine.managers;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/*
    Manages all resources like fonts, images, sounds, by storing them in private hash maps
    @author MCForsas 2018
 */

public class ResourceManager {

    private static Map<String, Music> soundMap = new HashMap<String, Music>();
    private static Map<String, Music> musicMap = new HashMap<String, Music>();
    private static final String programRootPath = new File("").getAbsolutePath();

    /*
     * returns buffered image when provided a path to file
     * @param String path path to file
     * @return BufferedImage image
     */
    public static BufferedImage loadImage(String filePath) throws IOException {
        BufferedImage image = null;
        File imageFile = new File(programRootPath + "\\src\\resources\\images\\"+filePath);
        try {
            image = ImageIO.read(imageFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return image;
    }

    /*
     * Register loaded ttf font to graphics environment from font path
     * @param String filePath font file path
     */
    public void loadFont(String filePath) {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

        File fontFile = new File(programRootPath + "\\src\\resources\\fonts\\" + filePath);

        /*if(fontFile.exists()) {
            System.out.println("DEBUG: font file exists");
        }else{
            System.out.println("DEBUG: font file doesnt exist");
        }*/

        try {
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, fontFile));
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * Load music files by file path
     * @param String key key used in hash map to index the file
     * @param String filePath audio file path
     */
    public void loadMusic(String key, String filePath) {
        try {
            musicMap.put(key, new Music(programRootPath + "\\src\\resources\\audio\\music\\"+filePath));
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    /*
     * Load music files by file path
     * @param String key key used in hash map to index the file
     * @param String filePath audio file path
     */
    public void loadSound(String key, String filePath) {
        try {
            soundMap.put(key, new Music(programRootPath + "\\src\\resources\\audio\\sound\\"+filePath));
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    /*
     * Get music by name
     * @param string key
     * @return Music music object from local music map
     */
    public static Music getMusic(String key) {
        return musicMap.get(key);
    }

    /*
     * Get sound by name
     * @param string key
     * @param Sound sound object from local sound map
     */
    public static Music getSound(String key) {
        return soundMap.get(key);
    }


}
