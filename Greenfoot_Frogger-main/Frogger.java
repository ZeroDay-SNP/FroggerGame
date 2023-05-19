import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import greenfoot.GreenfootSound;

/**
 * Write a description of class Frogger here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Frogger extends Actor
{
    private int leapSize = 50;
    private final int keyCooldown = 25;
    private int keyTimer = 0;
    private GreenfootImage img;
    private Game world;
    private String jumpFile = "jump.wav";
    private ArrayList<GreenfootSound> sounds = new ArrayList<GreenfootSound>();
    private Ready ready;
    
    public Frogger(Ready ready){
        img = getImage();
        img.scale(leapSize, leapSize);
        //jump = new GreenfootSound("jump.wav");
        this.ready = ready;
    }

    /**
     * Act - do whatever the Frogger wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(world == null){
            world = (Game)getWorld();
            //reset rotation and position
            reset();
        }

        //get input from the user
        getKeys();        
        //update the position
        
        clearSounds(sounds);
    }

    protected void getKeys(){
        
        String key = Greenfoot.getKey();
        System.out.println(ready.getState());
        if(ready.getState()) {
            if(key == null) {
                key = "";
            }
        
            if(key.equalsIgnoreCase("w")) {
                setRotation(-90);   
                move(leapSize);
                addSound(sounds, jumpFile);
            }
            if(key.equalsIgnoreCase("s")) {
                setRotation(90);   
                move(leapSize);
                addSound(sounds, jumpFile);
            }
            if(key.equalsIgnoreCase("a")) {
                setRotation(180);   
                move(leapSize);
                addSound(sounds, jumpFile);
            }
            if(key.equalsIgnoreCase("d")) {
                setRotation(0);   
                move(leapSize);
                addSound(sounds, jumpFile);
            } 
        }
        
    }

    protected void die() {
        world.addObject(new Corpse(img.getWidth(), img.getHeight(), getRotation()), getX(), getY());
        world.lives--;
        reset();
    }
    
    private void reset(){
        setRotation(-90);
        setLocation(world.getWidth()/2, world.getHeight()-img.getHeight()/2);
    }
    
    private void addSound(ArrayList<GreenfootSound> list, String file) {
        list.add(new GreenfootSound(file));
        list.get(list.size()-1).play();
    }
    
    private void clearSounds(ArrayList<GreenfootSound> list) {
        for(int i = 0; i < list.size(); i++) {
            if(!list.get(i).isPlaying()) {
                list.remove(list.get(i));
            }
        }
    }
}
