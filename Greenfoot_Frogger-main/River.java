import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class River here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class River extends Actor
{
    int width;
    int height = 300;
    
    GreenfootImage img;
    World world;
    
    /**
     * Act - do whatever the River wants to do. This method is called whenever
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
        
    }
}
