import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Road here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Road extends Actor
{
    int width;
    int height = 100;
    
    GreenfootImage img;
    World world;
    
    /**
     * Act - do whatever the Road wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
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
