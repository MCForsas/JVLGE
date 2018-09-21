package graphics;

import org.lwjgl.Sys;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class FontSheet {

    //private final int columns, rows;
    //private static Map<String, IntegerArray> letterTextures = new HashMap<String, IntegerArray>();

    public static BufferedImage getSymbolImage(Character symbol){
        BufferedImage fontSheet = null;
        try {
            fontSheet = ImageIO.read(new FileInputStream("src/resources/images/ubuntuMono.png"));
        }catch (IOException e) {
            e.printStackTrace();
        }

        int symbolWidth = 32;
        int symbolHeight = 64;
        int colCount = 16;
        int rowCount = 16;

        int charInt = (int) symbol.charValue() - 32;

        int symbolCol = charInt % colCount;
        int symbolRow = charInt/colCount;


        BufferedImage symbolImage = fontSheet.getSubimage(symbolCol*symbolWidth, symbolRow*symbolHeight, symbolWidth, symbolHeight);

        System.out.printf("x: %d, y: %d, width: %d, height: %d", symbolCol*symbolWidth, symbolRow*symbolHeight, symbolWidth, symbolHeight);
//        try {
//            File outputfile = new File("image.png");
//            ImageIO.write(symbolImage, "png", outputfile);
//        }catch (IOException e){
//            e.printStackTrace();
//        }
        return  symbolImage;
    }
}

