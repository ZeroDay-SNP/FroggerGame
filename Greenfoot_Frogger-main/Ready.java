import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ready here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ready extends Actor
{   
    private GreenfootSound resetSound;
    private boolean isReady = false;
    private GreenfootImage img;
    private World world;
    
    public Ready(GreenfootSound resetSound) {
        this.resetSound = resetSound;
        //img = this.getImage();
    }
    
    public void reset() {
        resetSound.play();
    }
    
    public boolean getState() {
        return isReady;
    }
    
    /**
     * Act - do whatever the Ready wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(world == null) {
            world = getWorld();
            this.setLocation(world.getWidth()/2, world.getHeight()/2);
        }
        if(resetSound.isPlaying()) {
            isReady = false;
            //img.setTransparency(255);
        } else {
            isReady = true;
            //img.setTransparency(0);
        }
    }
}
