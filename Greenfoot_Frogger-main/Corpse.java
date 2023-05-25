import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The decorative corpse that represents a previous death location for a small amount of time.
 * 
 * @author      Zachary Sousa 
 * @version     1.00
 */
public class Corpse extends Actor
{
    private int w = -99;
    private int h = -99;
    private GreenfootImage img;
    private int rotation;
    private int decay;
    private World world;
    private GreenfootSound squish;
    
    /**
     * Constructor for the corpse.
     * @param w         the width of the corpse in pixels
     * @param h         the height of the corpse in pixels
     * @param rotation  the rotation of the corpse in degrees
     */
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
     * act is called once per frame.
     * Slowly turns the corpse invisible before removing it.
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
