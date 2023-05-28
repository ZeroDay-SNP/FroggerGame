import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Has 
 * speed
 * width height
 * world, img
 * 
 * Does
 * move to the side 
 * resets to the other side
 * interacts with the player
 * 
 * @author      Zachary Sousa
 * @version     1.00
 */
public abstract class AbstOther extends Actor
{
    protected int speed;
    protected int width;
    protected int height;
    protected Game world;
    protected GreenfootImage img;
    protected Frogger frog;
    
    /*
     * Constructor for AbstOther
     * @param speed     the speed of the object
     */
    public AbstOther(int speed){
        this.speed = speed;
    }
    
    /*
     * Constructor for AbstOther
     * @param speed     the speed of the object
     * @param w         the width of the object
     * @param h         the height of the object
     */
    public AbstOther(int speed, int w, int h){
        this.speed = speed;
        this.width = w;
        this.height = h;
        this.img = getImage();
        img.scale(width, height);
    }
    
    /**
     * Act - do whatever the AbstOther wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (world == null){
            world = (Game)getWorld();
            frog = world.getFrog();
        }
        if(!frog.hasPow()) {
            //move it by speed
            move(speed);
            //if it reaches the edge of the screen
            if(getX()>world.getWidth() + width/2){
                //set it to the other side
                setLocation(0 - width/2, getY());
            }
            else if(getX()<0 - width/2){
                setLocation(world.getWidth() + width/2, getY());
            }
        } 
    }
    
    /**
     * interact called when interacting with the player
     */
    public abstract void interact(Frogger player);
}
