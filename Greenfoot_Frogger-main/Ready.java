import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A simple class that asks if the user is ready and plays a sound. 
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
    
    /**
     * Constructor for Ready
     * @param resetSound        the sound to play
     */
    public Ready(GreenfootSound resetSound) {
        this.resetSound = resetSound;
        img = this.getImage();
        img.scale(200, 50);
    }
    
    /**
     * play
     * Plays the sound
     */
    public void play() {
        resetSound.play();
    }
    
    /**
     * stop
     * Stops the sound
     */
    public void stop() {
        resetSound.stop();
    }
    
    /**
     * getState
     * @return      whether the sound is done/the player should be ready
     */
    public boolean getState() {
        return isReady;
    }
    
    /**
     * act is called once per frame.
     * Controls variables transparecny based on whether the sound is playing.
     */
    public void act()
    {
        if(world == null) {
            world = getWorld();
            this.setLocation(world.getWidth()/2, world.getHeight()/2);
        }
        if(resetSound.isPlaying()) {
            isReady = false;
            img.setTransparency(255);
        } else {
            isReady = true;
            resetSound.stop();
            img.setTransparency(0);
        }
    }
}
