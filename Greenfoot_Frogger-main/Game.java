import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Game extends World
{

    Frogger player;
    int lives;
    private int level = 0;
    
    int numCars = 3;
    Car[] cars1 = new Car[numCars];
    Car[] cars2 = new Car[numCars];
    int numRocks = 15;
    int numLogs1 = 3; //logs going right
    int numLogs2 = 2; //logs going left
    Log[] logs1 = new Log[numLogs1];
    Log[] logs2 = new Log[numLogs2];
    Rock[] rocks = new Rock[numRocks];
    Road road1;
    Road road2;
    River river;
    Start titleScreen;
    GameOver gameOver;
    GreenfootSound bgmusic;
    Home home;
    private Ready ready = new Ready(new GreenfootSound("reset.wav"));
    private GreenfootSound gameOverSound = new GreenfootSound("end.wav");
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public Game()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 700, 1, false);
        setPaintOrder(Ready.class, Car.class, Frogger.class,Rock.class, Log.class);
        reset();
        titleScreen = new Start(this);
        gameOver = new GameOver(this);
        Greenfoot.setWorld(titleScreen);
    }
    
    public void act(){
        if(bgmusic == null) {
            bgmusic = titleScreen.titleTrack;
            bgmusic.stop();
        }
        showText("Lives: " + lives, 50, 20);
        showText("Level: " + level, 300, 20);
        // player.move(5);
        // if(player.getX()>this.getWidth()){
        //     player.setLocation(0, player.getY());
            
        // }
       
        List<Car> allCars = getObjects(Car.class);
        for(Car car : allCars){
           car.interact(player);
        }
        List<Log> allLogs = getObjects(Log.class);
        for(Log log : allLogs){
           log.interact(player);
        }
       
        home.interact(player);
        
        if(lives < 1) {
            lives = 3;
            Greenfoot.setWorld(gameOver);
            ready.stop();
            gameOverSound.play();
        }
        
    }
    
    public void reset() {
        
         
        removeObjects(getObjects(null));
        addObject(ready, getWidth()/2, getHeight()/2);
        
        player = new Frogger(ready);
        lives = 3;
        addObject(player, getWidth()/2, getHeight()-25);

        
        for(int i=0; i < numCars; i++){
            cars1[i] = new Car(5, 50, 50);
            addObject(cars1[i], 100 + i*200, getHeight() - 125);
        }
        for(int i=0; i < numCars; i++){
            cars2[i] = new Car(3, 50, 50);
            cars2[i].setRotation(180);
            addObject(cars2[i], 100 + i*250, getHeight() - 225);
        }
        
        for(int i=0; i < numLogs1; i++){
            logs1[i] = new Log(3, 48*4, 11*4);
            addObject(logs1[i], 50 + i*300, 275);
        }
        for(int i=0; i < numLogs2; i++){
            logs2[i] = new Log(-3, 48*4, 11*4);
            addObject(logs2[i], 100 + i*400, 150);
        }
        
        for(int i=0; i < 5; i++){
            rocks[i] = new Rock(50, 50);
            addObject(rocks[i], 100 + i*200, 325);
        }
        
        for(int i=5; i < 10; i++){
            rocks[i] = new Rock(50, 50);
            addObject(rocks[i], 100 + (i-5)*200, 75);
        }
        for(int i=10; i < 15; i++){
            rocks[i] = new Rock(50, 50);
            addObject(rocks[i], 50 + (i-10)*200, 225);
        }
        road1 = new Road();
        addObject(road1, getWidth()/2, getHeight()-100);
        road2 = new Road();
        addObject(road2, getWidth()/2, getHeight()-250);
        
        river = new River();
        addObject(river, getWidth()/2, 200);
        
        home = new Home(1);
        addObject(home, getWidth()/2, 25);
    }
    
    public void setLevel(int level) {
        this.level = level;
    }
    
    public int getLevel() {
        return level;
    }
    
}
