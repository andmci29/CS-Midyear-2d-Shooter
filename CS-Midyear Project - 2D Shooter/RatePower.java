import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RatePower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RatePower extends Actor
{
    private int timer;
    public RatePower(){
        timer=0;
    }
    public void act()
    {
        timer++;
        if(timer == 1000){
            getWorld().removeObject(this);
        }
        
    }
}
