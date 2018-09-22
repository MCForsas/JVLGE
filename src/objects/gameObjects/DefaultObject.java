package objects.gameObjects;

import engine.game.Game;
import engine.game.Methods;
import engine.managers.KeyboardManager;
import engine.managers.MouseManager;
import engine.managers.ResourceManager;
import graphics.FontSheet;
import graphics.SpriteSheet;
import objects.GameObject;

/*
    Default game object. Is an example of how game object should function and how methods are used
    @author MCForsas 2018
 */

public class DefaultObject extends GameObject {

    private int spriteSize = 32;
    private int speed = 4;

    /*
        Generates game object, set x, y, coords. Set sprite from sprite sheet.
     */
    public DefaultObject(){
        this.x = 10;
        this.y = 10;
        try{
            this.spriteSheet = new SpriteSheet(ResourceManager.loadImage("Sheet.png"),this.spriteSize);
        }catch (Exception e){
            e.printStackTrace();
        }
        this.sprite = FontSheet.getSymbolImage('k'); //spriteSheet.grabImage(1,1, this.spriteSize, this.spriteSize);
    }

    @Override
    public void tick() {
        //Move by keyboard
        this.x += (KeyboardManager.getKeyPressedInt("D") - KeyboardManager.getKeyPressedInt("A"))*speed;
        this.y += (KeyboardManager.getKeyPressedInt("S") - KeyboardManager.getKeyPressedInt("W"))*speed;

        //Move by mouse
        if(MouseManager.getMouseButtonPressed(1)){
            this.x = MouseManager.getMouseX();
            this.y = MouseManager.getMouseY();
        }

        this.x = (int) Methods.clamp(this.x,0, Game.WINDOW_WIDTH - this.spriteSize);
        this.y = (int) Methods.clamp(this.y, 0,Game.WINDOW_HEIGHT - this.spriteSize);
    }

}
