import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Simple moving car obstacle.
 * 
 * @author      Zachary Sousa
 * @version     1.00
 */
public class Car extends AbstOther
{
    /**
     * Constructor for the Car
     * @param speed     the speed that the car moves in px
     * @param w         the width of the car in px
     * @param h         the height of the car moves in px
     */
    public Car(int speed, int w, int h){
        super(speed, w, h);
    }
    
    /**
     * act is called once per frame, and just calls the super's act method.
     */
    public void act()
    {
        super.act();
    }
    
    /**
     * interact
     * called once per frame by the Game
     * @param player        the main player object
     */
    public void interact(Frogger player){
        if(intersects(player)) {
            player.die();
        }
    }
}
