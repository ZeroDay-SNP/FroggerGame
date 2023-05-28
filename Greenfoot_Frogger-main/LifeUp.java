import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * When the player interacts with this fly, the player will recieve an extra life.
 * 
 * @author      Zachary Sousa
 * @version     1.00
 */
public class LifeUp extends AbstFly
{
    private GreenfootSound lifeUp = new GreenfootSound("lifeup.wav");
    
    /*
     * Constructor for LifeUp
     */
    public LifeUp() {
        super(10, 25, 25);
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
                world.setLives(world.getLives()+1);
                player.playSound(lifeUp);
                alive = false;
        }
    }
}
