import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        super(600, 400, 1);
        setPaintOrder(SinglePlayButton.class, DuelPlayButton.class, Title.class);
        prepare();
    }
    public void prepare(){
        addObject(new SinglePlayButton(), 150, 280);
        addObject(new DuelPlayButton(), 450, 280);
        addObject(new Title(), 300, 100);
    }
    public void act(){
        showText("Single Player Mode", 150, 220);
        showText("Two Player Mode", 450, 220);
    }
}
