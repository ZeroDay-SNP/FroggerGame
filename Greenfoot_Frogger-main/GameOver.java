import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.GreenfootSound;

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends World
{
    Game g;
    //UIElement title;
    

    /**
     * Constructor for objects of class GameOver.
     * 
     */
    public GameOver(Game g)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(g.getWidth(), g.getHeight(), 1); 
        this.g = g;
        //title = new UIElement(new GifImage("title.gif"), 300, 100);
        //addObject(title, getWidth()/2, getHeight()/2-100);
    }
    
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
