import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.GreenfootSound;

/**
 * The world for the Game Over screen
 * 
 * @author      Zachary Sousa
 * @version     1.00
 */
public class GameOver extends World
{
    Game g;
    //UIElement title;
    

    /**
     * Constructor for objects of class GameOver.
     * @param g     the main game world
     */
    public GameOver(Game g)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(g.getWidth(), g.getHeight(), 1); 
        this.g = g;
        //title = new UIElement(new GifImage("title.gif"), 300, 100);
        //addObject(title, getWidth()/2, getHeight()/2-100);
    }
    
    /**
     * act is called once per frame.
     * By pressing space the player can move to the title screen.
     */
    public void act() {
        showText("GAME OVER\nPRESS SPACE", getWidth()/2, getHeight()/2);
        String key = Greenfoot.getKey();
        if(key != null) {
            if(key.equals("space")) {
                Greenfoot.setWorld(new Start(g));
            }
        }
    }
}
