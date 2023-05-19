import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Log here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Log extends AbstOther
{
    public Log (int s, int w, int h){
        super(s, w, h);
    }

    
    public void interact(Frogger player){
        if(intersects(player)) {
            player.setLocation(player.getX()+speed, player.getY());
        }
    }
    
    public void setSpeed(int s) {
        this.speed = s;
    }
}
