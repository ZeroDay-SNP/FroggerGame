import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;

/**
 * The fly flies down the screen. The Player should be able to interact with it.
 * 
 * @author      Zachary Sousa 
 * @version     1.00
 */
public abstract class AbstFly extends Actor
{
    protected int speed;
    protected int width;
    protected int height;
    protected Game world;
    protected GreenfootImage img;
    protected boolean alive = true;
    private int frameCount = 0;
    
    /*
     * Constructor for AbstOther
     * @param speed     the speed of the object
     */
    public AbstFly(int speed){
        this.speed = speed;
    }
    
    /*
     * Constructor for AbstOther
     * @param speed     the speed of the object
     * @param w         the width of the object
     * @param h         the height of the object
     */
    public AbstFly(int speed, int w, int h){
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
            setLocation(new Random().nextInt(world.getWidth()), -50);
        }
        frameCount++;
        //move it by speed
        setRotation(90);
        
        if(frameCount % 10 == 0) {
            setLocation(getX() + (int)Math.floor(Math.random() *(5 - -5 + 1) + -5), getY());
            move(speed);
        }
        //if it reaches the edge of the screen
        if(getX()>world.getWidth() + width/2){
            //set it to the other side
            setLocation(0 - width/2, getY());
        }
        else if(getX()<0 - width/2){
            setLocation(world.getWidth() + width/2, getY());
        }
        if(getAlive()) {
            img.setTransparency(255);
        } else {
            img.setTransparency(0);
        }
    }
    
    /**
     * getAlive
     * @return      alive
     */
    public boolean getAlive() {
        return alive;
    }
    
    
    /**
     * getType returns the type of fly
     * @return String       fly type (ex. "1up", "power")
     */
    /*
    public String getType() {
        return type;
    }
    */
    
    /**
     * interact called when interacting with the player
     */
    public abstract void interact(Frogger player);
}
