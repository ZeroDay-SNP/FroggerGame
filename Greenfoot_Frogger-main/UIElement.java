import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A simple class for dislpaying a GifImage
 * 
 * @author      Zachary Sousa
 * @version     1.00
 */
public class UIElement extends Actor
{
    private GifImage gif;
    private int width   = -99;
    private int height  = -99;
    
    /**
     * Constructor for UIElement
     * @param gif   the GifImage to display
     */
    public UIElement(GifImage gif) {
        this.gif = gif;
    }
    
    /**
     * Constructor2 for UIElement
     * @param gif           the GifImage to display
     * @param width         the width of the gif in px
     * @param height        the height of the gif in px
     */
    public UIElement(GifImage gif, int width, int height) {
        this.gif        = gif;
        this.width      = width;
        this.height     = height;
    }
    
    /**
     * act is called once per frame.
     * Displays each frame of the gif.
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
