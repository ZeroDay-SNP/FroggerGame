import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class corpse here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Corpse extends Actor
{
    private int w = -99;
    private int h = -99;
    private GreenfootImage img;
    int rotation;
    int decay;
    World world;
    GreenfootSound squish;
    
    public Corpse(int w, int h, int rotation) {
        this.w = w;
        this.h = h;
        img = new GreenfootImage("death.png");
        img.scale(w, h);
        this.rotation = rotation;
        decay = 255;
        squish = new GreenfootSound("squish.wav");
    }
    
    /**
     * Act - do whatever the corpse wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(world == null) {
            world = getWorld();
            setRotation(rotation);
            squish.play();
        }
        getImage().setTransparency(decay);
        decay--;
        if(decay < 2) {
            world.removeObject(this);
        }
    }
}
