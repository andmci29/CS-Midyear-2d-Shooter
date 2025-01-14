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
        prepare();
    }
    public void prepare(){
        PlayButton playbutton = new PlayButton();
        addObject(playbutton, 300, 150);
        P1Customizer p1custom = new P1Customizer();
        addObject(p1custom, 300,250);
        P2Customizer p2custom = new P2Customizer();
        addObject(p2custom, 300,350);
    }
    public void act(){
        if(Greenfoot.mouseClicked(PlayButton.class)){
            Greenfoot.setWorld(new MyWorld());
        }
    }
}
