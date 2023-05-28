import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A log that the player can ride.
 * 
 * @author      Zachary Sousa
 * @version     1.00
 */
public class Log extends AbstOther
{
    private boolean isTouching = false;
    
    /**
     * Constructor for the Log
     * @param s         the speed that the log moves in px
     * @param w         the width of the log in px
     * @param h         the height of the log moves in px
     */
    public Log (int s, int w, int h){
        super(s, w, h);
    }

    /**
     * interact
     * Called once per frame by the Game.
     * Moves the player with the log.
     * @param player        the main player object
     */
    public void interact(Frogger player){
        if(intersects(player)) {
            if(!frog.hasPow()) {
                player.setLocation(player.getX()+speed, player.getY());
            }
            isTouching = true;
        } else {
            isTouching = false;
        }
    }
    
    /**
     * setSpeed
     * Sets the speed of the Car.
     */
    public void setSpeed(int s) {
        this.speed = s;
    }
    
    /**
     * getTouch
     * @return      true or false depending on if the player is touching the Log
     */
    public boolean getTouch() {
        return isTouching;
    }
}
