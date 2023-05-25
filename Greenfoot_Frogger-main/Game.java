import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Main world that controls all of the game elements.
 * 
 * @author      Zachary Sousa
 * @version     1.00
 */
public class Game extends World
{

    private Frogger player;
    private int lives;
    private int level = 0;
    
    private int numCars1 = 5;
    private int numCars2 = 3;
    private Car[] cars1 = new Car[numCars2];
    private Car[] cars2 = new Car[numCars1];
    private int numRocks = 15;
    private int numLogs1 = 3; //logs going right
    private int numLogs2 = 2; //logs going left
    private Log[] logs1 = new Log[numLogs1];
    private Log[] logs2 = new Log[numLogs2];
    private Rock[] rocks = new Rock[numRocks];
    private Road road1;
    private Road road2;
    private River river;
    private Start titleScreen;
    private GameOver gameOver;
    private GreenfootSound bgmusic;
    private Home home;
    private Ready ready = new Ready(new GreenfootSound("reset.wav"));
    private GreenfootSound gameOverSound = new GreenfootSound("end.wav");
    private int defCarSpeed1 = 2;
    private int defCarSpeed2 = 5;
    
    /**
     * Constructor for the Game.
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
    
    /**
     * act is called every frame and updates and checks statistics 
     * regarding the various game elements and player.
     */
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
        
        boolean safeLog = false;
        boolean safeRock = false;
        
        List<Log> allLogs = getObjects(Log.class);
        for(Log log : allLogs){
           log.interact(player);
           if(log.getTouch()) {
               safeLog = true;
           }
        }
        List<Rock> allRocks = getObjects(Rock.class);
        for(Rock rock : allRocks){
           rock.interact(player);
           if(rock.getTouch()) {
               safeRock = true;
           }
        }
       
        home.interact(player);
        
        if(lives < 1) {
            lives = 3;
            Greenfoot.setWorld(gameOver);
            ready.stop();
            gameOverSound.play();
        }
        
        if((player.getY() <= 325 && player.getY() >= 125) && !safeLog && !safeRock) {
            player.die();
        }
        
    }
    
    /**
     * reset resets the playing field to a fresh start.
     */
    public void reset() {
        
         
        removeObjects(getObjects(null));
        addObject(ready, getWidth()/2, getHeight()/2);
        
        player = new Frogger(ready);
        lives = 3;
        level = 0;
        addObject(player, getWidth()/2, getHeight()-25);

        
        for(int i=0; i < numCars2; i++){
            cars1[i] = new Car(defCarSpeed2, 50, 50);
            addObject(cars1[i], 100 + i*200, getHeight() - 125);
        }
        for(int i=0; i < numCars1; i++){
            cars2[i] = new Car(defCarSpeed1, 50, 50);
            cars2[i].setRotation(180);
            addObject(cars2[i], 100 + i*150, getHeight() - 225);
        }
        
        for(int i=0; i < numLogs1; i++){
            logs1[i] = new Log(3, 48*4, 11*4);
            addObject(logs1[i], 50 + i*300, 275);
        }
        for(int i=0; i < numLogs2; i++){
            logs2[i] = new Log(-3, 48*4, 11*4);
            addObject(logs2[i], 100 + i*400, 175);
        }
        
        for(int i=0; i < 5; i++){
            rocks[i] = new Rock(50, 50);
            addObject(rocks[i], 100 + i*200, 325);
        }
        
        for(int i=5; i < 10; i++){
            rocks[i] = new Rock(50, 50);
            addObject(rocks[i], 100 + (i-5)*200, 125);
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
    
    /**
     * newLevel clears the screen and respawns the cars using a new speed based on the level number. Level and lives are stored.
     */
    public void newLevel() {
        removeObjects(getObjects(null));
        addObject(ready, getWidth()/2, getHeight()/2);
        
        player = new Frogger(ready);
        addObject(player, getWidth()/2, getHeight()-25);

        for(int i=0; i < numCars2; i++){
            cars1[i] = new Car(defCarSpeed2 + (int)(defCarSpeed1*(level*0.1)), 50, 50);
            addObject(cars1[i], 100 + i*250, getHeight() - 125);
        }
        for(int i=0; i < numCars1; i++){
            cars2[i] = new Car(defCarSpeed1 + (int)(defCarSpeed1*(level*0.1)), 50, 50);
            cars2[i].setRotation(180);
            addObject(cars2[i], 100 + i*150, getHeight() - 225);
        }
        
        for(int i=0; i < numLogs1; i++){
            logs1[i] = new Log(3, 48*4, 11*4);
            addObject(logs1[i], 50 + i*300, 275);
        }
        for(int i=0; i < numLogs2; i++){
            logs2[i] = new Log(-3, 48*4, 11*4);
            addObject(logs2[i], 100 + i*400, 175);
        }
        
        for(int i=0; i < 5; i++){
            rocks[i] = new Rock(50, 50);
            addObject(rocks[i], 100 + i*200, 325);
        }
        
        for(int i=5; i < 10; i++){
            rocks[i] = new Rock(50, 50);
            addObject(rocks[i], 100 + (i-5)*200, 125);
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
    
    
    
    /**
     * setLevel
     * function for other classes to update the level number.
     * @param level     the new level number
     */
    public void setLevel(int level) {
        this.level = level;
    }
    
    /**
     * getLevel
     * function for other classes to get the level number.
     */
    public int getLevel() {
        return level;
    }
    
    /**
     * getLives
     * function for other classes to update the lives count.
     */
    public int getLives() {
        return lives;
    }
    
    /**
     * setLives
     * function for other classes to update the lives count.
     * @param i     the new life count
     */
    public void setLives(int i) {
        lives = i;
    }
    
}
