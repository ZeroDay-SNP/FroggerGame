import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Home here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Home extends AbstOther
{
    public Home(int s) {
        super(0);
    }
    
    /**
     * Act - do whatever the Home wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    
    
    public void interact(Frogger player) {
        if(intersects(player)) {
            //increase level var
            Game game = (Game)getWorld();
            game.setLevel(game.getLevel()+1);
            //call the frog reset method
        }
    }
}
