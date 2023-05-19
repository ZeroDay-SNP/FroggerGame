import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.GreenfootSound;

/**
 * Write a description of class Start here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Start extends World
{
    Game g;
    UIElement title;
    GreenfootSound titleTrack;

    /**
     * Constructor for objects of class Start.
     * 
     */
    public Start(Game g)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(g.getWidth(), g.getHeight(), 1); 
        this.g = g;
        title = new UIElement(new GifImage("title.gif"), 300, 100);
        addObject(title, getWidth()/2, getHeight()/2-100);
    }
    
    public void act() {
        if(titleTrack == null) {
            titleTrack = new GreenfootSound("funnysong.mp3");
            titleTrack.playLoop();
        }
        showText("PRESS SPACE", getWidth()/2, getHeight()/2);
        String key = Greenfoot.getKey();
        if(key != null) {
            if(key.equals("space")) {
                Greenfoot.setWorld(g);
            } else if (key.equals("p")) {
                if(titleTrack.isPlaying()) {
                    titleTrack.pause();
                } else {
                    titleTrack.playLoop();
                }
            } else if(key.equals("m")) {
                if(titleTrack.getVolume() == 100) {
                    titleTrack.setVolume(0);
                } else {
                    titleTrack.setVolume(100);
                }
            }
        }
    }
}
