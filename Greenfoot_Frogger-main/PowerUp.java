import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * When the player interacts with this fly, all movement of obstacles will stop
 * 
 * @author      Zachary Sousa
 * @version     1.00
 */
public class PowerUp extends AbstFly
{
    
    /*
     * Constructor for PowerUp
     */
    public PowerUp() {
        super(15, 25, 25);
    }
    
    /**
     * act is called once per frame, and just calls the super's act method.
     */
    public void act()
    {
        super.act();
    }
    
    /**
     * interact called every frame of gameplay
     */
    public void interact(Frogger player) {
        if(intersects(player)) {
                player.stopTime();
                alive = false;
        }
    }
}
