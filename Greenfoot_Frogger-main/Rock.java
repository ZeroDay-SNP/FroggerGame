import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A rock that the player can stand on safely.
 * 
 * @author      Zachary Sousa
 * @version     1.00
 */
public class Rock extends AbstOther
{
    private boolean isTouching = false;
    
    /**
     * Constructor for the Rock
     * @param w         the width of the log in px
     * @param h         the height of the log moves in px
     */
    public Rock(int w, int h){
        super(0, w, h);
    }
    
    /**
     * interact
     * Called once per frame by the Game.
     * @param player        the main player object
     */
    public void interact(Frogger player){
        if(intersects(player)) {
            player.setLocation(getX(), getY());
            isTouching = true;
        } else {
            isTouching = false;
        }
    }
    
    /**
     * getTouch
     * @return      true or false depending on if the player is touching the Rock
     */
    public boolean getTouch() {
        return isTouching;
    }
}
