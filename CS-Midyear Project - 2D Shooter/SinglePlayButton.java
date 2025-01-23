import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SinglePlayButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SinglePlayButton extends Actor
{
    public SinglePlayButton(){
        getImage().scale(100,100);
    }
    public void act()
    {
        if(Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new SingleWorld());
        }
    }
}
