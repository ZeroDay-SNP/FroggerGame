import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Car here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Car extends AbstOther
{
    public Car(int speed, int w, int h){
        super(speed, w, h);
    }
    
    
    
    /**
     * Act - do whatever the Car wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        super.act();
    }
    
    
    public void interact(Frogger player){
        if(intersects(player)) {
            player.die();
        }
    }
}
