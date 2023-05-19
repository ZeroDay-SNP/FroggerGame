import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class UIElement here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UIElement extends Actor
{
    private GifImage gif;
    private int width   = -99;
    private int height  = -99;
    
    public UIElement(GifImage gif) {
        this.gif = gif;
    }
    public UIElement(GifImage gif, int width, int height) {
        this.gif        = gif;
        this.width      = width;
        this.height     = height;
    }
    
    /**
     * Act - do whatever the UIElement wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        GreenfootImage current = gif.getCurrentImage();
        if(width != -99) {
            current.scale(width, height);
        }
        setImage(current);
    }
}
