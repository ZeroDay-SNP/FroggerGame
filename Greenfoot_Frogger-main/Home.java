import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.GreenfootSound;

/**
 * The goal for the player to get to.
 * 
 * @author      Zachary Sousa
 * @version     1.00
 */
public class Home extends AbstOther
{
    
    private GreenfootSound winSound = new GreenfootSound("win.wav");
    
    /**
     * Constructor for the Home/goal.
     * @param s     doesn't do anything currently
     */
    public Home(int s) {
        super(0);
    }
    
    /**
     * interact
     * gets called once per frame of gameplay by the Game. If the player
     * touches the Home then a happy sound is played, the level number
     * is incremented, and the level refreshes.
     * @param player        the main player object (Frogger)
     */
    public void interact(Frogger player) {
        if(intersects(player)) {
            //increase level var
            Game game = (Game)getWorld();
            game.setLevel(game.getLevel()+1);
            game.newLevel();
            winSound.play();
            //call the frog reset method
        }
    }
}
