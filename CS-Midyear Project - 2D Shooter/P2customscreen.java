import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class P2customscreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class P2customscreen extends World
{

    /**
     * Constructor for objects of class P2customscreen.
     * 
     */
    public P2customscreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        BackButton backbutton = new BackButton();
        addObject(backbutton, 75,75);
    }
}
