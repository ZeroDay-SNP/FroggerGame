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
    private boolean canSink = false;
    private final int sinkTime = 100;
    private int timeLeft = sinkTime;
    
    /**
     * Constructor for the Rock
     * @param w         the width of the log in px
     * @param h         the height of the log moves in px
     */
    public Rock(int w, int h, boolean canSink){
        super(0, w, h);
        this.canSink = canSink;
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
            if(canSink) {
                timeLeft -= 1;
                int transparency = (((timeLeft*100/sinkTime*100)*255)/10000);
                getImage().setTransparency(transparency);
                if(timeLeft < 1) {
                    player.die();
                }
            }
        } else {
            isTouching = false;
            timeLeft = sinkTime;
            getImage().setTransparency(255);
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
