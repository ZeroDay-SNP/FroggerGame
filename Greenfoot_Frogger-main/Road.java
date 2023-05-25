import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A decorative background element.
 * 
 * @author      Zachary Sousa
 * @version     1.00
 */
public class Road extends Actor
{
    private int width;
    private int height = 100;
    
    private GreenfootImage img;
    private World world;
    
    /**
     * act is called once per frame.
     * Initializes the image elements of the river.
     */
    public void act()
    {
        if(world == null){
            world = getWorld();
            img = getImage();
            width = world.getWidth();
            img.scale(width, height);
        }
        // Add your action code here.
    }
}
