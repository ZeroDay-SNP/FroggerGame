import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import greenfoot.GreenfootSound;

/**
 * The frog is controlled by the player.
 * 
 * @author      Zachary Sousa
 * @version     1.00
 */
public class Frogger extends Actor
{
    private int leapSize = 50;
    private final int keyCooldown = 25;
    private int keyTimer = 0;
    private GreenfootImage img = new GreenfootImage("frog.png");
    private GreenfootImage special = new GreenfootImage("frog2.png");
    private Game world;
    private String jumpFile = "jump.wav";
    private GreenfootSound powerUpSound = new GreenfootSound("invincible.wav");
    private ArrayList<GreenfootSound> sounds = new ArrayList<GreenfootSound>();
    private Ready ready;
    
    /**
     * Constructor for the player character.
     * @param ready     the instance of the Ready object (should only be one at any given time).
     */
    public Frogger(Ready ready){
        setImage(img);
        img.scale(leapSize, leapSize);
        special.scale(leapSize, leapSize);
        //jump = new GreenfootSound("jump.wav");
        this.ready = ready;
    }

    /**
     * act is called once per frame.
     * Gets the world.
     * Calls user input function.
     * Calls sound clearing function to get rid of any extra sound effects.
     * If the player passes the edge of the screen they die.
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
        
        if(getX() > world.getWidth() || getX() < 0 || getY() > world.getHeight() || getY() < 0) {
            die();
        }
        
        if(powerUpSound.isPlaying()) {
            setImage(special);
        } else {
            setImage(img);
        }
    }
    
    /**
     * stopTime
     * plays the powerup music and stops time
     */
    public void stopTime() {
        powerUpSound.play();
    }
    
    /**
     * startTime
     * stops the powerup music and starts time
     */
    public void startTime() {
        powerUpSound.stop();
    }
    
    /**
     * hasPow
     * @return T/F whether the power music is on
     */
    public boolean hasPow() {
        return powerUpSound.isPlaying();
    }

    /**
     * getKeys
     * Handles player movement based on inputs. Also adds sounds to
     * the playing list.
     */
    protected void getKeys(){
        String key = Greenfoot.getKey();
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
            if(key.equalsIgnoreCase("l")) {
                //world.setLevel(200);
            }
        }
        
    }
    
    
    /**
     * die
     * Spawns a Corpse and decrements live counter. Calls reset.
     */
    protected void die() {
        world.addObject(new Corpse(img.getWidth(), img.getHeight(), getRotation()), getX(), getY());
        world.setLives(world.getLives()-1);
        reset();
    }
    
    /**
     * reset
     * Resets the rotation and position of the player.
     * Starts the 'READY' part of the initilization.
     */
    private void reset(){
        powerUpSound.stop();
        setRotation(-90);
        setLocation(world.getWidth()/2, world.getHeight()-img.getHeight()/2);
        ready.play(); 
    }
    
    /**
     * addSound
     * Adds a sound to a list of sounds and plays it.
     * (This allows sounds to stack.)
     * 
     * @param list      the ArrayList of sounds
     * @param file      the file path of the sound to add
     */
    private void addSound(ArrayList<GreenfootSound> list, String file) {
        list.add(new GreenfootSound(file));
        list.get(list.size()-1).play();
    }
    
    /**
     * playSound
     * Play an instance of a single sound
     * (useful for powerups)
     * 
     * @param file      the file path of the sound to add
     */
    public void playSound(GreenfootSound sound) {
        sound.play();
    }
    
    /**
     * clearSounds
     * Searches an array list for any sounds that are completed and removes them.
     * 
     * @param list      the ArrayList of sounds
     */
    private void clearSounds(ArrayList<GreenfootSound> list) {
        for(int i = 0; i < list.size(); i++) {
            if(!list.get(i).isPlaying()) {
                list.remove(list.get(i));
            }
        }
    }
}
